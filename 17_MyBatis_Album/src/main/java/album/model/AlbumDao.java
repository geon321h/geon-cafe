package album.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

// AlbumDao myAlbumDao = new AlbumDao();
@Component("myAlbumDao")
public class AlbumDao {
	
	@Autowired // rootContext.xml에서 만든 객체 주입
	SqlSessionTemplate sqlSessionTemplate;
	
	public AlbumDao() {
		System.out.println("생성자");
	}
	
	public List<AlbumBean> getAlbumList(Paging pageInfo, Map<String, String> map) {
		List<AlbumBean> lists = new ArrayList<AlbumBean>();
		System.out.println("Offset"+pageInfo.getOffset()); // 건너뛸 레코드
		System.out.println("Limit"+pageInfo.getLimit()); // 가져올 개수
		
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		
		lists = sqlSessionTemplate.selectList("album.AlbumBean.getAlbumList",map,rowBounds);
		System.out.println("lists.size() : "+lists.size());
		
		return lists;
	}
	
	public int insertAlbum(AlbumBean album) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert("album.AlbumBean.insertAlbum",album);
		System.out.println("insertAlbum cnt: "+cnt);
		return cnt;
		
	}

	public AlbumBean getAlbum(int num) {
		AlbumBean album = new AlbumBean();
		album = sqlSessionTemplate.selectOne("album.AlbumBean.getAlbum", num);
		return album;
	}

	public int updateAlbum(AlbumBean album) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update("album.AlbumBean.updateAlbum", album);
		return cnt;
	}

	public int deleteAlbum(int num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete("album.AlbumBean.deleteAlbum", num);
		return cnt;
	}

	public int getTotalCount(Map<String, String> map) {
		int cnt = sqlSessionTemplate.selectOne("album.AlbumBean.getTotalCount",map);
		return cnt;
	}

}
