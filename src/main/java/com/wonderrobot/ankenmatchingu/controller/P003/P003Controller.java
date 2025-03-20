package com.wonderrobot.ankenmatchingu.controller.P003;
//UnitedController.vm
import java.util.ArrayList;
import java.util.List;

import com.wonderrobot.ankenmatchingu.entity.ParamEntity;
import com.wonderrobot.ankenmatchingu.entity.S001.S001Entity;
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
import com.wonderrobot.ankenmatchingu.entity.P003.P003Entity;
import com.wonderrobot.ankenmatchingu.service.P003.P003InitService;


/**
 * 案件マッチング
 * class: P003Controller
 * page: 技術者一覧
 */
@Api(tags = "P003技術者一覧")
@Controller
public class P003Controller {

	@Autowired
	private MessageUtil messageUtil;

	@Autowired
	private P003InitService p003InitService;





	/**
	 * P003 - 技術者一覧 - 画面初期化
	 * @param p003Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="P003 - 技術者一覧 - 画面初期化")
	@RequestMapping(path="P003Init.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('P003|INSERT','P003|UPDATE','P003|DISPLAY','P003|DELETE')")
	@ResponseBody
	public String p003Init(@RequestBody P003Entity p003Entity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// json 176
		jsonObj = p003InitService.sp003Init(p003Entity);
		

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}






	/**
	 * P003- Smart検索
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="P003 - Smart検索")
	@RequestMapping(path="F20230130173125652.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('S001|INSERT','S001|UPDATE','S001|DISPLAY','S001|DELETE')")
	@ResponseBody
	public String s001sms6grd1SmartSearch(@RequestBody ParamEntity paramEntity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// validate parameter 140
		if (result.hasFieldErrors()) {
			String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
			jsonObj = new JSONWFCObject();
			jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);

			// call service
		} else {
			jsonObj = p003InitService.smartSearch(paramEntity);
		}

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}







}