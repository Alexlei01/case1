package com.wonderrobot.ankenmatchingu.controller;
// firstController.vm
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 案件マッチング Page: 
 */


@Controller
public class FirstController {

	@Autowired
	private HttpServletRequest request;

	/**
	 * Login method
	 */
	@RequestMapping("login")
	public String index() {
		return "login";
	}

	/**
	 * logoutGamenn method
	 */
	@RequestMapping("logout")
	public String logoutGamenn() {
		HttpSession session = request.getSession();
		session.invalidate();
		return "login";
	}

	/**
	 * homePage method
	 */
	@RequestMapping("/")
	public String homePage() {
		return "S001";
	}

	/**
	 * showpdf method
	 */
	@RequestMapping("showpdf")
	public String showpdf() {
		return "showpdf";
	}
	/**
	 * J001を遷移 method
	 * 
	 */
	@RequestMapping("J001")
	public String J001Page() {
		return "J001";
	}
	/**
	 * J002を遷移 method
	 * 
	 */
	@RequestMapping("J002")
	public String J002Page() {
		return "J002";
	}
	/**
	 * J002sを遷移 method
	 * 
	 */
	@RequestMapping("J002s")
	public String J002sPage() {
		return "J002s";
	}
	/**
	 * J003を遷移 method
	 * 
	 */
	@RequestMapping("J003")
	public String J003Page() {
		return "J003";
	}
	/**
	 * J003sを遷移 method
	 * 
	 */
	@RequestMapping("J003s")
	public String J003sPage() {
		return "J003s";
	}
	/**
	 * J004を遷移 method
	 * 
	 */
	@RequestMapping("J004")
	public String J004Page() {
		return "J004";
	}
	/**
	 * P002を遷移 method
	 * 
	 */
	@RequestMapping("P002")
	public String P002Page() {
		return "P002";
	}
	/**
	 * P001を遷移 method
	 * 
	 */
	@RequestMapping("P001")
	public String P001Page() {
		return "P001";
	}
	/**
	 * P001sを遷移 method
	 * 
	 */
	@RequestMapping("P001s")
	public String P001sPage() {
		return "P001s";
	}
	/**
	 * P003を遷移 method
	 * 
	 */
	@RequestMapping("P003")
	public String P003Page() {
		return "P003";
	}
	/**
	 * C002を遷移 method
	 * 
	 */
	@RequestMapping("C002")
	public String C002Page() {
		return "C002";
	}
	/**
	 * C002sを遷移 method
	 * 
	 */
	@RequestMapping("C002s")
	public String C002sPage() {
		return "C002s";
	}
	/**
	 * C001を遷移 method
	 * 
	 */
	@RequestMapping("C001")
	public String C001Page() {
		return "C001";
	}
	/**
	 * C001sを遷移 method
	 * 
	 */
	@RequestMapping("C001s")
	public String C001sPage() {
		return "C001s";
	}
	/**
	 * S001を遷移 method
	 * 
	 */
	@RequestMapping("S001")
	public String S001Page() {
		return "S001";
	}
	/**
	 * T001を遷移 method
	 * 
	 */
	@RequestMapping("T001")
	public String T001Page() {
		return "T001";
	}
	/**
	 * T001sを遷移 method
	 * 
	 */
	@RequestMapping("T001s")
	public String T001sPage() {
		return "T001s";
	}

}