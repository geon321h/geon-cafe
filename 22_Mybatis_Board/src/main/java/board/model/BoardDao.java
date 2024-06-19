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
	
	public BoardBean getBoard(String num) {
		BoardBean board = sqlSessionTemplate.selectOne(namespace+".getBoard",num);
		return board;
	}

	public int insertBoard(BoardBean board) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.insert(namespace+".insertBoard",board);
		} catch (DataAccessException e) {
			System.out.println("insert 오류");
		}
		return  cnt;
	}

	public void readCount(String num) {
		try {
			sqlSessionTemplate.update(namespace+".readCount",num);
		} catch (DataAccessException e) {
			System.out.println("update 오류");
		}
	}

	public void deleteBoard(String num) {
		try {
			sqlSessionTemplate.delete(namespace+".deleteBoard",num);
		} catch (DataAccessException e) {
			System.out.println("delete 오류");
		}
	}

	public int updateBoard(BoardBean board) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.update(namespace+".updateBoard",board);
		} catch (DataAccessException e) {
			System.out.println("update 오류");
		}
		return  cnt;
	}

	public int replyBoard(BoardBean board) {
		int cnt = -1;
		sqlSessionTemplate.update(namespace+".updateReply",board);
		board.setRe_step(board.getRe_step()+1);
		board.setRe_level(board.getRe_level()+1);
		cnt = sqlSessionTemplate.insert(namespace+".replyBoard",board);
		try {
		} catch (DataAccessException e) {
			System.out.println("insert 오류");
		}
		return  cnt;
	}
	
	
	
}
