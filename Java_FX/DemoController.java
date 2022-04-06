package Java_FX;

import Session7.Assignment.Main;
import Session7.Assignment.Product;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class DemoController {
    public Text result;
    public Text errMsg;
    public TextField Ten;
    public TextField Dienthoai;

    public Quanlydanhsach quanlydanhsach;

    public void setData(Quanlydanhsach quanlydanhsach){
        this.quanlydanhsach = quanlydanhsach;
    }
    public void submit(){
//        String s = "\n------------------";
//        s+= "\n"+fullName.getText();
//        s+= "\n"+email.getText();
//        s+= "\n"+age.getText();
//
        try{
            Product p = new Product(Ten.getText(), Dienthoai.getText());
            result.setText(result.getText()+p.toString());
            Session7.Assignment.Main.productList.add(p);

//            renderList();

            Parent root = FXMLLoader.load(getClass().getResource("list.fxml"));
            Session7.Assignment.Main.rootStage.setScene(new Scene(root,800,600));
            errMsg.setVisible(false);
        }catch (Exception e){
            errMsg.setText(e.getMessage());
            errMsg.setVisible(true);
        }

    }

    private void renderList(){
        String txt = "Infomation\n";
        for (Product p: Main.productList){
            txt+= p.toString();
        }
        result.setText(txt);

        Ten.setText("");
        Dienthoai.setText("");
    }
}
