package member.model;

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
	
	public MemberBean getMember(String email) {
		MemberBean member = sqlSessionTemplate.selectOne(namespace+".getMember",email);
		return member;
	}

	public int getTotalCount(Map<String, String> map) {
		int cnt =0;
		cnt = sqlSessionTemplate.selectOne(namespace+".getTotalCount",map);
		return cnt;
	}


	public List<MemberBean> getMemberList(Map<String, String> map, Paging pageInfo) {
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit()); 
		List<MemberBean> list = sqlSessionTemplate.selectList(namespace+".getMemberList",map,rowBounds);
		return list;
	}
	
	public int insertMember(MemberBean member) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.insert(namespace+".insertMember",member);
		} catch (DataAccessException e) {
			System.out.println("insert 오류:아이디중복");
			cnt=-5;
		}
		System.out.println("cnt:"+cnt);
		return  cnt;
	}

	public void deleteMember(String num) {
		try {
			sqlSessionTemplate.delete(namespace+".deleteMember",num);
		} catch (DataAccessException e) {
			System.out.println("delete 오류");
		}
	}

	public MemberBean getMemberByNum(String num) {
		MemberBean member = sqlSessionTemplate.selectOne(namespace+".getMemberByNum",num);
		return member;
	}

	public int updateMember(MemberBean member) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.update(namespace+".updateMember",member);
		} catch (DataAccessException e) {
			System.out.println("update 오류");
		}
		return cnt;
	}

}
