package com.wonderrobot.ankenmatchingu.dao.C001;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.entity.C001.C001COMMUNICATIONRepeatCheckEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.mapper.C001.C001COMMUNICATIONRepeatCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class C001COMMUNICATIONRepeatCheckDao {
	@Autowired
	private C001COMMUNICATIONRepeatCheckMapper C001COMMUNICATIONRepeatCheckMapper;

   
	/**
	 * c001COMMUNICATIONRepeatCheckselectCOMMUNICATION
	 */
	public List<C001COMMUNICATIONRepeatCheckEntity> c001COMMUNICATIONRepeatCheckselectCOMMUNICATION (String txt2) throws Exception {

		List<C001COMMUNICATIONRepeatCheckEntity> returnVal = C001COMMUNICATIONRepeatCheckMapper.c001COMMUNICATIONRepeatCheckselectCOMMUNICATION(txt2);
		return returnVal;
	}
}