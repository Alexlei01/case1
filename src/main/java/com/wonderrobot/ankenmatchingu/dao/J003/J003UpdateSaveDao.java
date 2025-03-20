package com.wonderrobot.ankenmatchingu.dao.J003;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.mapper.J003.J003UpdateSaveMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class J003UpdateSaveDao {
	@Autowired
	private J003UpdateSaveMapper J003UpdateSaveMapper;

   
	/**
	 * J003UpdateSaveData
	 */
	public int j003UpdateSaveData (String id, String tag_type, String tag_id, String number_start, String number_end, String value, String detail_id, String tag_code, String email_send_time, String LAST_UPDATE_ID, String LAST_UPDATE_DTM, String id1) throws Exception {

		int returnVal = J003UpdateSaveMapper.j003UpdateSaveData(id,tag_type,tag_id,number_start,number_end,value,detail_id,tag_code,email_send_time,LAST_UPDATE_ID,LAST_UPDATE_DTM,id1);
		return returnVal;
	}
}