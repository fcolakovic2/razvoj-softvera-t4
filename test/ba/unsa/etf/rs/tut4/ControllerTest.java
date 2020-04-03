package ba.unsa.etf.rs.tut4;

import static org.junit.jupiter.api.Assertions.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;


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

}