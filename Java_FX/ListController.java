package Java_FX;

import javafx.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ListController implements Initializable {
    public TableView<Quanlydanhsach> tbView;
    public TableColumn<Person,String> cTen;
    public TableColumn<Person,String> cDienthoai;
    public TableColumn<Person, Button> cEdit;
    public TableColumn<Person, Button> cDelete;

    public TextField txtSearch;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cTen.setCellValueFactory(new PropertyValueFactory<Person,String>("Ten"));
        cDienthoai.setCellValueFactory(new PropertyValueFactory<Person,String>("Dienthoai"));
        cEdit.setCellValueFactory(new PropertyValueFactory<Person,Button>("Edit"));
        cDelete.setCellValueFactory(new PropertyValueFactory<Person,Button>("Delete"));
        tbView.setItems(Main.personList);
    }

    public void formScreen() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("form.fxml"));
        javafx.Main.rootStage.setScene(new Scene(root,800,600));
    }

   public void Search(){
        String s = txtSearch.getText();
        List<Quanlydanhsach> ds = Main.personList.stream().filter(p ->p.getTen().startsWith(s) || p.getDienthoai().startsWith(s)).collect(Collectors.toList());
       ObservableList result = FXCollections.observableArrayList();
       result.addAll(ds);
       tbView.setItems(result);
   }

}
