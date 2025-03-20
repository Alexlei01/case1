package com.wonderrobot.ankenmatchingu.entity.J001;
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
 * 案件明細  Entity
 */
public class J001PageSearchResponseEntity extends BaseEntity {

    /**
     *     txt24 送信者
     */
    @ApiModelProperty(value = "送信者")
    private String txt24;
    /**
     *     txt28 メールタイトル
     */
    @ApiModelProperty(value = "メールタイトル")
    private String txt28;
    /**
     *     txt2 id
     */
    @ApiModelProperty(value = "id")
    private String txt2;
    /**
     *     txt12 募集要員
     */
    @ApiModelProperty(value = "募集要員")
    private String txt12;


    /**
     * txt24 送信者 Set
     *
     * @param txt24 送信者
     */
    public void setTxt24(String txt24) {
        this.txt24 = txt24;
    }

    /**
     * txt24 送信者 Get
     *
     * @return txt24 送信者
     */
    public String getTxt24() {
        return this.txt24;
    }

    /**
     * txt28 メールタイトル Set
     *
     * @param txt28 メールタイトル
     */
    public void setTxt28(String txt28) {
        this.txt28 = txt28;
    }

    /**
     * txt28 メールタイトル Get
     *
     * @return txt28 メールタイトル
     */
    public String getTxt28() {
        return this.txt28;
    }

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
     * txt12 募集要員 Set
     *
     * @param txt12 募集要員
     */
    public void setTxt12(String txt12) {
        this.txt12 = txt12;
    }

    /**
     * txt12 募集要員 Get
     *
     * @return txt12 募集要員
     */
    public String getTxt12() {
        return this.txt12;
    }
}
