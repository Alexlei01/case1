package com.wonderrobot.ankenmatchingu.dao.C001;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.mapper.C001.C001UpdateSaveMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class C001UpdateSaveDao {
	@Autowired
	private C001UpdateSaveMapper C001UpdateSaveMapper;

   
	/**
	 * C001UpdateSaveData
	 */
	public int c001UpdateSaveData (String id, String job_id, String people_id, String remark, String status, String LAST_UPDATE_ID, String LAST_UPDATE_DTM, String id1) throws Exception {

		int returnVal = C001UpdateSaveMapper.c001UpdateSaveData(id,job_id,people_id,remark,status,LAST_UPDATE_ID,LAST_UPDATE_DTM,id1);
		return returnVal;
	}
}