/*
 * Class that accesses credential file and validates user. Also add new user.
 */
package print;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class AccessLoginCreds {
	private HashMap<String, String> logins;
	public AccessLoginCreds(){
		try {
			BufferedReader readCred = new BufferedReader(new FileReader(new File("C:\\Users\\jayal\\workspaceSecond\\PrintDataApp\\creds.txt")));
			String line = "";
			this.logins = new HashMap<String, String>(); 
			while((line = readCred.readLine())!= null){
				String[] currentLine = line.split(" ");
				logins.put(currentLine[0], currentLine[1]);
			}
			readCred.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, String> getLogins() {
		return logins;
	}

	public void setLogins(HashMap<String, String> logins) {
		this.logins = logins;
	}
	
	public int addUser(String username, String password, String email){
		try {
			if(!logins.containsKey(username)){
				if(ReadJSON.checkIfAValidUser(username)){
					FileWriter fw = new FileWriter("C:\\Users\\jayal\\workspaceSecond\\PrintDataApp\\creds.txt", true);
					fw.write(System.lineSeparator());
					fw.write(username + " " + password + " " + email);
					fw.close();
					return 1;
				}
				else{
					return -1;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
