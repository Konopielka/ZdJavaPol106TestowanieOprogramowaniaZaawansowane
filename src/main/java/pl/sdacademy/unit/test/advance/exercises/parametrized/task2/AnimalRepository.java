package pl.sdacademy.unit.test.advance.exercises.parametrized.task2;

import java.util.Optional;

public interface AnimalRepository {
    Optional<Animal> findById(long id);

    Animal add(Animal animal);
}