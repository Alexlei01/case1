package com.wonderrobot.ankenmatchingu.mapper.C002;
// SpringMapperClassCodeCreator.java


import com.wonderrobot.ankenmatchingu.entity.C002.C002COMMUNICATION_RECORDRepeatCheckEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * コミュニケーション記録 COMMUNICATION_RECORD キー重複チェック Mapper
 */
public interface C002COMMUNICATION_RECORDRepeatCheckMapper {
	public List<C002COMMUNICATION_RECORDRepeatCheckEntity> c002COMMUNICATION_RECORDRepeatCheckselectCOMMUNICATION_RECORD(@Param("txt2")String txt2);
}