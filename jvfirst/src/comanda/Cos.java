package comanda;
import produse.*;

public class Cos {
    private double total=0;

public Cos(){}
    public Cos(Produs y)
    {this.total=total+y.getPret();}

    public double getTotal() {return this.total;}
    public void setTotal(Produs y) {this.total=total+y.getPret();}

    @Override
    public String toString()
    {
        return  "Pretul total este: " + this.total;

    }
}
