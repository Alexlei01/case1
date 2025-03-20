package com.wonderrobot.ankenmatchingu.controller.C002;
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
import com.wonderrobot.ankenmatchingu.entity.C002.C002Entity;
import com.wonderrobot.ankenmatchingu.service.C002.C002InitService;
import com.wonderrobot.ankenmatchingu.service.C002.C002SearchInitService;
import com.wonderrobot.ankenmatchingu.service.C002.C002saveService;
import com.wonderrobot.ankenmatchingu.service.C002.C002saveCheckService;

import com.wonderrobot.ankenmatchingu.entity.C002.C002PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.C002.DeleteC002PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.service.C002.C002PageSearchService;

/**
 * 案件マッチング
 * class: C002Controller
 * page: コミュニケーション記録
 */
@Api(tags = "C002コミュニケーション記録")
@Controller
public class C002Controller {

	@Autowired
	private MessageUtil messageUtil;

	@Autowired
	private C002InitService c002InitService;
	@Autowired
	private C002SearchInitService c002sSearchInitService;


	@Autowired
	private C002saveCheckService c002saveCheckService;
	@Autowired
	private C002saveService c002saveService;

	@Autowired
	private C002PageSearchService C002PageSearchService;


	/**
	 * C002 - コミュニケーション記録 - 画面初期化
	 * @param c002Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="C002 - コミュニケーション記録 - 画面初期化")
	@RequestMapping(path="C002Init.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('C002|INSERT','C002|UPDATE','C002|DISPLAY','C002|DELETE')")
	@ResponseBody
	public String c002Init(@RequestBody C002Entity c002Entity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// json 176
		jsonObj = c002InitService.sc002Init(c002Entity);
		

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}
	/**
	 * C002 - コミュニケーション記録 - 標準検索初期化
	 * @param c002Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="C002 - コミュニケーション記録 - 標準検索初期化")
	@RequestMapping(path="C002sInit.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('C002|INSERT','C002|UPDATE','C002|DISPLAY','C002|DELETE')")
	@ResponseBody
	public String c002sInit(@RequestBody C002Entity c002Entity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// json 176
		jsonObj = c002sSearchInitService.sc002SearchInit(c002Entity);
		

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}



    /**
	 * C002 - 画面保存
     * @param c002Entity
     * @param result
     * @throws Exception
     */
    @ApiOperation(value="C002 - 画面保存")
    @PreAuthorize("hasAnyAuthority('C002|INSERT','C002|UPDATE','C002|DISPLAY','C002|DELETE')")
    @RequestMapping(path="C002doSave.do", method={RequestMethod.POST})
    @ResponseBody
    public String c002doSave(@RequestBody @Valid C002Entity c002Entity, BindingResult result) throws Exception {
        JSONWFCObject jsonObj = new JSONWFCObject();
        String errMsg = null;

        // validate parameter 302
        if (result.hasFieldErrors()) {
            String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
            jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);

        } else {

            // call check service
            errMsg = c002saveCheckService.saveDataCheck(c002Entity);

            // exists error
            if (!StringUtil.isNullOrBlank(errMsg)) {
                jsonObj.setMessageValue(JsonConstant.JSONID_ERR, errMsg);
            } else {
                jsonObj = c002saveService.sC002doSave(c002Entity);
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
	 * C002 - 標準検索
	 * @param C002PageSearchRequestEntity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="C002 - 標準検索")
	@RequestMapping(path="C002PageSearch.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('C002|INSERT','C002|UPDATE','C002|DISPLAY','C002|DELETE')")
	@ResponseBody
	public String queryC002PageSearch(@RequestBody @Valid C002PageSearchRequestEntity C002PageSearchRequestEntity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// validate parameter 410
		if (result.hasFieldErrors()) {
			// validate parameter
			String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
			jsonObj = new JSONWFCObject();
			jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);
		} else {
			// call service
			jsonObj = C002PageSearchService.queryC002PageSearch(C002PageSearchRequestEntity);
		}

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}




	/**
	 * C002 - 標準検索データ削除
	 * @param DeleteC002PageSearchRequestEntity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="C002 - 標準検索データ削除")
	@RequestMapping(path="C002DeletePageSearch.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('C002|INSERT','C002|UPDATE','C002|DISPLAY','C002|DELETE')")
	@ResponseBody
	public String deleteC002PageSearch(@RequestBody @Valid DeleteC002PageSearchRequestEntity DeleteC002PageSearchRequestEntity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = new JSONWFCObject();

		// validate parameter 449
		if (result.hasFieldErrors()) {
			// validate parameter
			String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
			jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);
		} else {
			// call service
			C002PageSearchService.deleteC002PageSearch(DeleteC002PageSearchRequestEntity);
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