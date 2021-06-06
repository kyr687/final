package proj.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proj.service.ProjService;
import proj.vo.Student;

public class profstuController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProjService service = ProjService.getInstance();
		ArrayList<Student> list = service.profstu();
		
		request.setAttribute("list",list);
		HttpUtil.forward(request, response, "/result/profstu.jsp");
		
	}

}
