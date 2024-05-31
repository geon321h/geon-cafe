package album.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// AlbumDao myAlbumDao = new AlbumDao();
@Component("myAlbumDao")
public class AlbumDao {
	
	@Autowired // rootContext.xml���� ���� ��ü ����
	SqlSessionTemplate sqlSessionTemplate;
	
	public AlbumDao() {
		System.out.println("������");
	}
	
	public List<AlbumBean> getAlbumList() {
		List<AlbumBean> lists = new ArrayList<AlbumBean>();
		lists = sqlSessionTemplate.selectList("album.AlbumBean.getAlbumList");
		System.out.println("lists.size() : "+lists.size());
		
		return lists;
	}

}
