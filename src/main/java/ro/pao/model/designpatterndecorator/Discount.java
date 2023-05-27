package ro.pao.model.designpatterndecorator;

import ro.pao.model.abstracts.Produs;

public class Discount extends AbstractDecorator{

    double prret;
    public Discount(Arepret pret,double prret) {
        super(pret); this.prret=prret;
    }

    private void setDiscount(Arepret pret,double a)
    {
        prret =prret-(a*prret);
        System.out.println("Pretul cu discountul "+ a +" : " + prret);


    }
    @Override
    public void disc(double a)
    {
        pret.disc(a);
        setDiscount(pret,a);
    }

    @Override
    public double getPpret() {
        return prret;
    }
}
