package ReportWork;

import javafx.application.Application;
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
* 	-
* 
* +Use another class object that hides the password
* 
* +Find a way to use multiple users
* 	-This I will make admin window.
* 
* +Update look for LoginController
* 	-Used changeFormat method that was block commented
* 
* +Figure out how to keep loginController so it doesn't move based loginMessages
* 
* +Make AdminController window that adds users
* 
* 
* +Make a file notes reader that read and writes to program
* 
* 
* 
*/

public class ReportWorkApp extends Application {
	
	@SuppressWarnings("exports")
	public void start(Stage loginStage) throws Exception {
		LoginController loginControl = new LoginController();
		loginControl.startLoginWindow(loginStage);		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
