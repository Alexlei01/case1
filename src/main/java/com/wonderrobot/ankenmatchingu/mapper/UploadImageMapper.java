package com.wonderrobot.ankenmatchingu.mapper;

import org.apache.ibatis.annotations.Param;

public interface UploadImageMapper {

	public void insertImageInfo(@Param("BUSINESS_UNIT") String BUSINESS_UNIT, @Param("ATTACHID") int ATTACHID, @Param("ATTACHFILENAME") String ATTACHFILENAME, @Param("ATTACHFILESIZE") int ATTACHFILESIZE, @Param("ATTACHMIMETYPE") String ATTACHMIMETYPE, @Param("ATTACHDESC") String ATTACHDESC, @Param("ATTACHCREATIONIP") String ATTACHCREATIONIP, @Param("ATTACHCREATIONDATE") String ATTACHCREATIONDATE, @Param("ATTACHMODIFIEDDATE") String ATTACHMODIFIEDDATE, @Param("REFFRFORM") String REFFRFORM, @Param("ATTACHNEWFILENM") String ATTACHNEWFILENM, @Param("FILETYPE") String FILETYPE, @Param("THUMBIMAGENM") String THUMBIMAGENM, @Param("IMAGEWIDTH") int IMAGEWIDTH, @Param("IMAGEHEIGHT") int IMAGEHEIGHT, @Param("FIRST_REG_DTM") String FIRST_REG_DTM, @Param("FIRST_REG_ID") String FIRST_REG_ID, @Param("LAST_UPDATE_DTM") String LAST_UPDATE_DTM, @Param("LAST_UPDATE_ID") String LAST_UPDATE_ID);
	public String getAttachId(@Param("FILENAME")String FILENAME);
}

