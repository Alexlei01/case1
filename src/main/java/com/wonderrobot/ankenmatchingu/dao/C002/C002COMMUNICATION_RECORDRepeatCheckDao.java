package com.wonderrobot.ankenmatchingu.dao.C002;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.entity.C002.C002COMMUNICATION_RECORDRepeatCheckEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.mapper.C002.C002COMMUNICATION_RECORDRepeatCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class C002COMMUNICATION_RECORDRepeatCheckDao {
	@Autowired
	private C002COMMUNICATION_RECORDRepeatCheckMapper C002COMMUNICATION_RECORDRepeatCheckMapper;

   
	/**
	 * c002COMMUNICATION_RECORDRepeatCheckselectCOMMUNICATION_RECORD
	 */
	public List<C002COMMUNICATION_RECORDRepeatCheckEntity> c002COMMUNICATION_RECORDRepeatCheckselectCOMMUNICATION_RECORD (String txt2) throws Exception {

		List<C002COMMUNICATION_RECORDRepeatCheckEntity> returnVal = C002COMMUNICATION_RECORDRepeatCheckMapper.c002COMMUNICATION_RECORDRepeatCheckselectCOMMUNICATION_RECORD(txt2);
		return returnVal;
	}
}