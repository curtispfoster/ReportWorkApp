package ReportWork;

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

public class ReportWorkController {
	
	@SuppressWarnings({ "exports", "static-access" })
	public void showReportWork(Stage reportStage) throws Exception {
		
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
		reportStage.setTitle("Report Work");
		reportStage.setScene(windowScene);
		reportStage.show();	
	}
	
}

