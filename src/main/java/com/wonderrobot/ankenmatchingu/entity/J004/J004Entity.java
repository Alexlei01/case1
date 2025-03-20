package com.wonderrobot.ankenmatchingu.entity.J004;
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
 * 案件一覧 Entity
 */
public class J004Entity extends BaseEntity{

    /**
     * btn1 閉じる
     */
    @ApiModelProperty(value = "閉じる")
    private String btn1;
    /**
     * btn16 検索
     */
    @ApiModelProperty(value = "検索")
    private String btn16;
    /**
     * emailSender 送信者
     */
    @ApiModelProperty(value = "送信者")
    private String emailsender;
    /**
     * emailSendTime メール送信時刻
     */
    @ApiModelProperty(value = "メール送信時刻")
    private String emailsendtime;
    /**
     * emailSendTime_end メール送信時刻
     */
@DateTimeStr(format = "yyyy/MM/dd",message = "validate.msg_J004emailSendTime_end9")
    @ApiModelProperty(value = "メール送信時刻")
    private String emailsendtimeend;
    /**
     * emailSendTime_start メール送信時刻
     */
@DateTimeStr(format = "yyyy/MM/dd",message = "validate.msg_J004emailSendTime_start9")
    @ApiModelProperty(value = "メール送信時刻")
    private String emailsendtimestart;
    /**
     * emailTitle メールタイトル
     */
    @ApiModelProperty(value = "メールタイトル")
    private String emailtitle;
    /**
     * id id
     */
    @ApiModelProperty(value = "id")
    private String id;
    /**
     * lnk9 編集
     */
    @ApiModelProperty(value = "編集")
    private String lnk9;
    /**
     * projectCycle_end 予定開始日
     */
@DateTimeStr(format = "yyyy/MM/dd",message = "validate.msg_J004projectCycle_end9")
    @ApiModelProperty(value = "予定開始日")
    private String projectcycleend;
    /**
     * projectCycle_start 予定開始日
     */
@DateTimeStr(format = "yyyy/MM/dd",message = "validate.msg_J004projectCycle_start9")
    @ApiModelProperty(value = "予定開始日")
    private String projectcyclestart;
    /**
     * recruitment 募集要員
     */
    @ApiModelProperty(value = "募集要員")
    private String recruitment;
    /**
     * txt10 検索文字列
     */
    @ApiModelProperty(value = "検索文字列")
    private String txt10;
    /**
     * Grid2 案件一覧
     */
    @ApiModelProperty(value = "案件一覧")
    private ArrayList<J004grd2Entity> grid2;

    /**
     * btn1 閉じる Set
     *
     * @param btn1 閉じる
     */
    public void setBtn1(String btn1) {
        this.btn1 = btn1;
    }

    /**
     * btn1 閉じる Get
     *
     * @return btn1 閉じる
     */
    public String getBtn1() {
        return this.btn1;
    }
    /**
     * btn16 検索 Set
     *
     * @param btn16 検索
     */
    public void setBtn16(String btn16) {
        this.btn16 = btn16;
    }

    /**
     * btn16 検索 Get
     *
     * @return btn16 検索
     */
    public String getBtn16() {
        return this.btn16;
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
     * emailSendTime_end メール送信時刻 Set
     *
     * @param emailSendTime_end メール送信時刻
     */
    public void setEmailsendtimeend(String emailSendTime_end) {
        this.emailsendtimeend = emailSendTime_end;
    }

    /**
     * emailSendTime_end メール送信時刻 Get
     *
     * @return emailSendTime_end メール送信時刻
     */
    public String getEmailsendtimeend() {
        return this.emailsendtimeend;
    }
    /**
     * emailSendTime_start メール送信時刻 Set
     *
     * @param emailSendTime_start メール送信時刻
     */
    public void setEmailsendtimestart(String emailSendTime_start) {
        this.emailsendtimestart = emailSendTime_start;
    }

    /**
     * emailSendTime_start メール送信時刻 Get
     *
     * @return emailSendTime_start メール送信時刻
     */
    public String getEmailsendtimestart() {
        return this.emailsendtimestart;
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
     * id id Set
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id.replaceAll(",", "");
    }

    /**
     * id id Get
     *
     * @return id id
     */
    public String getId() {
        return this.id;
    }
    /**
     * lnk9 編集 Set
     *
     * @param lnk9 編集
     */
    public void setLnk9(String lnk9) {
        this.lnk9 = lnk9;
    }

    /**
     * lnk9 編集 Get
     *
     * @return lnk9 編集
     */
    public String getLnk9() {
        return this.lnk9;
    }
    /**
     * projectCycle_end 予定開始日 Set
     *
     * @param projectCycle_end 予定開始日
     */
    public void setProjectcycleend(String projectCycle_end) {
        this.projectcycleend = projectCycle_end;
    }

    /**
     * projectCycle_end 予定開始日 Get
     *
     * @return projectCycle_end 予定開始日
     */
    public String getProjectcycleend() {
        return this.projectcycleend;
    }
    /**
     * projectCycle_start 予定開始日 Set
     *
     * @param projectCycle_start 予定開始日
     */
    public void setProjectcyclestart(String projectCycle_start) {
        this.projectcyclestart = projectCycle_start;
    }

    /**
     * projectCycle_start 予定開始日 Get
     *
     * @return projectCycle_start 予定開始日
     */
    public String getProjectcyclestart() {
        return this.projectcyclestart;
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
     * txt10 検索文字列 Set
     *
     * @param txt10 検索文字列
     */
    public void setTxt10(String txt10) {
        this.txt10 = txt10;
    }

    /**
     * txt10 検索文字列 Get
     *
     * @return txt10 検索文字列
     */
    public String getTxt10() {
        return this.txt10;
    }
    /**
     * Grid2 案件一覧 Set
     *
     * @param Grid2 案件一覧
     */
    public void setGrid2(ArrayList<J004grd2Entity> Grid2) {
        this.grid2 = Grid2;
    }

    /**
     * Grid2 案件一覧 Get
     *
     * @return Grid2 案件一覧
     */
    public ArrayList<J004grd2Entity> getGrid2() {
        return this.grid2;
    }
}