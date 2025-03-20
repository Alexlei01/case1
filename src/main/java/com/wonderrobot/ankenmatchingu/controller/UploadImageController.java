package com.wonderrobot.ankenmatchingu.controller;
// UploadImageControllerBuild.java
import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wonderfulfly.core.util.FileUtil;
import com.wonderfulfly.core.util.StringUtil;
import com.wonderfulfly.core.util.log.LoggerUtil;
import com.wonderfulfly.core.json.JSONWFCObject;
import com.wonderrobot.ankenmatchingu.service.UploadImageService;
import com.wonderrobot.ankenmatchingu.common.SpringPropertiesUtil;

@Controller
public class UploadImageController {
	@Autowired
	private UploadImageService UploadImageService;


	private int transferToFile (MultipartFile[] file, String orifileName, String uploadPath) throws Exception {
		String fileNewName = null;
		int imagepos = 0;
		File targetFile = null;
		MultipartFile oriFile = null;
		File uploadFile = null;
		
		int randomNum = ThreadLocalRandom.current().nextInt(100000, 999999);
		if (file != null && file.length > 0) {
			
			oriFile = file[imagepos];
			if (oriFile != null) {
				if (StringUtil.isNullOrBlank(orifileName)) {
					fileNewName = getNewFileName(oriFile, randomNum);
				} else {
					fileNewName = orifileName;
				}
				
				uploadFile = new File(uploadPath);
				if (!uploadFile.exists()) {
					uploadFile.mkdirs();
				}
				targetFile = new File(uploadPath, fileNewName);
				oriFile.transferTo(targetFile);
			}
			UploadImageService.saveImageInfo(randomNum, oriFile.getOriginalFilename(), fileNewName);
		}
		return randomNum;
	}
	private String getNewFileName (MultipartFile oriFile, int randomNum) throws Exception {
		String fileName = null;
		StringBuffer sBuffer = null;
		String fileNameExt = null;
		
		fileName = oriFile.getOriginalFilename();
		
		fileNameExt = FileUtil.getExtension(fileName);
		sBuffer = new StringBuffer();
		sBuffer.append(randomNum).append("_").append(System.currentTimeMillis()).append(".").append(fileNameExt);
		fileName = sBuffer.toString();
		
		return fileName;
	}

}
