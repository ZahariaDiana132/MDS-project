package src.produse.tipuri;

public enum Categorie {
    CARTI("carti"),
    MANUALE("manuale"),
    CULEGERI("culegeri"),


    Categorie(String nume) {
        this.nume = nume;
    }

    private String nume;

    public String getNume() {
        return this.nume;
    }
}