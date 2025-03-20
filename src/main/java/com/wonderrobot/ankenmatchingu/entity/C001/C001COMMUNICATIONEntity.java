package com.wonderrobot.ankenmatchingu.entity.C001;
// SpringEntityCodeCreator.java



/**
 * テーブル用
 * COMMUNICATION Entity
 */
public class C001COMMUNICATIONEntity {
   /**
	* id id
	*/
	private String id;
   /**
	* job_id 案件ID
	*/
	private String job_id;
   /**
	* people_id 技術者ID
	*/
	private String people_id;
   /**
	* remark コメント
	*/
	private String remark;
   /**
	* status ステータス
	*/
	private String status;
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
	* remark コメントを設定
	*
	* @param remark コメント
	*/
	public void setRemark(String remark) {
		this.remark = remark;
	}

   /**
	* remark コメントを取得
	*
	* @return remark コメント
	*/
	public String getRemark() {
		return this.remark;
	}

   /**
	* status ステータスを設定
	*
	* @param status ステータス
	*/
	public void setStatus(String status) {
		this.status = status;
	}

   /**
	* status ステータスを取得
	*
	* @return status ステータス
	*/
	public String getStatus() {
		return this.status;
	}


}