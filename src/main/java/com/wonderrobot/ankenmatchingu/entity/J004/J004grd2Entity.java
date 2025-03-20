package com.wonderrobot.ankenmatchingu.entity.J004;
// SpringEntityCodeCreator.java


import org.hibernate.validator.constraints.NotBlank;

/**
 * フォーム用
 *  grd2 Entity
 */
public class J004grd2Entity {
   /**
	* emailsender 送信者
	*/
	private String emailsender;
   /**
	* emailsendtime メール送信時刻
	*/
	private String emailsendtime;
   /**
	* emailtitle メールタイトル
	*/
	private String emailtitle;
   /**
	* id id
	*/

	@NotBlank(message = "validate.msg_J004id")
	private String id;
   /**
	* recruitment 募集要員
	*/
	private String recruitment;

	// gridFlag
	private String gridOpFlag;
	// rowindex

	private String rowindex;
   /**
	* emailsender 送信者を設定
	*
	* @param emailsender 送信者
	*/
	public void setEmailsender(String emailsender) {
		this.emailsender = emailsender;
	}

   /**
	* emailsender 送信者を取得
	*
	* @return emailsender 送信者
	*/
	public String getEmailsender() {
		return this.emailsender;
	}

   /**
	* emailsendtime メール送信時刻を設定
	*
	* @param emailsendtime メール送信時刻
	*/
	public void setEmailsendtime(String emailsendtime) {
		this.emailsendtime = emailsendtime;
	}

   /**
	* emailsendtime メール送信時刻を取得
	*
	* @return emailsendtime メール送信時刻
	*/
	public String getEmailsendtime() {
		return this.emailsendtime;
	}

   /**
	* emailtitle メールタイトルを設定
	*
	* @param emailtitle メールタイトル
	*/
	public void setEmailtitle(String emailtitle) {
		this.emailtitle = emailtitle;
	}

   /**
	* emailtitle メールタイトルを取得
	*
	* @return emailtitle メールタイトル
	*/
	public String getEmailtitle() {
		return this.emailtitle;
	}

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
	* recruitment 募集要員を設定
	*
	* @param recruitment 募集要員
	*/
	public void setRecruitment(String recruitment) {
		this.recruitment = recruitment;
	}

   /**
	* recruitment 募集要員を取得
	*
	* @return recruitment 募集要員
	*/
	public String getRecruitment() {
		return this.recruitment;
	}

	//Grid OpFlg SET
	public void setGridOpFlag(String gridOpFlag) {
		this.gridOpFlag = gridOpFlag;
	}

	//Grid OpFlg GET
	public String getGridOpFlag() {
		return this.gridOpFlag;
	}

	//Grid rowindex SET
	public void setRowindex(String rowindex) {
		this.rowindex = rowindex;
	}

	//Grid rowindex GET
	public String getRowindex() {
		return this.rowindex;
	}


}