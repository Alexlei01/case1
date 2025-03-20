package com.wonderrobot.ankenmatchingu.controller;
// BasicController.vm
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
import com.wonderrobot.ankenmatchingu.entity.UserPasswordRequestEntity;
import com.wonderrobot.ankenmatchingu.service.UserPasswordService;

/**
 * UserPasswordController
 */
@Controller
public class UserPasswordController {

	@Autowired
	private MessageUtil MessageUtil;
	@Autowired
	private UserPasswordService UserPasswordService;

	/**
	 * Change user password.
	 * @param UserPasswordRequestEntity
	 * @param result
	 * @throws Exception
	 */
	@RequestMapping(path="changeUserPassword.do", method={RequestMethod.POST})
	@ResponseBody
	public String updateUserPassword(@Valid UserPasswordRequestEntity UserPasswordRequestEntity, BindingResult result) throws Exception {
		JSONWFCObject jsonObj = new JSONWFCObject();
		if (result.hasFieldErrors()) {
			String messageError = MessageUtil.message(result.getFieldError().getDefaultMessage());
			jsonObj.setMessageValue(JsonConstant.JSONID_ERR, messageError);
		} else {
			UserPasswordService.updateUserPassword(UserPasswordRequestEntity);
			jsonObj.setScript(JsonConstant.JSONID_MSG, "パスワードのリセットが完了しました。");
		}
		String jsonObjStr = jsonObj.toJSONString();
		if (jsonObjStr == null) {
			jsonObjStr = "";
		}
		return jsonObjStr;
	}

}
