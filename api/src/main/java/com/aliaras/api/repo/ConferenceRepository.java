package com.aliaras.api.repo;

import com.aliaras.api.entity.Conference;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRepository extends MongoRepository<Conference, String> {
    @Query("{ 'name': ?0 }")
    Conference findByName(String name);
}
