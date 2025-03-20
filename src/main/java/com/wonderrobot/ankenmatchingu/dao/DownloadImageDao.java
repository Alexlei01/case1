package com.wonderrobot.ankenmatchingu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.mapper.DownloadImageMapper;

@Repository
public class DownloadImageDao {

	@Autowired
	private DownloadImageMapper DownloadImageMapper;

	public String getFileName(String BUSINESS_UNIT, int ATTACHID) throws Exception {
		return DownloadImageMapper.getFileName(BUSINESS_UNIT, ATTACHID);
	}
}

