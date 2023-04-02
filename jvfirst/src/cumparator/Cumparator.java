package cumparator;

public class Cumparator {
    private String prnume,email,adresa,telefon;
    public Cumparator(){}
    public Cumparator(String prnume, String email, String adresa, String telefon){
        this.prnume=prnume;
        this.email=email;
        this.adresa=adresa;
        this.telefon=telefon;
    }

    public String getPrnume(){return this.prnume;}
    public void setPrnume(String prnume){this.prnume = prnume;}

    public String getEmail(){return this.email;}
    public void setEmail(String email){this.email = email;}

    public String getTelefon(){return this.telefon;}
    public void setTelefon(String telefon){this.telefon= telefon;}

    public String getAdresa(){return this.adresa;}
    public void setAdresa(String adresa){this.adresa = adresa;}

    @Override
    public String toString()
    {
        return  "Cumparatorul: " + this.prnume + " cu email: " + this.email + " are adresa de livrare: "
                + this.adresa + " si telefonul " + this.telefon;
    }

}
