package ro.pao.exceptions.generic;
import ro.pao.exceptions.sameproducttwice;
import ro.pao.model.abstracts.Produs;


import java.util.ArrayList;

//acelasi nume, aceasi editura si acelasi autor
public class Alreadythere<T extends Produs> {

    private String nume,autor,editura;
    private ArrayList<T> produs ;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditura() {
        return editura;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    public Alreadythere() {
    }

    public Alreadythere(String nume, String autor, String editura) {
        this.nume = nume;
        this.autor = autor;
        this.editura = editura;
    }

    public void checkEligibility(String nume, String autor, String editura, ArrayList<T> produs) throws sameproducttwice {
        for (T i : produs)
          if (i.getEditura()==editura && i.getNume()==nume && i.getAutor()==autor ) {

              this.setNume("LOLA");

              this.setAutor("LOLA");

              this.setEditura("LOL");

            throw new sameproducttwice("exista deja man");
        }
    }

}
