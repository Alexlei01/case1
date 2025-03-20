package com.wonderrobot.ankenmatchingu.dao.C001;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.entity.C001.C001COMMUNICATIONEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.mapper.C001.C001COMMUNICATIONMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class C001COMMUNICATIONDao {
	@Autowired
	private C001COMMUNICATIONMapper C001COMMUNICATIONMapper;

   
	/**
	 * 深さゼロのリストのクエリ
	 * @throws Exception
	 */
	public List<C001COMMUNICATIONEntity> c001InitDepthZero (String txt2) throws Exception {

		List<C001COMMUNICATIONEntity> returnVal = C001COMMUNICATIONMapper.c001InitDepthZero(txt2);
		return returnVal;
	}

   
	/**
	 * 深さゼロのリストのクエリ
	 * @throws Exception
	 */
	public List<C001COMMUNICATIONEntity> c001SearchInitDepthZero (String txt2) throws Exception {

		List<C001COMMUNICATIONEntity> returnVal = C001COMMUNICATIONMapper.c001SearchInitDepthZero(txt2);
		return returnVal;
	}
}