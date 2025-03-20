package com.wonderrobot.ankenmatchingu.mapper.P003;
// SpringMapperClassCodeCreator.java


import com.wonderrobot.ankenmatchingu.entity.P003.P003Entity;
import com.wonderrobot.ankenmatchingu.entity.P003.P003PEOPLE_DETAILEntity;
import com.wonderrobot.ankenmatchingu.entity.S001.S001sms6grd1SmartSearchEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * テーブル用
 * PEOPLE_DETAIL Mapper
 */
public interface P003PEOPLE_DETAILMapper {

    public List<P003PEOPLE_DETAILEntity> smartSearch(@Param("interviewTime_start")String interviewTime_start,
                                                     @Param("interviewTime_end")String interviewTime_end,
                                                     @Param("entryTime_start")String entryTime_start,
                                                     @Param("entryTime_end")String entryTime_end,
                                                     @Param("emailSendTime_start")String emailSendTime_start,
                                                     @Param("emailSendTime_end")String emailSendTime_end,
                                                     @Param("email_content")String email_content
                                        );
}