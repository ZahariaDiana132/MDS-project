package ro.pao.model.produse;
import ro.pao.model.abstracts.Produs;
import ro.pao.model.designpatterndecorator.Arepret;

//singurul produs pe care il retin in baza de date
public class Carte extends Produs implements Arepret {
    private String autor,sect,subsect;

    private int cosid;
    public Carte(){ }
    public Carte(String autor,String sect,String subsect,String nume,String editura, double pret)
    {this.autor=autor;
     this.sect=sect;
     this.subsect=subsect;
     this.setNume(nume);
     this.setEditura(editura);
     this.setPret(pret);
    }
    public String getAutor(){return this.autor;}
    public void setAutor(String autor){this.autor = autor;}
    public String getSect(){return this.sect;}
    public void setSect(String sect){this.sect = sect;}
    public String getSubsect(){return this.subsect;}
    public void setSubsect(String subsect){this.subsect = subsect;}

    @Override
    public String toString()
    {
        return "\nCartea scrisa de " + this.autor + " cu numele: " + this.getNume() + " sectia: " + this.sect+
                " sub-sectia: "+ this.subsect + "  editura: " + this.getEditura() + "\n nr produsului: "
                + this.getNr()+ "\n Pret: " + this.getPret() + " lei\n";
    }

    public void disc(double a)
    {

        System.out.println("\n Pretul fara un discount: " + this.getPret());

    }
    @Override
    public double getPpret() {
        return getPret();
    }

    public void setCosid(int cosid) {
        this.cosid = cosid;
    }

    public int getCosid() {
        return cosid;
    }
}
