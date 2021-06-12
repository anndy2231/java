package com.kopo.memoproject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

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
	public String main(Locale locale, Model model) {
		return "main";
	}

	@RequestMapping(value = "/create_table", method = RequestMethod.GET)
	public String createTable(Locale locale, Model model) {
		MemoDB db = new MemoDB();
		boolean isSuccess = db.createTable();
		if (isSuccess) {
			model.addAttribute("m1", "테이블이 생성되었습니다.");
			return "message";
		} else {
			model.addAttribute("m1", "DB Error");
			return "message";
		}
	}

	@RequestMapping(value = "/insertMemo", method = RequestMethod.GET)
	public String createMethod(HttpSession session, Locale locale, Model model) {
		String isLogin = (String) session.getAttribute("isLogin");
		if (isLogin != null && isLogin.equals("success")) {
			return "insertMemo";
		} else {
			model.addAttribute("m1", "로그인이 필요합니다.");
			return "message";
		}
	}

	@RequestMapping(value = "/insertMemo_action", method = RequestMethod.POST)
	public String createAction(HttpServletRequest request, HttpSession session, Locale locale, Model model) {

		int userIdx = Integer.parseInt(String.valueOf(session.getAttribute("is_login_idx")));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = sdf.format(Calendar.getInstance().getTime());

		MemoDB db = new MemoDB();
		User user = new User();
		Memo memo = new Memo(title, content, now, now, userIdx);
		boolean isSuccess = db.insertMemo(memo);
		if (isSuccess) {
			model.addAttribute("m1", "메모 작성 완료");
		} else {
			model.addAttribute("m1", "Error");
		}
		return "message";
	}

	@RequestMapping(value = "/memoList", method = RequestMethod.GET)
	public String memoList(HttpSession session, Locale locale, Model model) {
		try {
			String isLogin = (String) session.getAttribute("isLogin");
			if (isLogin != null && isLogin.equals("success")) {
				int userIdx = Integer.parseInt(String.valueOf(session.getAttribute("is_login_idx")));
				MemoDB db = new MemoDB();
				String htmlString = db.selectMemo(userIdx);
				model.addAttribute("listInTbody", htmlString);
				return "memoList";
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

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteAction(Locale locale, Model model, @RequestParam("idx") int idx) {
		MemoDB db = new MemoDB();
		Memo selectMemo = db.detailsData(idx);
		if (selectMemo != null) {
			db.deleteMemo(idx);
		}
		model.addAttribute("m1", "메모가 삭제되었습니다.");
		return "message";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateMethod(Locale locale, Model model, @RequestParam("idx") int idx) {
		MemoDB db = new MemoDB();
		Memo selectMemo = db.detailsData(idx);
		if (selectMemo != null) {
			model.addAttribute("idx", selectMemo.idx);
			model.addAttribute("title", selectMemo.title);
			model.addAttribute("content", selectMemo.content);
			model.addAttribute("updated", selectMemo.updated);
		}
		return "update";
	}

	@RequestMapping(value = "/update_action", method = RequestMethod.POST)
	public String updateAction(HttpServletRequest request, Locale locale, Model model) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = sdf.format(Calendar.getInstance().getTime());

		String idxString = request.getParameter("idx");
		int idx = Integer.parseInt(idxString);
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		MemoDB db = new MemoDB();
		Memo memo = new Memo(idx, title, content, now);
		boolean isSuccess = db.updateMemo(memo);
		if (isSuccess) {
			model.addAttribute("m1", "수정 완료");
		} else {
			model.addAttribute("m1", "DB Error");
		}
		return "message";
	}

	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public String loginMethod(Locale locale, Model model) {
		return "signUp";
	}

	@RequestMapping(value = "/signUp_action", method = RequestMethod.POST)
	public String signUpAction(HttpServletRequest request, Locale locale, Model model) {

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = sdf.format(Calendar.getInstance().getTime());

		MemoDB db = new MemoDB();
		User user = new User(id, pwd, name, birthday, address, now);
		boolean isSuccess = db.signUp(user);

		if (id.isEmpty() || pwd.isEmpty()) {
			model.addAttribute("m1", "아이디, 비밀번호 입력 필수");
		} else if (isSuccess) {
			model.addAttribute("m1", "회원가입 완료");
		} else {
			model.addAttribute("m1", "아이디 중복 또는 DB 에러");
		}
		return "message";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "login";
	}

	@RequestMapping(value = "/login_action", method = RequestMethod.POST)
	public String loginInAction(HttpServletRequest request, HttpSession session, Locale locale, Model model) {

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemoDB db = new MemoDB();
		boolean isSuccess = db.logIn(id, pwd);

		if (isSuccess) {
			int userIdx = db.detailsData2(id, pwd);
			session.setAttribute("isLogin", "success");
			session.setAttribute("is_login_idx", userIdx);
			session.setAttribute("is_login_id", id);
			session.setAttribute("is_login_pwd", pwd);
			model.addAttribute("m1", "로그인 성공");
			return "logMsg";
		} else {
			model.addAttribute("m1", "아이디 또는 비밀번호 불일치");
			return "logFail";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, Locale locale, Model model) {
		session.invalidate();
		model.addAttribute("m1", "로그아웃 완료");
		return "message";
	}

	
	@RequestMapping(value = "/login2_action", method = RequestMethod.POST)
	public String logInAction2(HttpServletRequest request, HttpSession session, Locale locale, Model model) {
		String userId = String.valueOf(session.getAttribute("is_login_id"));
		String pwd = request.getParameter("pwd");
		MemoDB db = new MemoDB();
		boolean isLogin = db.logIn(userId, pwd);
		if(isLogin) {
			model.addAttribute("m1", "비밀번호 일치");
			return "logMsg2";
		} else {
			model.addAttribute("m1", "로그인 필수, 비밀번호 확인 요망");
			return "message";
		}
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.GET)
	public String updateUser(Locale locale, Model model) {
		return "login2";
	}
	
	@RequestMapping(value = "/updateUser2", method = RequestMethod.GET)
	public String updateUser2(HttpSession session, Locale locale, Model model) {
		int userIdx = Integer.parseInt(String.valueOf(session.getAttribute("is_login_idx")));
		MemoDB db = new MemoDB();
		User selectUser = db.detailsData3(userIdx);
		if (selectUser != null) {
			model.addAttribute("idx", selectUser.idx);
			model.addAttribute("id", selectUser.id);
			model.addAttribute("name", selectUser.name);
			model.addAttribute("address", selectUser.address);
			model.addAttribute("birthday", selectUser.birthday);
			}
		return "updateUser";
	}
	
	@RequestMapping(value = "/updateUser_action", method = RequestMethod.POST)
	public String updateUserAction(HttpServletRequest request, Locale locale, Model model) {
		int idx = Integer.parseInt(request.getParameter("idx"));
		String pwd = request.getParameter("pwd2");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String birthday = request.getParameter("birthday");
		MemoDB db = new MemoDB();
		User user1 = new User(idx, pwd, name, address, birthday);
		User user2 = new User(idx, name, address, birthday);
		
		boolean isSuccess = false;
		
		if(pwd.isEmpty()) {
			isSuccess = db.updateUser2(user2);
		} else {
			isSuccess = db.updateUser(user1);
		}
		
		if (isSuccess) {
			model.addAttribute("m1", "정보 수정 완료");
		} else {
			model.addAttribute("m1", "DB Error!!!");
		}
		return "message";
	}
	
}
