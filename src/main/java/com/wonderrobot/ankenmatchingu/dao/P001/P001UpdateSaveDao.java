package com.wonderrobot.ankenmatchingu.dao.P001;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.mapper.P001.P001UpdateSaveMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class P001UpdateSaveDao {
	@Autowired
	private P001UpdateSaveMapper P001UpdateSaveMapper;

   
	/**
	 * P001UpdateSaveData
	 */
	public int p001UpdateSaveData (String id, String tag_type, String tag_id, String number_start, String number_end, String value, String detail_id, String tag_code, String email_send_time, String LAST_UPDATE_ID, String LAST_UPDATE_DTM, String id1) throws Exception {

		int returnVal = P001UpdateSaveMapper.p001UpdateSaveData(id,tag_type,tag_id,number_start,number_end,value,detail_id,tag_code,email_send_time,LAST_UPDATE_ID,LAST_UPDATE_DTM,id1);
		return returnVal;
	}
}