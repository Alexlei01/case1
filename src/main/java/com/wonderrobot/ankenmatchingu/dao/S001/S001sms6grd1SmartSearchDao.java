package com.wonderrobot.ankenmatchingu.dao.S001;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.entity.S001.S001sms6grd1SmartSearchEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.mapper.S001.S001sms6grd1SmartSearchMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 */
@Repository
public class S001sms6grd1SmartSearchDao {
	@Autowired
	private S001sms6grd1SmartSearchMapper S001sms6grd1SmartSearchMapper;

   
	/**
	 * S001sms6grd1SmartSearch
	 */
	public List<S001sms6grd1SmartSearchEntity> s001sms6grd1SmartSearch (String configCode1, String value1, String desc1, String description1) throws Exception {

		List<S001sms6grd1SmartSearchEntity> returnVal = S001sms6grd1SmartSearchMapper.s001sms6grd1SmartSearch(configCode1,value1,desc1,description1);
		return returnVal;
	}
}