package com.wonderrobot.ankenmatchingu.dao.T001;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.mapper.T001.T001InsertSaveMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class T001InsertSaveDao {
	@Autowired
	private T001InsertSaveMapper T001InsertSaveMapper;

   
	/**
	 * T001InsertSaveData
	 */
	public int t001InsertSaveData (String id, String tag_name, String tag_type, String remark, String tag_code, String FIRST_REG_ID, String FIRST_REG_DTM, String LAST_UPDATE_ID, String LAST_UPDATE_DTM) throws Exception {

		int returnVal = T001InsertSaveMapper.t001InsertSaveData(id,tag_name,tag_type,remark,tag_code,FIRST_REG_ID,FIRST_REG_DTM,LAST_UPDATE_ID,LAST_UPDATE_DTM);
		return returnVal;
	}
}