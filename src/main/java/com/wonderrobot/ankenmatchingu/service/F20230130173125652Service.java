package com.wonderrobot.ankenmatchingu.service;
// ControllerFormat.java
import javax.servlet.http.HttpServletRequest;
import com.wonderfulfly.core.util.log.LoggerUtil;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wonderfulfly.core.constant.JsonConstant;
import com.wonderfulfly.core.json.JSONWFCObject;
import com.wonderfulfly.core.util.StringUtil;
import org.springframework.transaction.annotation.Transactional;
import com.wonderrobot.ankenmatchingu.entity.F20230130173125652Entity;
import com.wonderrobot.ankenmatchingu.aspect.Log;


/**
 * 案件マッチング
 * Page: 
 * Function: 技術者一覧検索
 */
@Service
public class F20230130173125652Service {

   
	/**
	 * 技術者一覧検索
	 * @param Entity
	 * @param jsonObj
	 * @throws Exception
	 */
	@Log
	public JSONWFCObject f20230130173125652 (F20230130173125652Entity F20230130173125652Entity, JSONWFCObject jsonObj) throws Exception {

		LoggerUtil.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + ": start");
		try {
			return null;
		} catch (Exception e) {
			LoggerUtil.error(Thread.currentThread().getStackTrace()[1].getMethodName()+":", e);
			throw e;
		} finally {
			LoggerUtil.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + ": end");
		}
	}
}