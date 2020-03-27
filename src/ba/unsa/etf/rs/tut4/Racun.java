package ba.unsa.etf.rs.tut4;



import java.util.ArrayList;

public class Racun {

    private ArrayList<Stavka> listastavki ;


    public Racun(ArrayList<Stavka> listastavki) {

        this.listastavki = listastavki;
    }

    public ArrayList<Stavka> getListastavki() {

        return listastavki;
    }

    public void setListastavki(ArrayList<Stavka> listastavki) {

        this.listastavki = listastavki;
    }

    public void dodajStavku(int kolicina, Artikal artikal){

        listastavki.add(new Stavka(kolicina, artikal));
    }


    public double ukupanIznos(){
        double zaplatiti=0;
        for (Stavka s : listastavki){
            zaplatiti+=s.kolicina*s.artikal.getCijena();
        }
        return zaplatiti;
    }

}
