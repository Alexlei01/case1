package com.wonderrobot.ankenmatchingu.dao.S001;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.entity.S001.S001SYS_CONFIGRepeatCheckEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.mapper.S001.S001SYS_CONFIGRepeatCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class S001SYS_CONFIGRepeatCheckDao {
	@Autowired
	private S001SYS_CONFIGRepeatCheckMapper S001SYS_CONFIGRepeatCheckMapper;

   
	/**
	 * s001SYS_CONFIGRepeatCheckselectSYS_CONFIG
	 */
	public List<S001SYS_CONFIGRepeatCheckEntity> s001SYS_CONFIGRepeatCheckselectSYS_CONFIG (String id) throws Exception {

		List<S001SYS_CONFIGRepeatCheckEntity> returnVal = S001SYS_CONFIGRepeatCheckMapper.s001SYS_CONFIGRepeatCheckselectSYS_CONFIG(id);
		return returnVal;
	}
}