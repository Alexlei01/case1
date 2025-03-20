package com.wonderrobot.ankenmatchingu.controller.T001;
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
import com.wonderrobot.ankenmatchingu.entity.T001.T001Entity;
import com.wonderrobot.ankenmatchingu.service.T001.T001InitService;
import com.wonderrobot.ankenmatchingu.service.T001.T001SearchInitService;
import com.wonderrobot.ankenmatchingu.service.T001.T001saveService;
import com.wonderrobot.ankenmatchingu.service.T001.T001saveCheckService;

import com.wonderrobot.ankenmatchingu.entity.T001.T001PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.T001.DeleteT001PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.service.T001.T001PageSearchService;

/**
 * 案件マッチング
 * class: T001Controller
 * page: タグ管理
 */
@Api(tags = "T001タグ管理")
@Controller
public class T001Controller {

	@Autowired
	private MessageUtil messageUtil;

	@Autowired
	private T001InitService t001InitService;
	@Autowired
	private T001SearchInitService t001sSearchInitService;


	@Autowired
	private T001saveCheckService t001saveCheckService;
	@Autowired
	private T001saveService t001saveService;

	@Autowired
	private T001PageSearchService T001PageSearchService;


	/**
	 * T001 - タグ管理 - 画面初期化
	 * @param t001Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="T001 - タグ管理 - 画面初期化")
	@RequestMapping(path="T001Init.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('T001|INSERT','T001|UPDATE','T001|DISPLAY','T001|DELETE')")
	@ResponseBody
	public String t001Init(@RequestBody T001Entity t001Entity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// json 176
		jsonObj = t001InitService.st001Init(t001Entity);
		

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}
	/**
	 * T001 - タグ管理 - 標準検索初期化
	 * @param t001Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="T001 - タグ管理 - 標準検索初期化")
	@RequestMapping(path="T001sInit.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('T001|INSERT','T001|UPDATE','T001|DISPLAY','T001|DELETE')")
	@ResponseBody
	public String t001sInit(@RequestBody T001Entity t001Entity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// json 176
		jsonObj = t001sSearchInitService.st001SearchInit(t001Entity);
		

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}



    /**
	 * T001 - 画面保存
     * @param t001Entity
     * @param result
     * @throws Exception
     */
    @ApiOperation(value="T001 - 画面保存")
    @PreAuthorize("hasAnyAuthority('T001|INSERT','T001|UPDATE','T001|DISPLAY','T001|DELETE')")
    @RequestMapping(path="T001doSave.do", method={RequestMethod.POST})
    @ResponseBody
    public String t001doSave(@RequestBody @Valid T001Entity t001Entity, BindingResult result) throws Exception {
        JSONWFCObject jsonObj = new JSONWFCObject();
        String errMsg = null;

        // validate parameter 302
        if (result.hasFieldErrors()) {
            String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
            jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);

        } else {

            // call check service
            errMsg = t001saveCheckService.saveDataCheck(t001Entity);

            // exists error
            if (!StringUtil.isNullOrBlank(errMsg)) {
                jsonObj.setMessageValue(JsonConstant.JSONID_ERR, errMsg);
            } else {
                jsonObj = t001saveService.sT001doSave(t001Entity);
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
	 * T001 - 標準検索
	 * @param T001PageSearchRequestEntity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="T001 - 標準検索")
	@RequestMapping(path="T001PageSearch.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('T001|INSERT','T001|UPDATE','T001|DISPLAY','T001|DELETE')")
	@ResponseBody
	public String queryT001PageSearch(@RequestBody @Valid T001PageSearchRequestEntity T001PageSearchRequestEntity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// validate parameter 410
		if (result.hasFieldErrors()) {
			// validate parameter
			String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
			jsonObj = new JSONWFCObject();
			jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);
		} else {
			// call service
			jsonObj = T001PageSearchService.queryT001PageSearch(T001PageSearchRequestEntity);
		}

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}




	/**
	 * T001 - 標準検索データ削除
	 * @param DeleteT001PageSearchRequestEntity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="T001 - 標準検索データ削除")
	@RequestMapping(path="T001DeletePageSearch.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('T001|INSERT','T001|UPDATE','T001|DISPLAY','T001|DELETE')")
	@ResponseBody
	public String deleteT001PageSearch(@RequestBody @Valid DeleteT001PageSearchRequestEntity DeleteT001PageSearchRequestEntity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = new JSONWFCObject();

		// validate parameter 449
		if (result.hasFieldErrors()) {
			// validate parameter
			String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
			jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);
		} else {
			// call service
			T001PageSearchService.deleteT001PageSearch(DeleteT001PageSearchRequestEntity);
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