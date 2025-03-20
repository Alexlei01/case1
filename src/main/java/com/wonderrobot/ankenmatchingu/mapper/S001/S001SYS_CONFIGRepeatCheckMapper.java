package com.wonderrobot.ankenmatchingu.mapper.S001;
// SpringMapperClassCodeCreator.java


import com.wonderrobot.ankenmatchingu.entity.S001.S001SYS_CONFIGRepeatCheckEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 共通設定管理 SYS_CONFIG キー重複チェック Mapper
 */
public interface S001SYS_CONFIGRepeatCheckMapper {
	public List<S001SYS_CONFIGRepeatCheckEntity> s001SYS_CONFIGRepeatCheckselectSYS_CONFIG(@Param("id")String id);
}