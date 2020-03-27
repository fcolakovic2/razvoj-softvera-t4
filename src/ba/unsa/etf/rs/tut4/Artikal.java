package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;

public class Artikal {

    private String sifra;
    private String naziv;
    private double cijena;

    @Override
    public boolean equals(Object o){
        Artikal artikal = (Artikal) o;

        if (Double.compare(artikal.getCijena(), this.cijena)==0 && artikal.sifra.equals(this.sifra) && artikal.naziv.equals(this.naziv))
            return true;
        else return false;

    }

    public static ArrayList<String> izbaciDuplikate(ArrayList<String> artikli){
     for (int i=0; i<artikli.size();i++){
         for (int j=i+1; j<artikli.size();j++){
             if (artikli.get(i).equals(artikli.get(j))) {
                 artikli.remove(j); j--; //j moram vratiti na prethodni jer ce se u protivnom preskocit 1 koji treba izbaciti
             }
         }
     }

     return artikli;

    }

    public Artikal(String artikal) {
        String[] info= artikal.split(",");
        setSifra(info [0]);
        setNaziv(info [1]);
        setCijena(Double.parseDouble(info [2]));
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        if(sifra.isEmpty()) {
            throw new IllegalArgumentException("Šifra je prazna");
        }
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        if(naziv.isEmpty()) {
            throw new IllegalArgumentException("Naziv je prazan");
        }
        this.naziv = naziv;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        if(cijena<0) {
            throw new IllegalArgumentException("Cijena je negativna");
        }
        this.cijena = cijena;
    }

    @Override
    public String toString() {
        return sifra + "," + naziv + "," + cijena;
    }
}
