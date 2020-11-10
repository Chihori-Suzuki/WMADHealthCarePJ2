package ca.healthcare.pj;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String DEFAULT = "Unknown"; 
	
	public User(int id, String firstName, String lastName, String phoneNumber, String email) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setEmail(email);
	}
	
	/**
	 * 
	 * @return doctorId
	 */
	public int getId() {
		if(id > 1000 && id < 100000) {
			return this.id;
		} else {
			return 1001;
		}
	}
	/**
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		
		if(firstName.isEmpty() || firstName.equalsIgnoreCase("")) {
			return DEFAULT;
		} else {
			return this.firstName;
		}
	}
	/**
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		
		if(lastName.isEmpty() || lastName.equalsIgnoreCase("")) {
			return DEFAULT;
		} else {
			return this.lastName;
		}
	}
	/**
	 * 
	 * @return phoneNumber
	 */
	public String getPhoneNumber() {
		
		if(phoneNumber.isEmpty() || phoneNumber.equalsIgnoreCase("")) {
			return DEFAULT;
		} else {
			return this.phoneNumber;
		}
	}
	/**
	 * 
	 * @return email
	 */
	public String getEmail() {
		
		if(email.isEmpty() || email.equalsIgnoreCase("")) {
			return DEFAULT;
		} else {
			return this.email;
		}
	}
	
	public void setId(int id) {
		this.id = id;
				//(int)(Math.floor((Math.random() * 90001) + 1000)); //??
		
	}
	/**
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		
	}
	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
		
	}
	/**
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		
	}
	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
		
	}

	@Override
	public String toString() {
		return "ID : " + getId() +
				"\nName : " + getFirstName() + " " + getLastName() +
				"\nPhone Number : " + getPhoneNumber() +
				"\nEmail : " + getEmail() ;
	}
	

}

