package ro.pao.exceptions;

import ro.pao.model.cumparator.Firma;
import ro.pao.model.cumparator.Client;
import ro.pao.model.cumparator.Sealedforcump;

public class Inputincorect<T> {

    public Inputincorect() {
    }

    // create method checkEligibility() to check whether the given is valid for exam or not
    public void checkEligibility(T param) throws wrongcomandaimput {
        // use conditional statement to check age
        Sealedforcump c;
        if (!(param.getClass().equals(Firma.class)) && !(param.getClass().equals(Client.class)) ) {
            // we throw InvalidAgeException when the age is less than 18
            throw new wrongcomandaimput("nu ai introdus tipul de date bun, trebuie sa fie firma sau client");
        } else {
            System.out.println("e cumparator");
        }
    }
}
