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
import javafx.application.Application;

public class LoginWindow extends Application{ // Change LoginWindow to Authentication
	private Driver newLogin = new Driver();
	private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 300;
    
	
	@SuppressWarnings("exports")
	public void start(Stage loginStage) {
		TextField userName = new TextField();
		TextField password = new TextField();
		Button loginButton = new Button("Login");
		Label loginMessageLabel = new Label();
		
		GridPane login = new GridPane();
		BorderPane root = new BorderPane(login);
		
		changeFormat(login);
		
		login.add(new Label("Login "), 0, 0);
		login.add(userName, 1, 0);
		login.add(new Label("Password "), 0, 1);
		login.add(password, 1, 1);
		login.add(loginButton, 1, 2);
		login.add(loginMessageLabel, 1, 4); //wrap message so that it doesn't move

		loginButton.setOnAction(e -> {
			try {
				if (newLogin.validateLogin(userName.getText(), password.getText())) {
					loginMessageLabel.setText("Successful Login");
				} else if (userName.getText().isEmpty() && password.getText().isEmpty()) {
					loginMessageLabel.setText("No username & password entered");
					return;
				} else if (userName.getText().isEmpty()) {
					loginMessageLabel.setText("Username is Empty");
					return;
				} else if (password.getText().isEmpty()) {
					loginMessageLabel.setText("No password entered");
					return;
				} else if (!newLogin.invalidPwd(userName.getText())){
					loginMessageLabel.setText("Password is invalid");		
				} else {
					loginMessageLabel.setText("Invalid Username and Password");
				}
				
			} catch (Exception e1) {
				e1.printStackTrace(); // add a logging framework
			}
		});

		loginStage.setTitle("Report Work");
		Scene windowScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
		loginStage.setScene(windowScene);
		loginStage.show();

	}
	
	
	
	@SuppressWarnings("exports")
	public void changeFormat(GridPane login) {
		login.setAlignment(Pos.CENTER_RIGHT);
		login.setPadding(new Insets(20));
		login.setVgap(10); 
	}

	public static void main(String[] args){
		launch(args);
		
	}
	 
}
