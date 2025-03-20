package com.wonderrobot.ankenmatchingu.controller.P002;
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
import com.wonderrobot.ankenmatchingu.entity.P002.P002Entity;
import com.wonderrobot.ankenmatchingu.service.P002.P002InitService;
import com.wonderrobot.ankenmatchingu.service.P002.P002SearchInitService;
import com.wonderrobot.ankenmatchingu.service.P002.P002saveService;
import com.wonderrobot.ankenmatchingu.service.P002.P002saveCheckService;

import com.wonderrobot.ankenmatchingu.entity.P002.P002PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.P002.DeleteP002PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.service.P002.P002PageSearchService;

/**
 * 案件マッチング
 * class: P002Controller
 * page: 技術者明細
 */
@Api(tags = "P002技術者明細")
@Controller
public class P002Controller {

	@Autowired
	private MessageUtil messageUtil;

	@Autowired
	private P002InitService p002InitService;
	@Autowired
	private P002SearchInitService p002sSearchInitService;


	@Autowired
	private P002saveCheckService p002saveCheckService;
	@Autowired
	private P002saveService p002saveService;

	@Autowired
	private P002PageSearchService P002PageSearchService;


	/**
	 * P002 - 技術者明細 - 画面初期化
	 * @param p002Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="P002 - 技術者明細 - 画面初期化")
	@RequestMapping(path="P002Init.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('P002|INSERT','P002|UPDATE','P002|DISPLAY','P002|DELETE')")
	@ResponseBody
	public String p002Init(@RequestBody P002Entity p002Entity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// json 176
		jsonObj = p002InitService.sp002Init(p002Entity);
		

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}
	/**
	 * P002 - 技術者明細 - 標準検索初期化
	 * @param p002Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="P002 - 技術者明細 - 標準検索初期化")
	@RequestMapping(path="P002sInit.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('P002|INSERT','P002|UPDATE','P002|DISPLAY','P002|DELETE')")
	@ResponseBody
	public String p002sInit(@RequestBody P002Entity p002Entity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// json 176
		jsonObj = p002sSearchInitService.sp002SearchInit(p002Entity);
		

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}



    /**
	 * P002 - 画面保存
     * @param p002Entity
     * @param result
     * @throws Exception
     */
    @ApiOperation(value="P002 - 画面保存")
    @PreAuthorize("hasAnyAuthority('P002|INSERT','P002|UPDATE','P002|DISPLAY','P002|DELETE')")
    @RequestMapping(path="P002doSave.do", method={RequestMethod.POST})
    @ResponseBody
    public String p002doSave(@RequestBody @Valid P002Entity p002Entity, BindingResult result) throws Exception {
        JSONWFCObject jsonObj = new JSONWFCObject();
        String errMsg = null;

        // validate parameter 302
        if (result.hasFieldErrors()) {
            String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
            jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);

        } else {

            // call check service
            errMsg = p002saveCheckService.saveDataCheck(p002Entity);

            // exists error
            if (!StringUtil.isNullOrBlank(errMsg)) {
                jsonObj.setMessageValue(JsonConstant.JSONID_ERR, errMsg);
            } else {
                jsonObj = p002saveService.sP002doSave(p002Entity);
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
	 * P002 - 標準検索
	 * @param P002PageSearchRequestEntity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="P002 - 標準検索")
	@RequestMapping(path="P002PageSearch.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('P002|INSERT','P002|UPDATE','P002|DISPLAY','P002|DELETE')")
	@ResponseBody
	public String queryP002PageSearch(@RequestBody @Valid P002PageSearchRequestEntity P002PageSearchRequestEntity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// validate parameter 410
		if (result.hasFieldErrors()) {
			// validate parameter
			String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
			jsonObj = new JSONWFCObject();
			jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);
		} else {
			// call service
			jsonObj = P002PageSearchService.queryP002PageSearch(P002PageSearchRequestEntity);
		}

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}




	/**
	 * P002 - 標準検索データ削除
	 * @param DeleteP002PageSearchRequestEntity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="P002 - 標準検索データ削除")
	@RequestMapping(path="P002DeletePageSearch.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('P002|INSERT','P002|UPDATE','P002|DISPLAY','P002|DELETE')")
	@ResponseBody
	public String deleteP002PageSearch(@RequestBody @Valid DeleteP002PageSearchRequestEntity DeleteP002PageSearchRequestEntity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = new JSONWFCObject();

		// validate parameter 449
		if (result.hasFieldErrors()) {
			// validate parameter
			String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
			jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);
		} else {
			// call service
			P002PageSearchService.deleteP002PageSearch(DeleteP002PageSearchRequestEntity);
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