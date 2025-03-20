package com.wonderrobot.ankenmatchingu.entity.J003;
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
 * 案件タグ Entity
 */
public class J003Entity extends BaseEntity{

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
     * detailId 詳細ID
     */
    @ApiModelProperty(value = "詳細ID")
    private String detailid;
    /**
     * emailSendTime メール送信時刻
     */
    @ApiModelProperty(value = "メール送信時刻")
    private String emailsendtime;
    /**
     * numberEnd 終了番号
     */
    @ApiModelProperty(value = "終了番号")
    private String numberend;
    /**
     * numberStart 開始番号
     */
    @ApiModelProperty(value = "開始番号")
    private String numberstart;
    /**
     * tagCode タグコード
     */
@Length(max=25,message="validate.msg_J003tagCode")
    @ApiModelProperty(value = "タグコード")
    private String tagcode;
    /**
     * tagId タグID
     */
    @ApiModelProperty(value = "タグID")
    private String tagid;
    /**
     * tagType タグタイプ
     */
    @ApiModelProperty(value = "タグタイプ")
    private String tagtype;
    /**
     * txt2 id
     */
@NotBlank(message = "validate.msg_J003txt2")
    @ApiModelProperty(value = "id")
    private String txt2;
    /**
     * value 値
     */
@Length(max=255,message="validate.msg_J003value")
    @ApiModelProperty(value = "値")
    private String value;

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
     * detailId 詳細ID Set
     *
     * @param detailId 詳細ID
     */
    public void setDetailid(String detailId) {
        this.detailid = detailId.replaceAll(",", "");
    }

    /**
     * detailId 詳細ID Get
     *
     * @return detailId 詳細ID
     */
    public String getDetailid() {
        return this.detailid;
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
     * numberEnd 終了番号 Set
     *
     * @param numberEnd 終了番号
     */
    public void setNumberend(String numberEnd) {
        this.numberend = numberEnd.replaceAll(",", "");
    }

    /**
     * numberEnd 終了番号 Get
     *
     * @return numberEnd 終了番号
     */
    public String getNumberend() {
        return this.numberend;
    }
    /**
     * numberStart 開始番号 Set
     *
     * @param numberStart 開始番号
     */
    public void setNumberstart(String numberStart) {
        this.numberstart = numberStart.replaceAll(",", "");
    }

    /**
     * numberStart 開始番号 Get
     *
     * @return numberStart 開始番号
     */
    public String getNumberstart() {
        return this.numberstart;
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
     * tagId タグID Set
     *
     * @param tagId タグID
     */
    public void setTagid(String tagId) {
        this.tagid = tagId.replaceAll(",", "");
    }

    /**
     * tagId タグID Get
     *
     * @return tagId タグID
     */
    public String getTagid() {
        return this.tagid;
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
    /**
     * value 値 Set
     *
     * @param value 値
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * value 値 Get
     *
     * @return value 値
     */
    public String getValue() {
        return this.value;
    }
}