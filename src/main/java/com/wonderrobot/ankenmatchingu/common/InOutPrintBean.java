package com.wonderrobot.ankenmatchingu.common;
// InOutPrintBean.vm
import java.util.ArrayList;

/**
 * InOutPrintBean
 */
public class InOutPrintBean {

	private String template_id;
	private String sheet_name;
	private String cell_num;
	private String recordid;
	private String fieldid;
	private String seqnum;
	private String fromflg;
	private String list_name;
	private String print_file_sheet_name;
	private String data_type;

	private ArrayList<String> label_id;

	private String handleMethod;

	private String list_extend_method;
	private String list_data_per_page;

	/**
	 * @return the list_extend_method
	 */
	public String getList_extend_method() {
		return list_extend_method;
	}

	/**
	 * @param list_extend_method the list_extend_method to set
	 */
	public void setList_extend_method(String list_extend_method) {
		this.list_extend_method = list_extend_method;
	}

	/**
	 * @return the list_data_per_page
	 */
	public String getList_data_per_page() {
		return list_data_per_page;
	}

	/**
	 * @param list_data_per_page the list_data_per_page to set
	 */
	public void setList_data_per_page(String list_data_per_page) {
		this.list_data_per_page = list_data_per_page;
	}

	/**
	 * @return the handleMethod
	 */
	public String getHandleMethod() {
		return handleMethod;
	}

	/**
	 * @param handleMethod the handleMethod to set
	 */
	public void setHandleMethod(String handleMethod) {
		this.handleMethod = handleMethod;
	}

	/**
	 * @return the label_id
	 */
	public ArrayList<String> getLabel_id() {
		return label_id;
	}

	/**
	 * @param label_id the label_id to set
	 */
	public void setLabel_id(ArrayList<String> label_id) {
		this.label_id = label_id;
	}

	/**
	 * @return the template_id
	 */
	public String getTemplate_id() {
		return template_id;
	}

	/**
	 * @param template_id the template_id to set
	 */
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	/**
	 * @return the sheet_name
	 */
	public String getSheet_name() {
		return sheet_name;
	}

	/**
	 * @param sheet_name the sheet_name to set
	 */
	public void setSheet_name(String sheet_name) {
		this.sheet_name = sheet_name;
	}

	/**
	 * @return the cell_num
	 */
	public String getCell_num() {
		return cell_num;
	}

	/**
	 * @param cell_num the cell_num to set
	 */
	public void setCell_num(String cell_num) {
		this.cell_num = cell_num;
	}

	/**
	 * @return the recordid
	 */
	public String getRecordid() {
		return recordid;
	}

	/**
	 * @param recordid the recordid to set
	 */
	public void setRecordid(String recordid) {
		this.recordid = recordid;
	}

	/**
	 * @return the fieldid
	 */
	public String getFieldid() {
		return fieldid;
	}

	/**
	 * @param fieldid the fieldid to set
	 */
	public void setFieldid(String fieldid) {
		this.fieldid = fieldid;
	}

	/**
	 * @return the seqnum
	 */
	public String getSeqnum() {
		return seqnum;
	}

	/**
	 * @param seqnum the seqnum to set
	 */
	public void setSeqnum(String seqnum) {
		this.seqnum = seqnum;
	}

	/**
	 * @return the fromflg
	 */
	public String getFromflg() {
		return fromflg;
	}

	/**
	 * @param fromflg the fromflg to set
	 */
	public void setFromflg(String fromflg) {
		this.fromflg = fromflg;
	}

	/**
	 * @return the list_name
	 */
	public String getList_name() {
		return list_name;
	}

	/**
	 * @param list_name the list_name to set
	 */
	public void setList_name(String list_name) {
		this.list_name = list_name;
	}

	/**
	 * @return the print_file_sheet_name
	 */
	public String getPrint_file_sheet_name() {
		return print_file_sheet_name;
	}

	/**
	 * @param print_file_sheet_name the print_file_sheet_name to set
	 */
	public void setPrint_file_sheet_name(String print_file_sheet_name) {
		this.print_file_sheet_name = print_file_sheet_name;
	}

	/**
	 * @return the data_type
	 */
	public String getData_type() {
		return data_type;
	}

	/**
	 * @param data_type the data_type to set
	 */
	public void setData_type(String data_type) {
		this.data_type = data_type;
	}

}
