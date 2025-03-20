package com.wonderrobot.ankenmatchingu.dao.P002;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.entity.P002.P002PEOPLE_DETAILRepeatCheckEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.mapper.P002.P002PEOPLE_DETAILRepeatCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class P002PEOPLE_DETAILRepeatCheckDao {
	@Autowired
	private P002PEOPLE_DETAILRepeatCheckMapper P002PEOPLE_DETAILRepeatCheckMapper;

   
	/**
	 * p002PEOPLE_DETAILRepeatCheckselectPEOPLE_DETAIL
	 */
	public List<P002PEOPLE_DETAILRepeatCheckEntity> p002PEOPLE_DETAILRepeatCheckselectPEOPLE_DETAIL (String txt2) throws Exception {

		List<P002PEOPLE_DETAILRepeatCheckEntity> returnVal = P002PEOPLE_DETAILRepeatCheckMapper.p002PEOPLE_DETAILRepeatCheckselectPEOPLE_DETAIL(txt2);
		return returnVal;
	}
}