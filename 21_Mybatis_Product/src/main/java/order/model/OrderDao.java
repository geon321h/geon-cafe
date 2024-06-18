package order.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;


@Component("myOrderDao")
public class OrderDao {
	
	private String namespace = "order.model.Order";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public void insertData(String id) {
		try {
			sqlSessionTemplate.insert(namespace+".InsertData",id);
		} catch (DataAccessException e) {
			System.out.println("insert ¿À·ù");
		}
	}
	
	public List<OrderBean> getOrderList(String id) {
		List<OrderBean> lists = new ArrayList<OrderBean>();
		lists = sqlSessionTemplate.selectList(namespace+".getOrderList",id);

		return  lists;
	}


}
