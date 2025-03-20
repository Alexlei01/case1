package com.wonderrobot.ankenmatchingu.controller.C001;
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
import com.wonderrobot.ankenmatchingu.entity.C001.C001Entity;
import com.wonderrobot.ankenmatchingu.service.C001.C001InitService;
import com.wonderrobot.ankenmatchingu.service.C001.C001SearchInitService;
import com.wonderrobot.ankenmatchingu.service.C001.C001saveService;
import com.wonderrobot.ankenmatchingu.service.C001.C001saveCheckService;

import com.wonderrobot.ankenmatchingu.entity.C001.C001PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.C001.DeleteC001PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.service.C001.C001PageSearchService;

/**
 * 案件マッチング
 * class: C001Controller
 * page: コミュニケーション
 */
@Api(tags = "C001コミュニケーション")
@Controller
public class C001Controller {

	@Autowired
	private MessageUtil messageUtil;

	@Autowired
	private C001InitService c001InitService;
	@Autowired
	private C001SearchInitService c001sSearchInitService;


	@Autowired
	private C001saveCheckService c001saveCheckService;
	@Autowired
	private C001saveService c001saveService;

	@Autowired
	private C001PageSearchService C001PageSearchService;


	/**
	 * C001 - コミュニケーション - 画面初期化
	 * @param c001Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="C001 - コミュニケーション - 画面初期化")
	@RequestMapping(path="C001Init.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('C001|INSERT','C001|UPDATE','C001|DISPLAY','C001|DELETE')")
	@ResponseBody
	public String c001Init(@RequestBody C001Entity c001Entity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// json 176
		jsonObj = c001InitService.sc001Init(c001Entity);
		

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}
	/**
	 * C001 - コミュニケーション - 標準検索初期化
	 * @param c001Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="C001 - コミュニケーション - 標準検索初期化")
	@RequestMapping(path="C001sInit.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('C001|INSERT','C001|UPDATE','C001|DISPLAY','C001|DELETE')")
	@ResponseBody
	public String c001sInit(@RequestBody C001Entity c001Entity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// json 176
		jsonObj = c001sSearchInitService.sc001SearchInit(c001Entity);
		

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}



    /**
	 * C001 - 画面保存
     * @param c001Entity
     * @param result
     * @throws Exception
     */
    @ApiOperation(value="C001 - 画面保存")
    @PreAuthorize("hasAnyAuthority('C001|INSERT','C001|UPDATE','C001|DISPLAY','C001|DELETE')")
    @RequestMapping(path="C001doSave.do", method={RequestMethod.POST})
    @ResponseBody
    public String c001doSave(@RequestBody @Valid C001Entity c001Entity, BindingResult result) throws Exception {
        JSONWFCObject jsonObj = new JSONWFCObject();
        String errMsg = null;

        // validate parameter 302
        if (result.hasFieldErrors()) {
            String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
            jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);

        } else {

            // call check service
            errMsg = c001saveCheckService.saveDataCheck(c001Entity);

            // exists error
            if (!StringUtil.isNullOrBlank(errMsg)) {
                jsonObj.setMessageValue(JsonConstant.JSONID_ERR, errMsg);
            } else {
                jsonObj = c001saveService.sC001doSave(c001Entity);
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
	 * C001 - 標準検索
	 * @param C001PageSearchRequestEntity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="C001 - 標準検索")
	@RequestMapping(path="C001PageSearch.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('C001|INSERT','C001|UPDATE','C001|DISPLAY','C001|DELETE')")
	@ResponseBody
	public String queryC001PageSearch(@RequestBody @Valid C001PageSearchRequestEntity C001PageSearchRequestEntity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// validate parameter 410
		if (result.hasFieldErrors()) {
			// validate parameter
			String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
			jsonObj = new JSONWFCObject();
			jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);
		} else {
			// call service
			jsonObj = C001PageSearchService.queryC001PageSearch(C001PageSearchRequestEntity);
		}

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}




	/**
	 * C001 - 標準検索データ削除
	 * @param DeleteC001PageSearchRequestEntity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="C001 - 標準検索データ削除")
	@RequestMapping(path="C001DeletePageSearch.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('C001|INSERT','C001|UPDATE','C001|DISPLAY','C001|DELETE')")
	@ResponseBody
	public String deleteC001PageSearch(@RequestBody @Valid DeleteC001PageSearchRequestEntity DeleteC001PageSearchRequestEntity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = new JSONWFCObject();

		// validate parameter 449
		if (result.hasFieldErrors()) {
			// validate parameter
			String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
			jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);
		} else {
			// call service
			C001PageSearchService.deleteC001PageSearch(DeleteC001PageSearchRequestEntity);
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