package proj.vo;

public class Student {
	private static String id;
	private String pwd;
	private String name;
	
	public Student() {}
	
	public static String getId() {
		return id;
	}
	public void setId(String tid) {
		this.id = tid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String tpwd) {
		this.pwd = tpwd;
	}	
	
	public String getName() {
		return name;
	}
	public void setName(String tname) {
		this.name = tname;
	}


}
