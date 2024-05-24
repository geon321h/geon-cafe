package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mUpdateCommand implements MemberCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		MemberDao mdao = MemberDao.getInstance();
		MemberBean mb = new MemberBean();
		
		int num = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		mb.setNum(num);
		mb.setId(id);
		mb.setPasswd(passwd);
		mb.setName(name);
		int cnt = mdao.updateMember(mb);
		
	}

}
