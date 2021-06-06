package proj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proj.service.ProjService;

public class EnrollController implements Controller {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String sid = request.getParameter("sid");
		String name = request.getParameter("name");
		
		String id = (String)request.getSession().getAttribute("id");
		if(sid==null)
		{
			System.out.print("Subject id not exist !!!");
		}
		
		request.setAttribute("name",name);
		request.setAttribute("id",id);
		
		HttpUtil.forward(request, response, "/result/enrollResult.jsp");
	}
}
