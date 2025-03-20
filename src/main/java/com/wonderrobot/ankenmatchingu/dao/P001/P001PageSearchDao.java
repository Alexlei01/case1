package com.wonderrobot.ankenmatchingu.dao.P001;
// BasicDao.vm
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wonderrobot.ankenmatchingu.entity.P001.P001PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.P001.P001PageSearchByNameResponseEntity;
import com.wonderrobot.ankenmatchingu.mapper.P001.P001PageSearchMapper;

/**
 * P001PageSearchDao
 */
@Repository
public class P001PageSearchDao {

	@Autowired
	private P001PageSearchMapper P001PageSearchMapper;

	/*
	 * call mapper interface
	 */
	public List<P001PageSearchResponseEntity> queryP001PageSearch(String detail_id, String email_send_time, String id, String number_end, String number_start, String tag_code, String tag_id, String tag_type, String value) throws Exception {
        return P001PageSearchMapper.queryP001PageSearch(detail_id, email_send_time, id, number_end, number_start, tag_code, tag_id, tag_type, value);
	}

	/*
	 * call mapper interface
	 */
	public void deleteP001PageSearch(String id) throws Exception {
        P001PageSearchMapper.deleteP001PageSearch(id);
	}

}
