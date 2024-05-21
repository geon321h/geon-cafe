package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MdeleteCommand implements MemberCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		MemberDao mdao = MemberDao.getInstance();
		int num = Integer.parseInt(request.getParameter("num"));
		int cnt = mdao.deleteMember(num);
		
	}

	
	
}
