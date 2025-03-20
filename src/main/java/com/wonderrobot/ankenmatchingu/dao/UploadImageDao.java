package com.wonderrobot.ankenmatchingu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.mapper.UploadImageMapper;

@Repository
public class UploadImageDao {

	@Autowired
	private UploadImageMapper UploadImageMapper;

	public void insertImageInfo(String BUSINESS_UNIT, int ATTACHID, String ATTACHFILENAME, int ATTACHFILESIZE, String ATTACHMIMETYPE, String ATTACHDESC, String ATTACHCREATIONIP, String ATTACHCREATIONDATE, String ATTACHMODIFIEDDATE, String REFFRFORM, String ATTACHNEWFILENM, String FILETYPE, String THUMBIMAGENM, int IMAGEWIDTH, int IMAGEHEIGHT, String FIRST_REG_DTM, String FIRST_REG_ID, String LAST_UPDATE_DTM, String LAST_UPDATE_ID) throws Exception {
		UploadImageMapper.insertImageInfo(BUSINESS_UNIT, ATTACHID, ATTACHFILENAME, ATTACHFILESIZE, ATTACHMIMETYPE, ATTACHDESC, ATTACHCREATIONIP, ATTACHCREATIONDATE, ATTACHMODIFIEDDATE, REFFRFORM, ATTACHNEWFILENM, FILETYPE, THUMBIMAGENM, IMAGEWIDTH, IMAGEHEIGHT, FIRST_REG_DTM, FIRST_REG_ID, LAST_UPDATE_DTM, LAST_UPDATE_ID);
	}
	public String getAttachId (String FILENAME) throws Exception {
		String returnVal = UploadImageMapper.getAttachId(FILENAME);
	return returnVal;
	}
}

