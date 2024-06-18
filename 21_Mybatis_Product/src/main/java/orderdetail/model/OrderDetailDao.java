package orderdetail.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import member.model.MemberBean;
import order.model.OrderBean;
import product.model.ProductBean;

@Component("myOrderDetailDao")
public class OrderDetailDao {

	private String namespace = "orderdetail.model.OrderDetail";


	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public void insertData(Integer pnum, int qty) {
		ProductBean pb = new ProductBean();
		pb.setNum(pnum);
		pb.setOrderqty(qty);
		sqlSessionTemplate.insert(namespace+".InsertData",pb);
		try {
		} catch (DataAccessException e) {
			System.out.println("insert ¿À·ù");
		}		
	}

	public List<OrderBean> detailOrder(int oid) {
		List<OrderBean> lists = new ArrayList<OrderBean>();
		lists = sqlSessionTemplate.selectList(namespace+".detailOrder",oid);
		return lists;
	}

	public MemberBean detailMember(int oid) {
		MemberBean mb = new MemberBean();
		mb = sqlSessionTemplate.selectOne(namespace+".detailMember",oid);
		return mb;
	}

	public List<OrderBean> detailProduct(int oid) {
		List<OrderBean> lists = new ArrayList<OrderBean>();
		lists = sqlSessionTemplate.selectList(namespace+".detailProduct",oid);
		return lists;
	}
	
	
}
