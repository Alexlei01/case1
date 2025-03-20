package com.wonderrobot.ankenmatchingu.dao.S001;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.mapper.S001.S001Insert1GridSaveMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class S001Insert1GridSaveDao {
	@Autowired
	private S001Insert1GridSaveMapper S001Insert1GridSaveMapper;

   
	/**
	 * S001Insert1GridSaveData
	 */
	public int s001Insert1GridSaveData (String config_code, String description, String value, String id, String FIRST_REG_ID, String FIRST_REG_DTM, String LAST_UPDATE_ID, String LAST_UPDATE_DTM) throws Exception {

		int returnVal = S001Insert1GridSaveMapper.s001Insert1GridSaveData(config_code,description,value,id,FIRST_REG_ID,FIRST_REG_DTM,LAST_UPDATE_ID,LAST_UPDATE_DTM);
		return returnVal;
	}
}