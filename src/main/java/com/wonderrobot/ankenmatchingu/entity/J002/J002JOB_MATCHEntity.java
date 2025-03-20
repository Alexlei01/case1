package com.wonderrobot.ankenmatchingu.entity.J002;
// SpringEntityCodeCreator.java



/**
 * テーブル用
 * JOB_MATCH Entity
 */
public class J002JOB_MATCHEntity {
   /**
	* id id
	*/
	private String id;
   /**
	* job_id 案件ID
	*/
	private String job_id;
   /**
	* job_name 案件名
	*/
	private String job_name;
   /**
	* match_code マッチングコード
	*/
	private String match_code;
   /**
	* match_percent マッチング率
	*/
	private String match_percent;
   /**
	* people_id 技術者ID
	*/
	private String people_id;
   /**
	* people_name 技術者名
	*/
	private String people_name;
   /**
	* id idを設定
	*
	* @param id id
	*/
	public void setId(String id) {
		this.id = id;
	}

   /**
	* id idを取得
	*
	* @return id id
	*/
	public String getId() {
		return this.id;
	}

   /**
	* job_id 案件IDを設定
	*
	* @param job_id 案件ID
	*/
	public void setJobid(String job_id) {
		this.job_id = job_id;
	}

   /**
	* job_id 案件IDを取得
	*
	* @return job_id 案件ID
	*/
	public String getJobid() {
		return this.job_id;
	}

   /**
	* job_name 案件名を設定
	*
	* @param job_name 案件名
	*/
	public void setJobname(String job_name) {
		this.job_name = job_name;
	}

   /**
	* job_name 案件名を取得
	*
	* @return job_name 案件名
	*/
	public String getJobname() {
		return this.job_name;
	}

   /**
	* match_code マッチングコードを設定
	*
	* @param match_code マッチングコード
	*/
	public void setMatchcode(String match_code) {
		this.match_code = match_code;
	}

   /**
	* match_code マッチングコードを取得
	*
	* @return match_code マッチングコード
	*/
	public String getMatchcode() {
		return this.match_code;
	}

   /**
	* match_percent マッチング率を設定
	*
	* @param match_percent マッチング率
	*/
	public void setMatchpercent(String match_percent) {
		this.match_percent = match_percent;
	}

   /**
	* match_percent マッチング率を取得
	*
	* @return match_percent マッチング率
	*/
	public String getMatchpercent() {
		return this.match_percent;
	}

   /**
	* people_id 技術者IDを設定
	*
	* @param people_id 技術者ID
	*/
	public void setPeopleid(String people_id) {
		this.people_id = people_id;
	}

   /**
	* people_id 技術者IDを取得
	*
	* @return people_id 技術者ID
	*/
	public String getPeopleid() {
		return this.people_id;
	}

   /**
	* people_name 技術者名を設定
	*
	* @param people_name 技術者名
	*/
	public void setPeoplename(String people_name) {
		this.people_name = people_name;
	}

   /**
	* people_name 技術者名を取得
	*
	* @return people_name 技術者名
	*/
	public String getPeoplename() {
		return this.people_name;
	}


}