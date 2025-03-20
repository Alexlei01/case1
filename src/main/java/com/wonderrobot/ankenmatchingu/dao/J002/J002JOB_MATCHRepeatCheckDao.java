package com.wonderrobot.ankenmatchingu.dao.J002;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.entity.J002.J002JOB_MATCHRepeatCheckEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.mapper.J002.J002JOB_MATCHRepeatCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class J002JOB_MATCHRepeatCheckDao {
	@Autowired
	private J002JOB_MATCHRepeatCheckMapper J002JOB_MATCHRepeatCheckMapper;

   
	/**
	 * j002JOB_MATCHRepeatCheckselectJOB_MATCH
	 */
	public List<J002JOB_MATCHRepeatCheckEntity> j002JOB_MATCHRepeatCheckselectJOB_MATCH (String txt2) throws Exception {

		List<J002JOB_MATCHRepeatCheckEntity> returnVal = J002JOB_MATCHRepeatCheckMapper.j002JOB_MATCHRepeatCheckselectJOB_MATCH(txt2);
		return returnVal;
	}
}