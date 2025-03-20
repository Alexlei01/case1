package com.wonderrobot.ankenmatchingu.mapper;
// BasicMapperClass.vm
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wonderrobot.ankenmatchingu.entity.UserPasswordRequestEntity;

/**
 * User Password 用 Mapper
 */
public interface UserPasswordMapper {

	/*
	 * call sql
	 */
	public void updateUserPassword(@Param("LOGINTABLEID") String LOGINTABLEID, @Param("LOGINPASSWORD") String LOGINPASSWORD, @Param("LOGINPASSWORD_VALUE") String LOGINPASSWORD_VALUE, @Param("LOGINID") String LOGINID, @Param("LOGINID_VALUE") String LOGINID_VALUE);

}
