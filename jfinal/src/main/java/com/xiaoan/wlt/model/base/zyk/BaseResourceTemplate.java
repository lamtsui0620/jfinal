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
public abstract class BaseResourceTemplate<M extends BaseResourceTemplate<M>> extends BaseModel<M> implements IBean {

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

	public void setAuthorId(java.lang.Long authorId) {
		set("authorId", authorId);
	}

	public java.lang.Long getAuthorId() {
		return get("authorId");
	}

	public void setAuthor(java.lang.String author) {
		set("author", author);
	}

	public java.lang.String getAuthor() {
		return get("author");
	}

	public void setMainPic(java.lang.String mainPic) {
		set("mainPic", mainPic);
	}

	public java.lang.String getMainPic() {
		return get("mainPic");
	}

	public void setTitle(java.lang.String title) {
		set("title", title);
	}

	public java.lang.String getTitle() {
		return get("title");
	}

	public void setDescription(java.lang.String description) {
		set("description", description);
	}

	public java.lang.String getDescription() {
		return get("description");
	}

	public void setContent(java.lang.String content) {
		set("content", content);
	}

	public java.lang.String getContent() {
		return get("content");
	}

	public void setRate(java.lang.Integer rate) {
		set("rate", rate);
	}

	public java.lang.Integer getRate() {
		return get("rate");
	}

	public void setHits(java.lang.Integer hits) {
		set("hits", hits);
	}

	public java.lang.Integer getHits() {
		return get("hits");
	}

	public void setVoteUp(java.lang.Integer voteUp) {
		set("voteUp", voteUp);
	}

	public java.lang.Integer getVoteUp() {
		return get("voteUp");
	}

	public void setCategory(java.lang.Long category) {
		set("category", category);
	}

	public java.lang.Long getCategory() {
		return get("category");
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

	public static final String TABLE = " zyk_resource_template ";
	public WhereAndParas getWhereAndParas(BaseResourceTemplate resourceTemplate){
		StringBuffer sql = new StringBuffer();
		List<Object> list = new ArrayList<Object>();
		WhereAndParas wap = new WhereAndParas();
		if(resourceTemplate.getId() != null && resourceTemplate.getId() > 0){
			sql.append(" and o.id = ?");
			list.add(resourceTemplate.getId());
		}
		if(resourceTemplate.getVersion() != null && resourceTemplate.getVersion() > 0){
			sql.append(" and o.version = ?");
			list.add(resourceTemplate.getVersion());
		}
		if(resourceTemplate.getAuthorId() != null && resourceTemplate.getAuthorId() > 0){
			sql.append(" and o.authorId = ?");
			list.add(resourceTemplate.getAuthorId());
		}
		if(StringUtils.isNotEmpty(resourceTemplate.getAuthor())){
			sql.append(" and o.author like ?");
			list.add("%"+resourceTemplate.getAuthor()+"%");
		}
		if(StringUtils.isNotEmpty(resourceTemplate.getMainPic())){
			sql.append(" and o.mainPic like ?");
			list.add("%"+resourceTemplate.getMainPic()+"%");
		}
		if(StringUtils.isNotEmpty(resourceTemplate.getTitle())){
			sql.append(" and o.title like ?");
			list.add("%"+resourceTemplate.getTitle()+"%");
		}
		if(StringUtils.isNotEmpty(resourceTemplate.getDescription())){
			sql.append(" and o.description like ?");
			list.add("%"+resourceTemplate.getDescription()+"%");
		}
		if(StringUtils.isNotEmpty(resourceTemplate.getContent())){
			sql.append(" and o.content like ?");
			list.add("%"+resourceTemplate.getContent()+"%");
		}
		if(resourceTemplate.getRate() != null && resourceTemplate.getRate() > 0){
			sql.append(" and o.rate = ?");
			list.add(resourceTemplate.getRate());
		}
		if(resourceTemplate.getHits() != null && resourceTemplate.getHits() > 0){
			sql.append(" and o.hits = ?");
			list.add(resourceTemplate.getHits());
		}
		if(resourceTemplate.getVoteUp() != null && resourceTemplate.getVoteUp() > 0){
			sql.append(" and o.voteUp = ?");
			list.add(resourceTemplate.getVoteUp());
		}
		if(resourceTemplate.getCategory() != null && resourceTemplate.getCategory() > 0){
			sql.append(" and o.category = ?");
			list.add(resourceTemplate.getCategory());
		}
		if(resourceTemplate.getIdx() != null && resourceTemplate.getIdx() > 0){
			sql.append(" and o.idx = ?");
			list.add(resourceTemplate.getIdx());
		}
		if(StringUtils.isNotEmpty(resourceTemplate.getState())){
			sql.append(" and o.state like ?");
			list.add("%"+resourceTemplate.getState()+"%");
		}
		wap.setWhere(sql.toString());
		wap.setParas(list.toArray());
		return wap;
	}
}
