package Java_FX;

import javafx.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public final class Quanlydanhsach{
    public String Ten;
    public String Dienthoai;
    public Button edit;
    public Button delete;

    public Quanlydanhsach(String Ten, String Dienthoai) {
        this.Ten = Ten;
        this.Dienthoai = Dienthoai;
        this.edit = new Button("edit");
        this.edit.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("form.fxml"));
                Parent root = loader.load();
                DemoController d = loader.getController();
                d.setData(this);
                Java_FX.Main.rootStage.setScene(new Scene(root, 800, 600));
            } catch (Exception e) {

            }
        });
        this.delete = new Button("Delete");
        this.delete.setOnAction(event -> {
            Main.personList.remove(this);
        });
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getDienthoai() {
        return Dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        Dienthoai = dienthoai;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public Button getDelete() {
        return delete;
    }

    public void setDelete(Button delete) {
        this.delete = delete;
    }

    public String toString() {
        String s = "\n---------------------";
        s += "\n" + getTen();
        s += "\n" + getDienthoai();
        return s;
    }

}