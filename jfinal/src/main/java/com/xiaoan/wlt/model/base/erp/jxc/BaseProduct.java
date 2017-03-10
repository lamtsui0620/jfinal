package com.xiaoan.wlt.model.base.erp.jxc;

import com.xiaoan.wlt.common.jfinal.BaseModel;
import com.jfinal.plugin.activerecord.IBean;

import org.apache.commons.lang3.StringUtils;

import com.xiaoan.wlt.common.WhereAndParas;

import java.util.ArrayList;

import java.util.List;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseProduct<M extends BaseProduct<M>> extends BaseModel<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public void setSId(java.lang.Integer sId) {
		set("s_id", sId);
	}

	public java.lang.Integer getSId() {
		return get("s_id");
	}

	public void setCode(java.lang.String code) {
		set("code", code);
	}

	public java.lang.String getCode() {
		return get("code");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return get("name");
	}

	public void setCategoryId(java.lang.Integer categoryId) {
		set("category_id", categoryId);
	}

	public java.lang.Integer getCategoryId() {
		return get("category_id");
	}

	public void setUnit(java.lang.String unit) {
		set("unit", unit);
	}

	public java.lang.String getUnit() {
		return get("unit");
	}

	public void setDivider(java.lang.String divider) {
		set("divider", divider);
	}

	public java.lang.String getDivider() {
		return get("divider");
	}

	public void setPriceRetail(java.lang.Double priceRetail) {
		set("price_retail", priceRetail);
	}

	public java.lang.Double getPriceRetail() {
		return get("price_retail");
	}

	public void setPriceWholesale(java.lang.Double priceWholesale) {
		set("price_wholesale", priceWholesale);
	}

	public java.lang.Double getPriceWholesale() {
		return get("price_wholesale");
	}

	public void setPriceLowest(java.lang.Double priceLowest) {
		set("price_lowest", priceLowest);
	}

	public java.lang.Double getPriceLowest() {
		return get("price_lowest");
	}

	public void setPriceReference(java.lang.Double priceReference) {
		set("price_reference", priceReference);
	}

	public java.lang.Double getPriceReference() {
		return get("price_reference");
	}

	public void setState(java.lang.String state) {
		set("state", state);
	}

	public java.lang.String getState() {
		return get("state");
	}

	public void setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
	}

	public java.util.Date getCreateTime() {
		return get("create_time");
	}

	public void setUpdateTime(java.util.Date updateTime) {
		set("update_time", updateTime);
	}

	public java.util.Date getUpdateTime() {
		return get("update_time");
	}

	public void setRemarks(java.lang.String remarks) {
		set("remarks", remarks);
	}

	public java.lang.String getRemarks() {
		return get("remarks");
	}

	public void setVersion(java.lang.Integer version) {
		set("version", version);
	}

	public java.lang.Integer getVersion() {
		return get("version");
	}

	public void setImg(java.lang.String img) {
		set("img", img);
	}

	public java.lang.String getImg() {
		return get("img");
	}

	public void setStockLow(java.lang.Double stockLow) {
		set("stock_low", stockLow);
	}

	public java.lang.Double getStockLow() {
		return get("stock_low");
	}

	public void setStockHigh(java.lang.Double stockHigh) {
		set("stock_high", stockHigh);
	}

	public java.lang.Double getStockHigh() {
		return get("stock_high");
	}

	public static final String TABLE = " erp_jxc_product ";
	public WhereAndParas getWhereAndParas(BaseProduct product){
		StringBuffer sql = new StringBuffer();
		List<Object> list = new ArrayList<Object>();
		WhereAndParas wap = new WhereAndParas();
		if(product.getId() != null && product.getId() > 0){
			sql.append(" and o.id = ?");
			list.add(product.getId());
		}
		if(product.getSId() != null && product.getSId() > 0){
			sql.append(" and o.s_id = ?");
			list.add(product.getSId());
		}
		if(StringUtils.isNotEmpty(product.getCode())){
			sql.append(" and o.code like ?");
			list.add("%"+product.getCode()+"%");
		}
		if(StringUtils.isNotEmpty(product.getName())){
			sql.append(" and o.name like ?");
			list.add("%"+product.getName()+"%");
		}
		if(product.getCategoryId() != null && product.getCategoryId() > 0){
			sql.append(" and o.category_id = ?");
			list.add(product.getCategoryId());
		}
		if(StringUtils.isNotEmpty(product.getUnit())){
			sql.append(" and o.unit like ?");
			list.add("%"+product.getUnit()+"%");
		}
		if(StringUtils.isNotEmpty(product.getDivider())){
			sql.append(" and o.divider like ?");
			list.add("%"+product.getDivider()+"%");
		}
		if(product.getPriceRetail() != null && product.getPriceRetail() > 0){
			sql.append(" and o.price_retail = ?");
			list.add(product.getPriceRetail());
		}
		if(product.getPriceWholesale() != null && product.getPriceWholesale() > 0){
			sql.append(" and o.price_wholesale = ?");
			list.add(product.getPriceWholesale());
		}
		if(product.getPriceLowest() != null && product.getPriceLowest() > 0){
			sql.append(" and o.price_lowest = ?");
			list.add(product.getPriceLowest());
		}
		if(product.getPriceReference() != null && product.getPriceReference() > 0){
			sql.append(" and o.price_reference = ?");
			list.add(product.getPriceReference());
		}
		if(StringUtils.isNotEmpty(product.getState())){
			sql.append(" and o.state like ?");
			list.add("%"+product.getState()+"%");
		}
		if(StringUtils.isNotEmpty(product.getRemarks())){
			sql.append(" and o.remarks like ?");
			list.add("%"+product.getRemarks()+"%");
		}
		if(product.getVersion() != null && product.getVersion() > 0){
			sql.append(" and o.version = ?");
			list.add(product.getVersion());
		}
		if(StringUtils.isNotEmpty(product.getImg())){
			sql.append(" and o.img like ?");
			list.add("%"+product.getImg()+"%");
		}
		if(product.getStockLow() != null && product.getStockLow() > 0){
			sql.append(" and o.stock_low = ?");
			list.add(product.getStockLow());
		}
		if(product.getStockHigh() != null && product.getStockHigh() > 0){
			sql.append(" and o.stock_high = ?");
			list.add(product.getStockHigh());
		}
		wap.setWhere(sql.toString());
		wap.setParas(list.toArray());
		return wap;
	}
}
