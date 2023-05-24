package ro.pao.model.cumparator;

import java.util.concurrent.atomic.AtomicInteger;

public non-sealed class Client extends Sealedforcump {
    private String prnume,email,adresa,telefon;
    static AtomicInteger nextId = new AtomicInteger();
    private int id;
    public Client(){id = nextId.incrementAndGet();}
    public Client(String prnume, String email, String adresa, String telefon){
        this.prnume=prnume;
        this.email=email;
        this.adresa=adresa;
        this.telefon=telefon;
        id = nextId.incrementAndGet();
    }

    public String getPrnume(){return this.prnume;}
    public void setPrnume(String prnume){this.prnume = prnume;}

    public String getEmail(){return this.email;}
    public void setEmail(String email){this.email = email;}

    public String getTelefon(){return this.telefon;}
    public void setTelefon(String telefon){this.telefon= telefon;}

    public String getAdresa(){return this.adresa;}
    public void setAdresa(String adresa){this.adresa = adresa;}

    public int getId(){return this.id;}

    @Override
    public String toString()
    {
        return  "Clientul: " + this.prnume + " cu email: " + this.email + " are adresa de livrare: "
                + this.adresa + " si telefonul " + this.telefon;
    }

}
