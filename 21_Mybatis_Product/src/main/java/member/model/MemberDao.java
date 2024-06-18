package member.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myMemberDao")
public class MemberDao {
	
	private String namespace = "member.model.Member";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<MemberBean> getMemberList(Paging pageInfo, Map<String, String> map) {
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		List<MemberBean> lists = new ArrayList<MemberBean>();
		lists = sqlSessionTemplate.selectList(namespace+".getMemberList",map,rowBounds);

		return  lists;
	}
	
	public int getTotalCount(Map<String, String> map) {
		int cnt = 0;
		cnt = sqlSessionTemplate.selectOne(namespace+".getTotalCount",map);
		return  cnt;
	}

	public int insertMember(MemberBean member) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.insert(namespace+".insertMember",member);
		} catch (DataAccessException e) {
			System.out.println("insert 오류:아이디중복");
			cnt=-3;
		}
		return  cnt;
	}
	
	public int deleteMember(String id) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.delete(namespace+".deleteMember",id);
		} catch (DataAccessException e) {
			System.out.println("delete 오류");
		}
		return  cnt;
	}

	public MemberBean getMember(String id) {
		MemberBean mb = new MemberBean();
		mb = sqlSessionTemplate.selectOne(namespace+".getMember",id);
		return  mb;
	}

	public int updateMember(MemberBean member) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.update(namespace+".updateMember",member);
		} catch (DataAccessException e) {
			System.out.println("update 오류");
		}
		return  cnt;
	}

	public String login(MemberBean member) {
		System.out.println("도착");
		String db_pw = null; 
		db_pw =  sqlSessionTemplate.selectOne(namespace+".login",member.getId());
		System.out.println("db_pw");
		if(db_pw==null) {
			return "id";
		}else {
			if(db_pw.equals(member.getPassword())) {
				return "login";
			}else {
				return "pw";
			}
		}
		
	}

	public void updateMpoint(String id, int i) {
		MemberBean member = new MemberBean();
		member.setId(id);
		member.setMpoint(i);
		try {
			sqlSessionTemplate.update(namespace+".updateMpoint",member);
		} catch (DataAccessException e) {
			System.out.println("update 오류");
		}
	}

}
