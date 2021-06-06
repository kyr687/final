package proj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proj.controller.HttpUtil;
import proj.service.ProjService;
import proj.vo.Subject;

public class profenrollController implements Controller{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int count = Integer.parseInt(request.getParameter("count"));
		
		Subject subject = new Subject();
		subject.setCount(count);
		subject.setId(id);
		subject.setName(name);
		
		ProjService service = ProjService.getInstance();
		service.profenroll(subject);
		
		HttpUtil.forward(request, response, "/result/profenrollResult.jsp");
	}

}
