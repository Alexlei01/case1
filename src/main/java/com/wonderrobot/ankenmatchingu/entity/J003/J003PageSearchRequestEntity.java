package com.wonderrobot.ankenmatchingu.entity.J003;
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
 * 案件タグ  Entity
 */
public class J003PageSearchRequestEntity extends BaseEntity {

    /**
     *     txt14 詳細ID
     */
    @ApiModelProperty(value = "詳細ID")
    private String txt14;
    /**
     *     txt18 メール送信時刻
     */
    @ApiModelProperty(value = "メール送信時刻")
    private String txt18;
    /**
     *     txt2 id
     */
    @ApiModelProperty(value = "id")
    private String txt2;
    /**
     *     txt10 終了番号
     */
    @ApiModelProperty(value = "終了番号")
    private String txt10;
    /**
     *     txt8 開始番号
     */
    @ApiModelProperty(value = "開始番号")
    private String txt8;
    /**
     *     txt16 タグコード
     */
    @ApiModelProperty(value = "タグコード")
    private String txt16;
    /**
     *     txt6 タグID
     */
    @ApiModelProperty(value = "タグID")
    private String txt6;
    /**
     *     txt4 タグタイプ
     */
    @ApiModelProperty(value = "タグタイプ")
    private String txt4;
    /**
     *     txt12 値
     */
    @ApiModelProperty(value = "値")
    private String txt12;


    /**
     * txt14 詳細ID Set
     *
     * @param txt14 詳細ID
     */
    public void setTxt14(String txt14) {
        this.txt14 = txt14;
    }

    /**
     * txt14 詳細ID Get
     *
     * @return txt14 詳細ID
     */
    public String getTxt14() {
        return this.txt14;
    }

    /**
     * txt18 メール送信時刻 Set
     *
     * @param txt18 メール送信時刻
     */
    public void setTxt18(String txt18) {
        this.txt18 = txt18;
    }

    /**
     * txt18 メール送信時刻 Get
     *
     * @return txt18 メール送信時刻
     */
    public String getTxt18() {
        return this.txt18;
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
     * txt10 終了番号 Set
     *
     * @param txt10 終了番号
     */
    public void setTxt10(String txt10) {
        this.txt10 = txt10;
    }

    /**
     * txt10 終了番号 Get
     *
     * @return txt10 終了番号
     */
    public String getTxt10() {
        return this.txt10;
    }

    /**
     * txt8 開始番号 Set
     *
     * @param txt8 開始番号
     */
    public void setTxt8(String txt8) {
        this.txt8 = txt8;
    }

    /**
     * txt8 開始番号 Get
     *
     * @return txt8 開始番号
     */
    public String getTxt8() {
        return this.txt8;
    }

    /**
     * txt16 タグコード Set
     *
     * @param txt16 タグコード
     */
    public void setTxt16(String txt16) {
        this.txt16 = txt16;
    }

    /**
     * txt16 タグコード Get
     *
     * @return txt16 タグコード
     */
    public String getTxt16() {
        return this.txt16;
    }

    /**
     * txt6 タグID Set
     *
     * @param txt6 タグID
     */
    public void setTxt6(String txt6) {
        this.txt6 = txt6;
    }

    /**
     * txt6 タグID Get
     *
     * @return txt6 タグID
     */
    public String getTxt6() {
        return this.txt6;
    }

    /**
     * txt4 タグタイプ Set
     *
     * @param txt4 タグタイプ
     */
    public void setTxt4(String txt4) {
        this.txt4 = txt4;
    }

    /**
     * txt4 タグタイプ Get
     *
     * @return txt4 タグタイプ
     */
    public String getTxt4() {
        return this.txt4;
    }

    /**
     * txt12 値 Set
     *
     * @param txt12 値
     */
    public void setTxt12(String txt12) {
        this.txt12 = txt12;
    }

    /**
     * txt12 値 Get
     *
     * @return txt12 値
     */
    public String getTxt12() {
        return this.txt12;
    }
}
