package application;
import java.io.IOException;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class productPagecontroller implements Initializable{
	   @FXML
	    private TextField tx1;

	    @FXML
	    private TextField tx3;

	    @FXML
	    private TextField tx2;
	    
	    @FXML
	    private TextField tx4;

	    @FXML
	    private Button bt1;
	    
	    @FXML
	    private Button bt2;
	    
	    @FXML
	    private Label hyperlinklab;
	    
	    @FXML
	    private Label pricelab;
	    
	    

	    
	    @FXML
	    private ChoiceBox<String>ChoiceBox;
	    
	    Datebase datebase=new Datebase();
		Connection conn=null;
		ResultSet re=null;
		Statement stat=null;
		private Stage stage;
		private Scene scene;
		@FXML
	    private Button bt3;

	    @FXML
	    private Button dropbtu;

	    @FXML
	    private Button launchbtu;
	    
	    @FXML
	    private Label dialoglab;

	    @FXML
	    private ChoiceBox<String> ChoiceBox2;

		
		public void switchToScene1(ActionEvent event)throws IOException
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("homePage.fxml"));	
			Parent root = loader.load();	
			homePageController scene2Controller = loader.getController();
			scene2Controller.getname(tx1.getText());
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		public void getname(String name) throws IOException
		{
		 tx1.setText(name);
		}
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			ChoiceBox2.setVisible(false);
			bt3.setVisible(false);
			launchbtu.setVisible(false);
			ChoiceBox.getItems().add("3C產品");
		    ChoiceBox.getItems().add("美妝保養");
		    ChoiceBox.getItems().add("運動");
		    ChoiceBox.getItems().add("配件");
		    ChoiceBox.getItems().add("男生服飾");
		    ChoiceBox.getItems().add("女生服飾");
		    ChoiceBox.getItems().add("食品");
		    ChoiceBox.getItems().add("家電用品");
		    ChoiceBox.getItems().add("寵物");
		    ChoiceBox.getItems().add("男生包包與精品");
		    ChoiceBox.getItems().add("女生包包與精品");
		    ChoiceBox.getItems().add("書籍與文創");
		    ChoiceBox.getItems().add("其他");
		    		    
		    
			// TODO Auto-generated method stub
		}
		public void launch(ActionEvent event) throws SQLException
		{
		 
		 if(tx2.getText().length()>4&&tx3.getText().length()>1&&tx4.getText().length()>10&&tx3.getText()!=" ")
		 {updateUsernamePro();
		  updateIDname();
		  updateDialogProducts();
		  updateProducts();
		 }
		 else
			{Alert alt1=new Alert(Alert.AlertType.ERROR);
			alt1.setTitle("Error");
			alt1.setContentText("You need to input Product name or the length of name isnt enough");
			alt1.show();
			}
		 reset();
		 
		}
		public void drop(ActionEvent event)throws SQLException
		{
		if(ChoiceBox2.getSelectionModel().getSelectedItem().length()>4)
		{dropUsernamePro();
		 dropIDname();
		 dropDialogProduct();
		 dropIDname();
		 dropcomment();
		 dropProducts();
		}
		else
		{Alert alt1=new Alert(Alert.AlertType.ERROR);
		alt1.setTitle("Error");
		alt1.setContentText("You need to choose a product to delete");
		alt1.show();
		 }
		ChoiceBox2.getItems().removeAll(ChoiceBox2.getItems());
		try {
			updateChoiceBox2();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		public void reset()
		{
			tx1.setText("");
			tx2.setText("");
			tx3.setText("");
			tx4.setText("");
		}
		public void updateUsernamePro() throws SQLException
		{
			
			
			conn= datebase.getconn();
			stat=conn.createStatement();
			String query=("INSERT INTO userNamePro(name,product) VALUES(?,?)");
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, tx2.getText());
			ps.setString(2, tx1.getText());
			ps.execute();
			
			
			
		}
		public void updateIDname() throws SQLException
		{
			conn= datebase.getconn();
			stat=conn.createStatement();
			String query=("INSERT INTO IDname(name,dialog,price,hyperlink) VALUES(?,?,?,?)");
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, tx2.getText());
			ps.setString(2, ChoiceBox.getSelectionModel().getSelectedItem());
			ps.setString(3, tx3.getText());
			ps.setString(4, tx4.getText());
			ps.execute();
		}
		public void updateDialogProducts() throws SQLException
		{
			
			conn= datebase.getconn();
			stat=conn.createStatement();
			String query=("INSERT INTO dialogproducts(dialog,name) VALUES(?,?)");
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, ChoiceBox.getSelectionModel().getSelectedItem());
			ps.setString(2, tx2.getText());
			ps.execute();
			}
			
		public void updateProducts() throws SQLException
		{
			conn= datebase.getconn();
			stat=conn.createStatement();
			String query=("INSERT INTO products(name) VALUES(?)");
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, tx2.getText());
			ps.execute();
		}
		public void updateChoiceBox2() throws SQLException
		{
			conn=datebase.getconn();
			stat=conn.createStatement();
			String query="SELECT * FROM userNamePro WHERE product LIKE '%"+tx1.getText()+"%'";
			re=stat.executeQuery(query);
			ResultSetMetaData metaData= re.getMetaData();
			int columnCount=metaData.getColumnCount();
			while(re.next())
		   {for(int i=0;i<columnCount;i++) 
			{if(i%3==2)
			 {ChoiceBox2.getItems().add(re.getString(i));}}}
		}
		public void dropBtu(ActionEvent event)throws IOException
		{
			try {
				updateChoiceBox2();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tx2.setVisible(false);
			tx3.setVisible(false);
			tx4.setVisible(false);
			pricelab.setVisible(false);
			hyperlinklab.setVisible(false);
			dialoglab.setVisible(false);
			ChoiceBox.setVisible(false);
			bt2.setVisible(false);
			ChoiceBox2.setVisible(true);
			bt3.setVisible(true);
			launchbtu.setVisible(true);
			dropbtu.setVisible(false);
			
		}
		public void launchBtu(ActionEvent event)throws IOException
		{
			tx2.setVisible(true);
			tx3.setVisible(true);
			tx4.setVisible(true);
			pricelab.setVisible(true);
			hyperlinklab.setVisible(true);
			dialoglab.setVisible(true);
			ChoiceBox.setVisible(true);
			bt2.setVisible(true);
			ChoiceBox2.setVisible(false);
			bt3.setVisible(false);
			launchbtu.setVisible(false);
			dropbtu.setVisible(true);
			ChoiceBox2.getItems().removeAll(ChoiceBox2.getItems());
		}
		public void dropUsernamePro() throws SQLException
		{
			conn=datebase.getconn();
			stat=conn.createStatement();
			String query="DELETE FROM userNamePro WHERE name LIKE'"+ChoiceBox2.getSelectionModel().getSelectedItem()+"'";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.execute();
		}
		public void dropIDname() throws SQLException
		{
			conn=datebase.getconn();
			stat=conn.createStatement();
			String query="DELETE FROM IDname WHERE name LIKE'"+ChoiceBox2.getSelectionModel().getSelectedItem()+"'";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.execute();
		}
		public void dropDialogProduct() throws SQLException
		{
			conn=datebase.getconn();
			stat=conn.createStatement();
			String query="DELETE FROM dialogproducts WHERE name LIKE'"+ChoiceBox2.getSelectionModel().getSelectedItem()+"'";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.execute();
		}
		public void dropProducts() throws SQLException
		{
			conn=datebase.getconn();
			stat=conn.createStatement();
			String query="DELETE FROM products WHERE name LIKE'"+ChoiceBox2.getSelectionModel().getSelectedItem()+"'";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.execute();
		}
		public void dropcomment() throws SQLException
		{
			conn=datebase.getconn();
			stat=conn.createStatement();
			String query="DELETE FROM commentTable WHERE name LIKE'"+ChoiceBox2.getSelectionModel().getSelectedItem()+"'";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.execute();
		}
		
		
		
	 


}
