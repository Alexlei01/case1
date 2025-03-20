package com.wonderrobot.ankenmatchingu.dao.J003;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.entity.J003.J003JOB_TAGEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.mapper.J003.J003JOB_TAGMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class J003JOB_TAGDao {
	@Autowired
	private J003JOB_TAGMapper J003JOB_TAGMapper;

   
	/**
	 * 深さゼロのリストのクエリ
	 * @throws Exception
	 */
	public List<J003JOB_TAGEntity> j003InitDepthZero (String txt2) throws Exception {

		List<J003JOB_TAGEntity> returnVal = J003JOB_TAGMapper.j003InitDepthZero(txt2);
		return returnVal;
	}

   
	/**
	 * 深さゼロのリストのクエリ
	 * @throws Exception
	 */
	public List<J003JOB_TAGEntity> j003SearchInitDepthZero (String txt2) throws Exception {

		List<J003JOB_TAGEntity> returnVal = J003JOB_TAGMapper.j003SearchInitDepthZero(txt2);
		return returnVal;
	}
}