package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MUpdateFormCommand implements MemberCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		MemberDao mdao = MemberDao.getInstance();
		int num = Integer.parseInt(request.getParameter("num"));
		MemberBean mb = mdao.getMemberByNum(num);
		request.setAttribute("mb", mb);
		
	}

}
