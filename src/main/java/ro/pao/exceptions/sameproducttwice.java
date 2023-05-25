package ro.pao.exceptions;
//daca un produs ce vrem sa il introducem are acelasi nume, aceasi editura si acelasi autor cu cv ce e deja in baza de date
public class sameproducttwice extends Exception{
    public sameproducttwice(String message) {
        super(message);
    }
}
