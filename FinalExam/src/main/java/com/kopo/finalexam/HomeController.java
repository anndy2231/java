package com.kopo.finalexam;

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
	public String main(Locale locale, Model model) {
		return "main";
	}

	@RequestMapping(value = "/create_table", method = RequestMethod.GET)
	public String createTable(Locale locale, Model model) {
		PeopleDB db = new PeopleDB();
		boolean isSuccess = db.createTable();
		if (isSuccess) {
			model.addAttribute("m1", "테이블이 생성되었습니다.");
			return "message";
		} else {
			model.addAttribute("m1", "DB Error");
			return "message";
		}
	}

	@RequestMapping(value = "/insertApartment", method = RequestMethod.GET)
	public String createMethod(HttpSession session, Locale locale, Model model) {
		String isLogin = (String) session.getAttribute("isLogin");
		if (isLogin != null && isLogin.equals("success")) {
			return "insertApartment";
		} else {
			model.addAttribute("m1", "로그인이 필요합니다.");
			return "message";
		}
	}

	@RequestMapping(value = "/insertApartment_action", method = RequestMethod.POST)
	public String createAction(HttpServletRequest request, HttpSession session, Locale locale, Model model) {

		int peopleIdx = Integer.parseInt(String.valueOf(session.getAttribute("is_login_idx")));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = sdf.format(Calendar.getInstance().getTime());

		PeopleDB db = new PeopleDB();
		Apartment Apartment = new Apartment(title, content, now, now, peopleIdx);
		boolean isSuccess = db.insertApartment(Apartment);
		if (isSuccess) {
			model.addAttribute("m1", "작성 완료");
		} else {
			model.addAttribute("m1", "Error");
		}
		return "message";
	}

	@RequestMapping(value = "/apartmentList", method = RequestMethod.GET)
	public String apartmentList(HttpSession session, Locale locale, Model model) {
		try {
			String isLogin = (String) session.getAttribute("isLogin");
			if (isLogin != null && isLogin.equals("success")) {
				int peopleIdx = Integer.parseInt(String.valueOf(session.getAttribute("is_login_idx")));
				PeopleDB db = new PeopleDB();
				String htmlString = db.selectApartment(peopleIdx);
				model.addAttribute("listInTbody", htmlString);
				return "apartmentList";
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
	
	@RequestMapping(value = "/peopleList", method = RequestMethod.GET)
	public String peopleList(HttpSession session, Locale locale, Model model) {
		try {
			String isLogin = (String) session.getAttribute("isLogin");
			if (isLogin != null && isLogin.equals("success")) {
				int PeopleIdx = Integer.parseInt(String.valueOf(session.getAttribute("is_login_idx")));
				PeopleDB db = new PeopleDB();
				String htmlString = db.selectPeople();
				model.addAttribute("listInTbody", htmlString);
				return "peopleList";
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
		PeopleDB db = new PeopleDB();
		Apartment selectApartment = db.detailsData(idx);
		if (selectApartment != null) {
			db.deleteApartment(idx);
		}
		model.addAttribute("m1", "삭제되었습니다.");
		return "message";
	}
	
	@RequestMapping(value = "/delete2", method = RequestMethod.GET)
	public String deleteAction2(Locale locale, Model model, @RequestParam("idx") int idx) {
		PeopleDB db = new PeopleDB();
		People selectPeople = db.detailsData3(idx);
		if (selectPeople != null) {
			db.deletePeople(idx);
		}
		model.addAttribute("m1", "삭제되었습니다.");
		return "message";
	}


	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateMethod(Locale locale, Model model, @RequestParam("idx") int idx) {
		PeopleDB db = new PeopleDB();
		Apartment selectApartment = db.detailsData(idx);
		if (selectApartment != null) {
			model.addAttribute("idx", selectApartment.idx);
			model.addAttribute("title", selectApartment.title);
			model.addAttribute("content", selectApartment.content);
			model.addAttribute("updated", selectApartment.updated);
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

		PeopleDB db = new PeopleDB();
		Apartment Apartment = new Apartment(idx, title, content, now);
		boolean isSuccess = db.updateApartment(Apartment);
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
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = sdf.format(Calendar.getInstance().getTime());

		PeopleDB db = new PeopleDB();
		People people = new People(id, pwd, name, age, gender, now);
		boolean isSuccess = db.signUp(people);

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

		PeopleDB db = new PeopleDB();
		boolean isSuccess = db.logIn(id, pwd);

		if (isSuccess) {
			int PeopleIdx = db.detailsData2(id, pwd);
			session.setAttribute("isLogin", "success");
			session.setAttribute("is_login_idx", PeopleIdx);
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

	
	@RequestMapping(value = "/update2", method = RequestMethod.GET)
	public String updatePeople2(HttpSession session, Locale locale, Model model) {
		int PeopleIdx = Integer.parseInt(String.valueOf(session.getAttribute("is_login_idx")));
		PeopleDB db = new PeopleDB();
		People selectPeople = db.detailsData3(PeopleIdx);
		if (selectPeople != null) {
			model.addAttribute("idx", selectPeople.idx);
			model.addAttribute("id", selectPeople.id);
			model.addAttribute("name", selectPeople.name);
			model.addAttribute("age", selectPeople.age);
			model.addAttribute("gender", selectPeople.gender);
			}
		return "update2";
	}
	
	@RequestMapping(value = "/updatePeople_action", method = RequestMethod.POST)
	public String updatePeopleAction(HttpServletRequest request, Locale locale, Model model) {
		int idx = Integer.parseInt(request.getParameter("idx"));
		String pwd = request.getParameter("pwd2");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		PeopleDB db = new PeopleDB();
		People people1 = new People(idx, pwd, name, age, gender);
		People people2 = new People(idx, name, age, gender);
		
		boolean isSuccess = false;
		
		if(pwd.isEmpty()) {
			isSuccess = db.updatePeople2(people2);
		} else {
			isSuccess = db.updatePeople(people1);
		}
		
		if (isSuccess) {
			model.addAttribute("m1", "정보 수정 완료");
		} else {
			model.addAttribute("m1", "DB Error!!!");
		}
		return "message";
	}

	@RequestMapping(value = "/searchPeople", method = RequestMethod.GET)
	public String searchMethod(Locale locale, Model model) {
		return "searchPeople";
	}

	@RequestMapping(value = "/searchPeople_action", method = RequestMethod.POST)
	public String searchAction(HttpServletRequest request, Locale locale, Model model) {
		String name = request.getParameter("name");
		if(name.isEmpty()) {
			model.addAttribute("m1", "이름을 입력해주세요");
			return "message";
		} else {	
			PeopleDB db = new PeopleDB();
			String htmlString = db.searchPeople(name);
			model.addAttribute("listInTbody", htmlString);
			return "peopleList2";
		}
	}
	
	@RequestMapping(value = "/peopleStatistics", method = RequestMethod.GET)
	public String peopleStatistics(Locale locale, Model model) {
		PeopleDB db = new PeopleDB();
		int count1 = db.peopleStatistics1();
		model.addAttribute("total", count1);
		int count2 = db.peopleStatistics2();
		model.addAttribute("avgAge", count2);
		int count3 = db.peopleStatistics3_man();
		int count4 = db.peopleStatistics3_woman();
		
		double count5 = (double) count3 / count1 * 100;
		double count6 = (double) count4 / count1 * 100;
				
		model.addAttribute("man", Math.round(count5*10)/10.0);
		model.addAttribute("woman", Math.round(count6*10)/10.0);
		return "peopleStatistics";
	}
	
}
