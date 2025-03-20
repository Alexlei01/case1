package com.wonderrobot.ankenmatchingu.dao.P001;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.entity.P001.P001PEOPLE_TAGEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.mapper.P001.P001PEOPLE_TAGMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class P001PEOPLE_TAGDao {
	@Autowired
	private P001PEOPLE_TAGMapper P001PEOPLE_TAGMapper;

   
	/**
	 * 深さゼロのリストのクエリ
	 * @throws Exception
	 */
	public List<P001PEOPLE_TAGEntity> p001InitDepthZero (String txt2) throws Exception {

		List<P001PEOPLE_TAGEntity> returnVal = P001PEOPLE_TAGMapper.p001InitDepthZero(txt2);
		return returnVal;
	}

   
	/**
	 * 深さゼロのリストのクエリ
	 * @throws Exception
	 */
	public List<P001PEOPLE_TAGEntity> p001SearchInitDepthZero (String txt2) throws Exception {

		List<P001PEOPLE_TAGEntity> returnVal = P001PEOPLE_TAGMapper.p001SearchInitDepthZero(txt2);
		return returnVal;
	}
}