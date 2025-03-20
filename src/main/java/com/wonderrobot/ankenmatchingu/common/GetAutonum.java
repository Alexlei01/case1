package com.wonderrobot.ankenmatchingu.common;
import com.wonderfulfly.core.constant.DBConstant;
import com.wonderfulfly.core.constant.StringConst;
import com.wonderfulfly.core.util.DateUtil;
import com.wonderfulfly.core.util.StringUtil;
import com.wonderfulfly.core.util.log.LoggerUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import com.wonderrobot.ankenmatchingu.dao.GetMaxNumValueDao;
import com.wonderrobot.ankenmatchingu.entity.GetMaxNumValueEntity;
@Component
public class GetAutonum {
	@Autowired
	private GetMaxNumValueDao GetMaxNumValueDao;
	private static GetAutonum InitStaticConstant;

	@PostConstruct
	private void init() {
		InitStaticConstant = this;
	}
	public String getMaxNumValue(String RecordID,String FieldID) throws Exception {                                                                                         
		LoggerUtil.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+ ": start");
		String returnVal = null;                                                                                                                    
		ArrayList<ArrayList<String>> alData = null, numVarData = null;                                                                              
		ArrayList<String> alRowData = null;                                                                                                         
		StringBuffer sb = new StringBuffer();                                                                                                       
		String headChar = "";                                                                                                                       
		int maxNumVar = 1;                                                                                                                          
		String curNum = "";                                                                                                                         
		String dataType = "";                                                                                                                       
		String dataLen = "";                                                                                                                        
		String userValue = "";                                                                                                                      
		String tmpValue = "";                                                                                                                       
		String dateFormatPattern = "";                                                                                                              
		String dateString = "";                                                                                                                     
		HashMap<String, ArrayList<ArrayList<String>>> alDataMap = null;
		ArrayList<String> alField = null;
		ArrayList<ArrayList<String>> alFields = null;
		try {                                                                                                                                       
			alDataMap = new HashMap<String, ArrayList<ArrayList<String>>>();
			alFields = new ArrayList<ArrayList<String>>();
			alField = new ArrayList<String>();
			alField.add("0");
			alField.add("");
			alField.add("9");
			alField.add("2");
			alField.add("10");
			alField.add("");
			alField.add("1");
			alFields.add(alField);
			alDataMap.put("SYS_CONFIGid", alFields);
			alData = alDataMap.get(RecordID+FieldID);                                                                                                  
			int iNumLen = 0;                                                                                                                   
			if (alData != null  && alData.size()>0) {                                                                                          
				alRowData = alData.get(0);                                                                                                 
		                                                                                                                              
				numVarData = getSysRecfldAutoRecordFieldAuto(RecordID, FieldID);                                                                            
				if (numVarData != null && numVarData.size() > 0) {                                                                         
					curNum = StringUtil.changeNullToBlank(numVarData.get(0).get(0));                                                   
				} else {                                                                                                                   
					insertRecordFieldAutoIntoSysRecfldAuto(RecordID, FieldID);                                                                          
					curNum = "0";                                                                                                      
				}                                                                                                                          
		                                                                                                                              
				//データ長さ                                                                                                               
				dataLen = StringUtil.changeNullToBlank( alRowData.get(4));                                                                 
				//頭文字                                                                                                                   
				headChar = StringUtil.changeNullToBlank( alRowData.get(0));                                                                
		                                                                                                                              
				if (StringUtil.ChangeIntToString(StringUtil.parseInt(curNum) + 1).length() > StringUtil.changeStringToInt(dataLen)) {      
					curNum = "0";                                                                                                      
				}                                                                                                                          
				//最大番号                                                                                                                 
				//番号の長さ                                                                                                               
				if (StringUtil.isNullOrBlank(alRowData.get(2))) {                                                                          
					iNumLen = StringUtil.parseInt(dataLen);                                                                            
				} else {                                                                                                                   
					iNumLen = StringUtil.parseInt(StringUtil.changeNullToBlank(alRowData.get(2)));                                     
				}                                                                                                                          
				//データタイプ                                                                                                             
				dataType = StringUtil.changeNullToBlank( alRowData.get(3));                                                                
                                                                                                                                            
				//ユーザーテーブル自動採番値を取得                                                                                         
				userValue = StringUtil.changeNullToBlank(getLastNumFronUserTableContent(headChar, FieldID, RecordID));                                        
		                                                                                                                              
				if (dataType.equals(DBConstant.MYSQL_DATA_TYPE_INT)                                                                        
						|| dataType.equals(DBConstant.MYSQL_DATA_TYPE_UNDEFINED)                                                   
						|| dataType.equals(DBConstant.MYSQL_DATA_TYPE_DOUBLE)                                                      
						|| dataType.equals(DBConstant.MYSQL_DATA_TYPE_DATE)                                                        
						|| dataType.equals(DBConstant.MYSQL_DATA_TYPE_DATETIME)                                                    
						|| dataType.equals(DBConstant.MYSQL_DATA_TYPE_TIME)                                                        
						|| dataType.equals(DBConstant.MYSQL_DATA_TYPE_BOOLEAN)) {                                                  
					throw new Exception("定義より、フィールドが採番できません。");                                                   
				}                                                                                                                          
		                                                                                                                              
				//特殊採番ルール対応                                                                                                       
				tmpValue = headChar;                                                                                                       
				int start = 0;                                                                                                             
				int end = 0;                                                                                                               
				while (((start = tmpValue.indexOf("[")) > -1) && ((end = tmpValue.indexOf("]")) > -1)) {                                   
					if (start > -1 && end > -1 && start < end) {                                                                       
						dateFormatPattern = tmpValue.substring(start + 1, end);                                                    
						dateString = DateUtil.getPatternDate(dateFormatPattern);                                                   
						tmpValue = tmpValue.substring(0, start) + dateString + tmpValue.substring(end + 1);                        
					}                                                                                                                  
				}                                                                                                                          
				headChar = tmpValue;                                                                                                       
		                                                                                                                              
				if (StringUtil.parseInt(dataLen) < (headChar.trim().length() + iNumLen)) {                                                 
					throw new Exception("採番に関する定義が間違いました。");                                                         
				}                                                                                                                          
		                                                                                                                              
				//フィールド定義の最大値                                                                                                   
				if(!StringUtil.isNullOrBlank(curNum)){                                                                                     
					maxNumVar = StringUtil.parseInt(curNum) + 1;                                                                       
				}                                                                                                                          
                                                                                                                                            
				//ユーザー値の頭文字を削除                                                                                                 
				userValue = userValue.replaceAll(headChar, StringConst.STRING_OF_BLANK);                                                   
		                                                                                                                              
				//比較し、最大値を利用                                                                                                     
				if ( StringUtil.changeStringToInt(userValue)+1 > maxNumVar) {                                                              
					maxNumVar =  StringUtil.parseInt(userValue) + 1;                                                                   
				}                                                                                                                          
		                                                                                                                              
				sb.append(headChar);                                                                                                       
		                                                                                                                              
				int iZeroCnt = iNumLen - StringUtil.ChangeIntToString(maxNumVar).length();                                                 
				for (int i = 0; i < iZeroCnt; i++) {                                                                                       
					sb.append("0");                                                                                                    
				}                                                                                                                          
				sb.append(StringUtil.ChangeIntToString(maxNumVar));                                                                        
			} else {                                                                                                                           
				throw new Exception("採番フィールドを定義していません。");                                                               
			}                                                                                                                                  
			returnVal = sb.toString();                                                                                                         
			uptRecordFieldAutoToSysRecfldAuto(RecordID, FieldID, StringUtil.ChangeIntToString(maxNumVar));                                                      
		} catch (Exception e) {                                                                                                                   
			LoggerUtil.error("SQL文を取得時にエラー：", e);                                                                                    
			throw e;                                                                                                                      
		} finally {                                                                                                                                 
			LoggerUtil.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + ": end");
			alData = null;                                                                                                                     
			alRowData = null;                                                                                                                  
			sb = null;                                                                                                                         
			headChar = null;                                                                                                                   
			curNum = null;                                                                                                                     
			dataType = null;                                                                                                                   
	                                                                                                                                      
