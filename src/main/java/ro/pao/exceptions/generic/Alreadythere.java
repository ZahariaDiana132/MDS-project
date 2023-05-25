package ro.pao.exceptions.generic;
import ro.pao.exceptions.sameproducttwice;
import ro.pao.model.abstracts.Produs;


import java.util.ArrayList;

//acelasi nume, aceasi editura si acelasi autor
public class Alreadythere<T extends Produs> {

    private String nume,autor,editura;
    private ArrayList<T> produs ;

    public Alreadythere() {
    }
    public void checkEligibility(String nume, String autor, String editura, ArrayList<T> produs) throws sameproducttwice {
        for (T i : produs)
          if (i.getEditura()==editura && i.getNume()==nume && i.getAutor()==autor ) {
            // we throw InvalidAgeException when the age is less than 18
            throw new sameproducttwice("exista deja man");
        }
    }

}
