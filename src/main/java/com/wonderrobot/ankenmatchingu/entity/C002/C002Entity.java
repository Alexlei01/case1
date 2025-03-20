package com.wonderrobot.ankenmatchingu.entity.C002;
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
 * コミュニケーション記録 Entity
 */
public class C002Entity extends BaseEntity{

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
     * emailContent メールの内容
     */
    @ApiModelProperty(value = "メールの内容")
    private String emailcontent;
    /**
     * emailReceiver 受信者
     */
    @ApiModelProperty(value = "受信者")
    private String emailreceiver;
    /**
     * emailSender 送信者
     */
@Length(max=255,message="validate.msg_C002emailSender")
    @ApiModelProperty(value = "送信者")
    private String emailsender;
    /**
     * emailSendTime 送信時間
     */
    @ApiModelProperty(value = "送信時間")
    private String emailsendtime;
    /**
     * emailTitle メールタイトル
     */
@Length(max=1000,message="validate.msg_C002emailTitle")
    @ApiModelProperty(value = "メールタイトル")
    private String emailtitle;
    /**
     * matchId マッチングID
     */
    @ApiModelProperty(value = "マッチングID")
    private String matchid;
    /**
     * recordType レコードタイプ
     */
    @ApiModelProperty(value = "レコードタイプ")
    private String recordtype;
    /**
     * txt2 id
     */
@NotBlank(message = "validate.msg_C002txt2")
    @ApiModelProperty(value = "id")
    private String txt2;
    /**
     * txt26 コミュニケーションID
     */
    @ApiModelProperty(value = "コミュニケーションID")
    private String txt26;

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
     * emailReceiver 受信者 Set
     *
     * @param emailReceiver 受信者
     */
    public void setEmailreceiver(String emailReceiver) {
        this.emailreceiver = emailReceiver;
    }

    /**
     * emailReceiver 受信者 Get
     *
     * @return emailReceiver 受信者
     */
    public String getEmailreceiver() {
        return this.emailreceiver;
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
     * emailSendTime 送信時間 Set
     *
     * @param emailSendTime 送信時間
     */
    public void setEmailsendtime(String emailSendTime) {
        this.emailsendtime = emailSendTime;
    }

    /**
     * emailSendTime 送信時間 Get
     *
     * @return emailSendTime 送信時間
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
     * matchId マッチングID Set
     *
     * @param matchId マッチングID
     */
    public void setMatchid(String matchId) {
        this.matchid = matchId.replaceAll(",", "");
    }

    /**
     * matchId マッチングID Get
     *
     * @return matchId マッチングID
     */
    public String getMatchid() {
        return this.matchid;
    }
    /**
     * recordType レコードタイプ Set
     *
     * @param recordType レコードタイプ
     */
    public void setRecordtype(String recordType) {
        this.recordtype = recordType.replaceAll(",", "");
    }

    /**
     * recordType レコードタイプ Get
     *
     * @return recordType レコードタイプ
     */
    public String getRecordtype() {
        return this.recordtype;
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
     * txt26 コミュニケーションID Set
     *
     * @param txt26 コミュニケーションID
     */
    public void setTxt26(String txt26) {
        this.txt26 = txt26.replaceAll(",", "");
    }

    /**
     * txt26 コミュニケーションID Get
     *
     * @return txt26 コミュニケーションID
     */
    public String getTxt26() {
        return this.txt26;
    }
}