			tmpValue = null;                                                                                                                   
			dateFormatPattern = null;                                                                                                          
			dateString = null;                                                                                                                 
		}                                                                                                                                           
	                                                                                                                                      
		return returnVal;                                                                                                                           
	}                                                                                                                                           
	public ArrayList<ArrayList<String>> getSysRecfldAutoRecordFieldAuto(String RecordID,String FieldID) throws Exception {                          
		LoggerUtil.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+ ": start");
		ArrayList<ArrayList<String>> returnVal = null;                                                              
		ArrayList<String> returnValStr = null;                                                              
		List<GetMaxNumValueEntity> maxNum = null;
		try {                                                                                                       
		    maxNum = new ArrayList<GetMaxNumValueEntity>();
			maxNum = InitStaticConstant.GetMaxNumValueDao.getSysRecfldAutoRecordFieldAuto(RecordID, FieldID);                     
		    if (maxNum != null) {
		       returnVal = new ArrayList<ArrayList<String>>();
		       for (int i = 0; i < maxNum.size(); i++) {
		          returnValStr = new ArrayList<String>();
		          returnValStr.add(maxNum.get(i).getNUM_VAR());
		          returnVal.add(returnValStr);
		       }
		    }
		} catch (Exception e) {                                                                                   
			LoggerUtil.error("ﾚｺｰﾄﾞ定義(管理用)取得時にエラー：", e);                                           
			throw e;                                                                                            
		} finally {                                                                                            
			LoggerUtil.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + ": end");
			returnValStr = null;
			maxNum = null;
		}
			return returnVal;                                                                                           
	}                                                                                                                   
  public void insertRecordFieldAutoIntoSysRecfldAuto(String RecordID,String FieldID) throws Exception {                                                                                                                        
		LoggerUtil.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+ ": start");
		try {                                                                                                                                                                                
         InitStaticConstant.GetMaxNumValueDao.insertRecordFieldAutoIntoSysRecfldAuto("AI000000105", RecordID, FieldID, DateUtil.getPatternDateForDb(), "", DateUtil.getPatternDateForDb(), "");
		} catch (Exception e) {                                                                                                                                                            
			LoggerUtil.error("ﾚｺｰﾄﾞ定義(管理用)追加時にエラー：", e);                                                                                                                    
			throw e;                                                                                                                                                                     
		} finally {                                                                                                                                                                          
			LoggerUtil.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + ": end");                                                                                            
		}                                                                                                                                                                                    
	}																																											 
                                                                                                                                                                                 
	public void uptRecordFieldAutoToSysRecfldAuto(String RecordID,String FieldID, String NUM_VAR) throws Exception {                                           
		LoggerUtil.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+ ": start");
	                                                                                         
		// ﾒｯｾｰｼﾞ一覧の取得                                                                      
		try {                                                                                    
			InitStaticConstant.GetMaxNumValueDao.uptRecordFieldAutoToSysRecfldAuto(NUM_VAR, DateUtil.getPatternDateForDb(), "", RecordID, FieldID);
		} catch (Exception e) {                                                                
			LoggerUtil.error("レコードのフィールド情報を更新時にエラー：", e);               
			throw e;                                                                         
		}  finally {                                                                             
			LoggerUtil.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + ": end");
		}                                                                                        
}                                                                                              
  private String getLastNumFronUserTableContent(String headStr, String FieldID, String RECORD_ID) throws Exception {                                                                                                               
		LoggerUtil.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+ ": start");
		ArrayList<ArrayList<String>> alData = null;                                                                                                                                          
		// ﾒｯｾｰｼﾞ一覧の取得                                                                                                                                                                  
		ArrayList<String> returnValStr = null;                                                              
		List<String> maxNum = null;
		String fieldID = "";                                                                                                                                                                 
		                                                                                                                                                                                     
		try {                                                                                                                                                                                
			                                                                                                                                                                             
			if (FieldID.indexOf(",") != -1) {                                                                                                                                            
				fieldID = FieldID.substring(0,FieldID.indexOf(","));                                                                                                                 
			} else {                                                                                                                                                                     
				fieldID = FieldID;                                                                                                                                                   
			}                                                                                                                                                                            
			                                                                                                                                                                             
		    maxNum = new ArrayList<String>();
			maxNum = InitStaticConstant.GetMaxNumValueDao.getLastNumFronUserTableContent(fieldID, RECORD_ID, fieldID, headStr);                     
		    if (maxNum != null && maxNum.size() > 0) {
		       alData = new ArrayList<ArrayList<String>>();
		       for (int i = 0; i < maxNum.size(); i++) {
		          returnValStr = new ArrayList<String>();
		          returnValStr.add(maxNum.get(i));
		          alData.add(returnValStr);
		       }
		    }
			                                                                                                                                                                             
			if (alData != null && alData.size() >0) {                                                                                                                                    
				return alData.get(0).get(0);                                                                                                                                         
			} else {                                                                                                                                                                     
				return StringConst.STRING_OF_BLANK;                                                                                                                                  
			}                                                                                                                                                                            
		} catch (Exception e) {                                                                                                                                                            
			LoggerUtil.error("レコードのフィールド情報を更新時にエラー：", e);                                                                                                           
			throw e;                                                                                                                                                                     
		}  finally {                                                                                                                                                                         
			LoggerUtil.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + ": end");
		}                                                                                                                                                                            
	}                                                                                                                                                                                    
}                                                                                                                                                                                            

