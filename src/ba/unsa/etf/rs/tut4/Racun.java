package ba.unsa.etf.rs.tut4;




import java.util.ArrayList;

public class Racun {

    private ArrayList<Integer> kol = new ArrayList<> ();
    private ArrayList<Artikal> listastavki= new ArrayList<>();


    public Racun() {
    }

    private  void setArtikal(Artikal artikal)  {
        listastavki.add(artikal);
    }

    private void setKolicina(Integer kolicina) {
        kol.add(kolicina);
    }

    public Racun(ArrayList<Integer> kol, ArrayList<Artikal> listastavki) {
        this.kol = kol;
        this.listastavki = listastavki;
    }

    public void dodajStavku(Artikal artikal, int kolicina){
       setArtikal(artikal);
       setKolicina(kolicina);
    }

    public double ukupanIznos(){
        double zaplatiti = 0;
        for (int i=0;i <listastavki.size();i++){
            zaplatiti += kol.get(i) * listastavki.get(i).getCijena();
        }
        return zaplatiti;
    }

}
