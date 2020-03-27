package ba.unsa.etf.rs.tut4;

import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.Arrays;

import static ba.unsa.etf.rs.tut4.Artikal.izbaciDuplikate;

public class Controller {

    public TextArea unos;
    public TextArea ispis;
    public ChoiceBox choiceBox;

    public void dodajArtikle(ActionEvent actionEvent) {
      ArrayList<String> unesenitekst = new ArrayList<>(Arrays.asList(unos.getText().split("\n")));
      izbaciDuplikate(unesenitekst);
      String unesenitekst2 = String.join("\n", unesenitekst);
      ispis.setText(unesenitekst2);
      ispis.setDisable(true);
      choiceBox.getChildrenUnmodifiable().add(unesenitekst2);



    }
}
