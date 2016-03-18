package literata;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ProgressBar;
import javafx.event.ActionEvent;

public class TestAppController implements Initializable {
    private double pbVal = 0;

    @FXML
    private TextField fxTextField1;

    @FXML
    private ProgressBar fxProgressBar1;

    @FXML
    void handleCheckBox1Action(ActionEvent event) {
        System.out.println("handleCheckBox1Action");
        pbVal += 0.1;
        fxProgressBar1.setProgress(pbVal);
    }

    @FXML
    void handlePushButtonAction(ActionEvent event) {
        System.out.println("handlePushButtonAction");
        pbVal += 0.1;
        fxProgressBar1.setProgress(pbVal);
    }

    @FXML
    void handleRadioButton1Action(ActionEvent event) {
        System.out.println("handleRadioButton1Action");
        pbVal += 0.1;
        fxProgressBar1.setProgress(pbVal);
    }

    @FXML
    void handleRadioButton2Action(ActionEvent event) {
        System.out.println("handleRadioButton2Action");
        pbVal += 0.1;
        fxProgressBar1.setProgress(pbVal);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fxTextField1.setPromptText("Enter a valid REGEXP string");
    }
}
