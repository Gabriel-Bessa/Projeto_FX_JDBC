package gui;

import Application.Program;
import Model.entities.Departamento;
import Model.service.DepartamentoService;
import gui.util.Alert;
import static gui.util.Utils.stageAtual;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
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
    public void onBtnNewAction(ActionEvent event){
        Departamento obj = new Departamento();
        Stage parentStage = stageAtual(event);
        createDialogForm(obj, "/gui/FormDepartamento.fxml", parentStage);
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
    
    private void createDialogForm(Departamento obj, String path, Stage parentStage){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Pane pane = loader.load();
            
            FormDepartamentoController controller = loader.getController();
            controller.setEntity(obj);
            
            Stage modalStage = new Stage();
            modalStage.setTitle("Entre com os dados do departamento!");
            modalStage.setScene(new Scene(pane));
            modalStage.setResizable(true);
            modalStage.initOwner(parentStage);
            modalStage.initModality(Modality.WINDOW_MODAL); 
            modalStage.showAndWait();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
            Alert.showAlert("IO Exception", "ERROR", e.getMessage(), javafx.scene.control.Alert.AlertType.ERROR);
        }
    }
    
}
