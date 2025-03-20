package com.wonderrobot.ankenmatchingu.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.wonderrobot.ankenmatchingu.aspect.Log;
import com.wonderrobot.ankenmatchingu.dao.DownloadImageDao;

/**
 * null Page: 
 */
@Service
public class DownloadImageService {

	@Autowired
	private DownloadImageDao DownloadImageDao;

	/**
	 * IDによるイメージ名のクエリ
	 * @param BUSINESS_UNIT
	 * @param ATTACHID
	 * @return file name
	 * @throws Exception
	 */
	@Log
	public String getFileName(String BUSINESS_UNIT, int ATTACHID) throws Exception {
         return DownloadImageDao.getFileName(BUSINESS_UNIT, ATTACHID);
	}
}

