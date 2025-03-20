package com.wonderrobot.ankenmatchingu.dao.P002;
// BasicDao.vm
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wonderrobot.ankenmatchingu.entity.P002.P002PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.P002.P002PageSearchByNameResponseEntity;
import com.wonderrobot.ankenmatchingu.mapper.P002.P002PageSearchMapper;

/**
 * P002PageSearchDao
 */
@Repository
public class P002PageSearchDao {

	@Autowired
	private P002PageSearchMapper P002PageSearchMapper;

	/*
	 * call mapper interface
	 */
	public List<P002PageSearchResponseEntity> queryP002PageSearch(String email_send_time, String email_title, String id) throws Exception {
        return P002PageSearchMapper.queryP002PageSearch(email_send_time, email_title, id);
	}

	/*
	 * call mapper interface
	 */
	public void deleteP002PageSearch(String id) throws Exception {
        P002PageSearchMapper.deleteP002PageSearch(id);
	}

}
