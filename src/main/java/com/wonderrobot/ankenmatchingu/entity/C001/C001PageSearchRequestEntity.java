package com.wonderrobot.ankenmatchingu.entity.C001;
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
 * コミュニケーション  Entity
 */
public class C001PageSearchRequestEntity extends BaseEntity {

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
     *     txt6 技術者ID
     */
    @ApiModelProperty(value = "技術者ID")
    private String txt6;
    /**
     *     txt8 コメント
     */
    @ApiModelProperty(value = "コメント")
    private String txt8;
    /**
     *     txt10 ステータス
     */
    @ApiModelProperty(value = "ステータス")
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
     * txt6 技術者ID Set
     *
     * @param txt6 技術者ID
     */
    public void setTxt6(String txt6) {
        this.txt6 = txt6;
    }

    /**
     * txt6 技術者ID Get
     *
     * @return txt6 技術者ID
     */
    public String getTxt6() {
        return this.txt6;
    }

    /**
     * txt8 コメント Set
     *
     * @param txt8 コメント
     */
    public void setTxt8(String txt8) {
        this.txt8 = txt8;
    }

    /**
     * txt8 コメント Get
     *
     * @return txt8 コメント
     */
    public String getTxt8() {
        return this.txt8;
    }

    /**
     * txt10 ステータス Set
     *
     * @param txt10 ステータス
     */
    public void setTxt10(String txt10) {
        this.txt10 = txt10;
    }

    /**
     * txt10 ステータス Get
     *
     * @return txt10 ステータス
     */
    public String getTxt10() {
        return this.txt10;
    }
}
