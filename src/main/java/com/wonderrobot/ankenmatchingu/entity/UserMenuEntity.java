package com.wonderrobot.ankenmatchingu.entity;

/**
 * UserMenuEntity
 * 
 * @author wonderfulfly
 *
 */
public class UserMenuEntity {

	/**
	 * Current node
	 */
	private String PROFILE_ID;

	/**
	 * Trans flg
	 */
	private String TRANSFLG;
	
	/**
	 * Parent node
	 */
	private String FATHER_ID;
	
	/**
	 * Node name
	 */
	private String PFOFILE_NM;
	
	/**
	 * page id
	 */
	private String PAGE_MNG_ID;
	/**
	 * displayflg
	 */
	private String DISPLAYFLG;

	public String getPROFILE_ID() {
		return PROFILE_ID;
	}

	public void setPROFILE_ID(String PROFILE_ID) {
		this.PROFILE_ID = PROFILE_ID;
	}

	public String getFATHER_ID() {
		return FATHER_ID;
	}

	public String getTRANSFLG() {
		return TRANSFLG;
	}

	public void setFATHER_ID(String FATHER_ID) {
		this.FATHER_ID = FATHER_ID;
	}

	public void setTRANSFLG(String TRANSFLG) {
		this.TRANSFLG = TRANSFLG;
	}

	public String getPFOFILE_NM() {
		return PFOFILE_NM;
	}

	public void setPFOFILE_NM(String PFOFILE_NM) {
		this.PFOFILE_NM = PFOFILE_NM;
	}

	public String getPAGE_MNG_ID() {
		return PAGE_MNG_ID;
	}

	public void setPAGE_MNG_ID(String PAGE_MNG_ID) {
		this.PAGE_MNG_ID = PAGE_MNG_ID;
	}

	public String getDISPLAYFLG() {
		return DISPLAYFLG;
	}

	public void setDISPLAYFLG(String DISPLAYFLG) {
		this.DISPLAYFLG = DISPLAYFLG;
	}
}

