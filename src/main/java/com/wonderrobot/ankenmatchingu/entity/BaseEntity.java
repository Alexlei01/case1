package com.wonderrobot.ankenmatchingu.entity;
// BaseEntity.vm
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Controller Entity base class, Session Basic Information
 */
public class BaseEntity {

	private HttpServletRequest request;
	private HttpSession session;

	/**
	 *		mode
	 */
	 private String mode;

	/**
	 *		actFlg
	 */
	 private String actflg;

	/**
	 *		trigger
	 */
	 private String trigger;

	/**
	 *		row
	 */
	 private String row;

	/**
	 *		f
	 */
	 private String f;

	/**
	*		e
	*/
	private String e;

    /**
	*		d
	*/
	private String d;

	 /**
	 *		subID
	 */
	 private String subID;
	 /**
	 *		pagingNum
	 */
	 private String pagingNum;
	 /**
	 *		recordNum
	 */
	 private String recordNum;
	 /**
	 *		dir
	 */
	 private String dir;
	 /**
	 *		sort
	 */
	 private String sort;
	/**
	 *		pagename
	 */
	 private String pagename;

	/**
	 * SYSTEM_NAME
	 * @return
	 */
	public String getSystemName() {
		return (String) _getSession().getAttribute("SYSTEM_NAME");
	}

	/**
	 * USER_ID
	 * @return
	 */
	public String getUserId() {
		return (String) _getSession().getAttribute("USER_ID");
	}

	/**
	 * DEFAULT_PAGE_ID
	 * @return
	 */
	public String getDefaultPageId() {
		return (String) _getSession().getAttribute("DEFAULT_PAGE_ID");
	}

	/**
	 * LOGOUT_PAGE
	 * @return
	 */
	public String getLogoutPage() {
		return (String) _getSession().getAttribute("LOGOUT_PAGE");
	}

	/**
	 * USER_NAME1
	 * @return
	 */
	public String getUserName1() {
		return (String) _getSession().getAttribute("USER_NAME1");
	}

	/**
	 * USER_NAME2
	 * @return
	 */
	public String getUserName2() {
		return (String) _getSession().getAttribute("USER_NAME2");
	}

	/**
	 * USER_NAME
	 * @return
	 */
	public String getUserName() {
		return (String) _getSession().getAttribute("USER_NAME1") + ((String) _getSession().getAttribute("USER_NAME2") == null ? "" : (String) _getSession().getAttribute("USER_NAME2"));
	}

	/**
	 * LANGUAGE_ID
	 * @return
	 */
	public String getLanguageId() {
		return (String) _getSession().getAttribute("LANGUAGE_ID");
	}

	/**
	 * HEAD_DISPLAY
	 * @return
	 */
	public String getHeadDisplay() {
		return (String) _getSession().getAttribute("HEAD_DISPLAY");
	}

	/**
	 * APP_USER_ID
	 * @return
	 */
	public String getAppUserId() {
		return (String) _getSession().getAttribute("APP_USER_ID");
	}

	/**
	 * Id
	 * @return
	 */
	public String getId() {
		return (String) _getSession().getId();
	}

	/**
	 * ORGID
	 * @return
	 */
	public String getOrgID() {
		return (String) _getSession().getAttribute("ORGID");
	}

	public HttpSession _getSession() {
		if (session == null) {
			session = _getRequest().getSession();
		}
		return session;
	}

	private HttpServletRequest _getRequest() {
		if (request == null) {
			request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		}
		return request;
	}

	/**
	 * read HttpServletRequest Parameter
	 *
	 * @param name parameter name
	 * @return
	 */
	public String getRequestParameter(String name) {
		return _getRequest().getParameter(name);
	}

	/**
	 * read HttpSession Attribute
	 *
	 * @param name attribute name
	 * @return
	 */
	public Object getSessionAttribute(String name) {
		return _getSession().getAttribute(name);
	}

	/**
     * mode set
     *
     * @param mode
    */
	public void setMode(String mode){
		this.mode = mode;
	}

	/**
     * mode get
     *
     * @return mode
    */
	public String getMode(){
		return this.mode;
	}

	/**
     * actFlg set
     *
     * @param actFlg
    */
	public void setActflg(String actflg){
		this.actflg = actflg;
	}

	/**
     * actFlg get
     *
     * @return actFlg
    */
	public String getActflg(){
		return this.actflg;
	}


	/**
     * trigger　set
     *
     * @param trigger
    */
	public void setTrigger(String trigger){
		this.trigger = trigger;
	}

	/**
     * trigger get
     *
     * @return trigger
    */
	public String getTrigger(){
		return this.trigger;
	}

	/**
     * row　set
     *
     * @param row
    */
	public void setRow(String row){
		this.row = row;
	}

	/**
     * row get
     *
     * @return row
    */
	public String getRow(){
		return this.row;
	}

	/**
     * f　set
     *
     * @param f
    */
	public void setF(String f){
		this.f = f;
	}

	/**
     * f get
     *
     * @return f
    */
	public String getF(){
		return this.f;
	}

	//******************
	/**
     * subID　set
     *
     * @param subID
    */
	public void setSubID(String subID){
		this.subID = subID;
	}

	/**
     * subID get
     *
     * @return subID
    */
	public String getSubID(){
		return this.subID;
	}
	/**
     * pagingNum　set
     *
     * @param pagingNum
    */
	public void setPagingNum(String pagingNum){
		this.pagingNum = pagingNum;
	}

	/**
     * pagingNum get
     *
     * @return pagingNum
    */
	public String getPagingNum(){
		return this.pagingNum;
	}
	/**
     * recordNum　set
     *
     * @param recordNum
    */
	public void setRecordNum(String recordNum){
		this.recordNum = recordNum;
	}

	/**
     * recordNum get
     *
     * @return recordNum
    */
	public String getRecordNum(){
		return this.recordNum;
	}
	/**
     * dir　set
     *
     * @param dir
    */
	public void setDir(String dir){
		this.dir = dir;
	}

	/**
     * dir get
     *
     * @return dir
    */
	public String getDir(){
		return this.dir;
	}
	/**
     * sort　set
     *
     * @param sort
    */
	public void setSort(String sort){
		this.sort = sort;
	}

	/**
     * sort get
     *
     * @return sort
    */
	public String getSort(){
		return this.sort;
	}

	public String getE() {
		return e;
	}

	public void setE(String e) {
		this.e = e;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getPagename() {
		return pagename;
	}

	public void setPagename(String pagename) {
		this.pagename = pagename;
	}
}
