package com.xiaoan.wlt.model.erp.jxc;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.jfinal.plugin.activerecord.Page;
import com.xiaoan.wlt.common.WhereAndParas;
import com.xiaoan.wlt.model.base.erp.jxc.BaseStock;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Stock extends BaseStock<Stock> {
	public static final Stock dao = new Stock();
	private int pageNumber = 1;
	private int pageSize = 15;
	public int getPageSize() {return pageSize;}
	public void setPageSize(int pageSize) {this.pageSize = pageSize;}
	public int getPageNumber() {return pageNumber;}
	public void setPageNumber(int pageNumber) {this.pageNumber = pageNumber;}
	public Page<Stock> findPageList(Stock stock) {
		WhereAndParas wp = getWhereAndParas(stock);
		return dao.paginate(stock.getPageNumber(),stock.getPageSize(),"select * ","from"+ Stock.TABLE + "where 1=1 " +wp.getWhere(),wp.getParas());
	}
	public static final String TABLE = " erp_jxc_stock o ";
	public WhereAndParas getWhereAndParas(Stock stock){
		StringBuffer sql = new StringBuffer();
		List<Object> list = new ArrayList<Object>();
		WhereAndParas wap = new WhereAndParas();
		if(stock.getId() != null && stock.getId() > 0){
			sql.append(" and o.id = ?");
			list.add(stock.getId());
		}
		if(stock.getSId() != null && stock.getSId() > 0){
			sql.append(" and o.s_id = ?");
			list.add(stock.getSId());
		}
		if(stock.getDepotId() != null && stock.getDepotId() > 0){
			sql.append(" and o.depot_id = ?");
			list.add(stock.getDepotId());
		}
		if(stock.getProductId() != null && stock.getProductId() > 0){
			sql.append(" and o.product_id = ?");
			list.add(stock.getProductId());
		}
		if(StringUtils.isNotEmpty(stock.getCode())){
			sql.append(" and o.code like ?");
			list.add("%"+stock.getCode()+"%");
		}
		if(stock.getNum() != null && stock.getNum() > 0){
			sql.append(" and o.num = ?");
			list.add(stock.getNum());
		}
		if(StringUtils.isNotEmpty(stock.getRemarks())){
			sql.append(" and o.remarks like ?");
			list.add("%"+stock.getRemarks()+"%");
		}
		if(stock.getVersion() != null && stock.getVersion() > 0){
			sql.append(" and o.version = ?");
			list.add(stock.getVersion());
		}
		wap.setWhere(sql.toString());
		wap.setParas(list.toArray());
		return wap;
	}
	
	/**
	 * 入库操作
	 * @param into
	 */
	public void intoStock(Into into) {
		if(into.getDepotId() == null && into.getDepotId() < 0) throw new RuntimeException("没选择仓库");
		if(Depot.dao.findById(into.getDepotId()) == null) throw new RuntimeException("所选的仓库不存在");
		//查出该单的 所有商品
		List<IntoList> intoList = IntoList.dao.findByIntoId(into.getId());
		if(intoList == null || intoList.size() <= 0 ) throw new RuntimeException("该入库单没有商品");
		for(IntoList il : intoList){
			String code = into.getSId()+"-"+into.getDepotId()+"-"+il.getProductId();
			Stock stock = dao.findByCode(code);
			if(stock == null){//库存内没有该商品，创建一条
				stock = new Stock();
				stock.setCode(code);
				stock.setDepotId(into.getDepotId());
				stock.setNum(il.getNum());
				stock.setProductId(il.getProductId());
				stock.setSId(into.getSId());
				stock.save();
			}else{
				stock.setNum(stock.getNum()+il.getNum());
				stock.setVersion(stock.getVersion()+1);
				stock.update();
			}
			//入库操作流水
			addStockList(into, il);
		}
	}
	
	/**
	 * 入库操作
	 * @param into
	 */
	public void outStock(Out out) {
		if(out.getDepotId() == null && out.getDepotId() < 0) throw new RuntimeException("没选择仓库");
		if(Depot.dao.findById(out.getDepotId()) == null) throw new RuntimeException("所选的仓库不存在");
		//查出该单的 所有商品
		List<OutList> outList = OutList.dao.findByOutId(out.getId());
		if(outList == null || outList.size() <= 0 ) throw new RuntimeException("该出库单没有商品");
		for(OutList o : outList){
			String code = out.getSId()+"-"+out.getDepotId()+"-"+o.getProductId();
			Stock stock = dao.findByCode(code);
			if(stock == null){//库存内没有该商品，创建一条
				stock = new Stock();
				stock.setCode(code);
				stock.setDepotId(out.getDepotId());
				stock.setNum(-o.getNum());
				stock.setProductId(o.getProductId());
				stock.setSId(out.getSId());
				stock.save();
			}else{
				stock.setNum(stock.getNum()-o.getNum());
				stock.setVersion(stock.getVersion()+1);
				stock.update();
			}
			//入库操作流水
			addStockList(out, o);
		}
	}
	
	private void addStockList(Out out, OutList o) {
		StockList sl = new StockList();
		sl.setDepotId(out.getDepotId());
		sl.setNum(o.getNum());
		sl.setProductId(o.getProductId());
		sl.setSId(out.getSId());
		sl.setType("OUT");
		sl.setUser(out.getOutUser());
		sl.save();
	}
	private void addStockList(Into into, IntoList il) {
		StockList sl = new StockList();
		sl.setDepotId(into.getDepotId());
		sl.setNum(il.getNum());
		sl.setProductId(il.getProductId());
		sl.setSId(into.getSId());
		sl.setType("PUT");
		sl.setUser(into.getIntoUser());
		sl.save();
	}
	
	public Stock findByCode(String code) {
		return dao.findFirst("select * from erp_jxc_stock where code = ?", code);
	}
	
	public Page<Stock> findPageList2(Stock stock) {
		WhereAndParas wp = getWhereAndParas(stock);
		String select = "SELECT o.depot_id,o.product_id,o.num, d.name as depotName, p.name as productName";
		String from = "FROM"
				+ "	erp_jxc_stock o "
				+ " LEFT JOIN erp_jxc_depot d ON d.id = o.depot_id "
				+ " LEFT JOIN erp_jxc_product p ON o.product_id = p.id "
				+ " WHERE 1 = 1 "
				+ wp.getWhere();
		return dao.paginate(stock.getPageNumber(),stock.getPageSize(),select,from,wp.getParas());
	}
	
	/**
	 * 作废入货单 
	 * @param into
	 */
	public void cancelByInto(Into into) {
		if(into == null || into.getId() <= 0) throw new RuntimeException("入货单不能为空");
		if(into.getState().equals("CANCEL")) throw new RuntimeException("该单已作废");
		List<IntoList> list = IntoList.dao.findByIntoId(into.getId());
		if(list == null || list.size() == 0) throw new RuntimeException("该入货单，对应的商品不存在");
		for(IntoList il : list){
			String code = into.getSId()+"-"+into.getDepotId()+"-"+il.getProductId();
			Stock stock = dao.findByCode(code);
			if(stock == null ) throw new RuntimeException("库存内不存在，不作废失败");
			stock.setNum(stock.getNum()-il.getNum());
			stock.setVersion(stock.getVersion()+1);
			stock.update();
			//入库操作流水
			StockList sl = new StockList();
			sl.setDepotId(into.getDepotId());
			sl.setNum(il.getNum());
			sl.setProductId(il.getProductId());
			sl.setSId(into.getSId());
			sl.setType("CANCEL");
			sl.setUser(into.getIntoUser());
			sl.setRemarks("作废入货单号："+into.getCode());
			sl.save();
		}
		//更新货单的状态
		into.setState("CANCEL");
		into.setVersion(into.getVersion()+1);
		into.update();
	}
	
	/**
	 * 作废出货单 
	 * @param into
	 */
	public void cancelByInto(Out out) {
		if(out == null || out.getId() <= 0) throw new RuntimeException("入货单不能为空");
		if(out.getState().equals("CANCEL")) throw new RuntimeException("该单已作废");
		List<OutList> list = OutList.dao.findByOutId(out.getId());
		if(list == null || list.size() == 0) throw new RuntimeException("该出货单，对应的商品不存在");
		for(OutList il : list){
			String code = out.getSId()+"-"+out.getDepotId()+"-"+il.getProductId();
			Stock stock = dao.findByCode(code);
			if(stock == null ) throw new RuntimeException("库存内不存在，不作废失败");
			stock.setNum(stock.getNum()+il.getNum());
			stock.setVersion(stock.getVersion()+1);
			stock.update();
			//入库操作流水
			StockList sl = new StockList();
			sl.setDepotId(out.getDepotId());
			sl.setNum(il.getNum());
			sl.setProductId(il.getProductId());
			sl.setSId(out.getSId());
			sl.setType("CANCEL");
			sl.setUser(out.getOutUser());
			sl.setRemarks("作废出货单号："+out.getCode());
			sl.save();
		}
		//更新货单的状态
		out.setState("CANCEL");
		out.setVersion(out.getVersion()+1);
		out.update();
	}
	public void findByProductId(Integer productId) {
		// TODO Auto-generated method stub
		
	}
}
