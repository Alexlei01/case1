package com.wonderrobot.ankenmatchingu.mapper.C001;
// SpringMapperClassCodeCreator.java


import com.wonderrobot.ankenmatchingu.entity.C001.C001COMMUNICATIONEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * テーブル用
 * COMMUNICATION Mapper
 */
public interface C001COMMUNICATIONMapper {
	public List<C001COMMUNICATIONEntity> c001InitDepthZero(@Param("txt2")String txt2);
	public List<C001COMMUNICATIONEntity> c001SearchInitDepthZero(@Param("txt2")String txt2);
}