package com.wonderrobot.ankenmatchingu.mapper;

import com.wonderrobot.ankenmatchingu.entity.UserMenuEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * UserMenuMapper Mapper
 * 
 * @author wonderfulfly
 *
 */
public interface UserMenuMapper {
	
	/**
	 * getUserGroup method
	 * 
	 * @param USERID
	 * @return
	 */
	public List<String> getUserGroup(@Param("USERID") String USERID);

	public List<String> getBusinessUserGroup(@Param("LOGINID")String LOGINID,@Param("LOGINPASSWORD")String LOGINPASSWORD,@Param("DEPARTID")String DEPARTID,@Param("LOGINTABLEID")String LOGINTABLEID,@Param("WHRLOGINID")String WHRLOGINID);

	/**
	 * getUserMenu method
	 * 
	 * @param USERID
	 * @param GROUPIDS
	 * @return
	 */
	public List<UserMenuEntity> getUserMenu(@Param("USERID") String USERID, @Param("GROUPIDS") List<String> GROUPIDS);
}

