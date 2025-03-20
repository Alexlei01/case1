package com.wonderrobot.ankenmatchingu.dao.J001;
// BasicDao.vm
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wonderrobot.ankenmatchingu.entity.J001.J001PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.J001.J001PageSearchByNameResponseEntity;
import com.wonderrobot.ankenmatchingu.mapper.J001.J001PageSearchMapper;

/**
 * J001PageSearchDao
 */
@Repository
public class J001PageSearchDao {

	@Autowired
	private J001PageSearchMapper J001PageSearchMapper;

	/*
	 * call mapper interface
	 */
	public List<J001PageSearchResponseEntity> queryJ001PageSearch(String email_sender, String email_title, String id, String recruitment) throws Exception {
        return J001PageSearchMapper.queryJ001PageSearch(email_sender, email_title, id, recruitment);
	}

	/*
	 * call mapper interface
	 */
	public void deleteJ001PageSearch(String id) throws Exception {
        J001PageSearchMapper.deleteJ001PageSearch(id);
	}

}
