package com.kopo.spring_login;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "main";
	}
	
	@RequestMapping(value = "/create_table", method = RequestMethod.GET)
	public String createTable(Locale locale, Model model) {
		
		UserDB db = new UserDB();
		boolean isSuccess = db.createTable();
		if (isSuccess) {
			model.addAttribute("m1", "테이블이 생성되었습니다.");
		} else {
			model.addAttribute("m1", "DB Error");
		}
		return "message";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/login2", method = RequestMethod.GET)
	public String login2(Locale locale, Model model) {
		return "login2";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Locale locale, Model model, HttpSession session) {
		session.invalidate();
		model.addAttribute("m1", "로그아웃 완료");
		return "message";
	}

	@RequestMapping(value = "/login_action", method = RequestMethod.POST)
	public String loginAction(HttpServletRequest request, HttpSession session, Locale locale, Model model) {

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		UserDB db = new UserDB();
		boolean isSuccess = db.logInData(id, pwd);
		if (isSuccess) {
			session.setAttribute("is_login", true);
			session.setAttribute("is_login_id", id);
			session.setAttribute("is_login_pwd", pwd);
			model.addAttribute("m1", "로그인 성공");
			return "logMsg";
		} else {
			model.addAttribute("m1", "아이디 또는 비밀번호 불일치");
			return "logFail";
		}
	}

	@RequestMapping(value = "/login_action2", method = RequestMethod.POST)
	public String loginAction2(HttpServletRequest request, HttpSession session, Locale locale, Model model) {

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		UserDB db = new UserDB();
		boolean isSuccess = db.logInData(id, pwd);
		int idx = db.logInData2(id, pwd);
		
		if (isSuccess) {
			session.setAttribute("is_login2", true);
			session.setAttribute("is_login_idx", idx);
			session.setAttribute("is_login_id", id);
			session.setAttribute("is_login_id", pwd);
			model.addAttribute("m1", "로그인 성공");
			return "logMsg2";
		} else {
			model.addAttribute("m1", "아이디 또는 비밀번호 불일치");
			return "logFail";
		}
	}
	
	

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listMethod(HttpSession session, Locale locale, Model model) {
		try {
			String isLogin_id = (String) session.getAttribute("is_login_id");
			String isLogin_pwd = (String) session.getAttribute("is_login_pwd");
			UserInfo userinfo = new UserInfo();
			UserDB db = new UserDB();
//			System.out.println(isLogin_id);
//			System.out.println(isLogin_pwd);

			if (isLogin_id != null && isLogin_pwd != null && isLogin_id.equals("knd") 
					&& isLogin_pwd.equals("1")) {
				String htmlString = db.selectData();
				model.addAttribute("listInTbody", htmlString);
				return "list";
			} else if(isLogin_id != null && isLogin_pwd != null) {
				String htmlString = db.selectData2();
				model.addAttribute("listInTbody", htmlString);
				return "list2";
			} else {
				model.addAttribute("m1", "로그인이 필요합니다.");
				return "message";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("m1", "로그인이 필요합니다.");
			return "message";
		}
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insertMethod(Locale locale, Model model) {
		return "insert";
	}

	@RequestMapping(value = "/insert_action", method = RequestMethod.POST)
	public String insertAction(Locale locale, Model model, @RequestParam("id") String id,
			@RequestParam("pwd") String pwd, @RequestParam("user_name") String name,
			@RequestParam("birthday") String birthday, @RequestParam("address") String address) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = sdf.format(Calendar.getInstance().getTime());
		UserInfo userinfo = new UserInfo(id, pwd, name, birthday, address, now, now);

		UserDB db = new UserDB();
		boolean isSuccess = db.insertData(userinfo);
		if (isSuccess) {
			model.addAttribute("m1", "회원가입 완료");
		} else {
			model.addAttribute("m1", "아이디 중복 또는 DB 에러");
		}
		return "message";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateMethod(Locale locale, Model model, @RequestParam("idx") int idx) {
		UserDB db = new UserDB();
		UserInfo selectUser = db.detailsData(idx);
		if (selectUser != null) {
			model.addAttribute("idx", selectUser.idx);
			model.addAttribute("id", selectUser.id);
			model.addAttribute("pwd", selectUser.pwd);
			model.addAttribute("nameInJspValue", selectUser.name);
			model.addAttribute("birthday", selectUser.birthday);
			model.addAttribute("address", selectUser.address);
		}
		return "update";
	}

	@RequestMapping(value = "/update_action", method = RequestMethod.GET)
	public String updateAction(Locale locale, Model model, 
			@RequestParam("idx") int idx, 
			@RequestParam("id") String id,
			@RequestParam("pwd") String pwd, 
			@RequestParam("user_name") String name,
			@RequestParam("birthday") String birthday, 
			@RequestParam("address") String address) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = sdf.format(Calendar.getInstance().getTime());

		UserInfo userinfo = new UserInfo(idx, id, pwd, name, birthday, address, now);
		UserDB userDB = new UserDB();
		boolean isSuccess = userDB.updateData(userinfo);
		if (isSuccess) {
			model.addAttribute("m1", "수정 완료");
		} else {
			model.addAttribute("m1", "DB Error");
		}
		return "message";
	}

	@RequestMapping(value = "/update2", method = RequestMethod.GET)
	public String updateMethod2(HttpServletRequest request, HttpSession session, Locale locale, Model model) {
		try {
			boolean isLogin = (Boolean) session.getAttribute("is_login2");
			if(isLogin) {
				int idx = (Integer) session.getAttribute("is_login_idx");
				UserDB db = new UserDB();
				UserInfo userinfo = db.detailsData(idx);
			
				model.addAttribute("idx", userinfo.idx);
				model.addAttribute("id", userinfo.id);
				model.addAttribute("nameInJspValue", userinfo.name);
				model.addAttribute("birthday", userinfo.birthday);
				model.addAttribute("address", userinfo.address);
				return "update2";
				
			} else {
				model.addAttribute("m1", "로그인이 필요합니다. else");
				return "message";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("m1", "메인 화면에서 로그인을 먼저 해주세요.");
			return "message";
		}

	}

	
	@RequestMapping(value = "/update_action2", method = RequestMethod.POST)
	public String updateAction2(HttpServletRequest request, Locale locale, Model model) {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = sdf.format(Calendar.getInstance().getTime());
		
		String idxString = request.getParameter("idx");
		int idx = Integer.parseInt(idxString);
		String pwd = request.getParameter("pwd2");
		String name = request.getParameter("user_name");
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		
		UserInfo userinfo1 = new UserInfo(idx, pwd, name, birthday, address, now);
		UserInfo userinfo2 = new UserInfo(idx, name, birthday, address, now);
		UserDB db = new UserDB();
		boolean isSuccess = false;
		if(pwd.isEmpty()) {
			isSuccess = db.updateData2(userinfo2);
		} else {
			isSuccess = db.updateData2(userinfo1);
		}
		if (isSuccess) {
			model.addAttribute("m1", "수정 완료");
		} else {
			model.addAttribute("m1", "DB Error");
		}
		return "message";
	}
	

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteAction(Locale locale, Model model, @RequestParam("idx") int idx) {
		UserDB db = new UserDB();
		UserInfo selectUser = db.detailsData(idx);
		if (selectUser != null) {
			db.deleteData(idx);
		}
		model.addAttribute("m1", "데이터가 삭제되었습니다.");
		return "message";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchMethod(Locale locale, Model model) {
		return "search";
	}

	@RequestMapping(value = "/search_action", method = RequestMethod.GET)
	public String searchAction(Locale locale, Model model, @RequestParam("user_name") String name) {
		UserDB db = new UserDB();
		String htmlString = db.searchData(name);
		model.addAttribute("listInTbody", htmlString);
		return "list";
	}

}
