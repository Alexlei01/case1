package com.wonderrobot.ankenmatchingu.controller.J003;
//UnitedController.vm
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.wonderfulfly.core.util.log.LoggerUtil;
import com.wonderfulfly.core.util.StringUtil;
import javax.validation.Valid;
import javax.servlet.http.HttpServletResponse;
import com.wonderfulfly.core.json.JSONWFCObject;
import com.wonderfulfly.core.constant.JsonConstant;
import com.wonderrobot.ankenmatchingu.common.MessageUtil;
import com.wonderrobot.ankenmatchingu.entity.J003.J003Entity;
import com.wonderrobot.ankenmatchingu.service.J003.J003InitService;
import com.wonderrobot.ankenmatchingu.service.J003.J003SearchInitService;
import com.wonderrobot.ankenmatchingu.service.J003.J003saveService;
import com.wonderrobot.ankenmatchingu.service.J003.J003saveCheckService;

import com.wonderrobot.ankenmatchingu.entity.J003.J003PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.J003.DeleteJ003PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.service.J003.J003PageSearchService;

/**
 * 案件マッチング
 * class: J003Controller
 * page: 案件タグ
 */
@Api(tags = "J003案件タグ")
@Controller
public class J003Controller {

	@Autowired
	private MessageUtil messageUtil;

	@Autowired
	private J003InitService j003InitService;
	@Autowired
	private J003SearchInitService j003sSearchInitService;


	@Autowired
	private J003saveCheckService j003saveCheckService;
	@Autowired
	private J003saveService j003saveService;

	@Autowired
	private J003PageSearchService J003PageSearchService;


	/**
	 * J003 - 案件タグ - 画面初期化
	 * @param j003Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="J003 - 案件タグ - 画面初期化")
	@RequestMapping(path="J003Init.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('J003|INSERT','J003|UPDATE','J003|DISPLAY','J003|DELETE')")
	@ResponseBody
	public String j003Init(@RequestBody J003Entity j003Entity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// json 176
		jsonObj = j003InitService.sj003Init(j003Entity);
		

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}
	/**
	 * J003 - 案件タグ - 標準検索初期化
	 * @param j003Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="J003 - 案件タグ - 標準検索初期化")
	@RequestMapping(path="J003sInit.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('J003|INSERT','J003|UPDATE','J003|DISPLAY','J003|DELETE')")
	@ResponseBody
	public String j003sInit(@RequestBody J003Entity j003Entity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// json 176
		jsonObj = j003sSearchInitService.sj003SearchInit(j003Entity);
		

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}



    /**
	 * J003 - 画面保存
     * @param j003Entity
     * @param result
     * @throws Exception
     */
    @ApiOperation(value="J003 - 画面保存")
    @PreAuthorize("hasAnyAuthority('J003|INSERT','J003|UPDATE','J003|DISPLAY','J003|DELETE')")
    @RequestMapping(path="J003doSave.do", method={RequestMethod.POST})
    @ResponseBody
    public String j003doSave(@RequestBody @Valid J003Entity j003Entity, BindingResult result) throws Exception {
        JSONWFCObject jsonObj = new JSONWFCObject();
        String errMsg = null;

        // validate parameter 302
        if (result.hasFieldErrors()) {
            String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
            jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);

        } else {

            // call check service
            errMsg = j003saveCheckService.saveDataCheck(j003Entity);

            // exists error
            if (!StringUtil.isNullOrBlank(errMsg)) {
                jsonObj.setMessageValue(JsonConstant.JSONID_ERR, errMsg);
            } else {
                jsonObj = j003saveService.sJ003doSave(j003Entity);
            }
        }

        // return json string
        String jsonObjStr = jsonObj.toJSONString();
        if (jsonObjStr == null) {
            jsonObjStr = "";
        }
        return jsonObjStr;
    }




	/**
	 * J003 - 標準検索
	 * @param J003PageSearchRequestEntity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="J003 - 標準検索")
	@RequestMapping(path="J003PageSearch.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('J003|INSERT','J003|UPDATE','J003|DISPLAY','J003|DELETE')")
	@ResponseBody
	public String queryJ003PageSearch(@RequestBody @Valid J003PageSearchRequestEntity J003PageSearchRequestEntity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// validate parameter 410
		if (result.hasFieldErrors()) {
			// validate parameter
			String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
			jsonObj = new JSONWFCObject();
			jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);
		} else {
			// call service
			jsonObj = J003PageSearchService.queryJ003PageSearch(J003PageSearchRequestEntity);
		}

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}




	/**
	 * J003 - 標準検索データ削除
	 * @param DeleteJ003PageSearchRequestEntity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="J003 - 標準検索データ削除")
	@RequestMapping(path="J003DeletePageSearch.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('J003|INSERT','J003|UPDATE','J003|DISPLAY','J003|DELETE')")
	@ResponseBody
	public String deleteJ003PageSearch(@RequestBody @Valid DeleteJ003PageSearchRequestEntity DeleteJ003PageSearchRequestEntity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = new JSONWFCObject();

		// validate parameter 449
		if (result.hasFieldErrors()) {
			// validate parameter
			String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
			jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);
		} else {
			// call service
			J003PageSearchService.deleteJ003PageSearch(DeleteJ003PageSearchRequestEntity);
			jsonObj.setScript(JsonConstant.JSONID_MSG, "削除が完了しました。");
		}

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}


}