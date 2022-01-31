package com.aliaras.api.util;

import com.aliaras.api.constant.PeriodType;
import com.aliaras.api.constant.PresentationType;
import com.aliaras.api.entity.Period;
import com.aliaras.api.entity.Presentation;
import com.aliaras.api.entity.Track;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public final class ConferenceUtil {

    private static Period createPeriod(PeriodType periodType) {
        Period period = new Period();
        LocalDate startDate = LocalDate.now();
        LocalTime startTime = LocalTime.now();
        LocalTime endTime = LocalTime.now();
        if (periodType == PeriodType.AM) {
            startTime = LocalTime.of(9, 0);
            endTime = LocalTime.of(12, 0);
        } else if (periodType == PeriodType.LAUNCH) {
            startTime = LocalTime.of(12, 0);
            endTime = LocalTime.of(13, 0);
        } else if (periodType == PeriodType.PM) {
            startTime = LocalTime.of(13, 0);
            endTime = LocalTime.of(17, 0);
        }
        LocalDateTime startDateTime = LocalDateTime.of(startDate, startTime);
        LocalDateTime endDateTime = LocalDateTime.of(startDate, endTime);
        period.setStart(startDateTime);
        period.setEnd(endDateTime);
        period.setPresentations(new ArrayList<>());
        return period;
    }

    public static void assignPresentationToTracks(List<Track> tracks, List<Presentation> presentations) {

        Map<PeriodType, Period> periods = getPeriods();

        LocalDateTime start = periods.get(PeriodType.AM).getStart();

        presentationsShuffle(presentations);

        List<Presentation> unsetPresentations = new ArrayList<>();

        long totalDuration = assignPresentationLoop(presentations, periods, start, unsetPresentations);

        setNetworking(periods.get(PeriodType.PM), presentations, totalDuration);

        tracks.add(new Track(String.format("Track %s", tracks.size() + 1), periods));

        if (!unsetPresentations.isEmpty()) {
            assignPresentationToTracks(tracks, unsetPresentations);
        }
    }

    private static long assignPresentationLoop(List<Presentation> presentations, Map<PeriodType, Period> periods, LocalDateTime start, List<Presentation> unsetPresentations) {
        long totalDuration = 0;

        for (Presentation presentation : presentations) {

            boolean isAmTimingOk =
                    (start.plusMinutes(totalDuration).isEqual(periods.get(PeriodType.AM).getStart())) ||
                            (start.plusMinutes(totalDuration).isAfter(periods.get(PeriodType.AM).getStart()) &&
                                    start.plusMinutes(totalDuration).isBefore(periods.get(PeriodType.AM).getEnd()));

            boolean isLaunchTimingOk = (start.plusMinutes(totalDuration).isEqual(periods.get(PeriodType.LAUNCH).getStart())) ||
                    (start.plusMinutes(totalDuration).isAfter(periods.get(PeriodType.LAUNCH).getStart()) &&
                            start.plusMinutes(totalDuration).isBefore(periods.get(PeriodType.LAUNCH).getEnd()));

            boolean isPmTimingOk = (
                    (start.plusMinutes(totalDuration).isEqual(periods.get(PeriodType.PM).getStart())) ||
                            start.plusMinutes(totalDuration).isAfter(periods.get(PeriodType.PM).getStart()) &&
                                    start.plusMinutes(totalDuration).isBefore(periods.get(PeriodType.PM).getEnd()));

            if (isAmTimingOk) {
                totalDuration = preparePeriod(periods.get(PeriodType.AM), totalDuration, start, presentation);
            } else if (isLaunchTimingOk) {
                totalDuration += Duration.between(periods.get(PeriodType.LAUNCH).getStart(), periods.get(PeriodType.LAUNCH).getEnd()).toMinutes();
            } else if (isPmTimingOk) {
                totalDuration = preparePeriod(periods.get(PeriodType.PM), totalDuration, start, presentation);
            } else {
                unsetPresentations.add(presentation);
            }
        }

        return totalDuration;
    }

    private static void presentationsShuffle(List<Presentation> presentations) {
        Collections.shuffle(presentations);
    }

    private static void setNetworking(Period period, List<Presentation> presentations, long totalDuration) {
        if (presentations.size() > 0) {
            List<Presentation> periodPresentations = period.getPresentations();
            LocalDateTime networkingStart = period.getEnd().minusHours(1);
            if (periodPresentations.size() > 0) {
                networkingStart = periodPresentations.get(periodPresentations.size() - 1).getEnd();
            }
            LocalDateTime networkingEnd = period.getEnd();
            boolean isNetworkingTimingOk =
                    networkingStart.isBefore(networkingEnd) &&
                            (networkingEnd.isEqual(period.getEnd().minusMinutes(60))
                                    || networkingEnd.isAfter(period.getEnd().minusMinutes(60)));

            if (isNetworkingTimingOk) {
                assignNetworkingLoop(period, presentations, totalDuration);
            }
        }
    }

    private static void assignNetworkingLoop(Period period, List<Presentation> presentations, long totalDuration) {
        if (period.getPresentations().size() > 0) {
            while (period.getPresentations().get(period.getPresentations().size() - 1).getEnd().isBefore(period.getEnd())) {

                Presentation lastPresentation = period.getPresentations().get(period.getPresentations().size() - 1);

                long offset = Duration.between(lastPresentation.getEnd(), period.getEnd()).toMinutes();

                long networkingDuration = getNetworkingDuration(offset);

                Presentation networking = Presentation.builder()
                        .type(PresentationType.NETWORKING.name())
                        .name(PresentationType.NETWORKING.name())
                        .duration((int) networkingDuration)
                        .start(lastPresentation.getEnd())
                        .end(lastPresentation.getEnd().plusMinutes(networkingDuration))
                        .build();

                period.getPresentations().add(networking);
                presentations.add(networking);

                totalDuration += networkingDuration;
            }
        }
    }

    private static long getNetworkingDuration(long offset) {
        long networkingDuration = offset;
        if (offset > 5) {
            networkingDuration = new Random().nextLong(5, offset);
        }
        return networkingDuration;
    }

    private static long preparePeriod(Period period,
                                      long totalDuration,
                                      LocalDateTime timer,
                                      Presentation presentation) {

        presentation.setStart(timer.plusMinutes(totalDuration));

        totalDuration += presentation.getDuration();

        presentation.setEnd(timer.plusMinutes(totalDuration));

        period.getPresentations().add(presentation);

        return totalDuration;
    }

    private static Map<PeriodType, Period> getPeriods() {
        Map<PeriodType, Period> periods = new HashMap<>(3);
        for (PeriodType value : PeriodType.values()) {
            periods.put(value, createPeriod(value));
        }
        return periods;
    }
}
