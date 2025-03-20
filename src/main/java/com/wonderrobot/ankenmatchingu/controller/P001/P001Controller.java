package com.wonderrobot.ankenmatchingu.controller.P001;
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
import com.wonderrobot.ankenmatchingu.entity.P001.P001Entity;
import com.wonderrobot.ankenmatchingu.service.P001.P001InitService;
import com.wonderrobot.ankenmatchingu.service.P001.P001SearchInitService;
import com.wonderrobot.ankenmatchingu.service.P001.P001saveService;
import com.wonderrobot.ankenmatchingu.service.P001.P001saveCheckService;

import com.wonderrobot.ankenmatchingu.entity.P001.P001PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.P001.DeleteP001PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.service.P001.P001PageSearchService;

/**
 * 案件マッチング
 * class: P001Controller
 * page: 技術者タグ
 */
@Api(tags = "P001技術者タグ")
@Controller
public class P001Controller {

	@Autowired
	private MessageUtil messageUtil;

	@Autowired
	private P001InitService p001InitService;
	@Autowired
	private P001SearchInitService p001sSearchInitService;


	@Autowired
	private P001saveCheckService p001saveCheckService;
	@Autowired
	private P001saveService p001saveService;

	@Autowired
	private P001PageSearchService P001PageSearchService;


	/**
	 * P001 - 技術者タグ - 画面初期化
	 * @param p001Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="P001 - 技術者タグ - 画面初期化")
	@RequestMapping(path="P001Init.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('P001|INSERT','P001|UPDATE','P001|DISPLAY','P001|DELETE')")
	@ResponseBody
	public String p001Init(@RequestBody P001Entity p001Entity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// json 176
		jsonObj = p001InitService.sp001Init(p001Entity);
		

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}
	/**
	 * P001 - 技術者タグ - 標準検索初期化
	 * @param p001Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="P001 - 技術者タグ - 標準検索初期化")
	@RequestMapping(path="P001sInit.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('P001|INSERT','P001|UPDATE','P001|DISPLAY','P001|DELETE')")
	@ResponseBody
	public String p001sInit(@RequestBody P001Entity p001Entity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// json 176
		jsonObj = p001sSearchInitService.sp001SearchInit(p001Entity);
		

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}



    /**
	 * P001 - 画面保存
     * @param p001Entity
     * @param result
     * @throws Exception
     */
    @ApiOperation(value="P001 - 画面保存")
    @PreAuthorize("hasAnyAuthority('P001|INSERT','P001|UPDATE','P001|DISPLAY','P001|DELETE')")
    @RequestMapping(path="P001doSave.do", method={RequestMethod.POST})
    @ResponseBody
    public String p001doSave(@RequestBody @Valid P001Entity p001Entity, BindingResult result) throws Exception {
        JSONWFCObject jsonObj = new JSONWFCObject();
        String errMsg = null;

        // validate parameter 302
        if (result.hasFieldErrors()) {
            String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
            jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);

        } else {

            // call check service
            errMsg = p001saveCheckService.saveDataCheck(p001Entity);

            // exists error
            if (!StringUtil.isNullOrBlank(errMsg)) {
                jsonObj.setMessageValue(JsonConstant.JSONID_ERR, errMsg);
            } else {
                jsonObj = p001saveService.sP001doSave(p001Entity);
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
	 * P001 - 標準検索
	 * @param P001PageSearchRequestEntity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="P001 - 標準検索")
	@RequestMapping(path="P001PageSearch.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('P001|INSERT','P001|UPDATE','P001|DISPLAY','P001|DELETE')")
	@ResponseBody
	public String queryP001PageSearch(@RequestBody @Valid P001PageSearchRequestEntity P001PageSearchRequestEntity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// validate parameter 410
		if (result.hasFieldErrors()) {
			// validate parameter
			String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
			jsonObj = new JSONWFCObject();
			jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);
		} else {
			// call service
			jsonObj = P001PageSearchService.queryP001PageSearch(P001PageSearchRequestEntity);
		}

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}




	/**
	 * P001 - 標準検索データ削除
	 * @param DeleteP001PageSearchRequestEntity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="P001 - 標準検索データ削除")
	@RequestMapping(path="P001DeletePageSearch.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('P001|INSERT','P001|UPDATE','P001|DISPLAY','P001|DELETE')")
	@ResponseBody
	public String deleteP001PageSearch(@RequestBody @Valid DeleteP001PageSearchRequestEntity DeleteP001PageSearchRequestEntity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = new JSONWFCObject();

		// validate parameter 449
		if (result.hasFieldErrors()) {
			// validate parameter
			String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
			jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);
		} else {
			// call service
			P001PageSearchService.deleteP001PageSearch(DeleteP001PageSearchRequestEntity);
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