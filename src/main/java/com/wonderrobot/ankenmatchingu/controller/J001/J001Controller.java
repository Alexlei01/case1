package com.wonderrobot.ankenmatchingu.controller.J001;
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
import com.wonderrobot.ankenmatchingu.entity.J001.J001Entity;
import com.wonderrobot.ankenmatchingu.service.J001.J001InitService;
import com.wonderrobot.ankenmatchingu.service.J001.J001SearchInitService;
import com.wonderrobot.ankenmatchingu.service.J001.J001saveService;
import com.wonderrobot.ankenmatchingu.service.J001.J001saveCheckService;

import com.wonderrobot.ankenmatchingu.entity.J001.J001PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.J001.DeleteJ001PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.service.J001.J001PageSearchService;

/**
 * 案件マッチング
 * class: J001Controller
 * page: 案件明細
 */
@Api(tags = "J001案件明細")
@Controller
public class J001Controller {

	@Autowired
	private MessageUtil messageUtil;

	@Autowired
	private J001InitService j001InitService;
	@Autowired
	private J001SearchInitService j001sSearchInitService;


	@Autowired
	private J001saveCheckService j001saveCheckService;
	@Autowired
	private J001saveService j001saveService;

	@Autowired
	private J001PageSearchService J001PageSearchService;


	/**
	 * J001 - 案件明細 - 画面初期化
	 * @param j001Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="J001 - 案件明細 - 画面初期化")
	@RequestMapping(path="J001Init.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('J001|INSERT','J001|UPDATE','J001|DISPLAY','J001|DELETE')")
	@ResponseBody
	public String j001Init(@RequestBody J001Entity j001Entity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// json 176
		jsonObj = j001InitService.sj001Init(j001Entity);
		

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}
	/**
	 * J001 - 案件明細 - 標準検索初期化
	 * @param j001Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="J001 - 案件明細 - 標準検索初期化")
	@RequestMapping(path="J001sInit.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('J001|INSERT','J001|UPDATE','J001|DISPLAY','J001|DELETE')")
	@ResponseBody
	public String j001sInit(@RequestBody J001Entity j001Entity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// json 176
		jsonObj = j001sSearchInitService.sj001SearchInit(j001Entity);
		

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}



    /**
	 * J001 - 画面保存
     * @param j001Entity
     * @param result
     * @throws Exception
     */
    @ApiOperation(value="J001 - 画面保存")
    @PreAuthorize("hasAnyAuthority('J001|INSERT','J001|UPDATE','J001|DISPLAY','J001|DELETE')")
    @RequestMapping(path="J001doSave.do", method={RequestMethod.POST})
    @ResponseBody
    public String j001doSave(@RequestBody @Valid J001Entity j001Entity, BindingResult result) throws Exception {
        JSONWFCObject jsonObj = new JSONWFCObject();
        String errMsg = null;

        // validate parameter 302
        if (result.hasFieldErrors()) {
            String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
            jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);

        } else {

            // call check service
            errMsg = j001saveCheckService.saveDataCheck(j001Entity);

            // exists error
            if (!StringUtil.isNullOrBlank(errMsg)) {
                jsonObj.setMessageValue(JsonConstant.JSONID_ERR, errMsg);
            } else {
                jsonObj = j001saveService.sJ001doSave(j001Entity);
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
	 * J001 - 標準検索
	 * @param J001PageSearchRequestEntity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="J001 - 標準検索")
	@RequestMapping(path="J001PageSearch.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('J001|INSERT','J001|UPDATE','J001|DISPLAY','J001|DELETE')")
	@ResponseBody
	public String queryJ001PageSearch(@RequestBody @Valid J001PageSearchRequestEntity J001PageSearchRequestEntity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// validate parameter 410
		if (result.hasFieldErrors()) {
			// validate parameter
			String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
			jsonObj = new JSONWFCObject();
			jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);
		} else {
			// call service
			jsonObj = J001PageSearchService.queryJ001PageSearch(J001PageSearchRequestEntity);
		}

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}




	/**
	 * J001 - 標準検索データ削除
	 * @param DeleteJ001PageSearchRequestEntity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="J001 - 標準検索データ削除")
	@RequestMapping(path="J001DeletePageSearch.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('J001|INSERT','J001|UPDATE','J001|DISPLAY','J001|DELETE')")
	@ResponseBody
	public String deleteJ001PageSearch(@RequestBody @Valid DeleteJ001PageSearchRequestEntity DeleteJ001PageSearchRequestEntity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = new JSONWFCObject();

		// validate parameter 449
		if (result.hasFieldErrors()) {
			// validate parameter
			String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
			jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);
		} else {
			// call service
			J001PageSearchService.deleteJ001PageSearch(DeleteJ001PageSearchRequestEntity);
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