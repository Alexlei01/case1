package com.wonderrobot.ankenmatchingu.entity.S001;
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
 * 共通設定管理 Entity
 */
public class S001Entity extends BaseEntity{

    /**
     * btn7 保存
     */
    @ApiModelProperty(value = "保存")
    private String btn7;
    /**
     * configCode コード
     */
    @ApiModelProperty(value = "コード")
    private String configcode;
    /**
     * configCode1 code
     */
    @ApiModelProperty(value = "code")
    private String configcode1;
    /**
     * description 説明
     */
    @ApiModelProperty(value = "説明")
    private String description;
    /**
     * description1 説明
     */
    @ApiModelProperty(value = "説明")
    private String description1;
    /**
     * id id
     */
    @ApiModelProperty(value = "id")
    private String id;
    /**
     * value 値
     */
    @ApiModelProperty(value = "値")
    private String value;
    /**
     * value1 值
     */
    @ApiModelProperty(value = "值")
    private String value1;
    /**
     * Grid1 配置表
     */
    @ApiModelProperty(value = "配置表")
    private ArrayList<S001grd1Entity> grid1;

    /**
     * btn7 保存 Set
     *
     * @param btn7 保存
     */
    public void setBtn7(String btn7) {
        this.btn7 = btn7;
    }

    /**
     * btn7 保存 Get
     *
     * @return btn7 保存
     */
    public String getBtn7() {
        return this.btn7;
    }
    /**
     * configCode コード Set
     *
     * @param configCode コード
     */
    public void setConfigcode(String configCode) {
        this.configcode = configCode;
    }

    /**
     * configCode コード Get
     *
     * @return configCode コード
     */
    public String getConfigcode() {
        return this.configcode;
    }
    /**
     * configCode1 code Set
     *
     * @param configCode1 code
     */
    public void setConfigcode1(String configCode1) {
        this.configcode1 = configCode1;
    }

    /**
     * configCode1 code Get
     *
     * @return configCode1 code
     */
    public String getConfigcode1() {
        return this.configcode1;
    }
    /**
     * description 説明 Set
     *
     * @param description 説明
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * description 説明 Get
     *
     * @return description 説明
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * description1 説明 Set
     *
     * @param description1 説明
     */
    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    /**
     * description1 説明 Get
     *
     * @return description1 説明
     */
    public String getDescription1() {
        return this.description1;
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
     * value 値 Set
     *
     * @param value 値
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * value 値 Get
     *
     * @return value 値
     */
    public String getValue() {
        return this.value;
    }
    /**
     * value1 值 Set
     *
     * @param value1 值
     */
    public void setValue1(String value1) {
        this.value1 = value1;
    }

    /**
     * value1 值 Get
     *
     * @return value1 值
     */
    public String getValue1() {
        return this.value1;
    }
    /**
     * Grid1 配置表 Set
     *
     * @param Grid1 配置表
     */
    public void setGrid1(ArrayList<S001grd1Entity> Grid1) {
        this.grid1 = Grid1;
    }

    /**
     * Grid1 配置表 Get
     *
     * @return Grid1 配置表
     */
    public ArrayList<S001grd1Entity> getGrid1() {
        return this.grid1;
    }

    public int getDesc1() {
        return 1;
    }
}