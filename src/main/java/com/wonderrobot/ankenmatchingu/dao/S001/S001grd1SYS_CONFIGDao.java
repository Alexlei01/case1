package com.wonderrobot.ankenmatchingu.dao.S001;
// ControllerFormat.java
import org.springframework.stereotype.Repository;
import com.wonderrobot.ankenmatchingu.entity.S001.S001grd1SYS_CONFIGEntity;
import java.util.List;
import com.wonderrobot.ankenmatchingu.mapper.S001.S001grd1SYS_CONFIGMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 案件マッチング
 */
@Repository
public class S001grd1SYS_CONFIGDao {
	@Autowired
	private S001grd1SYS_CONFIGMapper S001grd1SYS_CONFIGMapper;

   
	/**
	 * グリッドの初期化
	 * @throws Exception
	 */
	public List<S001grd1SYS_CONFIGEntity> s001InitGrid () throws Exception {

		List<S001grd1SYS_CONFIGEntity> returnVal = S001grd1SYS_CONFIGMapper.s001InitGrid();
		return returnVal;
	}
}