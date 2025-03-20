package com.wonderrobot.ankenmatchingu.dao.J002;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.mapper.J002.J002UpdateSaveMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class J002UpdateSaveDao {
	@Autowired
	private J002UpdateSaveMapper J002UpdateSaveMapper;

   
	/**
	 * J002UpdateSaveData
	 */
	public int j002UpdateSaveData (String id, String job_id, String job_name, String people_id, String people_name, String match_percent, String match_code, String LAST_UPDATE_ID, String LAST_UPDATE_DTM, String id1) throws Exception {

		int returnVal = J002UpdateSaveMapper.j002UpdateSaveData(id,job_id,job_name,people_id,people_name,match_percent,match_code,LAST_UPDATE_ID,LAST_UPDATE_DTM,id1);
		return returnVal;
	}
}