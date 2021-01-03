package gui;

import Application.Program;
import Model.entities.Departamento;
import Model.service.DepartamentoService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DepartamentoListaController implements Initializable{

    private DepartamentoService service;
    
    @FXML    
    private TableView<Departamento> tableViewDepartamento;
    
    @FXML
    private TableColumn<Departamento, Integer> tableColumnId;
    
    @FXML
    private TableColumn<Departamento, String> tableColumnNome;
    
    @FXML
    private Button btnNew;
    
    private ObservableList<Departamento> obsList; 
    
    @FXML
    public void onBtnNewAction(){
        System.out.println("onBtnNewAction");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciarNodos();
    }

    public void setDepartamentoService(DepartamentoService service){
        this.service = service;
    }
    
    private void iniciarNodos() {
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        
        Stage stage = (Stage) Program.getMainScene().getWindow();
        tableViewDepartamento.prefHeightProperty().bind(stage.heightProperty());
    }

    public void updateTableView(){
        if(service == null){
            throw new IllegalStateException("Service está Nulo!");
        }
        List<Departamento> list = service.findAll();
        obsList = FXCollections.observableArrayList(list);
        tableViewDepartamento.setItems(obsList);
    }
    
}
