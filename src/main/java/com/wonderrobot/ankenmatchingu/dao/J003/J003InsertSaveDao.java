package com.wonderrobot.ankenmatchingu.dao.J003;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.mapper.J003.J003InsertSaveMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class J003InsertSaveDao {
	@Autowired
	private J003InsertSaveMapper J003InsertSaveMapper;

   
	/**
	 * J003InsertSaveData
	 */
	public int j003InsertSaveData (String id, String tag_type, String tag_id, String number_start, String number_end, String value, String detail_id, String tag_code, String email_send_time, String FIRST_REG_ID, String FIRST_REG_DTM, String LAST_UPDATE_ID, String LAST_UPDATE_DTM) throws Exception {

		int returnVal = J003InsertSaveMapper.j003InsertSaveData(id,tag_type,tag_id,number_start,number_end,value,detail_id,tag_code,email_send_time,FIRST_REG_ID,FIRST_REG_DTM,LAST_UPDATE_ID,LAST_UPDATE_DTM);
		return returnVal;
	}
}