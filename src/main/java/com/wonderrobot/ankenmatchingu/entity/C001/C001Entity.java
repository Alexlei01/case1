package com.wonderrobot.ankenmatchingu.entity.C001;
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
 * コミュニケーション Entity
 */
public class C001Entity extends BaseEntity{

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
     * jobId 案件ID
     */
    @ApiModelProperty(value = "案件ID")
    private String jobid;
    /**
     * peopleId 技術者ID
     */
    @ApiModelProperty(value = "技術者ID")
    private String peopleid;
    /**
     * remark コメント
     */
    @ApiModelProperty(value = "コメント")
    private String remark;
    /**
     * status ステータス
     */
@Length(max=255,message="validate.msg_C001status")
    @ApiModelProperty(value = "ステータス")
    private String status;
    /**
     * txt2 id
     */
@NotBlank(message = "validate.msg_C001txt2")
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
     * jobId 案件ID Set
     *
     * @param jobId 案件ID
     */
    public void setJobid(String jobId) {
        this.jobid = jobId.replaceAll(",", "");
    }

    /**
     * jobId 案件ID Get
     *
     * @return jobId 案件ID
     */
    public String getJobid() {
        return this.jobid;
    }
    /**
     * peopleId 技術者ID Set
     *
     * @param peopleId 技術者ID
     */
    public void setPeopleid(String peopleId) {
        this.peopleid = peopleId.replaceAll(",", "");
    }

    /**
     * peopleId 技術者ID Get
     *
     * @return peopleId 技術者ID
     */
    public String getPeopleid() {
        return this.peopleid;
    }
    /**
     * remark コメント Set
     *
     * @param remark コメント
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * remark コメント Get
     *
     * @return remark コメント
     */
    public String getRemark() {
        return this.remark;
    }
    /**
     * status ステータス Set
     *
     * @param status ステータス
     */
    public void setStatus(String status) {
        this.status = status.replaceAll(",", "");
    }

    /**
     * status ステータス Get
     *
     * @return status ステータス
     */
    public String getStatus() {
        return this.status;
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