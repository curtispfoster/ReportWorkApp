package ReportWork;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;

public class Driver { //Change name
	
	private String userName;
	private String password;
	private StringProperty loginMessage;
	
	ArrayList<String> names = new ArrayList<>();
	private String tempIn;
	private String tempOut;
	
	public Driver(){	
			
	}
	
	public Driver(String userName, String password){
		this.userName = userName;
		this.password = password;
		this.loginMessage = new SimpleStringProperty();
	}

	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getLoginMessage() {
		return loginMessage.get();
	}
	@SuppressWarnings("exports")
	public StringProperty loginMessageProperty() {
		return loginMessage;
	}
	
	public ArrayList<String> getNames() {
		return names;
	}
	public String getTempIn() {
		return tempIn;
	}
	public String getTempOut() {
		return tempOut;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}	
	public void setPassword(String password) {
		this.password = password;
	}
	public void setLoginMessage(String loginMessage) {
		this.loginMessage.set(loginMessage);
	}
	public void setNames(ArrayList<String> names) {
		this.names = names;
	}
	public void setTempIn(String tempIn) {
		this.tempIn = tempIn;
	}
	public void setTempOut(String tempOut) {
		this.tempOut = tempOut;
	}

	
	public int postMeridiem(String clockinClockout) {
		String[]extract = clockinClockout.split(" ");
		int count = 0;
		if(extract[1].equalsIgnoreCase("PM") 
					 || extract[1].equalsIgnoreCase("pM") 
					 || extract[1].equalsIgnoreCase("Pm") 
					 || extract[1].equalsIgnoreCase("pm")) 
		{
			count += 12;
		}
		
		return count;
	}
	public String clientServerNames() throws Exception {
		String urlString = "https://liveexample.pearsoncmg.com/data/babynameranking2001.txt";
		String line = null;
		@SuppressWarnings("deprecation")
		URL url = new URL(urlString);
		try (Scanner input = new Scanner(url.openStream())) {
			line = input.nextLine();
			return processLine(line);
			

		} catch (IOException ex) {
			throw new Exception("Unable to find or read the file: " + urlString, ex);
		}
	}
	public String processLine(String line) {
		ArrayList<String> splitLine = new ArrayList<>();
		splitLine.add(line);
		String join = null;
		if (splitLine.size() >= 5) {
			join = String.join("\t", splitLine);
			System.out.println(join);
		}
		return join;
	}
	
	public boolean validateLogin(String empId, String pwd) {
		boolean usernameValid = invalidId(empId);
		boolean pwdValid = invalidPwd(pwd);
		//invalidMessage(usernameValid, pwdValid);
		return usernameValid && pwdValid;
	}
	public boolean invalidId(String empId) {
		return empId.contains(getUserName()) && !getUserName().isBlank();
	}
	public boolean invalidPwd(String pwd) {
		return pwd.contains(getPassword()) && !getPassword().isBlank();
	}
	/*
	 * public String invalidMessage(boolean usernameValid, boolean pwdValid) {
	 * 
	 * if (usernameValid && !pwdValid) {
	 * setLoginMessage("Your Password is not correct"); }
	 * 
	 * else if (!usernameValid && pwdValid){
	 * setLoginMessage("Username is not found"); }
	 * 
	 * else if (!usernameValid && !pwdValid) {
	 * setLoginMessage("Username and Password are not correct"); }
	 * 
	 * else { setLoginMessage("Login Successful"); } return getLoginMessage(); }
	 */
	
	
	
	
} //End of WorkLogic
