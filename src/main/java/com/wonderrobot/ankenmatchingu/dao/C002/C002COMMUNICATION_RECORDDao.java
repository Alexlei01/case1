package com.wonderrobot.ankenmatchingu.dao.C002;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.entity.C002.C002COMMUNICATION_RECORDEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.mapper.C002.C002COMMUNICATION_RECORDMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class C002COMMUNICATION_RECORDDao {
	@Autowired
	private C002COMMUNICATION_RECORDMapper C002COMMUNICATION_RECORDMapper;

   
	/**
	 * 深さゼロのリストのクエリ
	 * @throws Exception
	 */
	public List<C002COMMUNICATION_RECORDEntity> c002InitDepthZero (String txt2) throws Exception {

		List<C002COMMUNICATION_RECORDEntity> returnVal = C002COMMUNICATION_RECORDMapper.c002InitDepthZero(txt2);
		return returnVal;
	}

   
	/**
	 * 深さゼロのリストのクエリ
	 * @throws Exception
	 */
	public List<C002COMMUNICATION_RECORDEntity> c002SearchInitDepthZero (String txt2) throws Exception {

		List<C002COMMUNICATION_RECORDEntity> returnVal = C002COMMUNICATION_RECORDMapper.c002SearchInitDepthZero(txt2);
		return returnVal;
	}
}