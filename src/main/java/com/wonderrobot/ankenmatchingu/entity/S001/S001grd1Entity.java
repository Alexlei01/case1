package com.wonderrobot.ankenmatchingu.entity.S001;
// SpringEntityCodeCreator.java


import org.hibernate.validator.constraints.NotBlank;

/**
 * フォーム用
 *  grd1 Entity
 */
public class S001grd1Entity {
   /**
	* configcode コード
	*/

	@NotBlank(message = "validate.msg_S001configCode")
	private String configcode;
   /**
	* description 説明
	*/
	private String description;
   /**
	* id id
	*/

	@NotBlank(message = "validate.msg_S001id")
	private String id;
   /**
	* value 値
	*/
	private String value;

	// gridFlag
	private String gridOpFlag;
	// rowindex

	private String rowindex;
   /**
	* configcode コードを設定
	*
	* @param configcode コード
	*/
	public void setConfigcode(String configcode) {
		this.configcode = configcode;
	}

   /**
	* configcode コードを取得
	*
	* @return configcode コード
	*/
	public String getConfigcode() {
		return this.configcode;
	}

   /**
	* description 説明を設定
	*
	* @param description 説明
	*/
	public void setDescription(String description) {
		this.description = description;
	}

   /**
	* description 説明を取得
	*
	* @return description 説明
	*/
	public String getDescription() {
		return this.description;
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
	* value 値を設定
	*
	* @param value 値
	*/
	public void setValue(String value) {
		this.value = value;
	}

   /**
	* value 値を取得
	*
	* @return value 値
	*/
	public String getValue() {
		return this.value;
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