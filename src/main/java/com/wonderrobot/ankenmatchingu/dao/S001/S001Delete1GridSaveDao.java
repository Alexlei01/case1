package com.wonderrobot.ankenmatchingu.dao.S001;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.mapper.S001.S001Delete1GridSaveMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class S001Delete1GridSaveDao {
	@Autowired
	private S001Delete1GridSaveMapper S001Delete1GridSaveMapper;

   
	/**
	 * S001Delete1GridSaveData
	 */
	public int s001Delete1GridSaveData (String id) throws Exception {

		int returnVal = S001Delete1GridSaveMapper.s001Delete1GridSaveData(id);
		return returnVal;
	}
}