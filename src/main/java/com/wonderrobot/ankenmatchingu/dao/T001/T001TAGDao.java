package com.wonderrobot.ankenmatchingu.dao.T001;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.entity.T001.T001TAGEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.mapper.T001.T001TAGMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class T001TAGDao {
	@Autowired
	private T001TAGMapper T001TAGMapper;

   
	/**
	 * 深さゼロのリストのクエリ
	 * @throws Exception
	 */
	public List<T001TAGEntity> t001InitDepthZero (String txt2) throws Exception {

		List<T001TAGEntity> returnVal = T001TAGMapper.t001InitDepthZero(txt2);
		return returnVal;
	}

   
	/**
	 * 深さゼロのリストのクエリ
	 * @throws Exception
	 */
	public List<T001TAGEntity> t001SearchInitDepthZero (String txt2) throws Exception {

		List<T001TAGEntity> returnVal = T001TAGMapper.t001SearchInitDepthZero(txt2);
		return returnVal;
	}
}