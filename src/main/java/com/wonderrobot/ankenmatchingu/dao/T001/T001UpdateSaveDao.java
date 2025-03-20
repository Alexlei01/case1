package com.wonderrobot.ankenmatchingu.dao.T001;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.mapper.T001.T001UpdateSaveMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class T001UpdateSaveDao {
	@Autowired
	private T001UpdateSaveMapper T001UpdateSaveMapper;

   
	/**
	 * T001UpdateSaveData
	 */
	public int t001UpdateSaveData (String id, String tag_name, String tag_type, String remark, String tag_code, String LAST_UPDATE_ID, String LAST_UPDATE_DTM, String id1) throws Exception {

		int returnVal = T001UpdateSaveMapper.t001UpdateSaveData(id,tag_name,tag_type,remark,tag_code,LAST_UPDATE_ID,LAST_UPDATE_DTM,id1);
		return returnVal;
	}
}