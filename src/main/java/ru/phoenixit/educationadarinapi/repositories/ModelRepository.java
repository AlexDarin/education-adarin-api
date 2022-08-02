package ru.phoenixit.educationadarinapi.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.phoenixit.educationadarinapi.models.Model;

public interface ModelRepository extends MongoRepository<Model, String> {

}
