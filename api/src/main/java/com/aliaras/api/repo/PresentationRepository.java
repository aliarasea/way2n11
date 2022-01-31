package com.aliaras.api.repo;

import com.aliaras.api.entity.Presentation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentationRepository extends MongoRepository<Presentation, String> {
     @Query("{ 'name': ?0 }")
     Presentation findByName(String name);
}
