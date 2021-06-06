package proj.controller;

import java.io.IOException;
import java.util.ArrayList;

import proj.vo.Subject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proj.service.ProjService;

public class profsubController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProjService service = ProjService.getInstance();
		ArrayList<Subject> list = service.profsub();
		
		request.setAttribute("list",list);
		HttpUtil.forward(request, response, "/result/profsub.jsp");
		
	}

}
