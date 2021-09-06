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
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import javafx.stage.Stage;

public class homePageController implements Initializable{
	@FXML
    private Button bt2;
	
    @FXML
	private TextField TextField;

    @FXML
    private Button bt3;

    @FXML
    private Button bt4;

    @FXML
    private Button bt5;

    @FXML
    private Button bt6;

    @FXML
    private Button bt7;

    @FXML
    private Button bt8;

    @FXML
    private Button bt9;

    @FXML
    private Button bt10;

    @FXML
    private Button bt11;

    @FXML
    private Button bt12;

    @FXML
    private Button bt1;
	 private Stage stage;
	 private Scene scene;
	 
	 @FXML
	 private TextField userName;
	 
	 @FXML
	 private Button launchbtu;
	 
	 Datebase datebase=new Datebase();
	Connection conn=null;
	ResultSet re=null;
		Statement stat=null;
	 getInformation getinfor=new getInformation();
	
		
public void switchToScene1(ActionEvent event)throws IOException
{
	FXMLLoader loader = new FXMLLoader(getClass().getResource("homePage.fxml"));	
	Parent root = loader.load();	
	homePageController scene2Controller = loader.getController();
	scene2Controller.getname(userName.getText());
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
public void goTosearchPage(ActionEvent event)throws IOException, SQLException
{
	conn=datebase.getconn();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("searchPage.fxml"));	
	Parent root = loader.load();	
	searchPageController scene2Controller = loader.getController();
	if(TextField.getText()!=""&&TextField.getText()!=" "&&TextField.getText()!="  ")
	{scene2Controller.setTextField(TextField.getText());
	scene2Controller.setListView();
	}
	scene2Controller.getname(userName.getText());
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
	}
public void bt4(ActionEvent event)throws IOException, SQLException
{
	conn=datebase.getconn();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("searchPage.fxml"));	
	Parent root = loader.load();	
	searchPageController scene2Controller = loader.getController();
	
	scene2Controller.setTextField("3C");
	scene2Controller.setListViewBydialog();
	scene2Controller.getname(userName.getText());
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
public void bt5(ActionEvent event)throws IOException, SQLException
{
	conn=datebase.getconn();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("searchPage.fxml"));	
	Parent root = loader.load();	
	searchPageController scene2Controller = loader.getController();
	scene2Controller.setTextField("美妝保養");
	scene2Controller.setListViewBydialog();
	scene2Controller.getname(userName.getText());
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
public void bt6(ActionEvent event)throws IOException, SQLException
{
	conn=datebase.getconn();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("searchPage.fxml"));	
	Parent root = loader.load();	
	searchPageController scene2Controller = loader.getController();
	scene2Controller.setTextField("男生服飾");
	scene2Controller.setListViewBydialog();
	scene2Controller.getname(userName.getText());
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
public void bt7(ActionEvent event)throws IOException, SQLException
{
	conn=datebase.getconn();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("searchPage.fxml"));	
	Parent root = loader.load();	
	searchPageController scene2Controller = loader.getController();
	scene2Controller.setTextField("女生服飾");
	scene2Controller.setListViewBydialog();
	scene2Controller.getname(userName.getText());
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
public void bt8(ActionEvent event)throws IOException, SQLException
{
	conn=datebase.getconn();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("searchPage.fxml"));	
	Parent root = loader.load();	
	searchPageController scene2Controller = loader.getController();
	scene2Controller.setTextField("運動");
	scene2Controller.setListViewBydialog();
	scene2Controller.getname(userName.getText());
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
public void bt9(ActionEvent event)throws IOException, SQLException
{
	conn=datebase.getconn();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("searchPage.fxml"));	
	Parent root = loader.load();	
	searchPageController scene2Controller = loader.getController();
	scene2Controller.setTextField("配件");
	scene2Controller.setListViewBydialog();
	scene2Controller.getname(userName.getText());
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
public void bt10(ActionEvent event)throws IOException, SQLException
{
	conn=datebase.getconn();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("searchPage.fxml"));	
	Parent root = loader.load();	
	searchPageController scene2Controller = loader.getController();
	scene2Controller.setTextField("寵物");
	scene2Controller.setListViewBydialog();
	scene2Controller.getname(userName.getText());
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
public void bt11(ActionEvent event)throws IOException, SQLException
{
	conn=datebase.getconn();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("searchPage.fxml"));	
	Parent root = loader.load();	
	searchPageController scene2Controller = loader.getController();
	scene2Controller.setTextField("家電");
	scene2Controller.setListViewBydialog();
	scene2Controller.getname(userName.getText());
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
public void bt12(ActionEvent event)throws IOException, SQLException
{
	conn=datebase.getconn();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("searchPage.fxml"));	
	Parent root = loader.load();	
	searchPageController scene2Controller = loader.getController();
	scene2Controller.setTextField("食品");
	scene2Controller.setListViewBydialog();
	scene2Controller.getname(userName.getText());
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
public void bt13(ActionEvent event)throws IOException, SQLException
{
	conn=datebase.getconn();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("searchPage.fxml"));	
	Parent root = loader.load();	
	searchPageController scene2Controller = loader.getController();
	scene2Controller.setTextField("書籍與文創");
	scene2Controller.setListViewBydialog();
	scene2Controller.getname(userName.getText());
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
public void bt14(ActionEvent event)throws IOException, SQLException
{
	conn=datebase.getconn();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("searchPage.fxml"));	
	Parent root = loader.load();	
	searchPageController scene2Controller = loader.getController();
	scene2Controller.setTextField("男生包包與精品");
	scene2Controller.setListViewBydialog();
	scene2Controller.getname(userName.getText());
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
public void bt15(ActionEvent event)throws IOException, SQLException
{
	conn=datebase.getconn();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("searchPage.fxml"));	
	Parent root = loader.load();	
	searchPageController scene2Controller = loader.getController();
	scene2Controller.setTextField("女生包包與精品");
	scene2Controller.setListViewBydialog();
	scene2Controller.getname(userName.getText());
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
public void switchtostorypage(ActionEvent event) throws IOException {
	FXMLLoader loader = new FXMLLoader(getClass().getResource("storyPage.fxml"));	
	Parent root = loader.load();	
	storyPageController scene2Controller = loader.getController();
	scene2Controller.getname(userName.getText());
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
public void switchtoproductpage(ActionEvent event) throws IOException {
	FXMLLoader loader = new FXMLLoader(getClass().getResource("productPage.fxml"));	
	Parent root = loader.load();	
	productPagecontroller scene2Controller = loader.getController();
	scene2Controller.getname(userName.getText());
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
}
public void getname(String name) throws IOException
{
 userName.setText(name);
}
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	userName.setVisible(false);// TODO Auto-generated method stub
}


}
