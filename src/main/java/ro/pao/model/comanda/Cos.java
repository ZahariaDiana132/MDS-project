package ro.pao.model.comanda;

import ro.pao.model.abstracts.Produs;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Cos {
    private double total=0;
    private ArrayList<Produs> cump = new ArrayList<>();

    static AtomicInteger nextId = new AtomicInteger();
    private int id;

public Cos(){id = nextId.incrementAndGet();}
    public Cos(Produs y)
    {this.total=total+y.getPret();}

    public double getTotal() {return this.total;}
    public void setTotal(Produs y) {this.total=total+y.getPret();}
    public void setProduse(Produs x){cump.add(x); this.total=total+x.getPret();}
    public String getProduse() {
        for (Produs i : cump)
            System.out.println(i);
        return "";
    }
    public int getProdusnr(int i){return this.cump.get(i).getNr();}

    @Override
    public String toString()
    {
        return  "Pretul total este: " + this.total + "\n produsele sunt: \n" + this.cump;

    }
    public ArrayList<Produs> getCump() {
        return cump;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
