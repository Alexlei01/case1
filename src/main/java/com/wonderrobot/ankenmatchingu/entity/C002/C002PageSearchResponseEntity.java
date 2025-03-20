package com.wonderrobot.ankenmatchingu.entity.C002;
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
 * コミュニケーション記録  Entity
 */
public class C002PageSearchResponseEntity extends BaseEntity {

    /**
     *     txt10 メールの内容
     */
    @ApiModelProperty(value = "メールの内容")
    private String txt10;
    /**
     *     txt6 受信者
     */
    @ApiModelProperty(value = "受信者")
    private String txt6;
    /**
     *     txt12 送信者
     */
    @ApiModelProperty(value = "送信者")
    private String txt12;
    /**
     *     txt14 送信時間
     */
    @ApiModelProperty(value = "送信時間")
    private String txt14;
    /**
     *     txt8 メールタイトル
     */
    @ApiModelProperty(value = "メールタイトル")
    private String txt8;
    /**
     *     txt2 id
     */
    @ApiModelProperty(value = "id")
    private String txt2;


    /**
     * txt10 メールの内容 Set
     *
     * @param txt10 メールの内容
     */
    public void setTxt10(String txt10) {
        this.txt10 = txt10;
    }

    /**
     * txt10 メールの内容 Get
     *
     * @return txt10 メールの内容
     */
    public String getTxt10() {
        return this.txt10;
    }

    /**
     * txt6 受信者 Set
     *
     * @param txt6 受信者
     */
    public void setTxt6(String txt6) {
        this.txt6 = txt6;
    }

    /**
     * txt6 受信者 Get
     *
     * @return txt6 受信者
     */
    public String getTxt6() {
        return this.txt6;
    }

    /**
     * txt12 送信者 Set
     *
     * @param txt12 送信者
     */
    public void setTxt12(String txt12) {
        this.txt12 = txt12;
    }

    /**
     * txt12 送信者 Get
     *
     * @return txt12 送信者
     */
    public String getTxt12() {
        return this.txt12;
    }

    /**
     * txt14 送信時間 Set
     *
     * @param txt14 送信時間
     */
    public void setTxt14(String txt14) {
        this.txt14 = txt14;
    }

    /**
     * txt14 送信時間 Get
     *
     * @return txt14 送信時間
     */
    public String getTxt14() {
        return this.txt14;
    }

    /**
     * txt8 メールタイトル Set
     *
     * @param txt8 メールタイトル
     */
    public void setTxt8(String txt8) {
        this.txt8 = txt8;
    }

    /**
     * txt8 メールタイトル Get
     *
     * @return txt8 メールタイトル
     */
    public String getTxt8() {
        return this.txt8;
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
}
