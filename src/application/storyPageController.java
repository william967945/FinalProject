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
	scene2Controller.setTextField("???????????????-????????????");
	scene2Controller.setListViewbystory();
	scene2Controller.setTextField("???????????????-??????&??????&????????????-??????");
	scene2Controller.setListViewbystory();
	scene2Controller.setTextField("?????????Dyson V11 Fluffy+???????????????-Dyson");
	scene2Controller.setListViewbystory();
	scene2Controller.setTextField("??????????????????-?????????");
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
	scene2Controller.setTextField("????????????????????????-????????????");
	scene2Controller.setListViewbystory();
	scene2Controller.setTextField("??????????????????-Arrr");
	scene2Controller.setListViewbystory();
	scene2Controller.setTextField("???????????????-????????????");
	scene2Controller.setListViewbystory();
	scene2Controller.setTextField("?????????????????????-??????");
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
	scene2Controller.setTextField("Explorer ?????????(??????)-Balenciaga");
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
	scene2Controller.setTextField("Dior ?????????????????????_Dior");
	scene2Controller.setListViewbystory();
	scene2Controller.setTextField("?????? ????????????_LANEIGE");
	scene2Controller.setListViewbystory();
	scene2Controller.setTextField("?????????????????????????????????????????????_??????");
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



