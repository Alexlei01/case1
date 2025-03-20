package com.wonderrobot.ankenmatchingu.dao.J002;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.mapper.J002.J002InsertSaveMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class J002InsertSaveDao {
	@Autowired
	private J002InsertSaveMapper J002InsertSaveMapper;

   
	/**
	 * J002InsertSaveData
	 */
	public int j002InsertSaveData (String id, String job_id, String job_name, String people_id, String people_name, String match_percent, String match_code, String FIRST_REG_ID, String FIRST_REG_DTM, String LAST_UPDATE_ID, String LAST_UPDATE_DTM) throws Exception {

		int returnVal = J002InsertSaveMapper.j002InsertSaveData(id,job_id,job_name,people_id,people_name,match_percent,match_code,FIRST_REG_ID,FIRST_REG_DTM,LAST_UPDATE_ID,LAST_UPDATE_DTM);
		return returnVal;
	}
}