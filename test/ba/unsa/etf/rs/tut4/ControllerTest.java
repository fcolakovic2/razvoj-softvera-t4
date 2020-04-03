package ba.unsa.etf.rs.tut4;

import static org.junit.jupiter.api.Assertions.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.lang.reflect.InvocationTargetException;


@ExtendWith(ApplicationExtension.class)
class ControllerTest {
        @Start
        public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
        stage.setTitle("Hello World");
        stage.setScene(new Scene(root, 600, 575));
        stage.show();
        stage.setResizable(false);
        stage.toFront();
    }

    @Test
    void Test1(FxRobot robot){
        TextArea textArea2 = robot.lookup("#unos").queryAs(TextArea.class);
        assertNotNull(textArea2);
    }

    @Test
    void Test2(FxRobot robot){
        robot.clickOn("#Račun");
        Spinner spiner = robot.lookup("#kol").queryAs(Spinner.class);
        assertNotNull(spiner);
    }

    @Test
    void Test3(FxRobot robot){
        TextArea area1 = robot.lookup("#unos").queryAs(TextArea.class);
        TextArea area2 = robot.lookup("#ispis").queryAs(TextArea.class);
        Button dugme = robot.lookup("#dugme").queryAs(Button.class);
        robot.clickOn("#unos");
        robot.write("ABC,Proizvod,100\n");
        robot.write("ABC,Proizvod,100\n");
        robot.clickOn(dugme);
        assertEquals("ABC,Proizvod,100.0\n", area2.getText());
    }

    @Test
    void Test4(FxRobot robot){
        TextArea area1 = robot.lookup("#unos").queryAs(TextArea.class);
        TextArea area2 = robot.lookup("#ispis").queryAs(TextArea.class);
        Button dugme = robot.lookup("#dugme").queryAs(Button.class);
        robot.clickOn("#unos");
        robot.write("ABC,Proizvod,100\n");
        robot.write("ABC,Proizvod,200\n");
        robot.clickOn(dugme);
        assertEquals("ABC,Proizvod,100.0\nABC,Proizvod,200.0\n", area2.getText());
    }

    @Test
    void Test5(FxRobot robot){
        TextArea area1 = robot.lookup("#unos").queryAs(TextArea.class);
        TextArea area2 = robot.lookup("#ispis").queryAs(TextArea.class);
        TextArea area3 = robot.lookup("#ispisitajracun").queryAs(TextArea.class);
        Button dugme = robot.lookup("#dugme").queryAs(Button.class);
        robot.clickOn("#unos");
        robot.write("ABC,Proizvod,100\n");
        robot.write("ABC,Proizvod,200\n");
        robot.clickOn(dugme);
        assertEquals("ABC,Proizvod,100.0\nABC,Proizvod,200.0\n", area2.getText());
        robot.clickOn("#Račun");
        robot.clickOn("#choiceBox");
        robot.press(KeyCode.ENTER);
        robot.release(KeyCode.ENTER);
        robot.clickOn("#kol");
        robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        robot.type(KeyCode.DIGIT8);
        robot.clickOn("#dugme2");
        assertEquals("ABC,Proizvod,100.0    00,000\nUKUPNO                0,00", area3.getText());

    }


    @Test
    void Test6(FxRobot robot){
        TextArea area1 = robot.lookup("#unos").queryAs(TextArea.class);
        TextArea area2 = robot.lookup("#ispis").queryAs(TextArea.class);
        TextArea area3 = robot.lookup("#ispisitajracun").queryAs(TextArea.class);
        Button dugme = robot.lookup("#dugme").queryAs(Button.class);
        robot.clickOn(area1);
        robot.write("Test,Testni,10\nTest,Testnic,20");
        robot.clickOn(dugme);
        assertEquals("Test,Testni,10.0\nTest,Testnic,20.0\n", area2.getText());
    }

    @Test
    void Test7(FxRobot robot){
        robot.clickOn("#Račun");
        ChoiceBox cojs = robot.lookup("#choiceBox").queryAs(ChoiceBox.class);
        Spinner spiner = robot.lookup("#kol").queryAs(Spinner.class);
        assertNotNull(spiner);
        assertNotNull(cojs);

    }

}