package com.wonderrobot.ankenmatchingu.dao.T001;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.entity.T001.T001TAGRepeatCheckEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.mapper.T001.T001TAGRepeatCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class T001TAGRepeatCheckDao {
	@Autowired
	private T001TAGRepeatCheckMapper T001TAGRepeatCheckMapper;

   
	/**
	 * t001TAGRepeatCheckselectTAG
	 */
	public List<T001TAGRepeatCheckEntity> t001TAGRepeatCheckselectTAG (String txt2) throws Exception {

		List<T001TAGRepeatCheckEntity> returnVal = T001TAGRepeatCheckMapper.t001TAGRepeatCheckselectTAG(txt2);
		return returnVal;
	}
}