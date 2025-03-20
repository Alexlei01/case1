package com.wonderrobot.ankenmatchingu.mapper.C001;
// SpringMapperClassCodeCreator.java


import com.wonderrobot.ankenmatchingu.entity.C001.C001COMMUNICATIONRepeatCheckEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * コミュニケーション COMMUNICATION キー重複チェック Mapper
 */
public interface C001COMMUNICATIONRepeatCheckMapper {
	public List<C001COMMUNICATIONRepeatCheckEntity> c001COMMUNICATIONRepeatCheckselectCOMMUNICATION(@Param("txt2")String txt2);
}