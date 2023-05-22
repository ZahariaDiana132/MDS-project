package ro.pao.model.produse;

public  class Culegere extends Produs {
    private String materie;
    public Culegere(){}
    public Culegere(String materie)
    {this.materie=materie;}
    public String getMaterie(){return this.materie;}
    public void setMaterie(String materie){this.materie = materie;}
    @Override
    public String toString()
    {
        return "Culegere: " + this.getNume() + ", editura " + this.getEditura() + " materia: "
                + this.materie+ "\n nr produsului: " + this.getNr()+" \n Pretul: " + this.getPret() + " lei";
    }
}
