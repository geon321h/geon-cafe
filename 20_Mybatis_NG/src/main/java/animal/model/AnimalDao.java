package animal.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myAnimalDao")
public class AnimalDao {
	
	private String namespace = "animal.AnimalBean";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<AnimalBean> getAnimalList(Paging pageInfo, Map<String, String> map) {
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit()); 
		List<AnimalBean> lists = new ArrayList<AnimalBean>();
		lists = sqlSessionTemplate.selectList(namespace+".getAnimalList",map,rowBounds);

		return  lists;
	}
	
	public int getAnimalCount(Map<String, String> map) {
		int cnt = 0;
		cnt = sqlSessionTemplate.selectOne(namespace+".getTotalCount",map);
		return  cnt;
	}

	public int deleteAnimal(String num) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.delete(namespace+".deleteAnimal",num);
		} catch (DataAccessException e) {
			System.out.println("delete 오류");
		}
		return cnt;
	}

	public int searchId(String id) {
		int cnt = 0;
		cnt = sqlSessionTemplate.selectOne(namespace+".searchId",id);
		return  cnt;
	}

	public int insertAnimal(AnimalBean animal) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.insert(namespace+".getInsertAnimal",animal);
		} catch (DataAccessException e) {
			System.out.println("insert 오류");
		}
		return  cnt;
	}

	public AnimalBean getAnimalDetail(String num) {
		AnimalBean ab = null;
		ab = sqlSessionTemplate.selectOne(namespace + ".detailAnimal", num);
		return ab;
	}
	
	public int updateAnimal(AnimalBean ab) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".updateAnimal",ab);
		return cnt;
	}

}
