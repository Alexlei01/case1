package com.wonderrobot.ankenmatchingu.dao.P002;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.entity.P002.P002PEOPLE_DETAILEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.mapper.P002.P002PEOPLE_DETAILMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class P002PEOPLE_DETAILDao {
	@Autowired
	private P002PEOPLE_DETAILMapper P002PEOPLE_DETAILMapper;

   
	/**
	 * 深さゼロのリストのクエリ
	 * @throws Exception
	 */
	public List<P002PEOPLE_DETAILEntity> p002InitDepthZero (String txt2) throws Exception {

		List<P002PEOPLE_DETAILEntity> returnVal = P002PEOPLE_DETAILMapper.p002InitDepthZero(txt2);
		return returnVal;
	}

   
	/**
	 * 深さゼロのリストのクエリ
	 * @throws Exception
	 */
	public List<P002PEOPLE_DETAILEntity> p002SearchInitDepthZero (String txt2) throws Exception {

		List<P002PEOPLE_DETAILEntity> returnVal = P002PEOPLE_DETAILMapper.p002SearchInitDepthZero(txt2);
		return returnVal;
	}
}