package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberCommand {

	// 똑같은 메서드를 수행시키기 위해 인터페이스를 이용
	void execute(HttpServletRequest request,HttpServletResponse response);
	
}
