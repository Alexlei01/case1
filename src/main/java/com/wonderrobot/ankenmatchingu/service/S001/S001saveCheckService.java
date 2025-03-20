package com.wonderrobot.ankenmatchingu.service.S001;
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
import com.wonderrobot.ankenmatchingu.entity.S001.S001Entity;
import java.util.ArrayList;
import com.wonderrobot.ankenmatchingu.common.SaveDataCheckUtil;
import com.wonderrobot.ankenmatchingu.entity.S001.S001grd1Entity;
import com.wonderrobot.ankenmatchingu.entity.S001.S001SYS_CONFIGRepeatCheckEntity;
import com.wonderrobot.ankenmatchingu.dao.S001.S001SYS_CONFIGRepeatCheckDao;
import java.util.List;
import com.wonderrobot.ankenmatchingu.aspect.Log;


/**
 * Page: 共通設定管理
 */
@Service
public class S001saveCheckService {
	@Autowired
	private S001SYS_CONFIGRepeatCheckDao S001SYS_CONFIGRepeatCheckDao;

   
	/**
	 * configCodeCheck
	 */
	@Log
	private String configCodeCheck (String configCode) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getNotNullCheckErr(configCode, "コード");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(configCode, 100, "コード");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(configCode, 0, "コード");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * descriptionCheck
	 */
	@Log
	private String descriptionCheck (String description) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(description, 100, "説明");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(description, 0, "説明");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * idCheck
	 */
	@Log
	private String idCheck (String id) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getKeyNullCheckErr(id, "id");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(id, 0, "id");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(id, 0, "id");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getIntCheckErr(id, "id");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * valueCheck
	 */
	@Log
	private String valueCheck (String value) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		errMsg = SaveDataCheckUtil.getMaxLengthCheckErr(value, 255, "値");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = SaveDataCheckUtil.getMinLengthCheckErr(value, 0, "値");
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * Gridデータ検証
	 */
	@Log
	private String gridCheck (S001Entity s001Entity) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		String gridOpFlag = null;
		String configCode = null;
		String description = null;
		String id = null;
		String value = null;
		msgBuffer = new StringBuffer();
		
		ArrayList<S001grd1Entity> s001grd1List = new ArrayList<S001grd1Entity>();
		s001grd1List = (ArrayList<S001grd1Entity>) s001Entity.getGrid1();
		if (s001grd1List != null) {
			for(S001grd1Entity s001grd1Entity : s001grd1List) {
				gridOpFlag = s001grd1Entity.getGridOpFlag();
				if ("1".equals(gridOpFlag) || "2".equals(gridOpFlag)) {
					configCode = s001grd1Entity.getConfigcode();
					description = s001grd1Entity.getDescription();
					id = s001grd1Entity.getId();
					value = s001grd1Entity.getValue();
					
					
					errMsg = configCodeCheck(configCode);
					SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
					
					errMsg = descriptionCheck(description);
					SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
					
					errMsg = idCheck(id);
					SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
					
					errMsg = valueCheck(value);
					SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
					
					errMsg = sYS_CONFIGRepeatCheck(id, gridOpFlag);
					SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
				}
			}
		}
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * フィールドの繰り返しをチェックする
	 * @param s001Entity
	 * @return error message
	 * @throws Exception
	 */
	@Log
	private String sYS_CONFIGRepeatCheck (String id, String gridOpFlag) throws Exception {

		List<S001SYS_CONFIGRepeatCheckEntity> S001SYS_CONFIGRepeatCheckEntityList = null;
		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		if ("2".equals(gridOpFlag)) {
			S001SYS_CONFIGRepeatCheckEntityList = S001SYS_CONFIGRepeatCheckDao.s001SYS_CONFIGRepeatCheckselectSYS_CONFIG(id);
			if (S001SYS_CONFIGRepeatCheckEntityList != null && S001SYS_CONFIGRepeatCheckEntityList.size() > 0) {
				
				errMsg = SaveDataCheckUtil.getKeyRepeatErr("SYS_共通設定");
				SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
			}
		}
		errMsg = msgBuffer.toString();

		return errMsg;
	}

   
	/**
	 * データ検証
	 * @param s001Entity
	 * @return String
	 * @throws Exception
	 */
	@Log
	public String saveDataCheck (S001Entity s001Entity) throws Exception {

		String errMsg = null;
		StringBuffer msgBuffer = null;
		msgBuffer = new StringBuffer();
		
		
		errMsg = gridCheck(s001Entity);
		SaveDataCheckUtil.addMsg(errMsg, msgBuffer);
		errMsg = msgBuffer.toString();

		return errMsg;
	}
}