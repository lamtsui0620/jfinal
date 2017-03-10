package com.xiaoan.wlt.model.base.zyk;

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
public abstract class BaseCategory<M extends BaseCategory<M>> extends BaseModel<M> implements IBean {

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return get("id");
	}

	public void setCreateTime(java.util.Date createTime) {
		set("createTime", createTime);
	}

	public java.util.Date getCreateTime() {
		return get("createTime");
	}

	public void setUpdateTime(java.util.Date updateTime) {
		set("updateTime", updateTime);
	}

	public java.util.Date getUpdateTime() {
		return get("updateTime");
	}

	public void setVersion(java.lang.Integer version) {
		set("version", version);
	}

	public java.lang.Integer getVersion() {
		return get("version");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return get("name");
	}

	public void setComments(java.lang.String comments) {
		set("comments", comments);
	}

	public java.lang.String getComments() {
		return get("comments");
	}

	public void setIcon(java.lang.String icon) {
		set("icon", icon);
	}

	public java.lang.String getIcon() {
		return get("icon");
	}

	public void setPid(java.lang.Long pid) {
		set("pid", pid);
	}

	public java.lang.Long getPid() {
		return get("pid");
	}

	public void setIsParent(java.lang.Integer isParent) {
		set("isParent", isParent);
	}

	public java.lang.Integer getIsParent() {
		return get("isParent");
	}

	public void setIdx(java.lang.Integer idx) {
		set("idx", idx);
	}

	public java.lang.Integer getIdx() {
		return get("idx");
	}

	public void setState(java.lang.String state) {
		set("state", state);
	}

	public java.lang.String getState() {
		return get("state");
	}

	public static final String TABLE = " zyk_category ";
	public WhereAndParas getWhereAndParas(BaseCategory category){
		StringBuffer sql = new StringBuffer();
		List<Object> list = new ArrayList<Object>();
		WhereAndParas wap = new WhereAndParas();
		if(category.getId() != null && category.getId() > 0){
			sql.append(" and o.id = ?");
			list.add(category.getId());
		}
		if(category.getVersion() != null && category.getVersion() > 0){
			sql.append(" and o.version = ?");
			list.add(category.getVersion());
		}
		if(StringUtils.isNotEmpty(category.getName())){
			sql.append(" and o.name like ?");
			list.add("%"+category.getName()+"%");
		}
		if(StringUtils.isNotEmpty(category.getComments())){
			sql.append(" and o.comments like ?");
			list.add("%"+category.getComments()+"%");
		}
		if(StringUtils.isNotEmpty(category.getIcon())){
			sql.append(" and o.icon like ?");
			list.add("%"+category.getIcon()+"%");
		}
		if(category.getPid() != null && category.getPid() > 0){
			sql.append(" and o.pid = ?");
			list.add(category.getPid());
		}
		if(category.getIsParent() != null && category.getIsParent() > 0){
			sql.append(" and o.isParent = ?");
			list.add(category.getIsParent());
		}
		if(category.getIdx() != null && category.getIdx() > 0){
			sql.append(" and o.idx = ?");
			list.add(category.getIdx());
		}
		if(StringUtils.isNotEmpty(category.getState())){
			sql.append(" and o.state like ?");
			list.add("%"+category.getState()+"%");
		}
		wap.setWhere(sql.toString());
		wap.setParas(list.toArray());
		return wap;
	}
}
