package ro.pao.model.comanda.generics;

import ro.pao.model.comanda.Cos;
import ro.pao.model.cumparator.Sealedforcump;

import java.util.concurrent.atomic.AtomicInteger;

public class cossicumpbd<T extends Cos,R extends Sealedforcump> {
    static AtomicInteger nextId = new AtomicInteger();
    private int id;

    private int cumparatorid,cosid;



    public cossicumpbd(int id, T cosid, R cumparatorid) {
        id=nextId.incrementAndGet();
        this.cumparatorid = cumparatorid.getId();
        this.cosid = cosid.getId();

    }

    public cossicumpbd() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCumparatorId() {
        return cumparatorid;
    }

    public void setCumparatorId(int cumparatorid) {
        this.cumparatorid = cumparatorid;
    }

    public int getCosId() {
        return cosid;
    }

    public void setCosId(int cosid) {
        this.cosid = cosid;
    }
    @Override
    public String toString()
    {
        return "Comanda cu nr: "+ this.id + "\nDetalii:\n" +"  Cumparator: " +this.cumparatorid + "\n  cosul cu id: " + this.cosid ;

    }

}
