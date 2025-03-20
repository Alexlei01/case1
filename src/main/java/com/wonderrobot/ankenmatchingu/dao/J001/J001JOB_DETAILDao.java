package com.wonderrobot.ankenmatchingu.dao.J001;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.entity.J001.J001JOB_DETAILEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.mapper.J001.J001JOB_DETAILMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class J001JOB_DETAILDao {
	@Autowired
	private J001JOB_DETAILMapper J001JOB_DETAILMapper;

   
	/**
	 * 深さゼロのリストのクエリ
	 * @throws Exception
	 */
	public List<J001JOB_DETAILEntity> j001InitDepthZero (String txt2) throws Exception {

		List<J001JOB_DETAILEntity> returnVal = J001JOB_DETAILMapper.j001InitDepthZero(txt2);
		return returnVal;
	}

   
	/**
	 * 深さゼロのリストのクエリ
	 * @throws Exception
	 */
	public List<J001JOB_DETAILEntity> j001SearchInitDepthZero (String txt2) throws Exception {

		List<J001JOB_DETAILEntity> returnVal = J001JOB_DETAILMapper.j001SearchInitDepthZero(txt2);
		return returnVal;
	}
}