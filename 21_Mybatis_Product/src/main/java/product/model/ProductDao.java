package product.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import utility.Paging;


@Component("myProductDao")
public class ProductDao {
	
	private String namespace = "product.model.Product";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<ProductBean> getProductList(Paging pageInfo, Map<String, String> map) {
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		List<ProductBean> lists = new ArrayList<ProductBean>();
		lists = sqlSessionTemplate.selectList(namespace+".getProductList",map,rowBounds);

		return  lists;
	}

	public int getTotalCount(Map<String, String> map) {
		int cnt = 0;
		cnt = sqlSessionTemplate.selectOne(namespace+".getTotalCount",map);
		return  cnt;
	}

	public int insertProduct(ProductBean product) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.insert(namespace+".insertProduct",product);
		} catch (DataAccessException e) {
			System.out.println("insert 오류");
		}
		return  cnt;
	}

	public ProductBean getProduct(String num) {
		ProductBean pb = null;
		pb = sqlSessionTemplate.selectOne(namespace + ".getProduct", num);
		return pb;
	}

	public int deleteProduct(String num) {
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.delete(namespace+".deleteProduct",num);
		} catch (DataAccessException e) {
			System.out.println("delete 오류");
		}
		return  cnt;
	}

	public int updateProduct(ProductBean product) {
		// TODO Auto-generated method stub
		int cnt = -1;
		try {
			cnt = sqlSessionTemplate.update(namespace+".updateProduct",product);
		} catch (DataAccessException e) {
			System.out.println("update 오류");
		}
		return  cnt;
	}

}
