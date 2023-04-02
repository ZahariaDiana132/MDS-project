package produse;

public class Produs {

 private int nr;
 private String nume,editura;
 private double pret;

 public Produs(){}

 public Produs(String nume,String editura,double pret,int nr)
 {
     this.nume = nume;
     this.editura=editura;
     this.pret = pret;
     this.nr=nr;
 }

    public String getNume(){return this.nume;}
    public void setNume(String nume){this.nume = nume;}
    public String getEditura(){return this.editura;}
    public void setEditura(String editura){this.editura = editura;}
    public double getPret(){return this.pret;}
    public void setPret(double pret){this.pret = pret;}
    public int getNr(){return this.nr;}
    public void setNr(int nr){this.nr = nr;}
    @Override
    public String toString()
    {
        return "Proudusul: " + this.nume + "cu nr:"+this.nr+", editura " + this.editura + "\nPretul: " + this.pret + " lei";
    }

}
