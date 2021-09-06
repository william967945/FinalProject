package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class signPageController implements Initializable{
	
	    @FXML
	    private Pane layer1;
	    
	    @FXML
	    private Pane layer2;

	    @FXML
	    private Label title1;

	    @FXML
	    private TextField username1;

	    @FXML
	    private TextField password1;

	    @FXML
	    private Button loginbut;

	    @FXML
	    private Button f1;

	    @FXML
	    private Label title2;

	    @FXML
	    private TextField username2;

	    @FXML
	    private TextField password2;

	    @FXML
	    private TextField gender;

	    @FXML
	    private Button signuobut;

	    @FXML
	    private Button f2;
	    
	    private Stage stage;
	    private Scene scene;
	    private Parent root;
	    
	    getInformation getinfor=new getInformation();
	    
	    
	    public void switchToSignup(ActionEvent event) throws IOException
	    {
	    	
	    	TranslateTransition slide=new TranslateTransition();
			slide.setDuration(Duration.seconds(0.7));
	    	slide.setNode(layer2);
	    	slide.setToX(-365);
	    	slide.play();
	    	TranslateTransition slide1=new TranslateTransition();
			slide1.setDuration(Duration.seconds(0.7));
	    	slide1.setNode(layer1);
	    	slide1.setToX(365);
	    	slide1.play();
	    	title1.setVisible(false);
	    	username1.setVisible(false);
	    	password1.setVisible(false);
	    	loginbut.setVisible(false);
	    	f1.setVisible(false);
	    	title2.setVisible(true);
			username2.setVisible(true);
			f2.setVisible(true);
			gender.setVisible(true);
			signuobut.setVisible(true);
			password2.setVisible(true);	
	    	
	    }
	    public void switchToLogin(ActionEvent event) throws IOException
	    {
	    	TranslateTransition slide=new TranslateTransition();
			slide.setDuration(Duration.seconds(0.5));
	    	slide.setNode(layer1);
	    	slide.setToX(0);
	    	slide.play();
	    	TranslateTransition slide1=new TranslateTransition();
			slide1.setDuration(Duration.seconds(0.5));
	    	slide1.setNode(layer2);
	    	slide1.setToX(0);
	    	slide1.play();
	    	layer2.setTranslateX(0);
	    	title1.setVisible(true);
	    	username1.setVisible(true);
	    	password1.setVisible(true);
	    	loginbut.setVisible(true);
	    	f1.setVisible(true);
	    	title2.setVisible(false);
			username2.setVisible(false);
			f2.setVisible(false);
			gender.setVisible(false);
			signuobut.setVisible(false);
			password2.setVisible(false);	
	    	
	    }
	    public void signupButton(ActionEvent event) throws IOException
	    {
	    	String username=username2.getText();
	    	String password=password2.getText();
	    	String gen=gender.getText();
	    	if(username==""||password==""||gen==""||(password.length()<6&&password.length()>12)||(gen!="boy"&&gen!="girl"))
	    	{	
	    		Alert alt=new Alert(Alert.AlertType.WARNING);
	    		alt.setTitle("Error");
	    		alt.setContentText("You need to input information correctly");
	    		alt.show();}
	    	else {
	    	if(getinfor.Login(username, password)==false&&getinfor.signUp(username, password, gen))
	    	{
	    		username2.setText("");
	    		password2.setText("");
	    		gender.setText("");
	    	}
	    	else
	    	{
	    		Alert alt1=new Alert(Alert.AlertType.ERROR);
	    		alt1.setTitle("Error");
	    		alt1.setContentText("Sign Up Fail");
	    		alt1.show();
	    	}
	    	}
	    }
	    
	    public void LoginButton(ActionEvent event)throws IOException
	    {
	    	String username=username1.getText();
	    	String password=password1.getText();
	    	if(username==""||password=="")
	    	{
	    		Alert alt1=new Alert(Alert.AlertType.ERROR);
	    		alt1.setTitle("Error");
	    		alt1.setContentText("Log in Fail");
	    		alt1.show();
	    	}
	    	else if (getinfor.Login(username, password))
	    	{
	    		
	    		 FXMLLoader loader = new FXMLLoader(getClass().getResource("homePage.fxml"));	
	    		 root = loader.load();	
	    		 homePageController scene2Controller = loader.getController();
	    		 scene2Controller.getname(username);
	    	     stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    	     scene = new Scene(root);
	    	     stage.setScene(scene);
	    	     stage.show();
	    	}
	    	else
	    	{
	    		Alert alt1=new Alert(Alert.AlertType.ERROR);
	    		alt1.setTitle("Error");
	    		alt1.setContentText("Log in Fail");
	    		alt1.show();
	    	}
	    }
	    

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			title2.setVisible(false);
			username2.setVisible(false);
			f2.setVisible(false);
			gender.setVisible(false);
			signuobut.setVisible(false);
			password2.setVisible(false);			
		}
		
		public String getTextfield()
		{return username1.getText();}
		

	


}
