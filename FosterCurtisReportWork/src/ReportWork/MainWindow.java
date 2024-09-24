package ReportWork;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.skin.DatePickerSkin;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
* TODO
* +validate for null value and tell the user and change validate to false. 
* 	-fixed with selection statement in the WorkLogic with method isBlank
* 	-fixed so that automatically tells user what is wrong such as username
* 	 or password with StringProperty
* 
* +add HashMap to userNames and rename userNames to empIds in Home
* 	***I might not need to use this. I would need research to how accomplish
* 	   validating with two birds one stone method. 
* 	+After doing research, I found that it not great to make username and password
* 	encapsulate in the code, that often is used for databases so in future I will use
* 	Microsoft Access for that. 
* 
* +Fix clientServerNames
* 	-Did partial fix, I did not understand what was going on with BufferReader
* 	so I reverted back to what I know would work. But now I need to figure out 
* 	how get multiple lines from the url. 
*
* 
* 
* 
* +Update look for LoginController
* 	-Used changeFormat method that was block commented
* 
* +Figure out how to keep loginController so it doesn't move based loginMessages
* 
* +Make AdminController window that adds users
* 
* 
* 
* 
*/

public class MainWindow extends Application {
	
	@SuppressWarnings("exports")
	public void start(Stage loginStage) throws Exception {
		LoginWindow loginWindow = new LoginWindow();
		loginWindow.startLoginWindow(loginStage);
		
		Driver work = new Driver();
		//Panes
		HBox rootPane = new HBox();
		VBox addClientsPane = new VBox();
		BorderPane rightView = new BorderPane();
		BorderPane leftView = new BorderPane();
		
	
		//Controls
		Button addButton = new Button("Add Work");
		Label selectedNames = new Label();
		//Label hoursWorked = new Label();
		TextField clockin = new TextField();
		TextField clockout = new TextField();
		
		ComboBox<String> clientBox = new ComboBox<>();
		ComboBox<String> inAmPmList = new ComboBox<>();
		ComboBox<String> outAmPmList = new ComboBox<>();
		
		rootPane.setPrefSize(600, 400);
		leftView.setPrefSize(500, 200);
		rightView.setPrefSize(500, 200);
		clockin.setMaxWidth(25);
		clockout.setMaxWidth(25);
		rootPane.getChildren().addAll(leftView,rightView);
		

		ObservableList<String> inAmPm = FXCollections.observableArrayList("AM", "PM");
		ObservableList<String> outAmPm = FXCollections.observableArrayList("AM", "PM");
		ObservableList<String> clientBoxList = FXCollections.observableArrayList(work.clientServerNames());
		
		clientBox.setItems(clientBoxList);
		inAmPmList.setItems(inAmPm);
		outAmPmList.setItems(outAmPm);
		
		
		
		clientBox.setPromptText("Select a Client");
		inAmPmList.setPromptText("AM or PM");
		outAmPmList.setPromptText("AM or PM");
		
		inAmPmList.setOnMouseClicked(clockinEvent -> {
			String selectionIn = inAmPmList.getSelectionModel().getSelectedItem();
			if(selectionIn != null) {
				work.setTempIn(selectionIn);
			}
		});
		
		outAmPmList.setOnMouseClicked(mouseEvent -> 
			{String selectedName = outAmPmList.getSelectionModel().getSelectedItem();
			if (selectedName != null) {
				outAmPmList.setPromptText(selectedName);
			}
		});
		
		clientBox.setOnMouseClicked(clientEvent -> {
		    String selectedName = clientBox.getSelectionModel().getSelectedItem();
		    if (selectedName != null) {
		        selectedNames.setText(selectedName);
		    }
		});
		
		//addButton.setOnAction(this);
		
		DatePicker newDate = new DatePicker();
		newDate.setManaged(false);
		newDate.setVisible(false);
		DatePickerSkin newDateSkin = new DatePickerSkin(newDate);
		Node datePicContent = newDateSkin.getPopupContent();
		
		
		addClientsPane.getChildren().addAll(clientBox, clockin, inAmPmList, clockout, outAmPmList, addButton);
		
		
		leftView.setTop(addClientsPane);
		leftView.setBottom(datePicContent);
		leftView.setCenter(selectedNames);
		
		
		addClientsPane.setAlignment(Pos.CENTER);
		addClientsPane.setSpacing(10);
		leftView.setMargin(addClientsPane, new Insets(10));
		leftView.setMargin(datePicContent, new Insets(10));
	
		Scene windowScene = new Scene(rootPane);
		loginStage.setTitle("Report Work");
		loginStage.setScene(windowScene);
		loginStage.show();	
	
	}

	public static void main(String[] args) {
		launch(args);
	}
}
