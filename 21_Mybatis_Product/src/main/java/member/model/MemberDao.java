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
			System.out.println("insert ¿À·ù");
		}
		return  cnt;
	}

}
