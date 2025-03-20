package com.wonderrobot.ankenmatchingu.entity.P002;
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
 * 技術者明細 Entity
 */
public class P002Entity extends BaseEntity{

    /**
     * address 住所
     */
@Length(max=255,message="validate.msg_P002address")
    @ApiModelProperty(value = "住所")
    private String address;
    /**
     * age 年齢
     */
@Length(max=25,message="validate.msg_P002age")
    @ApiModelProperty(value = "年齢")
    private String age;
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
     * btn58 setLink
     */
    @ApiModelProperty(value = "setLink")
    private String btn58;
    /**
     * certificate 資格
     */
@Length(max=1000,message="validate.msg_P002certificate")
    @ApiModelProperty(value = "資格")
    private String certificate;
    /**
     * companyCurrent 現在の会社
     */
@Length(max=100,message="validate.msg_P002companyCurrent")
    @ApiModelProperty(value = "現在の会社")
    private String companycurrent;
    /**
     * contact 連絡先
     */
@Length(max=50,message="validate.msg_P002contact")
    @ApiModelProperty(value = "連絡先")
    private String contact;
    /**
     * contactAddress 連絡先アドレス
     */
@Length(max=500,message="validate.msg_P002contactAddress")
    @ApiModelProperty(value = "連絡先アドレス")
    private String contactaddress;
    /**
     * contactCompany 連絡先会社
     */
@Length(max=255,message="validate.msg_P002contactCompany")
    @ApiModelProperty(value = "連絡先会社")
    private String contactcompany;
    /**
     * contactMail 連絡先メール
     */
@Length(max=100,message="validate.msg_P002contactMail")
    @ApiModelProperty(value = "連絡先メール")
    private String contactmail;
    /**
     * contactPhone 連絡先tel
     */
@Length(max=100,message="validate.msg_P002contactPhone")
    @ApiModelProperty(value = "連絡先tel")
    private String contactphone;
    /**
     * emailAttachment メール添付パス
     */
@Length(max=255,message="validate.msg_P002emailAttachment")
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
@Length(max=255,message="validate.msg_P002emailSender")
    @ApiModelProperty(value = "送信者")
    private String emailsender;
    /**
     * emailSendTime メール送信時刻
     */
    @ApiModelProperty(value = "メール送信時刻")
    private String emailsendtime;
    /**
     * emailTitle メールタイトル
     */
@Length(max=1000,message="validate.msg_P002emailTitle")
    @ApiModelProperty(value = "メールタイトル")
    private String emailtitle;
    /**
     * entryTime 入場可能時間
     */
@Length(max=100,message="validate.msg_P002entryTime")
    @ApiModelProperty(value = "入場可能時間")
    private String entrytime;
    /**
     * interviewTime 面接可能時間
     */
@Length(max=100,message="validate.msg_P002interviewTime")
    @ApiModelProperty(value = "面接可能時間")
    private String interviewtime;
    /**
     * introduction 紹介
     */
@Length(max=1000,message="validate.msg_P002introduction")
    @ApiModelProperty(value = "紹介")
    private String introduction;
    /**
     * name 名前
     */
    @ApiModelProperty(value = "名前")
    private String name;
    /**
     * price 単価
     */
@Length(max=50,message="validate.msg_P002price")
    @ApiModelProperty(value = "単価")
    private String price;
    /**
     * remark コメント
     */
@Length(max=1000,message="validate.msg_P002remark")
    @ApiModelProperty(value = "コメント")
    private String remark;
    /**
     * sex 性别
     */
    @ApiModelProperty(value = "性别")
    private String sex;
    /**
     * skills スキル
     */
@Length(max=255,message="validate.msg_P002skills")
    @ApiModelProperty(value = "スキル")
    private String skills;
    /**
     * txt2 id
     */
@NotBlank(message = "validate.msg_P002txt2")
@Pattern(regexp = "(^(0|\\+?[1-9][0-9]*){0,}$)?",message = "validate.msg_P002txt21")
    @ApiModelProperty(value = "id")
    private String txt2;
    /**
     * txt56 国籍
     */
@Length(max=50,message="validate.msg_P002txt56")
    @ApiModelProperty(value = "国籍")
    private String txt56;

    /**
     * address 住所 Set
     *
     * @param address 住所
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * address 住所 Get
     *
     * @return address 住所
     */
    public String getAddress() {
        return this.address;
    }
    /**
     * age 年齢 Set
     *
     * @param age 年齢
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * age 年齢 Get
     *
     * @return age 年齢
     */
    public String getAge() {
        return this.age;
    }
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
     * btn58 setLink Set
     *
     * @param btn58 setLink
     */
    public void setBtn58(String btn58) {
        this.btn58 = btn58;
    }

