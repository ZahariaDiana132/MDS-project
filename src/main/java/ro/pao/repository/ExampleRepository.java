package ro.pao.repository;

import ro.pao.model.ExampleClass;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExampleRepository {

    Optional<ExampleClass> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, ExampleClass newObject);

    void addNewObject(ExampleClass exampleClass);

    List<ExampleClass> getAll();

    void addAllFromGivenList(List<ExampleClass> exampleClassList);
}
