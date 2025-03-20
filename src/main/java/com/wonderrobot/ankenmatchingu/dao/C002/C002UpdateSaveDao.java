package com.wonderrobot.ankenmatchingu.dao.C002;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.mapper.C002.C002UpdateSaveMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class C002UpdateSaveDao {
	@Autowired
	private C002UpdateSaveMapper C002UpdateSaveMapper;

   
	/**
	 * C002UpdateSaveData
	 */
	public int c002UpdateSaveData (String id, String record_type, String email_receiver, String email_title, String email_content, String email_sender, String email_send_time, String match_id, String c_id, String LAST_UPDATE_ID, String LAST_UPDATE_DTM, String id1) throws Exception {

		int returnVal = C002UpdateSaveMapper.c002UpdateSaveData(id,record_type,email_receiver,email_title,email_content,email_sender,email_send_time,match_id,c_id,LAST_UPDATE_ID,LAST_UPDATE_DTM,id1);
		return returnVal;
	}
}