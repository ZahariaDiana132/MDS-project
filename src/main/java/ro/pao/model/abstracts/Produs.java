package ro.pao.model.abstracts;

import java.util.concurrent.atomic.AtomicInteger;

import ro.pao.model.designpatterndecorator.Arepret;
import ro.pao.model.enums.tipuriproduse;
public abstract class Produs  {

    static AtomicInteger nextId = new AtomicInteger();
    private int nr;
    private String nume,editura,autor;
    private double pret;


 public Produs(){nr = nextId.incrementAndGet();}

 public Produs(String nume,String editura,double pret,String autor)
 {
     this.nume = nume;
     this.editura=editura;
     this.pret = pret;
     this.autor=autor;


 }

    public String getAutor(){return this.autor;}
    public void setAutor(String autor){this.autor = autor;}
    public String getNume(){return this.nume;}
    public void setNume(String nume){this.nume = nume;}

    public String getEditura(){return this.editura;}
    public void setEditura(String editura){this.editura = editura;}
    public double getPret(){return this.pret;}
    public void setPret(double pret){this.pret = pret;}
    public int getNr(){return this.nr;}

    @Override
    public String toString()
    {
        return "Proudusul: " + this.nume + "cu nr:"+this.nr+", editura " + this.editura + "\nPretul: " + this.pret + " lei" ;
    }

}
