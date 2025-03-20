package com.wonderrobot.ankenmatchingu.entity.P002;
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
 * 技術者明細  Entity
 */
public class P002PageSearchResponseEntity extends BaseEntity {

    /**
     *     txt40 メール送信時刻
     */
    @ApiModelProperty(value = "メール送信時刻")
    private String txt40;
    /**
     *     txt42 メールタイトル
     */
    @ApiModelProperty(value = "メールタイトル")
    private String txt42;
    /**
     *     txt2 id
     */
    @ApiModelProperty(value = "id")
    private String txt2;


    /**
     * txt40 メール送信時刻 Set
     *
     * @param txt40 メール送信時刻
     */
    public void setTxt40(String txt40) {
        this.txt40 = txt40;
    }

    /**
     * txt40 メール送信時刻 Get
     *
     * @return txt40 メール送信時刻
     */
    public String getTxt40() {
        return this.txt40;
    }

    /**
     * txt42 メールタイトル Set
     *
     * @param txt42 メールタイトル
     */
    public void setTxt42(String txt42) {
        this.txt42 = txt42;
    }

    /**
     * txt42 メールタイトル Get
     *
     * @return txt42 メールタイトル
     */
    public String getTxt42() {
        return this.txt42;
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
