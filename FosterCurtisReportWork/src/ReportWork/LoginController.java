package ReportWork;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginController {
	private WorkLogic newWork = new WorkLogic();
	
	
	@SuppressWarnings("exports")
	public void startLoginWindow(Stage loginStage) {
		TextField userName = new TextField();
		TextField password = new TextField();
		Button loginButton = new Button("Login");
		Label loginMessageLabel = new Label();
		
		loginMessageLabel.textProperty().bind(newWork.loginMessageProperty());
		
		GridPane login = new GridPane();
		BorderPane root = new BorderPane(login);
		
		changeFormat(login);
		
		login.add(new Label("Login "), 0, 0);
		login.add(userName, 1, 0);
		login.add(new Label("Password "), 0, 1);
		login.add(password, 1, 1);
		login.add(loginButton, 1, 2);
		login.add(loginMessageLabel, 1, 4);

		// Declare Action Handler with Lambda
		loginButton.setOnAction(e -> {
			try {
				if(newWork.validateLogin(userName.getText(), password.getText())) {
					ReportWorkController newWork = new ReportWorkController();
					newWork.showReportWork(loginStage);
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		loginStage.setTitle("Report Work");
		Scene windowScene = new Scene(root, 400, 200);
		loginStage.setScene(windowScene);
		loginStage.show();

	}
	
	@SuppressWarnings("exports")
	public void changeFormat(GridPane login) {
		login.setAlignment(Pos.CENTER_RIGHT);
		login.setPadding(new Insets(20));
		login.setVgap(10); 
	}
	  
	  //public void changeFormat(String newLabel) { changeFormat(login); }
	 
}
