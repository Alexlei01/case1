package com.wonderrobot.ankenmatchingu.dao.P001;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.entity.P001.P001PEOPLE_TAGRepeatCheckEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.mapper.P001.P001PEOPLE_TAGRepeatCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class P001PEOPLE_TAGRepeatCheckDao {
	@Autowired
	private P001PEOPLE_TAGRepeatCheckMapper P001PEOPLE_TAGRepeatCheckMapper;

   
	/**
	 * p001PEOPLE_TAGRepeatCheckselectPEOPLE_TAG
	 */
	public List<P001PEOPLE_TAGRepeatCheckEntity> p001PEOPLE_TAGRepeatCheckselectPEOPLE_TAG (String txt2) throws Exception {

		List<P001PEOPLE_TAGRepeatCheckEntity> returnVal = P001PEOPLE_TAGRepeatCheckMapper.p001PEOPLE_TAGRepeatCheckselectPEOPLE_TAG(txt2);
		return returnVal;
	}
}