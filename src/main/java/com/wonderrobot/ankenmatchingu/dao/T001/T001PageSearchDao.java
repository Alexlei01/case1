package com.wonderrobot.ankenmatchingu.dao.T001;
// BasicDao.vm
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wonderrobot.ankenmatchingu.entity.T001.T001PageSearchResponseEntity;
import com.wonderrobot.ankenmatchingu.entity.T001.T001PageSearchByNameResponseEntity;
import com.wonderrobot.ankenmatchingu.mapper.T001.T001PageSearchMapper;

/**
 * T001PageSearchDao
 */
@Repository
public class T001PageSearchDao {

	@Autowired
	private T001PageSearchMapper T001PageSearchMapper;

	/*
	 * call mapper interface
	 */
	public List<T001PageSearchResponseEntity> queryT001PageSearch(String id, String remark, String tag_code, String tag_name, String tag_type) throws Exception {
        return T001PageSearchMapper.queryT001PageSearch(id, remark, tag_code, tag_name, tag_type);
	}

	/*
	 * call mapper interface
	 */
	public void deleteT001PageSearch(String id) throws Exception {
        T001PageSearchMapper.deleteT001PageSearch(id);
	}

}
