package travel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import utility.Paging;


@Component("myTravelDao")
public class TravelDao {
	
	private String namespace = "travel.TravelBean";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public List<TravelBean> getTravelList(Map<String, String> map, Paging pageInfo) {
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		List<TravelBean> lists = new ArrayList<TravelBean>();
		lists = sqlSessionTemplate.selectList(namespace+".getTravelList",map,rowBounds);

		return  lists;
	}

	public int insertTravel(TravelBean travel) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.insert(namespace+".insertTravel",travel);
		} catch (DataAccessException e) {
			System.out.println("insert 도중 예외발생");
			System.out.println("예외 : "+ e.getMessage());
			System.out.println();
		}
		return cnt;
	}

	public int deleteTravel(int num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace+".deleteTravel",num);
		return cnt;
	}

	public int updateTravel(TravelBean travel) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.update(namespace+".updateTravel",travel);
		} catch (DataAccessException e) {
			System.out.println("update 도중 예외발생");
			System.out.println("예외 : "+ e.getMessage());
		}
		return cnt;
	}

	public TravelBean getTravel(int num) {
		TravelBean travel = new TravelBean();
		travel = sqlSessionTemplate.selectOne(namespace+".getTravel",num);

		return  travel;
	}

	public int getTravelCount(Map<String, String> map) {
		int cnt = 0;
		cnt = sqlSessionTemplate.selectOne(namespace+".getTravelCount",map);

		return  cnt;
	}
	
	

}
