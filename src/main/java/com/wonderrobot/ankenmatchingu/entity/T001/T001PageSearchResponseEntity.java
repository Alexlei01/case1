package com.wonderrobot.ankenmatchingu.entity.T001;
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
 * タグ管理  Entity
 */
public class T001PageSearchResponseEntity extends BaseEntity {

    /**
     *     txt2 id
     */
    @ApiModelProperty(value = "id")
    private String txt2;
    /**
     *     txt8 備考
     */
    @ApiModelProperty(value = "備考")
    private String txt8;
    /**
     *     txt10 タグコード
     */
    @ApiModelProperty(value = "タグコード")
    private String txt10;
    /**
     *     txt4 タグ名
     */
    @ApiModelProperty(value = "タグ名")
    private String txt4;
    /**
     *     txt6 タグタイプ
     */
    @ApiModelProperty(value = "タグタイプ")
    private String txt6;


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
     * txt8 備考 Set
     *
     * @param txt8 備考
     */
    public void setTxt8(String txt8) {
        this.txt8 = txt8;
    }

    /**
     * txt8 備考 Get
     *
     * @return txt8 備考
     */
    public String getTxt8() {
        return this.txt8;
    }

    /**
     * txt10 タグコード Set
     *
     * @param txt10 タグコード
     */
    public void setTxt10(String txt10) {
        this.txt10 = txt10;
    }

    /**
     * txt10 タグコード Get
     *
     * @return txt10 タグコード
     */
    public String getTxt10() {
        return this.txt10;
    }

    /**
     * txt4 タグ名 Set
     *
     * @param txt4 タグ名
     */
    public void setTxt4(String txt4) {
        this.txt4 = txt4;
    }

    /**
     * txt4 タグ名 Get
     *
     * @return txt4 タグ名
     */
    public String getTxt4() {
        return this.txt4;
    }

    /**
     * txt6 タグタイプ Set
     *
     * @param txt6 タグタイプ
     */
    public void setTxt6(String txt6) {
        this.txt6 = txt6;
    }

    /**
     * txt6 タグタイプ Get
     *
     * @return txt6 タグタイプ
     */
    public String getTxt6() {
        return this.txt6;
    }
}
