package application;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class storyPageController implements Initializable{
	@FXML
    private Button bt1;

    @FXML
    private TextField TextField;

    @FXML
    private Button bt2;

    @FXML
    private Button bt3;

    @FXML
    private Button bt4;

    @FXML
    private Button bt5;
    
    @FXML
    private TextField userName;

    @FXML
    private Button bt6;
    getInformation ok=new getInformation();
    private Stage stage;
	private Scene scene;
	Datebase datebase=new Datebase();
	Connection conn=null;
	ResultSet re=null;
	Statement stat=null;
    

	
	public void initialize(URL arg0, ResourceBundle arg1) {
		userName.setVisible(false);// TODO Auto-generated method stub
	}
    @FXML
public void goTosearchPage(ActionEvent event) throws IOException, SQLException {
    	conn=datebase.getconn();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("searchPage.fxml"));	
    	Parent root = loader.load();	
    	searchPageController scene2Controller = loader.getController();
    	if(TextField.getText()!=""&&TextField.getText()!=" "&&TextField.getText()!="  ")
    	{scene2Controller.setTextField(TextField.getText());
    	scene2Controller.setListView();}
    	scene2Controller.getname(userName.getText());
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	}
   

    

    @FXML
public void switchToScene1(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("homePage.fxml"));	
    	Parent root = loader.load();	
    	homePageController scene2Controller = loader.getController();
    	scene2Controller.getname(userName.getText());
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();;}
    
public void bt3(ActionEvent event) throws IOException, SQLException
{
	conn=datebase.getconn();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("searchPage.fxml"));	
	Parent root = loader.load();	
	searchPageController scene2Controller = loader.getController();
	scene2Controller.getname(userName.getText());
	scene2Controller.setTextField("隨身果汁機-日本愛華");
	scene2Controller.setListViewbystory();
	scene2Controller.setTextField("頂級好茶組-茶王&天池&福壽山茶-琅茶");
	scene2Controller.setListViewbystory();
	scene2Controller.setTextField("新一代Dyson V11 Fluffy+無線吸塵器-Dyson");
	scene2Controller.setListViewbystory();
	scene2Controller.setTextField("頂級現燉燕盞-禧元堂");
	scene2Controller.setListViewbystory();
	scene2Controller.setTextField("");
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
public void bt4(ActionEvent event) throws IOException, SQLException
{
	conn=datebase.getconn();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("searchPage.fxml"));	
	Parent root = loader.load();	
	searchPageController scene2Controller = loader.getController();
	scene2Controller.getname(userName.getText());
	scene2Controller.setTextField("史努比狗狗嗅聞球-自家品牌");
	scene2Controller.setListViewbystory();
	scene2Controller.setTextField("寵物蜜糖被墊-Arrr");
	scene2Controller.setListViewbystory();
	scene2Controller.setTextField("寵物飲水機-自家品牌");
	scene2Controller.setListViewbystory();
	scene2Controller.setTextField("米家智能攝影機-小米");
	scene2Controller.setListViewbystory();
	scene2Controller.setTextField("");
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
public void bt5(ActionEvent event) throws IOException, SQLException
{
	conn=datebase.getconn();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("searchPage.fxml"));	
	Parent root = loader.load();	
	searchPageController scene2Controller = loader.getController();
	scene2Controller.getname(userName.getText());
	scene2Controller.setTextField("AirPods 2_apple");
	scene2Controller.setListViewbystory();
	scene2Controller.setTextField("Apple Watch SE_apple");
	scene2Controller.setListViewbystory();
	scene2Controller.setTextField("Explorer 斜背包(黑色)-Balenciaga");
	scene2Controller.setListViewbystory();
	scene2Controller.setTextField("");
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
public void bt6(ActionEvent event) throws IOException, SQLException
{
	conn=datebase.getconn();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("searchPage.fxml"));	
	Parent root = loader.load();	
	searchPageController scene2Controller = loader.getController();
	scene2Controller.getname(userName.getText());
	scene2Controller.setTextField("Dior 粉色花樣淡香水_Dior");
	scene2Controller.setListViewbystory();
	scene2Controller.setTextField("藍芝 晚安唇膜_LANEIGE");
	scene2Controller.setListViewbystory();
	scene2Controller.setTextField("書籍《不要在該奮鬥時選擇安逸》_誠品");
	scene2Controller.setListViewbystory();
	scene2Controller.setTextField("");
	
	
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
public void getname(String name) throws IOException
{
 userName.setText(name);
}
}



