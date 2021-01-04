package gui;

import gui.util.Limitante;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FormDepartamentoController implements Initializable{

    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNome;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label labelErrorNome;
    
    @FXML
    public void btnSalvarOnAction(){
        System.out.println("btnSalvarOnAction");
    }
    
    @FXML
    public void btnCancelarOnAcation(){
        System.out.println("btnCancelarOnAcation");
    }
    
    @Override
    public void initialize(URL utl, ResourceBundle rb) {
       iniciarNodes();
    }
    
    private void iniciarNodes(){
        Limitante.setTextFieldInteger(txtId);
        Limitante.setTextFieldMaxLength(txtNome, 30);
    }

}
