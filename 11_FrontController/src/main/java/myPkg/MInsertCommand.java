package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MInsertCommand implements MemberCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		MemberDao mdao = MemberDao.getInstance();
		MemberBean mb = new MemberBean();
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		mb.setId(id);
		mb.setPasswd(passwd);
		mb.setName(name);
		
		int cnt = mdao.insertMember(mb);
		
		if(cnt>0){
			System.out.println("추가성공");
		}else {
			System.out.println("추가실패");
		}
		
	}
	
}
