package mongo.products;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import mongo.products.security.Security;

public class User {

private long userId;
public String emailId;
public String firstName;
public String lastName;
public String password;
public String userName;

SecureRandom random = new SecureRandom();
Security sec =new Security();

public String getEmailId() {
	return emailId;
}
public String getFirstName() {
	return firstName;
}
public String getLastName() {
	return lastName;
}
public String getPassword() {
	return password;
}
public long getUserId() {
	return userId;
}
public String getUserName() {
	return userName;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public void setPassword(String string) {
	this.password = string;
}
public void setUserId(long userId) {
	this.userId = userId;
}
public void setUserName(String userName) {
	this.userName = userName;
}

public User createUser() throws NoSuchAlgorithmException {
	 
	 //User rest = new User();
       this.setUserId(2);
       this.setUserName("Hrishi18");
       this.setFirstName("Hrishi");
       this.setLastName("Karambelkar");
       String psd = sec.getStringFromSHA256((random.generateSeed(25) + "welcome!123"));
       this.setPassword(psd);
       this.setEmailId("hrishispi@gmail.com");
       return this;
   }

}
