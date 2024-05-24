package myPkg;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MListCommand implements MemberCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		MemberDao mdao = MemberDao.getInstance();
		ArrayList<MemberBean> lists = mdao.getAllMember();
		request.setAttribute("lists", lists);
		
	}
	
}
