package proj.vo;

import java.util.ArrayList;

public class Enroll {	
	private String student;
	private String subject;
	private ArrayList<Enroll> list;
	
	public String getStudent() {
		return student;
	}
	public void setStudent(String tstudent) {
		this.student = tstudent;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String tsubject) {
		this.subject = tsubject;
	}
	
	
}
