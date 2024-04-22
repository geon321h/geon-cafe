package my.shop.mall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import my.shop.ProductBean;

public class OrdersDao {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	
	public OrdersDao() {
		
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/OracleDB"); 
			conn = ds.getConnection();
		} catch (NamingException | SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public int insertOrders(int memno,Vector<ProductBean> clist) {
		int cnt = -1;
		String sql = "insert into orders"
				+ " values(orderseq.nextval,?,?,?,?)";
		
		try {
			
	  	 	for(int i=0;i<clist.size();i++) {
	  	 		ps = conn.prepareStatement(sql);
	  	 		ps.setInt(1, memno);
	  	 		ps.setInt(2, clist.get(i).getPnum());
	  	 		ps.setInt(3, clist.get(i).getPqty());
	  	 		ps.setInt(4, clist.get(i).getPrice()*clist.get(i).getPqty());
	  	 		
	  	 		cnt = ps.executeUpdate();
	  	 	}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (ps!=null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		return cnt;
	}
	
	public ArrayList<OrderBean> getAllOrders(String name) {
		ArrayList<OrderBean> lists =null;
		String sql = "SELECT T10.NAME,T10.ID,T10.QTY,T10.AMOUNT,T20.PNAME "
							+ "FROM (SELECT PNUM,QTY,AMOUNT,NAME,ID "
							+ "      FROM ORDERS T11 "
							+ "          ,(SELECT NO,NAME,ID "
							+ "            FROM MEMBERS "
							+ "            WHERE ID LIKE ?) T12 "
							+ "      WHERE T11.MEMNO=T12.NO) T10 "
							+ "      ,PRODUCT T20 "
							+ "WHERE T10.PNUM = T20.PNUM";
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				lists = getOrderBean(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (ps!=null) {
					ps.close();
				}
				if (rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		return lists;
	}
	
	public ArrayList<OrderBean> getOrderBean(ResultSet rs) throws SQLException {
		ArrayList<OrderBean> lists = new ArrayList<>();
		OrderBean order = new OrderBean();
		
		order.setMname(rs.getString("NAME"));
		order.setMid(rs.getString("ID"));
		order.setPname(rs.getString("PNAME"));
		order.setQty(rs.getInt("QTY"));
		order.setAmount(rs.getInt("AMOUNT"));
		
		lists.add(order);
		
		return lists;
	}
	
}
