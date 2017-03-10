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
public abstract class BaseOut<M extends BaseOut<M>> extends BaseModel<M> implements IBean {

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

	public void setCId(java.lang.Integer cId) {
		set("c_id", cId);
	}

	public java.lang.Integer getCId() {
		return get("c_id");
	}

	public void setOutUser(java.lang.String outUser) {
		set("out_user", outUser);
	}

	public java.lang.String getOutUser() {
		return get("out_user");
	}

	public void setOutTime(java.util.Date outTime) {
		set("out_time", outTime);
	}

	public java.util.Date getOutTime() {
		return get("out_time");
	}

	public void setState(java.lang.String state) {
		set("state", state);
	}

	public java.lang.String getState() {
		return get("state");
	}

	public void setPriceTotal(java.lang.Double priceTotal) {
		set("price_total", priceTotal);
	}

	public java.lang.Double getPriceTotal() {
		return get("price_total");
	}

	public void setRemarks(java.lang.String remarks) {
		set("remarks", remarks);
	}

	public java.lang.String getRemarks() {
		return get("remarks");
	}

	public void setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
	}

	public java.util.Date getCreateTime() {
		return get("create_time");
	}

	public void setUpdateTime(java.lang.String updateTime) {
		set("update_time", updateTime);
	}

	public java.lang.String getUpdateTime() {
		return get("update_time");
	}

	public void setVersion(java.lang.Integer version) {
		set("version", version);
	}

	public java.lang.Integer getVersion() {
		return get("version");
	}

	public void setDepotId(java.lang.Integer depotId) {
		set("depot_id", depotId);
	}

	public java.lang.Integer getDepotId() {
		return get("depot_id");
	}

	public static final String TABLE = " erp_jxc_out ";
	public WhereAndParas getWhereAndParas(BaseOut out){
		StringBuffer sql = new StringBuffer();
		List<Object> list = new ArrayList<Object>();
		WhereAndParas wap = new WhereAndParas();
		if(out.getId() != null && out.getId() > 0){
			sql.append(" and o.id = ?");
			list.add(out.getId());
		}
		if(out.getSId() != null && out.getSId() > 0){
			sql.append(" and o.s_id = ?");
			list.add(out.getSId());
		}
		if(StringUtils.isNotEmpty(out.getCode())){
			sql.append(" and o.code like ?");
			list.add("%"+out.getCode()+"%");
		}
		if(out.getCId() != null && out.getCId() > 0){
			sql.append(" and o.c_id = ?");
			list.add(out.getCId());
		}
		if(StringUtils.isNotEmpty(out.getOutUser())){
			sql.append(" and o.out_user like ?");
			list.add("%"+out.getOutUser()+"%");
		}
		if(StringUtils.isNotEmpty(out.getState())){
			sql.append(" and o.state like ?");
			list.add("%"+out.getState()+"%");
		}
		if(out.getPriceTotal() != null && out.getPriceTotal() > 0){
			sql.append(" and o.price_total = ?");
			list.add(out.getPriceTotal());
		}
		if(StringUtils.isNotEmpty(out.getRemarks())){
			sql.append(" and o.remarks like ?");
			list.add("%"+out.getRemarks()+"%");
		}
		if(StringUtils.isNotEmpty(out.getUpdateTime())){
			sql.append(" and o.update_time like ?");
			list.add("%"+out.getUpdateTime()+"%");
		}
		if(out.getVersion() != null && out.getVersion() > 0){
			sql.append(" and o.version = ?");
			list.add(out.getVersion());
		}
		if(out.getDepotId() != null && out.getDepotId() > 0){
			sql.append(" and o.depot_id = ?");
			list.add(out.getDepotId());
		}
		wap.setWhere(sql.toString());
		wap.setParas(list.toArray());
		return wap;
	}
}
