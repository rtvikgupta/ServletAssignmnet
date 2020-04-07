package p3;

public class UserModel {

	String user;
	String pass;
	String confpass;
	int age;
	String[] tech;
	String city;
	String gender;
	String workexp;
	
	public UserModel(String user, String pass, String confpass, int age, String[] tech, String city, String gender,
			String workexp) {
		this.user = user;
		this.pass = pass;
		this.confpass = confpass;
		this.age = age;
		this.tech = tech;
		this.city = city;
		this.gender = gender;
		this.workexp = workexp;
	}
}
