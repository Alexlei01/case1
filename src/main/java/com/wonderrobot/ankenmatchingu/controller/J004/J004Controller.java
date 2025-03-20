package com.wonderrobot.ankenmatchingu.controller.J004;
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
import com.wonderrobot.ankenmatchingu.entity.J004.J004Entity;
import com.wonderrobot.ankenmatchingu.service.J004.J004InitService;


/**
 * 案件マッチング
 * class: J004Controller
 * page: 案件一覧
 */
@Api(tags = "J004案件一覧")
@Controller
public class J004Controller {

	@Autowired
	private MessageUtil messageUtil;

	@Autowired
	private J004InitService j004InitService;





	/**
	 * J004 - 案件一覧 - 画面初期化
	 * @param j004Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="J004 - 案件一覧 - 画面初期化")
	@RequestMapping(path="J004Init.do", method={RequestMethod.POST})
	@PreAuthorize("hasAnyAuthority('J004|INSERT','J004|UPDATE','J004|DISPLAY','J004|DELETE')")
	@ResponseBody
	public String j004Init(@RequestBody J004Entity j004Entity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = null;

		// json 176
		jsonObj = j004InitService.sj004Init(j004Entity);
		

		// return json string
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}


	/**
	 * J004 -> J001 - 画面遷移
	 * @param j004Entity
	 * @param result
	 * @throws Exception
	 */
	@ApiOperation(value="J004 -> J001 - 画面遷移")
	@PreAuthorize("hasAnyAuthority('J004|INSERT','J004|UPDATE','J004|DISPLAY','J004|DELETE')")
	@RequestMapping(path="L00003.do", method={RequestMethod.POST})
	public ModelAndView l00003(@RequestBody @Valid J004Entity j004Entity, BindingResult result) throws Exception {

		// Parameter check 264
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("J001");
        modelAndView.addObject("mode","1");
		modelAndView.addObject("actflg","2");
		modelAndView.addObject("txt2", j004Entity.getId());
		return modelAndView;
	}









}