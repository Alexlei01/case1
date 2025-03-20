package com.wonderrobot.ankenmatchingu.mapper;
import com.wonderrobot.ankenmatchingu.security.LoginUser;
import com.wonderrobot.ankenmatchingu.entity.LoginEntity;
import com.wonderrobot.ankenmatchingu.security.PageRight;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LoginMapper {

    public List<LoginEntity> loginInit(@Param("LOGINID")String LOGINID,@Param("LOGINPASSWORD") String LOGINPASSWORD, @Param("USER_EFF") String USER_EFF, @Param("GROUPID")String GROUPID,@Param("LOGINTABLEID") String LOGINTABLEID,@Param("WHRLOGINID") String WHRLOGINID,@Param("WHRLOGINPASSWORD") String WHRLOGINPASSWORD,@Param("USERID") String USERID );
    public List<LoginEntity> loginInitNm(@Param("LOGINID")String LOGINID,@Param("LOGINPASSWORD") String LOGINPASSWORD, @Param("USER_EFF") String USER_EFF, @Param("GROUPID")String GROUPID,@Param("LOGINTABLEID") String LOGINTABLEID,@Param("WHRLOGINID") String WHRLOGINID,@Param("WHRLOGINPASSWORD") String WHRLOGINPASSWORD,@Param("USERID") String USERID,@Param("USERNM1") String USERNM1,@Param("USERNM2") String USERNM2 );
    public List<LoginEntity> loginInitSurname(@Param("LOGINID")String LOGINID,@Param("LOGINPASSWORD") String LOGINPASSWORD, @Param("USER_EFF") String USER_EFF, @Param("GROUPID")String GROUPID,@Param("LOGINTABLEID") String LOGINTABLEID,@Param("WHRLOGINID") String WHRLOGINID,@Param("WHRLOGINPASSWORD") String WHRLOGINPASSWORD,@Param("USERID") String USERID,@Param("USERNM1") String USERNM1 );
    public List<LoginEntity> loginInitName(@Param("LOGINID")String LOGINID,@Param("LOGINPASSWORD") String LOGINPASSWORD, @Param("USER_EFF") String USER_EFF, @Param("GROUPID")String GROUPID,@Param("LOGINTABLEID") String LOGINTABLEID,@Param("WHRLOGINID") String WHRLOGINID,@Param("WHRLOGINPASSWORD") String WHRLOGINPASSWORD,@Param("USERID") String USERID,@Param("USERNM2") String USERNM2 );
    public List<LoginEntity> loginAdminInit(@Param("LOGINID")String LOGINID,@Param("PASSWORD") String PASSWORD);
    public List<LoginUser> getAdminByUsername(@Param("LOGINID")String LOGINID);
    public List<LoginUser> getBusinessUserByUsername(@Param("LOGINID")String LOGINID,@Param("LOGINPASSWORD")String LOGINPASSWORD,@Param("DEPARTID")String DEPARTID,@Param("LOGINTABLEID")String LOGINTABLEID,@Param("WHRLOGINID")String WHRLOGINID);
    public List<PageRight> getPageRightByGroup(@Param("GROUPID")String GROUPID);
    public String getPageMngId(@Param("PAGEID")String PAGEID);
}

