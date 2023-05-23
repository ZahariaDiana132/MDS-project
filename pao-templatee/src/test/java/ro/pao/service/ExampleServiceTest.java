package ro.pao.service;

import org.junit.jupiter.api.Test;
import ro.pao.model.ExampleClass;
import ro.pao.repository.ExampleRepository;
import ro.pao.repository.impl.ExampleRepositoryImpl;
import ro.pao.service.impl.ExampleServiceImpl;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Metodele de test ale serviciului 'ExampleService'
 *
 * In functie de cate metode serviciu aveti, puteti face mai multe clase de test pe baza a ce clase serviciu aveti.
 *
 * Motivul pentru care exista teste este pentru a vedea daca functionalitatea 'pe bucati' functioneaza cum trebuie.
 *
 * Aceste teste se cheama 'unitare' pentru ca se testeaza 'per unitate'
 */
class ExampleServiceTest {


    /**
     * Dupa cum puteti vedea, metoda are 'o conventie'
     * Puteti lasa comentarii aici, cum am facut eu, despre ce face metoda
     *
     * Insa, in practica, se foloseste urmatoarea structura de definire a unei metode test:
     *
     * 'when{Descriere}_then{Descriere}
     */
    @Test
    void whenGivenExampleClass_thenElementIsAdd() {
        // given
        // pasul in care efectuam operatiile

        ExampleClass exampleClass = ExampleClass.builder()
                .id(UUID.randomUUID())
                .build();
        ExampleRepository exampleRepository = mock(ExampleRepositoryImpl.class);

        // when
        when(exampleRepository.getObjectById(any())).thenReturn(Optional.of(exampleClass));

        //mockExampleClassMapper(resultSet);

        // then
        // pasul in care testam comportamentul dupa apelarea functiilor
        // verifica daca cei doi parametri sunt egali, primul parametru fiind cel 'expected' si al doilea 'actual'

        ExampleService exampleService = new ExampleServiceImpl(exampleRepository);

        assertEquals(Optional.of(exampleClass), exampleService.getById(any()));

        // assertEquals face parte din clasa Assertions si este o metoda statica
        // alte metode mai sunt:
        // asssertTrue -> verifica daca e true
        // assertTrue(true);

        // assertFalse -> verifica daca e false
        // assertFalse(false);
    }
}
