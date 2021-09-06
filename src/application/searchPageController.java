package application;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;



public class searchPageController implements Initializable{
	Datebase datebase=new Datebase();
	Connection conn=null;
	ResultSet re=null;
	Statement stat=null;
	private Stage stage;
	private Scene scene;
	
	@FXML
    private ImageView image;

    @FXML
    private Pane pane1;

    @FXML
    private Button bt1;

    
    @FXML
    private TextField Textfeild;

    @FXML
    private Button bt3;

    @FXML
    private Button bt2;
    
    @FXML
    private TextArea comArea;

    @FXML
    private TextField Textfield2;

    @FXML
    private Button bt4;

    @FXML
    private ListView<String>myListView;
    
    @FXML
    private TextArea textArea;
    
    @FXML
    private ChoiceBox<String>ChoiceBox;
    
    @FXML
    private TextField userName;
    
  
    
    getInformation getinfor=new getInformation();
    
    public void initialize(URL arg0, ResourceBundle arg1)
    {
      ChoiceBox.getItems().add("5星");
      ChoiceBox.getItems().add("4星");
      ChoiceBox.getItems().add("3星");
      ChoiceBox.getItems().add("2星");
      ChoiceBox.getItems().add("1星");
      userName.setVisible(false);
    }
    
    public void switchToScene1(ActionEvent event) throws IOException {
    	reset();
    	image.setVisible(true);
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("homePage.fxml"));	
    	Parent root = loader.load();	
    	homePageController scene2Controller = loader.getController();
    	scene2Controller.getname(userName.getText());
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    }
    public void reset() 
    {
    	
    	myListView.getItems().removeAll(myListView.getItems());
    }
    public void reset2()
    {
    	textArea.setText("");
    }
    public void reset3()
    {
    	comArea.setText("「CommentField」"+"\n"+"-----------------------------------------");
    	comArea.appendText("\n");
    	
    }
    
    public void setListView(ActionEvent event) throws IOException, SQLException
    {
    	reset();
    	reset3();
    	image.setVisible(true);
    	
    	String a=Textfeild.getText().toString();
    	if(a!=""&&a!=" "&&a!="  "&&a!="   ")
       {conn=datebase.getconn();
		stat=conn.createStatement();
    	String re="SELECT * FROM products WHERE name LIKE '%"+a+"%'";
    	PreparedStatement pst=conn.prepareStatement(re);
    	ResultSet result=pst.executeQuery();

    	ResultSetMetaData metaData = result.getMetaData();
    	int columnCount = metaData.getColumnCount();
    	while(result.next()) {
    		   for(int i=1;i<=columnCount;i++) {
    		    if(i>=1) {
    		     myListView.getItems().add(result.getString(i));
    		    }
    		   }
    		   
    }}}
    public void setListView() throws SQLException
    {
    	reset();
    	image.setVisible(true);
    	String a=Textfeild.getText().toString();
    	if(a=="")
    	{conn=datebase.getconn();
		stat=conn.createStatement();
    	String re="SELECT * FROM products WHERE name LIKE '%"+a+"%'";
    	PreparedStatement pst=conn.prepareStatement(re);
    	ResultSet result=pst.executeQuery();
    	ResultSetMetaData metaData = result.getMetaData();
    	int columnCount = metaData.getColumnCount();
    	while(result.next()) {
    		   for(int i=1;i<=columnCount;i++) {
    		    if(i>=1) {
    		     myListView.getItems().add(result.getString(i));
    		    }
    		   }}
    }}
    public void setListViewbystory() throws SQLException
    {
    	
    	String a=Textfeild.getText().toString();
    	if(a!="")
    	{conn=datebase.getconn();
		stat=conn.createStatement();
    	String re="SELECT * FROM products WHERE name LIKE '%"+a+"%'";
    	PreparedStatement pst=conn.prepareStatement(re);
    	ResultSet result=pst.executeQuery();

    	ResultSetMetaData metaData = result.getMetaData();
    	int columnCount = metaData.getColumnCount();
    	while(result.next()) {
    		   for(int i=1;i<=columnCount;i++) {
    		    if(i>=1) {
    		     myListView.getItems().add(result.getString(i));
    		    }
    		   }}
    }}
    public double averge() throws SQLException
    {
    	String a=myListView.getSelectionModel().getSelectedItem();
    	double ave=0;
    	conn=datebase.getconn();
 		stat=conn.createStatement();
     	String re3="SELECT * FROM commentTable WHERE name LIKE '%"+a+"%'";
     	PreparedStatement pst3=conn.prepareStatement(re3);
     	ResultSet result3=pst3.executeQuery();
     	
     	double row=0;
     	while(result3.next()) {
     		row+=1;
     		ave+=result3.getInt("star");
     		   }
     	if(ave>row)
        {ave=ave/row;}
     	else if (ave==0) 
     	{ave=0;}
        
		return ave;

    	}
    
    public void getinfo(ActionEvent event) throws IOException, SQLException
    {
    	reset2();
    	reset3();
    	
    	image.setVisible(false);
    	String a=myListView.getSelectionModel().getSelectedItem();
    	conn=datebase.getconn();
		stat=conn.createStatement();
    	String re="SELECT * FROM IDname WHERE name LIKE '%"+a+"%'";
    	PreparedStatement pst=conn.prepareStatement(re);
    	ResultSet result=pst.executeQuery();
    	ResultSetMetaData metaData = result.getMetaData();
    	int columnCount = metaData.getColumnCount();
    	String product=null;
    	while(result.next()) {
    		String av=null;
        	if(averge()>0)
        	{av=String.format("%.1f", averge())+"星";}
        	else
        	{av="尚未有評價";}
        	comArea.appendText("綜合評價: "+av+"\n-----------------------------------------\n");
    	for(int i=1;i<=columnCount;i++) {
    	if(i%5==1) {
    		 textArea.appendText("ID: ");
    		 product=result.getString(i);
    		 textArea.appendText(product+"\n");
        		}
    	else if(i%5==2) {
   		 textArea.appendText("name: ");
   		 product=result.getString(i);
   		 textArea.appendText(product+"\n");
       		}
    	else if(i%5==3) {
   		 textArea.appendText("dialog: ");
   		 product=result.getString(i);
   		 textArea.appendText(product+"\n");
       		}
    	else if(i%5==4) {
   		 textArea.appendText("price: ");
   		 product=result.getString(i);
   		 textArea.appendText(product+"\n");
       		}
    	else
    	{}
        	 }}
    	result.close();
    	Textfield2.setText("");
    	String re1="SELECT * FROM commentTable WHERE name LIKE '%"+myListView.getSelectionModel().getSelectedItem()+"%'";
    	PreparedStatement pst1=conn.prepareStatement(re1);
    	ResultSet result1=pst1.executeQuery();

    	ResultSetMetaData metaData1= result1.getMetaData();
    	int columnCount1 = metaData1.getColumnCount();
    	while(result1.next()) {
    	for(int i=1;i<=columnCount1;i++) {
    	if(i%5==2) {
        comArea.appendText(result1.getString(i));
        comArea.appendText(":");
        
    }
    	else if(i%5==3) {
    	comArea.appendText("(");
    	comArea.appendText(result1.getString(i));
    	comArea.appendText("星)");
    	comArea.appendText("\n");
    	}
    	else if(i%5==0) {
    	comArea.appendText(result1.getString(i));
        comArea.appendText("\n");
    	}
    	else {}
    	}}
    	result1.close();
    	}
    	
    public void setTextField(String name)
    {
    	if(name!=null)
    	{Textfeild.setText(name);}
    }
    public void setListViewBydialog() throws SQLException
    {
        
    	reset();
    	String a=Textfeild.getText().toString();
    	image.setVisible(true);
    	conn=datebase.getconn();
		stat=conn.createStatement();
    	String re="SELECT * FROM dialogproducts WHERE dialog LIKE '%"+a+"%'";
    	PreparedStatement pst=conn.prepareStatement(re);
    	ResultSet result=pst.executeQuery();

    	ResultSetMetaData metaData = result.getMetaData();
    	int columnCount = metaData.getColumnCount();
    	while(result.next()) {
    	for(int i=1;i<=columnCount;i++) {
    	if(i>=1) {
        myListView.getItems().add(result.getString(i));
    }
    		   }}}
    public void bt4(ActionEvent event) throws SQLException, IOException
    {
    	String a= myListView.getSelectionModel().getSelectedItem();
    	conn=datebase.getconn();
		stat=conn.createStatement();
    	String re="SELECT * FROM IDname WHERE name LIKE '%"+a+"%'";
    	PreparedStatement pst=conn.prepareStatement(re);
    	ResultSet result=pst.executeQuery();
    	
    	if(result.next()==false)
     	{Alert alt1=new Alert(Alert.AlertType.ERROR);
 		alt1.setTitle("Error");
 		alt1.setContentText("You need to Pick some product or You select Dialog Label");
 		alt1.show();}
    	while(result.next())
    	{
    	conn= datebase.getconn();
		stat=conn.createStatement();
		String query=("INSERT INTO commentTable(userName,star,name,comment) VALUES(?,?,?,?)");
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setString(1, userName.getText());
		ps.setString(2, ChoiceBox.getSelectionModel().getSelectedItem().substring(0, 1));
		ps.setString(3, a);
		ps.setString(4, Textfield2.getText());
		ps.execute();
		Textfield2.setText("");}
       
    	}
    public void webbtu(ActionEvent event) throws IOException, URISyntaxException, SQLException 
    {
    	String a=myListView.getSelectionModel().getSelectedItem();
    	String url=null;
    	if(a!=""&&a!=" "&&a!="  "&&a!="   ")
        {conn=datebase.getconn();
 		stat=conn.createStatement();
     	String re="SELECT * FROM IDname WHERE name LIKE '%"+a+"%'";
     	PreparedStatement pst=conn.prepareStatement(re);
     	ResultSet result=pst.executeQuery();

     	ResultSetMetaData metaData = result.getMetaData();
     	int columnCount = metaData.getColumnCount();
     	while(result.next()) {
     		   for(int i=1;i<=columnCount;i++) {
     		    if(i%5==0) {
     		    url=result.getString(i);
     		    }
     		   }
     }}
    	if(url!=null)
    	{Desktop browser=Desktop.getDesktop();
    	browser.browse(new URI(url));}
    	else
    	{Alert alt1=new Alert(Alert.AlertType.ERROR);
		alt1.setTitle("Error");
		alt1.setContentText("You need to Pick some product");
		alt1.show();}
    }
    public void getname(String name) throws IOException
    {
     userName.setText(name);
    }
    

}
