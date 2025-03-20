package com.wonderrobot.ankenmatchingu.dao.J003;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.entity.J003.J003JOB_TAGRepeatCheckEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.mapper.J003.J003JOB_TAGRepeatCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class J003JOB_TAGRepeatCheckDao {
	@Autowired
	private J003JOB_TAGRepeatCheckMapper J003JOB_TAGRepeatCheckMapper;

   
	/**
	 * j003JOB_TAGRepeatCheckselectJOB_TAG
	 */
	public List<J003JOB_TAGRepeatCheckEntity> j003JOB_TAGRepeatCheckselectJOB_TAG (String txt2) throws Exception {

		List<J003JOB_TAGRepeatCheckEntity> returnVal = J003JOB_TAGRepeatCheckMapper.j003JOB_TAGRepeatCheckselectJOB_TAG(txt2);
		return returnVal;
	}
}