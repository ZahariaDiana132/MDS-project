package ro.pao.model.cumparator;

import java.util.concurrent.atomic.AtomicInteger;

public abstract sealed class Sealedforcump permits Client,Firma {
    static AtomicInteger nextId = new AtomicInteger();
    private int id;
    public Sealedforcump() {
        id = nextId.incrementAndGet();
    }


    public int getId() {
        return id;
    }
}
