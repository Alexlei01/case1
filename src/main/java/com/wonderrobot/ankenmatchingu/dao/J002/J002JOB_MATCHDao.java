package com.wonderrobot.ankenmatchingu.dao.J002;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.entity.J002.J002JOB_MATCHEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.mapper.J002.J002JOB_MATCHMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class J002JOB_MATCHDao {
	@Autowired
	private J002JOB_MATCHMapper J002JOB_MATCHMapper;

   
	/**
	 * 深さゼロのリストのクエリ
	 * @throws Exception
	 */
	public List<J002JOB_MATCHEntity> j002InitDepthZero (String txt2) throws Exception {

		List<J002JOB_MATCHEntity> returnVal = J002JOB_MATCHMapper.j002InitDepthZero(txt2);
		return returnVal;
	}

   
	/**
	 * 深さゼロのリストのクエリ
	 * @throws Exception
	 */
	public List<J002JOB_MATCHEntity> j002SearchInitDepthZero (String txt2) throws Exception {

		List<J002JOB_MATCHEntity> returnVal = J002JOB_MATCHMapper.j002SearchInitDepthZero(txt2);
		return returnVal;
	}
}