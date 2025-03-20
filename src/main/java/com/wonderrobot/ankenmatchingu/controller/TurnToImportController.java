 package com.wonderrobot.ankenmatchingu.controller;
// TurnToImportController.vm
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TurnToImportController
 **/
@Controller
public class TurnToImportController {

    @RequestMapping("turnTouinout001.do")
    public String turnTouinout001() {
        return "uinout001";
    }
}