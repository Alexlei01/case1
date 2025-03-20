package com.wonderrobot.ankenmatchingu.dao.S001;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.mapper.S001.S001Update1GridSaveMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class S001Update1GridSaveDao {
	@Autowired
	private S001Update1GridSaveMapper S001Update1GridSaveMapper;

   
	/**
	 * S001Update1GridSaveData
	 */
	public int s001Update1GridSaveData (String config_code, String description, String value, String id, String LAST_UPDATE_ID, String LAST_UPDATE_DTM, String id1) throws Exception {

		int returnVal = S001Update1GridSaveMapper.s001Update1GridSaveData(config_code,description,value,id,LAST_UPDATE_ID,LAST_UPDATE_DTM,id1);
		return returnVal;
	}
}