package com.wonderrobot.ankenmatchingu.dao.J001;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.entity.J001.J001JOB_DETAILRepeatCheckEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.mapper.J001.J001JOB_DETAILRepeatCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class J001JOB_DETAILRepeatCheckDao {
	@Autowired
	private J001JOB_DETAILRepeatCheckMapper J001JOB_DETAILRepeatCheckMapper;

   
	/**
	 * j001JOB_DETAILRepeatCheckselectJOB_DETAIL
	 */
	public List<J001JOB_DETAILRepeatCheckEntity> j001JOB_DETAILRepeatCheckselectJOB_DETAIL (String txt2) throws Exception {

		List<J001JOB_DETAILRepeatCheckEntity> returnVal = J001JOB_DETAILRepeatCheckMapper.j001JOB_DETAILRepeatCheckselectJOB_DETAIL(txt2);
		return returnVal;
	}
}