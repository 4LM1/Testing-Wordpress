package PageObject;

public class UserTestData {
	
	    
	    public enum UserType { NEW_USER, EXISTING_USER, WRONGNAME_USER, WRONGPASSWORD, EXTREMEUSERNAME, WRONGSITE, SHORTPASSWORD, SHORTNAME }
	    
	    public static class UserData {
	        public String email;
	        public String username;
	        public String password;
	        public String address;
	        public String site;
	        
	    public UserData(String email, String username, String password, String address, String site) {
	        this.email = email;
	        this.username = username;
	        this.password = password;
	        this.address = address;
	        this.site = site;
	        }
	    }
	    
	    public static final UserData NEW_USER = new UserData(
	        "testovani1wps@gmail.com", 
	        "tester121212", 
	        "TestovaciHeslo1",
	        "testing2@wordpress.com",
	        "newSite1234wps@wordpress.com"
	    );
	    
	    public static final UserData EXISTING_USER = new UserData(
	        "testingwps123@gmail.com", 
	        "tester123", 
	        "Bakalarka123",
	        "test1wps@wordpress.com",
	        "test1wps.wordpress.com"
	    );
	    
	    public static final UserData WRONGNAME_USER = new UserData(
	    		"tesst@gmail.com", 
		        "tester123", 
		        "Bakalarka123",
		        "test1wps@wordpress.com",
		        "test1wps.wordpress.com"
	    		);
	    public static final UserData WRONGPASSWORD = new UserData(
	    		"testingwps123@gmail.com", 
		        "tester123", 
		        "Bakalarka3",
		        "test1wps@wordpress.com",
		        "test1wps.wordpress.com"
	    		);
	    public static final UserData EXTREMEUSERNAME = new UserData(
	    		"a".repeat(100), 
		        "tester123", 
		        "Bakalarka3",
		        "test1wps@wordpress.com",
		        "test1wps.wordpress.com"
	    		);
	    public static final UserData WRONGSITE = new UserData(
	    		"qq",
		        "tester123", 
		        "Bakalarka3",
		        "test1wps@wordpress.com",
		        "test1wps.wordpress.com"
	    		);
	}
