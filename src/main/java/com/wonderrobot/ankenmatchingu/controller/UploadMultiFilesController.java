package com.wonderrobot.ankenmatchingu.controller;
// UploadMultiFilesController.vm
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wonderrobot.ankenmatchingu.common.SpringPropertiesUtil;
import com.wonderrobot.ankenmatchingu.service.UploadImageService;

/**
 * UploadMultiFilesController
 */
@Controller
public class UploadMultiFilesController {

	@Autowired
	private UploadImageService UploadImageService;

	@RequestMapping(path = "syncFiles.do", method = { RequestMethod.POST })
	@ResponseBody
	public ResponseEntity<String> handleFileUpload(MultipartHttpServletRequest request) throws Exception {
        Iterator<String> fileNames = request.getFileNames();

        while (fileNames.hasNext()) {
            String fieldName = fileNames.next();
            List<MultipartFile> files = request.getFiles(fieldName);

            for (MultipartFile file : files) {
                // Parse file ID from field name
                if (file.isEmpty()) {
                    return ResponseEntity.badRequest().body("File is empty or fileId is missing");
                }

                try {
                    // Get the path of the project folder
                    String uploadPath = SpringPropertiesUtil.getUpload_file_path();

                    // Create upload folder
                    File uploadDir = new File(uploadPath);
                    if (!uploadDir.exists()) {
                        uploadDir.mkdirs();
                    }

                    // Get the original name of the file
                    String originalFileName = file.getOriginalFilename();
                    // Build target file object
                    File destFile = new File(uploadDir.getAbsolutePath() + File.separator + originalFileName);

                    transferToFile(destFile, originalFileName);

                    // save document
                    file.transferTo(destFile);

                } catch (IOException e) {
                    e.printStackTrace();
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file: " + e.getMessage());
                }
            }
        }

        return ResponseEntity.ok("Files uploaded successfully");
    }

	private int transferToFile (File file, String orifileName) throws Exception {

		int randomNum = ThreadLocalRandom.current().nextInt(100000, 999999);

		if (file != null) {
			UploadImageService.saveImageInfo(randomNum, orifileName, orifileName);
		}

		return randomNum;
	}
}
