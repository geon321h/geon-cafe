package movie.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import utility.Paging;


@Component("myMovieDao")
public class MovieDao {

	private String namespace = "movie.MovieBean";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	public List<MovieBean> getMovieList(Paging pageInfo, Map<String, String> map) {
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit()); 
		List<MovieBean> lists = new ArrayList<MovieBean>();
		lists = sqlSessionTemplate.selectList(namespace+".getMovieList",map,rowBounds);

		return  lists;
	}
	public int getMovieCount(Map<String, String> map) {
		int cnt = 0;
		cnt = sqlSessionTemplate.selectOne(namespace+".getTotalCount",map);
		return  cnt;
	}
	public int searchTitle(String title) {
		int cnt = 0;
		cnt = sqlSessionTemplate.selectOne(namespace+".searchTitle",title);
		return  cnt;
	}
	public int insertMovie(MovieBean movie) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.insert(namespace+".getInsertMovie",movie);
		} catch (DataAccessException e) {
			System.out.println("insert ¿À·ù");
		}
		return  cnt;
	}
	public MovieBean getMovieDetail(String num) {
		MovieBean movie = sqlSessionTemplate.selectOne(namespace+".getMovieDetail",num);
		return  movie;
	}
	public int deleteMovie(String num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace+".deleteMovie",num);
		return cnt;
	}

	public MovieBean detailMovie(int num) {
		MovieBean mb = null;
		mb = sqlSessionTemplate.selectOne(namespace + ".detailMovie", num);
		
		return mb;
	}//detailMovie
	
	public void updateMovie(MovieBean movie) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".updateMovie",movie);
		System.out.println("updateMovie cnt:" + cnt);
	}//updateMovie

}
