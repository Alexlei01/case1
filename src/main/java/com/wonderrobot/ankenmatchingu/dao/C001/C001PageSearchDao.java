package com.wonderrobot.ankenmatchingu.dao.C001;
// BasicDao.vm
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wonderrobot.ankenmatchingu.entity.C001.C001PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.C001.C001PageSearchByNameResponseEntity;
import com.wonderrobot.ankenmatchingu.mapper.C001.C001PageSearchMapper;

/**
 * C001PageSearchDao
 */
@Repository
public class C001PageSearchDao {

	@Autowired
	private C001PageSearchMapper C001PageSearchMapper;

	/*
	 * call mapper interface
	 */
	public List<C001PageSearchResponseEntity> queryC001PageSearch(String id, String job_id, String people_id, String remark, String status) throws Exception {
        return C001PageSearchMapper.queryC001PageSearch(id, job_id, people_id, remark, status);
	}

	/*
	 * call mapper interface
	 */
	public void deleteC001PageSearch(String id) throws Exception {
        C001PageSearchMapper.deleteC001PageSearch(id);
	}

}
