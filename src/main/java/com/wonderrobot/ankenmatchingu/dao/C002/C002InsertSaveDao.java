package com.wonderrobot.ankenmatchingu.dao.C002;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.mapper.C002.C002InsertSaveMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class C002InsertSaveDao {
	@Autowired
	private C002InsertSaveMapper C002InsertSaveMapper;

   
	/**
	 * C002InsertSaveData
	 */
	public int c002InsertSaveData (String id, String record_type, String email_receiver, String email_title, String email_content, String email_sender, String email_send_time, String match_id, String c_id, String FIRST_REG_ID, String FIRST_REG_DTM, String LAST_UPDATE_ID, String LAST_UPDATE_DTM) throws Exception {

		int returnVal = C002InsertSaveMapper.c002InsertSaveData(id,record_type,email_receiver,email_title,email_content,email_sender,email_send_time,match_id,c_id,FIRST_REG_ID,FIRST_REG_DTM,LAST_UPDATE_ID,LAST_UPDATE_DTM);
		return returnVal;
	}
}