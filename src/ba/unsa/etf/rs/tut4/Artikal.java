package ba.unsa.etf.rs.tut4;

public class Artikal {

    private String sifra;
    private String naziv;
    private double cijena;

    public Artikal(String artikal) {
        String[] info= artikal.split(",");
        sifra = info [0];
        naziv = info [1];
        cijena= info [2];
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    @Override
    public String toString() {
        return "sifra" +"," +"naziv"+ ","+"cijena";
    }
}
