package com.wonderrobot.ankenmatchingu.service;

import com.wonderfulfly.core.util.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.wonderrobot.ankenmatchingu.aspect.Log;
import com.wonderrobot.ankenmatchingu.dao.UploadImageDao;
import com.wonderrobot.ankenmatchingu.entity.ConfigEntity;

/**
 * null Page: 
 */
@Service
public class UploadImageService {

	@Autowired
	private UploadImageDao UploadImageDao;
	@Autowired
	private ConfigEntity ConfigEntity;

	/**
	 * 画像をアップロードする
	 * @param id
	 * @param fileName
	 * @param fileNewName
	 * @throws Exception
	 */
	@Log
	public void saveImageInfo(int id, String fileName, String fileNewName) throws Exception {
         UploadImageDao.insertImageInfo(ConfigEntity.getInout_businessunit(), id, fileName, 0, "", "", "", null, null, null, fileNewName, "", null, 0, 0, DateUtil.getPatternDateForDb(), "", DateUtil.getPatternDateForDb(), "");
	}
}

