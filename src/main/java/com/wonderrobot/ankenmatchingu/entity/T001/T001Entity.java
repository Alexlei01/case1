package com.wonderrobot.ankenmatchingu.entity.T001;
// Entity.vm
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.Length;
import com.wonderrobot.ankenmatchingu.entity.BaseEntity;
import com.wonderrobot.ankenmatchingu.validation.DateTimeStr;
import com.wonderrobot.ankenmatchingu.validation.DateBeforeStr;
import com.wonderrobot.ankenmatchingu.validation.DateAfterStr;
import io.swagger.annotations.ApiModelProperty;

/**
 * ページ用
 * タグ管理 Entity
 */
public class T001Entity extends BaseEntity{

    /**
     * btn0 保存
     */
    @ApiModelProperty(value = "保存")
    private String btn0;
    /**
     * btn1 キャンセル
     */
    @ApiModelProperty(value = "キャンセル")
    private String btn1;
    /**
     * remark 備考
     */
@Length(max=1000,message="validate.msg_T001remark")
    @ApiModelProperty(value = "備考")
    private String remark;
    /**
     * tagCode タグコード
     */
@Length(max=25,message="validate.msg_T001tagCode")
    @ApiModelProperty(value = "タグコード")
    private String tagcode;
    /**
     * tagName タグ名
     */
    @ApiModelProperty(value = "タグ名")
    private String tagname;
    /**
     * tagType タグタイプ
     */
    @ApiModelProperty(value = "タグタイプ")
    private String tagtype;
    /**
     * txt2 id
     */
@NotBlank(message = "validate.msg_T001txt2")
@Pattern(regexp = "(^(0|\\+?[1-9][0-9]*){0,}$)?",message = "validate.msg_T001txt21")
    @ApiModelProperty(value = "id")
    private String txt2;

    /**
     * btn0 保存 Set
     *
     * @param btn0 保存
     */
    public void setBtn0(String btn0) {
        this.btn0 = btn0;
    }

    /**
     * btn0 保存 Get
     *
     * @return btn0 保存
     */
    public String getBtn0() {
        return this.btn0;
    }
    /**
     * btn1 キャンセル Set
     *
     * @param btn1 キャンセル
     */
    public void setBtn1(String btn1) {
        this.btn1 = btn1;
    }

    /**
     * btn1 キャンセル Get
     *
     * @return btn1 キャンセル
     */
    public String getBtn1() {
        return this.btn1;
    }
    /**
     * remark 備考 Set
     *
     * @param remark 備考
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * remark 備考 Get
     *
     * @return remark 備考
     */
    public String getRemark() {
        return this.remark;
    }
    /**
     * tagCode タグコード Set
     *
     * @param tagCode タグコード
     */
    public void setTagcode(String tagCode) {
        this.tagcode = tagCode;
    }

    /**
     * tagCode タグコード Get
     *
     * @return tagCode タグコード
     */
    public String getTagcode() {
        return this.tagcode;
    }
    /**
     * tagName タグ名 Set
     *
     * @param tagName タグ名
     */
    public void setTagname(String tagName) {
        this.tagname = tagName;
    }

    /**
     * tagName タグ名 Get
     *
     * @return tagName タグ名
     */
    public String getTagname() {
        return this.tagname;
    }
    /**
     * tagType タグタイプ Set
     *
     * @param tagType タグタイプ
     */
    public void setTagtype(String tagType) {
        this.tagtype = tagType.replaceAll(",", "");
    }

    /**
     * tagType タグタイプ Get
     *
     * @return tagType タグタイプ
     */
    public String getTagtype() {
        return this.tagtype;
    }
    /**
     * txt2 id Set
     *
     * @param txt2 id
     */
    public void setTxt2(String txt2) {
        this.txt2 = txt2.replaceAll(",", "");
    }

    /**
     * txt2 id Get
     *
     * @return txt2 id
     */
    public String getTxt2() {
        return this.txt2;
    }
}