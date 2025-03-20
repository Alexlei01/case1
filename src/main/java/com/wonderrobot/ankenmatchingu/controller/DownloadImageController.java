package com.wonderrobot.ankenmatchingu.controller;
// DownloadImageControllerBuild.java
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.wonderrobot.ankenmatchingu.service.DownloadImageService;
import com.wonderrobot.ankenmatchingu.entity.ConfigEntity;
import com.wonderrobot.ankenmatchingu.common.SpringPropertiesUtil;

@Controller
public class DownloadImageController {
	@Autowired
	private DownloadImageService DownloadImageService;
	@Autowired
	private ConfigEntity ConfigEntity;

	@GetMapping("/download/{fileId}")
	public void downloadFile(@PathVariable int fileId, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		try {
			String fileName = DownloadImageService.getFileName(ConfigEntity.getInout_businessunit(), fileId);
			if (fileName == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
			String uploadPath = SpringPropertiesUtil.getUpload_file_path() + fileName;
			Path file = Paths.get(uploadPath);
			if (Files.exists(file)) {
				response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
				response.setHeader("Content-Disposition", new StringBuilder().append("attachment; filename=\"").append(file.getFileName().toString()).append("\"").toString());
				Files.copy(file, response.getOutputStream());
				response.getOutputStream().flush();
			} else {
					response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} catch (Exception e) {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}


}
