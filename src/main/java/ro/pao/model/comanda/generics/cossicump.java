package ro.pao.model.comanda.generics;
import ro.pao.model.cumparator.Sealedforcump;
import ro.pao.model.comanda.Cos;

import java.util.concurrent.atomic.AtomicInteger;

public class cossicump<T extends Cos,R extends Sealedforcump >{
    private T produse;
    private R cumparator;

    static AtomicInteger nextId = new AtomicInteger();
    private int id;

    public cossicump(T produse, R cumparator) {
        this.produse = produse;
        this.cumparator = cumparator;
        id=nextId.incrementAndGet();
    }

    public T getProduse() {
        return this.produse;
    }

    public void setProduse(T produs) {
        this.produse = produs;
    }

    public R getCumparator() {
        return this.cumparator;
    }

    public void setCumparator(R cumparator) {
        this.cumparator = cumparator;
    }

    @Override
    public String toString()
    {
        return "Comanda cu nr: "+ this.id + "\nDetalii:\n" +"  Cumparator: " +this.cumparator + "\n  In valoare de: " + this.produse.getTotal();

    }

}
