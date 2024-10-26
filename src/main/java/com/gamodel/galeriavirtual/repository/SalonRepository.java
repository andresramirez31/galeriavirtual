package com.gamodel.galeriavirtual.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.gamodel.galeriavirtual.model.Salon;

public interface SalonRepository extends MongoRepository<Salon, String> {

}
