package proj.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	HashMap<String, Controller> map = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		map = new HashMap<String, Controller>();
		//map.put("/login.do", new loginController());
		map.put("/proflogin.do", new profloginController());
		map.put("/login.do", new LoginController());
		map.put("/profenroll.do", new profenrollController());
		map.put("/search.do", new SearchController());
		map.put("/enlist.do", new EnlistController());
		map.put("/enroll.do", new EnrollController());
		map.put("/profstu.do", new profstuController());
		map.put("/profsub.do", new profsubController());
		
	
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		String contextP = req.getContextPath();
		String url = req.getRequestURI();
		String path = url.substring(contextP.length());
		Controller subController = map.get(path);
		subController.execute(req,resp);	
	} 
	
	
}
