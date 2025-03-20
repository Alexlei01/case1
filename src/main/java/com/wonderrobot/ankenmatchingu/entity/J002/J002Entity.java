package com.wonderrobot.ankenmatchingu.entity.J002;
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
 * 案件マッチング Entity
 */
public class J002Entity extends BaseEntity{

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
     * jobName 案件名
     */
@Length(max=255,message="validate.msg_J002jobName")
    @ApiModelProperty(value = "案件名")
    private String jobname;
    /**
     * lnk16 案件詳細
     */
    @ApiModelProperty(value = "案件詳細")
    private String lnk16;
    /**
     * lnk17 技術者
     */
    @ApiModelProperty(value = "技術者")
    private String lnk17;
    /**
     * matchCode マッチングコード
     */
@Length(max=255,message="validate.msg_J002matchCode")
    @ApiModelProperty(value = "マッチングコード")
    private String matchcode;
    /**
     * matchPercent マッチング率
     */
    @ApiModelProperty(value = "マッチング率")
    private String matchpercent;
    /**
     * peopleId 技術者ID
     */
    @ApiModelProperty(value = "技術者ID")
    private String peopleid;
    /**
     * peopleName 技術者名
     */
@Length(max=255,message="validate.msg_J002peopleName")
    @ApiModelProperty(value = "技術者名")
    private String peoplename;
    /**
     * txt2 id
     */
@NotBlank(message = "validate.msg_J002txt2")
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
     * jobName 案件名 Set
     *
     * @param jobName 案件名
     */
    public void setJobname(String jobName) {
        this.jobname = jobName;
    }

    /**
     * jobName 案件名 Get
     *
     * @return jobName 案件名
     */
    public String getJobname() {
        return this.jobname;
    }
    /**
     * lnk16 案件詳細 Set
     *
     * @param lnk16 案件詳細
     */
    public void setLnk16(String lnk16) {
        this.lnk16 = lnk16;
    }

    /**
     * lnk16 案件詳細 Get
     *
     * @return lnk16 案件詳細
     */
    public String getLnk16() {
        return this.lnk16;
    }
    /**
     * lnk17 技術者 Set
     *
     * @param lnk17 技術者
     */
    public void setLnk17(String lnk17) {
        this.lnk17 = lnk17;
    }

    /**
     * lnk17 技術者 Get
     *
     * @return lnk17 技術者
     */
    public String getLnk17() {
        return this.lnk17;
    }
    /**
     * matchCode マッチングコード Set
     *
     * @param matchCode マッチングコード
     */
    public void setMatchcode(String matchCode) {
        this.matchcode = matchCode;
    }

    /**
     * matchCode マッチングコード Get
     *
     * @return matchCode マッチングコード
     */
    public String getMatchcode() {
        return this.matchcode;
    }
    /**
     * matchPercent マッチング率 Set
     *
     * @param matchPercent マッチング率
     */
    public void setMatchpercent(String matchPercent) {
        this.matchpercent = matchPercent.replaceAll(",", "");
    }

    /**
     * matchPercent マッチング率 Get
     *
     * @return matchPercent マッチング率
     */
    public String getMatchpercent() {
        return this.matchpercent;
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
     * peopleName 技術者名 Set
     *
     * @param peopleName 技術者名
     */
    public void setPeoplename(String peopleName) {
        this.peoplename = peopleName;
    }

    /**
     * peopleName 技術者名 Get
     *
     * @return peopleName 技術者名
     */
    public String getPeoplename() {
        return this.peoplename;
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