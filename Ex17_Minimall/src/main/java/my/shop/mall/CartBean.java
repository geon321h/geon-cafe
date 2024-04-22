package my.shop.mall;

import java.util.Vector;

import my.shop.ProductBean;
import my.shop.ProductDao;

public class CartBean {

	private Vector<ProductBean> clist;
	
	public CartBean() {

		clist = new Vector<>();
		System.out.println("CartBean객체");
		
	}
	
	public void addProduct(int pnum ,int oqty) {
		
		ProductDao pdao = ProductDao.getInstance();
		
		ProductBean pb = pdao.getProductByPnum(pnum);
		pb.setPqty(oqty);
		
		int totalPrice=0;
		int totalPoint=0;
		for(int i=0;i<clist.size();i++) {
			if(clist.get(i).getPnum()==pnum){
				clist.get(i).setPqty(clist.get(i).getPqty()+oqty);

				totalPrice += clist.get(i).getPrice()* clist.get(i).getPqty();
				totalPoint += clist.get(i).getPoint()* clist.get(i).getPqty();
				pb.setTotalPrice(totalPrice);
				pb.setTotalPoint(totalPoint);
				return;
			}
		}
		//새 상품일때
		totalPrice +=pb.getPrice()*pb.getPqty();
		totalPoint +=pb.getPoint()*pb.getPqty();
		pb.setTotalPrice(totalPrice);
		pb.setTotalPoint(totalPoint);
		clist.add(pb);
		
		System.out.println("clist 갯수: "+clist.size());
		
	}
	
	public void removeProduct(int pnum) {
		for(int i=0;i<clist.size();i++) {
			if(clist.get(i).getPnum()==pnum){
				clist.remove(i);
				break;
			}
		}		
	}
	
	public void removeAllProduct() {
		clist.removeAllElements();
	}

	
	public void setEdit(int pnum ,int oqty) {
		for(int i=0;i<clist.size();i++) {
			if(clist.get(i).getPnum()==pnum){
				clist.get(i).setPqty(oqty);
				break;
			}
		}
	}
	
	public Vector<ProductBean> getClist() {
		return clist;
	}
	
}
