package com.aliaras.api.config;

import com.aliaras.api.config.converter.ZonedDateTimeReadConverter;
import com.aliaras.api.config.converter.ZonedDateTimeWriteConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@EnableMongoRepositories(basePackages = "com.aliaras.api.repo")
@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {
    private final List<Converter<?, ?>> converters = new ArrayList<>();

    @Override
    protected String getDatabaseName() {
        return "way2n11db";
    }

    @Override
    public MongoCustomConversions customConversions() {
        converters.add(new ZonedDateTimeReadConverter());
        converters.add(new ZonedDateTimeWriteConverter());
        return new MongoCustomConversions(converters);
    }
}
