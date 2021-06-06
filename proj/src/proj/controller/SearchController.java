package proj.controller;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proj.controller.HttpUtil;
import proj.service.ProjService;
import proj.vo.*;


public class SearchController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		boolean result = ProjService.getInstance().search(id);
		String msg = null;
		if(result == false)
			msg = "false";
		else
			msg = "true";
		
		request.setAttribute("msg",msg);
		request.setAttribute("sid",id);
		HttpUtil.forward(request, response, "/enroll.jsp");		
	}
}
