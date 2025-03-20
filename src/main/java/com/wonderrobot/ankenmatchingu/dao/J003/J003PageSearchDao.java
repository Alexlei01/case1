package com.wonderrobot.ankenmatchingu.dao.J003;
// BasicDao.vm
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wonderrobot.ankenmatchingu.entity.J003.J003PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.J003.J003PageSearchByNameResponseEntity;
import com.wonderrobot.ankenmatchingu.mapper.J003.J003PageSearchMapper;

/**
 * J003PageSearchDao
 */
@Repository
public class J003PageSearchDao {

	@Autowired
	private J003PageSearchMapper J003PageSearchMapper;

	/*
	 * call mapper interface
	 */
	public List<J003PageSearchResponseEntity> queryJ003PageSearch(String detail_id, String email_send_time, String id, String number_end, String number_start, String tag_code, String tag_id, String tag_type, String value) throws Exception {
        return J003PageSearchMapper.queryJ003PageSearch(detail_id, email_send_time, id, number_end, number_start, tag_code, tag_id, tag_type, value);
	}

	/*
	 * call mapper interface
	 */
	public void deleteJ003PageSearch(String id) throws Exception {
        J003PageSearchMapper.deleteJ003PageSearch(id);
	}

}
