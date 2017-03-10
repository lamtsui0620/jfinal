package com.xiaoan.wlt.controller.admin.system;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;

import com.jfinal.plugin.activerecord.Page;
import com.xiaoan.wlt.controller.BaseController;
import com.xiaoan.wlt.model.sys.Log;

/**
 * 
 * @author xulinwei
 * @date 2017年03月09日
 */
@RequiresUser
public class LogController extends BaseController{
	
	private static final String LIST = "/admin/system/log/list.jsp"; 
	
	/**
	 * logList
	 */
	@RequiresPermissions("SYS_LOG")
	public void list(){
		Log log = getModel(Log.class);
		Integer pageNumber = getParaToInt("pageNumber");
		if (pageNumber != null) {
			log.setPageNumber(pageNumber);
		}
		log.put("order", " order by createTime desc");
		Page<Log> page = Log.dao.findPageList(log);
		setPageAttr(page);
		this.render(LIST);
	}

}
