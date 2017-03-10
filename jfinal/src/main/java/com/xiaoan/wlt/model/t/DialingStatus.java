package com.xiaoan.wlt.model.t;

import org.apache.commons.lang3.StringUtils;

import com.xiaoan.wlt.common.WhereAndParas;

import java.util.ArrayList;

import java.util.List;

import com.jfinal.plugin.activerecord.Page;

import com.xiaoan.wlt.model.base.t.BaseDialingStatus;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class DialingStatus extends BaseDialingStatus<DialingStatus> {
	public static final DialingStatus dao = new DialingStatus();
	private int pageNumber = 1;
	private int pageSize = 15;
	public int getPageSize() {return pageSize;}
	public void setPageSize(int pageSize) {this.pageSize = pageSize;}
	public int getPageNumber() {return pageNumber;}
	public void setPageNumber(int pageNumber) {this.pageNumber = pageNumber;}
	public Page<DialingStatus> findPageList(DialingStatus dialingStatus) {
		WhereAndParas wp = getWhereAndParas(dialingStatus);
		return dao.paginate(dialingStatus.getPageNumber(),dialingStatus.getPageSize(),"select * ","from"+ DialingStatus.TABLE + "where 1=1 " +wp.getWhere(),wp.getParas());
	}
	public static final String TABLE = " t_dialing_status ";
	public WhereAndParas getWhereAndParas(DialingStatus dialingStatus){
		StringBuffer sql = new StringBuffer();
		List<Object> list = new ArrayList<Object>();
		WhereAndParas wap = new WhereAndParas();
		if(dialingStatus.getId() != null && dialingStatus.getId() > 0){
			sql.append(" and id = ?");
			list.add(dialingStatus.getId());
		}
		if(dialingStatus.getVersion() != null && dialingStatus.getVersion() > 0){
			sql.append(" and version = ?");
			list.add(dialingStatus.getVersion());
		}
		if(StringUtils.isNotEmpty(dialingStatus.getCalled())){
			sql.append(" and called like ?");
			list.add("%"+dialingStatus.getCalled()+"%");
		}
		if(StringUtils.isNotEmpty(dialingStatus.getCaller())){
			sql.append(" and caller like ?");
			list.add("%"+dialingStatus.getCaller()+"%");
		}
		if(StringUtils.isNotEmpty(dialingStatus.getDescribes())){
			sql.append(" and describes like ?");
			list.add("%"+dialingStatus.getDescribes()+"%");
		}
		if(StringUtils.isNotEmpty(dialingStatus.getDialStatus())){
			sql.append(" and dialStatus like ?");
			list.add("%"+dialingStatus.getDialStatus()+"%");
		}
		if(dialingStatus.getHoldTime() != null && dialingStatus.getHoldTime() > 0){
			sql.append(" and holdTime = ?");
			list.add(dialingStatus.getHoldTime());
		}
		if(StringUtils.isNotEmpty(dialingStatus.getIsCallBack())){
			sql.append(" and isCallBack like ?");
			list.add("%"+dialingStatus.getIsCallBack()+"%");
		}
		if(StringUtils.isNotEmpty(dialingStatus.getResult())){
			sql.append(" and result like ?");
			list.add("%"+dialingStatus.getResult()+"%");
		}
		if(StringUtils.isNotEmpty(dialingStatus.getSessionId())){
			sql.append(" and sessionId like ?");
			list.add("%"+dialingStatus.getSessionId()+"%");
		}
		if(dialingStatus.getCustAcntId() != null && dialingStatus.getCustAcntId() > 0){
			sql.append(" and custAcntId = ?");
			list.add(dialingStatus.getCustAcntId());
		}
		if(StringUtils.isNotEmpty(dialingStatus.getIsStatusCallBack())){
			sql.append(" and isStatusCallBack like ?");
			list.add("%"+dialingStatus.getIsStatusCallBack()+"%");
		}
		wap.setWhere(sql.toString());
		wap.setParas(list.toArray());
		return wap;
	}
}