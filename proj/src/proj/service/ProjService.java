package proj.service;

import java.util.ArrayList;

import proj.vo.*;
import proj.dao.ProjDAO;

public class ProjService {
	private static ProjService service = new ProjService();
	public ProjDAO dao = ProjDAO.getInstance();
	private ProjService() {}

	public static ProjService getInstance() 
	{
		return service;
	}
	public boolean proflogin(String id, String pwd) {
		// TODO Auto-generated method stub
		return dao.proflogin(id, pwd);
	}
	
	public boolean login(String id, String pwd) {
		// TODO Auto-generated method stub
		return dao.login(id, pwd);
	}

	public boolean search(String id) {
		// TODO Auto-generated method stub
		return dao.search(id);
	}
	public Object enroll(String id,String sid, String name) {
		return dao.enroll(id,sid,name);
	}

	public ArrayList<Enroll> enlist() {
		// TODO Auto-generated method stub
		ArrayList<Enroll> list = dao.enlist();
		return list;
	}

	public void profenroll(Subject subject) {
		// TODO Auto-generated method stub
		dao.profenroll(subject);
		
	}

	public ArrayList<Student> profstu() {
		// TODO Auto-generated method stub
		ArrayList<Student> list = dao.profstu();
		return list;
	}

	public ArrayList<Subject> profsub() {
		// TODO Auto-generated method stub
		ArrayList<Subject> list = dao.profsub();
		return list;
	}

	

}
