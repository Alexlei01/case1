package com.wonderrobot.ankenmatchingu.entity;
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
 * User Password 用 Entity
 */
public class UserPasswordRequestEntity extends BaseEntity {

    /**
     *     changeLoginId 
     */
    @ApiModelProperty(value = "")
    private String changeloginid;
    /**
     *     changePassword 
     */
    @ApiModelProperty(value = "")
    private String changepassword;


    /**
     * changeLoginId  Set
     *
     * @param changeLoginId 
     */
    public void setChangeloginid(String changeLoginId) {
        this.changeloginid = changeLoginId;
    }

    /**
     * changeLoginId  Get
     *
     * @return changeLoginId 
     */
    public String getChangeloginid() {
        return this.changeloginid;
    }

    /**
     * changePassword  Set
     *
     * @param changePassword 
     */
    public void setChangepassword(String changePassword) {
        this.changepassword = changePassword;
    }

    /**
     * changePassword  Get
     *
     * @return changePassword 
     */
    public String getChangepassword() {
        return this.changepassword;
    }
}
