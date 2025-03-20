package com.wonderrobot.ankenmatchingu.entity.J001;
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
 * 案件明細 Entity
 */
public class J001Entity extends BaseEntity{

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
     * btn34 setLink
     */
    @ApiModelProperty(value = "setLink")
    private String btn34;
    /**
     * budget 予算
     */
@Length(max=100,message="validate.msg_J001budget")
    @ApiModelProperty(value = "予算")
    private String budget;
    /**
     * description フェーズ
     */
    @ApiModelProperty(value = "フェーズ")
    private String description;
    /**
     * emailAttachment メール添付パス
     */
    @ApiModelProperty(value = "メール添付パス")
    private String emailattachment;
    /**
     * emailContent メールの内容
     */
    @ApiModelProperty(value = "メールの内容")
    private String emailcontent;
    /**
     * emailSender 送信者
     */
@Length(max=255,message="validate.msg_J001emailSender")
    @ApiModelProperty(value = "送信者")
    private String emailsender;
    /**
     * emailSendTime メール送信時刻
     */
@Length(max=255,message="validate.msg_J001emailSendTime")
    @ApiModelProperty(value = "メール送信時刻")
    private String emailsendtime;
    /**
     * emailTitle メールタイトル
     */
    @ApiModelProperty(value = "メールタイトル")
    private String emailtitle;
    /**
     * outline 概要
     */
@Length(max=255,message="validate.msg_J001outline")
    @ApiModelProperty(value = "概要")
    private String outline;
    /**
     * project 項目
     */
@Length(max=255,message="validate.msg_J001project")
    @ApiModelProperty(value = "項目")
    private String project;
    /**
     * projectCycle 予定開始日
     */
@Length(max=250,message="validate.msg_J001projectCycle")
    @ApiModelProperty(value = "予定開始日")
    private String projectcycle;
    /**
     * projectMachine 機種
     */
@Length(max=255,message="validate.msg_J001projectMachine")
    @ApiModelProperty(value = "機種")
    private String projectmachine;
    /**
     * recruitment 募集要員
     */
@Length(max=100,message="validate.msg_J001recruitment")
    @ApiModelProperty(value = "募集要員")
    private String recruitment;
    /**
     * remark 備考
     */
    @ApiModelProperty(value = "備考")
    private String remark;
    /**
     * skillRequired スキル要件
     */
    @ApiModelProperty(value = "スキル要件")
    private String skillrequired;
    /**
     * txt2 id
     */
@NotBlank(message = "validate.msg_J001txt2")
    @ApiModelProperty(value = "id")
    private String txt2;
    /**
     * workAddress 勤務先アドレス
     */
@Length(max=255,message="validate.msg_J001workAddress")
    @ApiModelProperty(value = "勤務先アドレス")
    private String workaddress;

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
     * btn34 setLink Set
     *
     * @param btn34 setLink
     */
    public void setBtn34(String btn34) {
        this.btn34 = btn34;
    }

    /**
     * btn34 setLink Get
     *
     * @return btn34 setLink
     */
    public String getBtn34() {
        return this.btn34;
    }
    /**
     * budget 予算 Set
     *
     * @param budget 予算
     */
    public void setBudget(String budget) {
        this.budget = budget;
    }

    /**
     * budget 予算 Get
     *
     * @return budget 予算
     */
    public String getBudget() {
        return this.budget;
    }
    /**
     * description フェーズ Set
     *
     * @param description フェーズ
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * description フェーズ Get
     *
     * @return description フェーズ
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * emailAttachment メール添付パス Set
     *
     * @param emailAttachment メール添付パス
     */
    public void setEmailattachment(String emailAttachment) {
        this.emailattachment = emailAttachment;
    }

    /**
     * emailAttachment メール添付パス Get
     *
     * @return emailAttachment メール添付パス
     */
    public String getEmailattachment() {
        return this.emailattachment;
    }
    /**
     * emailContent メールの内容 Set
     *
     * @param emailContent メールの内容
     */
    public void setEmailcontent(String emailContent) {
        this.emailcontent = emailContent;
    }

    /**
     * emailContent メールの内容 Get
     *
     * @return emailContent メールの内容
     */
    public String getEmailcontent() {
        return this.emailcontent;
    }
    /**
     * emailSender 送信者 Set
     *
     * @param emailSender 送信者
     */
    public void setEmailsender(String emailSender) {
        this.emailsender = emailSender;
    }

    /**
     * emailSender 送信者 Get
     *
     * @return emailSender 送信者
     */
    public String getEmailsender() {
        return this.emailsender;
    }
    /**
     * emailSendTime メール送信時刻 Set
     *
     * @param emailSendTime メール送信時刻
     */
    public void setEmailsendtime(String emailSendTime) {
        this.emailsendtime = emailSendTime;
    }

    /**
     * emailSendTime メール送信時刻 Get
     *
     * @return emailSendTime メール送信時刻
     */
    public String getEmailsendtime() {
        return this.emailsendtime;
    }
    /**
     * emailTitle メールタイトル Set
     *
     * @param emailTitle メールタイトル
     */
    public void setEmailtitle(String emailTitle) {
        this.emailtitle = emailTitle;
    }

    /**
     * emailTitle メールタイトル Get
     *
     * @return emailTitle メールタイトル
     */
    public String getEmailtitle() {
        return this.emailtitle;
    }
    /**
     * outline 概要 Set
     *
     * @param outline 概要
     */
    public void setOutline(String outline) {
        this.outline = outline;
    }

    /**
     * outline 概要 Get
     *
     * @return outline 概要
     */
    public String getOutline() {
        return this.outline;
    }
    /**
     * project 項目 Set
     *
     * @param project 項目
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * project 項目 Get
     *
     * @return project 項目
     */
    public String getProject() {
        return this.project;
    }
    /**
     * projectCycle 予定開始日 Set
     *
     * @param projectCycle 予定開始日
     */
    public void setProjectcycle(String projectCycle) {
        this.projectcycle = projectCycle;
    }

    /**
     * projectCycle 予定開始日 Get
     *
     * @return projectCycle 予定開始日
     */
    public String getProjectcycle() {
        return this.projectcycle;
    }
    /**
     * projectMachine 機種 Set
     *
     * @param projectMachine 機種
     */
    public void setProjectmachine(String projectMachine) {
        this.projectmachine = projectMachine;
    }

    /**
     * projectMachine 機種 Get
     *
     * @return projectMachine 機種
     */
    public String getProjectmachine() {
        return this.projectmachine;
    }
    /**
     * recruitment 募集要員 Set
     *
     * @param recruitment 募集要員
     */
    public void setRecruitment(String recruitment) {
        this.recruitment = recruitment;
    }

    /**
     * recruitment 募集要員 Get
     *
     * @return recruitment 募集要員
     */
    public String getRecruitment() {
        return this.recruitment;
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
     * skillRequired スキル要件 Set
     *
     * @param skillRequired スキル要件
     */
    public void setSkillrequired(String skillRequired) {
        this.skillrequired = skillRequired;
    }

    /**
     * skillRequired スキル要件 Get
     *
     * @return skillRequired スキル要件
     */
    public String getSkillrequired() {
        return this.skillrequired;
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
    /**
     * workAddress 勤務先アドレス Set
     *
     * @param workAddress 勤務先アドレス
     */
    public void setWorkaddress(String workAddress) {
        this.workaddress = workAddress;
    }

    /**
     * workAddress 勤務先アドレス Get
     *
     * @return workAddress 勤務先アドレス
     */
    public String getWorkaddress() {
        return this.workaddress;
    }
}