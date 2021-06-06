package proj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import proj.controller.HttpUtil;
import proj.service.ProjService;

public class profloginController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		ProjService service = ProjService.getInstance();
		boolean result = service.proflogin(id,pwd);
		String path = null;
		if(result)
		{
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			path = "/profmenu.jsp";
		}
		else
		{
			path = "/index.jsp";
		}
		
		HttpUtil.forward(request, response, path);
		
	}

}
