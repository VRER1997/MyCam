package Model;

public class Userfo {
	
	private int id;
	private String username;
	private String password;
	private String email;
	private String phonenumber;
	private boolean is_root = false;
	private boolean is_VIP = false;
	private boolean is_SignIn = false;
	private int code;
	private String headpicture;
	
	public Userfo(){}
	
	public Userfo(String username, String password, String email,
			String phonenumber, boolean is_v) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phonenumber = phonenumber;
		is_root = is_v;
	}
 
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getHeadpicture() {
		return headpicture;
	}

	public void setHeadpicture(String headpicture) {
		this.headpicture = headpicture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isIs_root() {
		return is_root;
	}
	public void setIs_root(boolean is_root) {
		this.is_root = is_root;
	}
	public boolean isIs_VIP() {
		return is_VIP;
	}
	public void setIs_VIP(boolean is_VIP) {
		this.is_VIP = is_VIP;
	}
	public boolean isIs_SignIn() {
		return is_SignIn;
	}
	public void setIs_SignIn(boolean is_SignIn) {
		this.is_SignIn = is_SignIn;
	}

	
}
