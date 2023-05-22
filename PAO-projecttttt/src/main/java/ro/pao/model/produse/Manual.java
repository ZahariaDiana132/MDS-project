package ro.pao.model.produse;

public class Manual extends Produs {
    private String materie;
    public Manual(){}
    public Manual(String materie)
    {this.materie=materie;}
    public String getMaterie(){return this.materie;}
    public void setMaterie(String materie){this.materie = materie;}
    @Override
    public String toString()
    {
        return "Manual: " + this.getNume() + ", editura " + this.getEditura() + " materia: "
     + this.materie+ "\n nr produsului: " + this.getNr()+"\n Pretul: " + this.getPret() + " lei";
    }
}
