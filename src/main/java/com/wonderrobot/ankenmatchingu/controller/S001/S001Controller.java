package com.wonderrobot.ankenmatchingu.controller.S001;
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
import com.wonderrobot.ankenmatchingu.entity.S001.S001Entity;
import com.wonderrobot.ankenmatchingu.service.S001.S001sms6grd1SmartSearchService;
import com.wonderrobot.ankenmatchingu.service.S001.S001InitService;
import com.wonderrobot.ankenmatchingu.service.S001.S001saveService;
import com.wonderrobot.ankenmatchingu.service.S001.S001saveCheckService;
import com.wonderrobot.ankenmatchingu.entity.S001.S001grd1Entity;


/**
 * 案件マッチング
 * class: S001Controller
 * page: 共通設定管理
 */
@Api(tags = "S001共通設定管理")
@Controller
public class S001Controller {

	@Autowired
	private MessageUtil messageUtil;

	@Autowired
	private S001sms6grd1SmartSearchService s001sms6grd1SmartSearchService;
	@Autowired
	private S001InitService s001InitService;


	@Autowired
	private S001saveCheckService s001saveCheckService;
	@Autowired
	private S001saveService s001saveService;


	/**
	 * S001画面画面 - sms6 - grd1 - Smart検索
	 * @param s001Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="S001画面画面 - sms6 - grd1 - Smart検索")
	@RequestMapping(path="S001sms6grd1SmartSearch.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('S001|INSERT','S001|UPDATE','S001|DISPLAY','S001|DELETE')")
	@ResponseBody
	public String s001sms6grd1SmartSearch(@RequestBody S001Entity s001Entity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// validate parameter 140
		if (result.hasFieldErrors()) {
			String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
			jsonObj = new JSONWFCObject();
			jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);

		// call service
		} else {
			jsonObj = s001sms6grd1SmartSearchService.sS001sms6grd1SmartSearch(s001Entity);
		}

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}

	/**
	 * S001 - 共通設定管理 - 画面初期化
	 * @param s001Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="S001 - 共通設定管理 - 画面初期化")
	@RequestMapping(path="S001Init.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('S001|INSERT','S001|UPDATE','S001|DISPLAY','S001|DELETE')")
	@ResponseBody
	public String s001Init(@RequestBody S001Entity s001Entity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// json 176
		jsonObj = s001InitService.ss001Init(s001Entity);
		

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}



    /**
	 * S001 - 画面保存
     * @param s001Entity
     * @param result
     * @throws Exception
     */
    @ApiOperation(value="S001 - 画面保存")
    @PreAuthorize("hasAnyAuthority('S001|INSERT','S001|UPDATE','S001|DISPLAY','S001|DELETE')")
    @RequestMapping(path="S001doSave.do", method={RequestMethod.POST})
    @ResponseBody
    public String s001doSave(@RequestBody @Valid S001Entity s001Entity, BindingResult result) throws Exception {
        JSONWFCObject jsonObj = new JSONWFCObject();
        String errMsg = null;

        // validate parameter 302
        if (result.hasFieldErrors()) {
            String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
            jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);

        } else {

            // call check service
            errMsg = s001saveCheckService.saveDataCheck(s001Entity);

            // exists error
            if (!StringUtil.isNullOrBlank(errMsg)) {
                jsonObj.setMessageValue(JsonConstant.JSONID_ERR, errMsg);
            } else {
                jsonObj = s001saveService.sS001doSave(s001Entity);
            }
        }

        // return json string
        String jsonObjStr = jsonObj.toJSONString();
        if (jsonObjStr == null) {
            jsonObjStr = "";
        }
        return jsonObjStr;
    }








}