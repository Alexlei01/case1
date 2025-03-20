package com.wonderrobot.ankenmatchingu.mapper;

import org.apache.ibatis.annotations.Param;

public interface DownloadImageMapper {

	public String getFileName(@Param("BUSINESS_UNIT") String BUSINESS_UNIT, @Param("ATTACHID") int ATTACHID);
}