    /**
     * btn58 setLink Get
     *
     * @return btn58 setLink
     */
    public String getBtn58() {
        return this.btn58;
    }
    /**
     * certificate 資格 Set
     *
     * @param certificate 資格
     */
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    /**
     * certificate 資格 Get
     *
     * @return certificate 資格
     */
    public String getCertificate() {
        return this.certificate;
    }
    /**
     * companyCurrent 現在の会社 Set
     *
     * @param companyCurrent 現在の会社
     */
    public void setCompanycurrent(String companyCurrent) {
        this.companycurrent = companyCurrent;
    }

    /**
     * companyCurrent 現在の会社 Get
     *
     * @return companyCurrent 現在の会社
     */
    public String getCompanycurrent() {
        return this.companycurrent;
    }
    /**
     * contact 連絡先 Set
     *
     * @param contact 連絡先
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * contact 連絡先 Get
     *
     * @return contact 連絡先
     */
    public String getContact() {
        return this.contact;
    }
    /**
     * contactAddress 連絡先アドレス Set
     *
     * @param contactAddress 連絡先アドレス
     */
    public void setContactaddress(String contactAddress) {
        this.contactaddress = contactAddress;
    }

    /**
     * contactAddress 連絡先アドレス Get
     *
     * @return contactAddress 連絡先アドレス
     */
    public String getContactaddress() {
        return this.contactaddress;
    }
    /**
     * contactCompany 連絡先会社 Set
     *
     * @param contactCompany 連絡先会社
     */
    public void setContactcompany(String contactCompany) {
        this.contactcompany = contactCompany;
    }

    /**
     * contactCompany 連絡先会社 Get
     *
     * @return contactCompany 連絡先会社
     */
    public String getContactcompany() {
        return this.contactcompany;
    }
    /**
     * contactMail 連絡先メール Set
     *
     * @param contactMail 連絡先メール
     */
    public void setContactmail(String contactMail) {
        this.contactmail = contactMail;
    }

    /**
     * contactMail 連絡先メール Get
     *
     * @return contactMail 連絡先メール
     */
    public String getContactmail() {
        return this.contactmail;
    }
    /**
     * contactPhone 連絡先tel Set
     *
     * @param contactPhone 連絡先tel
     */
    public void setContactphone(String contactPhone) {
        this.contactphone = contactPhone;
    }

    /**
     * contactPhone 連絡先tel Get
     *
     * @return contactPhone 連絡先tel
     */
    public String getContactphone() {
        return this.contactphone;
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
     * entryTime 入場可能時間 Set
     *
     * @param entryTime 入場可能時間
     */
    public void setEntrytime(String entryTime) {
        this.entrytime = entryTime;
    }

    /**
     * entryTime 入場可能時間 Get
     *
     * @return entryTime 入場可能時間
     */
    public String getEntrytime() {
        return this.entrytime;
    }
    /**
     * interviewTime 面接可能時間 Set
     *
     * @param interviewTime 面接可能時間
     */
    public void setInterviewtime(String interviewTime) {
        this.interviewtime = interviewTime;
    }

    /**
     * interviewTime 面接可能時間 Get
     *
     * @return interviewTime 面接可能時間
     */
    public String getInterviewtime() {
        return this.interviewtime;
    }
    /**
     * introduction 紹介 Set
     *
     * @param introduction 紹介
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * introduction 紹介 Get
     *
     * @return introduction 紹介
     */
    public String getIntroduction() {
        return this.introduction;
    }
    /**
     * name 名前 Set
     *
     * @param name 名前
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * name 名前 Get
     *
     * @return name 名前
     */
    public String getName() {
        return this.name;
    }
    /**
     * price 単価 Set
     *
     * @param price 単価
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * price 単価 Get
     *
     * @return price 単価
     */
    public String getPrice() {
        return this.price;
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
     * sex 性别 Set
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex.replaceAll(",", "");
    }

    /**
     * sex 性别 Get
     *
     * @return sex 性别
     */
    public String getSex() {
        return this.sex;
    }
    /**
     * skills スキル Set
     *
     * @param skills スキル
     */
    public void setSkills(String skills) {
        this.skills = skills;
    }

    /**
     * skills スキル Get
     *
     * @return skills スキル
     */
    public String getSkills() {
        return this.skills;
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
     * txt56 国籍 Set
     *
     * @param txt56 国籍
     */
    public void setTxt56(String txt56) {
        this.txt56 = txt56;
    }

    /**
     * txt56 国籍 Get
     *
     * @return txt56 国籍
     */
    public String getTxt56() {
        return this.txt56;
    }
}