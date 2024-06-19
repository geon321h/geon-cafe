package board.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myBoardDao")
public class BoardDao {

	private String namespace = "board.model.Board";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int getTotalCount(Map<String, String> map) {
		int cnt =0;
		cnt = sqlSessionTemplate.selectOne(namespace+".getTotalCount",map);
		return cnt;
	}
	
	public List<BoardBean> getBoardList(Map<String, String> map, Paging pageInfo) {
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit()); 
		List<BoardBean> list = sqlSessionTemplate.selectList(namespace+".getBoardList",map,rowBounds);
		return list;
	}

	public int insertBoard(BoardBean board) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace+".insertBoard",board);
		try {
		} catch (DataAccessException e) {
			System.out.println("insert ¿À·ù");
		}
		return  cnt;
	}
	
	
	
}
