package com.wonderrobot.ankenmatchingu.dao.C002;
// BasicDao.vm
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wonderrobot.ankenmatchingu.entity.C002.C002PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.C002.C002PageSearchByNameResponseEntity;
import com.wonderrobot.ankenmatchingu.mapper.C002.C002PageSearchMapper;

/**
 * C002PageSearchDao
 */
@Repository
public class C002PageSearchDao {

	@Autowired
	private C002PageSearchMapper C002PageSearchMapper;

	/*
	 * call mapper interface
	 */
	public List<C002PageSearchResponseEntity> queryC002PageSearch(String email_content, String email_receiver, String email_sender, String email_send_time, String email_title) throws Exception {
        return C002PageSearchMapper.queryC002PageSearch(email_content, email_receiver, email_sender, email_send_time, email_title);
	}

	/*
	 * call mapper interface
	 */
	public void deleteC002PageSearch(String id) throws Exception {
        C002PageSearchMapper.deleteC002PageSearch(id);
	}

}
