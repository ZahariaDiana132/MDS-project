package ro.pao.exceptions.generic;

import ro.pao.exceptions.wrongcomandaimput;
import ro.pao.model.cumparator.Firma;
import ro.pao.model.cumparator.Client;
import ro.pao.model.cumparator.Sealedforcump;

public class Inputincorect<T> {

    public Inputincorect() {
    }

    // create method checkEligibility() to check whether the given is valid for exam or not
    public void checkEligibility(T param) throws wrongcomandaimput {

        Sealedforcump c;
        if (!(param.getClass().equals(Firma.class)) && !(param.getClass().equals(Client.class)) ) {

            throw new wrongcomandaimput("nu ai introdus tipul de date bun, trebuie sa fie firma sau client");
        } else {
            System.out.println("e cumparator");
        }
    }
}
