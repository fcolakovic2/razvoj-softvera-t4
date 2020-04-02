package ba.unsa.etf.rs.tut4;




import java.util.ArrayList;

public class Racun {

    private ArrayList<Artikal> r;
    private ArrayList<Stavka> listastavki;

    public Racun() {

    }

    public ArrayList<Artikal> getR() {
        return r;
    }

    public void setR(ArrayList<Artikal> r) {
        this.r = r;
    }

    public Racun(ArrayList<Artikal> r, ArrayList<Stavka> listastavki) {
        this.r = r;
        this.listastavki = listastavki;
    }

    public void dodajStavku(Artikal artikal, int kolicina){
        r.add(new Stavka(artikal, kolicina));
        listastavki.add(new Stavka(artikal, kolicina));
    }

    public double ukupanIznos(){
        double zaplatiti=0;
        for (Stavka s : listastavki){
            zaplatiti+=s.getKolicina()*s.getArti().getCijena();
        }
        return zaplatiti;
    }

}
