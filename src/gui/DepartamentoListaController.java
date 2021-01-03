package gui;

import Application.Program;
import Model.entities.Departamento;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DepartamentoListaController implements Initializable{

    @FXML    
    private TableView<Departamento> tableViewDepartamento;
    
    @FXML
    private TableColumn<Departamento, Integer> tableColumnId;
    
    @FXML
    private TableColumn<Departamento, String> tableColumnNome;
    
    @FXML
    private Button btnNew;
    
    @FXML
    public void onBtnNewAction(){
        System.out.println("onBtnNewAction");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciarNodos();
    }

    private void iniciarNodos() {
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        Stage stage = (Stage) Program.getMainScene().getWindow();
        tableViewDepartamento.prefHeightProperty().bind(stage.heightProperty());
    }

}
