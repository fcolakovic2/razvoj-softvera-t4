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
    private ArrayList<Artikal>abc = new ArrayList<>();
    private ObservableList<Artikal> artikli = FXCollections.observableArrayList();



    public void dodajArtikle(ActionEvent actionEvent) {
      String[] unesenitekst = unos.getText().split("\n");
        for (String i : unesenitekst) {
            abc.add(new Artikal(i));
        }

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
        choiceBox.getSelectionModel().getSelectedItem();


    }
}
