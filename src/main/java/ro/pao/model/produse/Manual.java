package ro.pao.model.produse;

import ro.pao.model.abstracts.Produs;

public class Manual extends Produs {
    private String materie;
    public Manual(){}
    public Manual(String materie,String nume,String editura, double pret)
    {   this.materie=materie;
        this.setNume(nume);
        this.setEditura(editura);
        this.setPret(pret);
    }
    public String getMaterie(){return this.materie;}
    public void setMaterie(String materie){this.materie = materie;}
    @Override
    public String toString()
    {
        return "Manual: " + this.getNume() + ", editura " + this.getEditura() + " materia: "
     + this.materie+ "\n nr produsului: " + this.getNr()+"\n Pretul: " + this.getPret() + " lei";
    }
}
