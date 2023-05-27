package ro.pao.model.designpatterndecorator;

import ro.pao.model.abstracts.Produs;

public abstract class AbstractDecorator extends Produs implements Arepret {
    protected Arepret pret;

    public AbstractDecorator(Arepret pret) {
        this.pret = pret;
    }
     public void disc(double a){pret.disc(a);}
}
