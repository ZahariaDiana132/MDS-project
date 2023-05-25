package ro.pao.model.produse;
import ro.pao.model.abstracts.Produs;

public class Carte extends Produs {
    private String autor,sect,subsect;

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

}
