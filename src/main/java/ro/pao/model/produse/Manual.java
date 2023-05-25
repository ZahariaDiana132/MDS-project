package ro.pao.model.produse;

import ro.pao.model.abstracts.Produs;

public class Manual extends Produs {
    private String materie;
    public Manual(){}
    public Manual(String materie,String nume,String editura, double pret,String autor)
    {   this.materie=materie;
        this.setNume(nume);
        this.setEditura(editura);
        this.setPret(pret);
        this.setAutor(autor);
    }
    public String getMaterie(){return this.materie;}
    public void setMaterie(String materie){this.materie = materie;}
    @Override
    public String toString()
    {
        return "\nManual: " + this.getNume() + ", editura " + this.getEditura() + " materia: "
     + this.materie+ "\n nr produsului: " + this.getNr()+"\n Pretul: " + this.getPret() + " lei\n";
    }
}
