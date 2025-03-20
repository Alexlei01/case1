package com.wonderrobot.ankenmatchingu.entity.J002;
// BasicEntity.vm
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.Length;
import io.swagger.annotations.ApiModelProperty;

import com.wonderrobot.ankenmatchingu.entity.BaseEntity;

/**
 * Search 用
 * 案件マッチング  Entity
 */
public class J002PageSearchResponseEntity extends BaseEntity {

    /**
     *     txt2 id
     */
    @ApiModelProperty(value = "id")
    private String txt2;
    /**
     *     txt4 案件ID
     */
    @ApiModelProperty(value = "案件ID")
    private String txt4;
    /**
     *     txt6 案件名
     */
    @ApiModelProperty(value = "案件名")
    private String txt6;
    /**
     *     txt14 マッチングコード
     */
    @ApiModelProperty(value = "マッチングコード")
    private String txt14;
    /**
     *     txt12 マッチング率
     */
    @ApiModelProperty(value = "マッチング率")
    private String txt12;
    /**
     *     txt8 技術者ID
     */
    @ApiModelProperty(value = "技術者ID")
    private String txt8;
    /**
     *     txt10 技術者名
     */
    @ApiModelProperty(value = "技術者名")
    private String txt10;


    /**
     * txt2 id Set
     *
     * @param txt2 id
     */
    public void setTxt2(String txt2) {
        this.txt2 = txt2;
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
     * txt4 案件ID Set
     *
     * @param txt4 案件ID
     */
    public void setTxt4(String txt4) {
        this.txt4 = txt4;
    }

    /**
     * txt4 案件ID Get
     *
     * @return txt4 案件ID
     */
    public String getTxt4() {
        return this.txt4;
    }

    /**
     * txt6 案件名 Set
     *
     * @param txt6 案件名
     */
    public void setTxt6(String txt6) {
        this.txt6 = txt6;
    }

    /**
     * txt6 案件名 Get
     *
     * @return txt6 案件名
     */
    public String getTxt6() {
        return this.txt6;
    }

    /**
     * txt14 マッチングコード Set
     *
     * @param txt14 マッチングコード
     */
    public void setTxt14(String txt14) {
        this.txt14 = txt14;
    }

    /**
     * txt14 マッチングコード Get
     *
     * @return txt14 マッチングコード
     */
    public String getTxt14() {
        return this.txt14;
    }

    /**
     * txt12 マッチング率 Set
     *
     * @param txt12 マッチング率
     */
    public void setTxt12(String txt12) {
        this.txt12 = txt12;
    }

    /**
     * txt12 マッチング率 Get
     *
     * @return txt12 マッチング率
     */
    public String getTxt12() {
        return this.txt12;
    }

    /**
     * txt8 技術者ID Set
     *
     * @param txt8 技術者ID
     */
    public void setTxt8(String txt8) {
        this.txt8 = txt8;
    }

    /**
     * txt8 技術者ID Get
     *
     * @return txt8 技術者ID
     */
    public String getTxt8() {
        return this.txt8;
    }

    /**
     * txt10 技術者名 Set
     *
     * @param txt10 技術者名
     */
    public void setTxt10(String txt10) {
        this.txt10 = txt10;
    }

    /**
     * txt10 技術者名 Get
     *
     * @return txt10 技術者名
     */
    public String getTxt10() {
        return this.txt10;
    }
}
