package com.wonderrobot.ankenmatchingu.controller.J002;
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
import com.wonderrobot.ankenmatchingu.entity.J002.J002Entity;
import com.wonderrobot.ankenmatchingu.service.J002.J002InitService;
import com.wonderrobot.ankenmatchingu.service.J002.J002SearchInitService;
import com.wonderrobot.ankenmatchingu.service.J002.J002saveService;
import com.wonderrobot.ankenmatchingu.service.J002.J002saveCheckService;

import com.wonderrobot.ankenmatchingu.entity.J002.J002PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.entity.J002.DeleteJ002PageSearchRequestEntity;
import com.wonderrobot.ankenmatchingu.service.J002.J002PageSearchService;

/**
 * 案件マッチング
 * class: J002Controller
 * page: 案件マッチング
 */
@Api(tags = "J002案件マッチング")
@Controller
public class J002Controller {

	@Autowired
	private MessageUtil messageUtil;

	@Autowired
	private J002InitService j002InitService;
	@Autowired
	private J002SearchInitService j002sSearchInitService;


	@Autowired
	private J002saveCheckService j002saveCheckService;
	@Autowired
	private J002saveService j002saveService;

	@Autowired
	private J002PageSearchService J002PageSearchService;


	/**
	 * J002 - 案件マッチング - 画面初期化
	 * @param j002Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="J002 - 案件マッチング - 画面初期化")
	@RequestMapping(path="J002Init.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('J002|INSERT','J002|UPDATE','J002|DISPLAY','J002|DELETE')")
	@ResponseBody
	public String j002Init(@RequestBody J002Entity j002Entity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// json 176
		jsonObj = j002InitService.sj002Init(j002Entity);
		

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}
	/**
	 * J002 - 案件マッチング - 標準検索初期化
	 * @param j002Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="J002 - 案件マッチング - 標準検索初期化")
	@RequestMapping(path="J002sInit.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('J002|INSERT','J002|UPDATE','J002|DISPLAY','J002|DELETE')")
	@ResponseBody
	public String j002sInit(@RequestBody J002Entity j002Entity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// json 176
		jsonObj = j002sSearchInitService.sj002SearchInit(j002Entity);
		

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}


	/**
	 * J002 -> J001 - 画面遷移
	 * @param j002Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="J002 -> J001 - 画面遷移")
	@PreAuthorize("hasAnyAuthority('J002|INSERT','J002|UPDATE','J002|DISPLAY','J002|DELETE')")
	@RequestMapping(path="L00001.do", method={RequestMethod.POST})
	public ModelAndView l00001(@RequestBody @Valid J002Entity j002Entity, BindingResult result) throws Exception {

		// Parameter check 264
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("J001");
        modelAndView.addObject("mode","1");
		modelAndView.addObject("actflg","2");
		modelAndView.addObject("txt2", j002Entity.getTxt2());
		return modelAndView;
	}
	/**
	 * J002 -> P002 - 画面遷移
	 * @param j002Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="J002 -> P002 - 画面遷移")
	@PreAuthorize("hasAnyAuthority('J002|INSERT','J002|UPDATE','J002|DISPLAY','J002|DELETE')")
	@RequestMapping(path="L00002.do", method={RequestMethod.POST})
	public ModelAndView l00002(@RequestBody @Valid J002Entity j002Entity, BindingResult result) throws Exception {

		// Parameter check 264
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("P002");
        modelAndView.addObject("mode","1");
		modelAndView.addObject("actflg","2");
		modelAndView.addObject("txt2", j002Entity.getPeopleid());
		return modelAndView;
	}

    /**
	 * J002 - 画面保存
     * @param j002Entity
     * @param result
     * @throws Exception
     */
    @ApiOperation(value="J002 - 画面保存")
    @PreAuthorize("hasAnyAuthority('J002|INSERT','J002|UPDATE','J002|DISPLAY','J002|DELETE')")
    @RequestMapping(path="J002doSave.do", method={RequestMethod.POST})
    @ResponseBody
    public String j002doSave(@RequestBody @Valid J002Entity j002Entity, BindingResult result) throws Exception {
        JSONWFCObject jsonObj = new JSONWFCObject();
        String errMsg = null;

        // validate parameter 302
        if (result.hasFieldErrors()) {
            String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
            jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);

        } else {

            // call check service
            errMsg = j002saveCheckService.saveDataCheck(j002Entity);

            // exists error
            if (!StringUtil.isNullOrBlank(errMsg)) {
                jsonObj.setMessageValue(JsonConstant.JSONID_ERR, errMsg);
            } else {
                jsonObj = j002saveService.sJ002doSave(j002Entity);
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
	 * J002 - 標準検索
	 * @param J002PageSearchRequestEntity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="J002 - 標準検索")
	@RequestMapping(path="J002PageSearch.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('J002|INSERT','J002|UPDATE','J002|DISPLAY','J002|DELETE')")
	@ResponseBody
	public String queryJ002PageSearch(@RequestBody @Valid J002PageSearchRequestEntity J002PageSearchRequestEntity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// validate parameter 410
		if (result.hasFieldErrors()) {
			// validate parameter
			String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
			jsonObj = new JSONWFCObject();
			jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);
		} else {
			// call service
			jsonObj = J002PageSearchService.queryJ002PageSearch(J002PageSearchRequestEntity);
		}

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}




	/**
	 * J002 - 標準検索データ削除
	 * @param DeleteJ002PageSearchRequestEntity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="J002 - 標準検索データ削除")
	@RequestMapping(path="J002DeletePageSearch.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('J002|INSERT','J002|UPDATE','J002|DISPLAY','J002|DELETE')")
	@ResponseBody
	public String deleteJ002PageSearch(@RequestBody @Valid DeleteJ002PageSearchRequestEntity DeleteJ002PageSearchRequestEntity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = new JSONWFCObject();

		// validate parameter 449
		if (result.hasFieldErrors()) {
			// validate parameter
			String messageError = messageUtil.message(result.getFieldError().getDefaultMessage());
			jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);
		} else {
			// call service
			J002PageSearchService.deleteJ002PageSearch(DeleteJ002PageSearchRequestEntity);
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