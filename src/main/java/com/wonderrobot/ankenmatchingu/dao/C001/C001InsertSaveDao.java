package com.wonderrobot.ankenmatchingu.dao.C001;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.mapper.C001.C001InsertSaveMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class C001InsertSaveDao {
	@Autowired
	private C001InsertSaveMapper C001InsertSaveMapper;

   
	/**
	 * C001InsertSaveData
	 */
	public int c001InsertSaveData (String id, String job_id, String people_id, String remark, String status, String FIRST_REG_ID, String FIRST_REG_DTM, String LAST_UPDATE_ID, String LAST_UPDATE_DTM) throws Exception {

		int returnVal = C001InsertSaveMapper.c001InsertSaveData(id,job_id,people_id,remark,status,FIRST_REG_ID,FIRST_REG_DTM,LAST_UPDATE_ID,LAST_UPDATE_DTM);
		return returnVal;
	}
}