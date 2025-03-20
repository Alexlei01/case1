package com.wonderrobot.ankenmatchingu.dao.J002;
// BasicDao.vm
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wonderrobot.ankenmatchingu.entity.J002.J002PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.J002.J002PageSearchByNameResponseEntity;
import com.wonderrobot.ankenmatchingu.mapper.J002.J002PageSearchMapper;

/**
 * J002PageSearchDao
 */
@Repository
public class J002PageSearchDao {

	@Autowired
	private J002PageSearchMapper J002PageSearchMapper;

	/*
	 * call mapper interface
	 */
	public List<J002PageSearchResponseEntity> queryJ002PageSearch(String id, String job_id, String job_name, String match_code, String match_percent, String people_id, String people_name) throws Exception {
        return J002PageSearchMapper.queryJ002PageSearch(id, job_id, job_name, match_code, match_percent, people_id, people_name);
	}

	/*
	 * call mapper interface
	 */
	public void deleteJ002PageSearch(String id) throws Exception {
        J002PageSearchMapper.deleteJ002PageSearch(id);
	}

}
