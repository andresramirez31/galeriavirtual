package com.gamodel.galeriavirtual.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.gamodel.galeriavirtual.model.Obra;

public interface ObraRepository extends MongoRepository<Obra, String> {

}
