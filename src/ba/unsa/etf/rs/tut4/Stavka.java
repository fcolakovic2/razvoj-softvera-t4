package ba.unsa.etf.rs.tut4;

public class Stavka extends Artikal {

    private int kolicina;
    private Artikal arti;

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Artikal getArti() {
        return arti;
    }

    public void setArti(Artikal arti) {
        this.arti = arti;
    }

    public Stavka(int kolicina, Artikal arti) {
        this.kolicina = kolicina;
        this.arti = arti;
    }

    public Stavka(String sifra, String naziv, double cijena, int kolicina, Artikal arti) {
        super(sifra, naziv, cijena);
        this.kolicina = kolicina;
        this.arti = arti;
    }

    public Stavka(String artikal, int kolicina, Artikal arti) {
        super(artikal);
        this.kolicina = kolicina;
        this.arti = arti;
    }

    public Stavka(Artikal artikal, int kolicina) {
    }
}
