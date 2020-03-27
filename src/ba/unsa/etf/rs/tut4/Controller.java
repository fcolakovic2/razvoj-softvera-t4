package ba.unsa.etf.rs.tut4;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import static ba.unsa.etf.rs.tut4.Artikal.izbaciDuplikate;

public class Controller implements Initializable {

    public TextArea unos;
    public TextArea ispis;
    public ChoiceBox<Artikal> choiceBox;
    public Spinner<Integer> kol;
    public TextArea racun;
    public TextArea ispisitajracun;
    private static ArrayList<Artikal>abc = new ArrayList<>();
    private static ObservableList<Artikal> artikli = FXCollections.observableArrayList();



    public void dodajArtikle(ActionEvent actionEvent) {
      String[] unesenitekst = unos.getText().split("\n");
        for (String i : unesenitekst) {
            abc.add(new Artikal(i));
        }

        artikli.clear();
        artikli.addAll(abc);

      Artikal.izbaciDuplikate(abc);
      String rezultat="";
      for (Artikal i : abc){
          rezultat=rezultat+i+"\n";
      }
      ispis.setText(rezultat);
      ispis.setDisable(true);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        artikli.addAll(abc);
        choiceBox.setItems(artikli);
        SpinnerValueFactory<Integer> quantityValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        this.kol.setValueFactory(quantityValueFactory);
    }


    public void dodaj(ActionEvent actionEvent) {
       int brojproizvoda = kol.getValue();   //uzimam broj proizvioda preko kolicine zadane u spinneru
       String artikal = String.valueOf(choiceBox.getValue());
       Artikal rezultat = new Artikal();
       for (int i=0; i<abc.size();i++){    //prolazim kroz observListu i ako je artikal iz choiceboxa jednak nekom od ovih iz liste, taj iz liste ce bit rezultujuci
           if (artikal.equals(abc.get(i).getSifra())){
               rezultat=abc.get(i);
           }
       }
        double zaplatiti=0;
        zaplatiti = zaplatiti + rezultat.getCijena() * brojproizvoda;  //racunanje ukupnog placanja, cijena puta broj proizvoda
       ArrayList<String> ispisracuna = new ArrayList<>();
       ispisracuna.add(String.format("%5s%5d%.3f", artikal, brojproizvoda, rezultat.getCijena()));  //formatiran ispis utem metode String.format , mislim da je moglo i printf-om
       StringBuilder ispisracunabuilder = new StringBuilder();
       for (int i=0; i<ispisracuna.size();i++){   //prolaz kroz niz stringova , za svaki string dodaje novi red i odgovarajuci artikal kolicinu i cijenu
           ispisracunabuilder.append(ispisracuna.get(i));
           ispisracunabuilder.append("\n");
       }
       ispisracunabuilder.append(String.format("UKUPNO%17.2f", zaplatiti)); //dodavanje ukupne cijene za platiti
       ispisitajracun.setText(ispisracunabuilder.toString()); //pristup textarea i postavljanje teksta na konacni ispis svega



    }

}
