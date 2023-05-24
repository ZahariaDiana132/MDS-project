package ro.pao.model.cumparator;

import java.util.concurrent.atomic.AtomicInteger;

public non-sealed class Firma extends Sealedforcump {

    private int CUI;

    private String nume;

    public Firma(int cui, String nume)
    {this.CUI = cui;
     this.nume=nume;
    }

    public int getCUI() {
        return this.CUI;
    }
    public String getNume() {
        return this.nume;
    }

    @Override
    public String toString()
    {
        return  "Firma: " + this.nume + " CUI: " + this.CUI;
    }
}
