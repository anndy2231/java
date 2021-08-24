package com.example.boardMongo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BoardMongoController {

	@Autowired
	private Environment env;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private BoardMongoRepository boardMongoRepository;
	
	@Autowired
	private BoardMongoRepository2 boardMongoRepository2;

	@RequestMapping("/")
	public String index() throws Exception {
		System.out.println("index=====");
		return "index";
	}

	@RequestMapping("/board.do")
	public String board() throws Exception {
		System.out.println("board=====");
		return "board";
	}
	
	@RequestMapping("/boardContents.do")
	public String boardContents() throws Exception {
		System.out.println("boardContents=====");
		return "boardContents";
	}
	
	@RequestMapping("/boardWrite.do")
	public String boardWrite() throws Exception {
		System.out.println("boardWrite=====");
		return "boardWrite";
	}
	
	@RequestMapping("/board2.do")
	public String board2() throws Exception {
		System.out.println("board2=====");
		return "board2";
	}

	@RequestMapping("/list.do")
	@ResponseBody
	public Map<String, Object> list(HttpServletRequest request) throws Exception {
		System.out.println("list=====");
		String login = (String) request.getSession().getAttribute("isLogin");
		if(login != null && login.equals("success")) {
			Map<String, Object> map = new HashMap<>();
			List<BoardMongoVO> list = new ArrayList<BoardMongoVO>();
			list = boardMongoRepository.findAll();
			map.put("list", list);
			return map;
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/add.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(@RequestParam(value = "title", required = true) String title,
			@RequestParam(value = "contents", required = false, defaultValue = "") String contents,
			@RequestParam(value="file", required=false) MultipartFile file) throws Exception {
		System.out.println("add=====");
		Map<String, Object> map = new HashMap<>();

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:MM");
		Date time = new Date();
		String ymd = format1.format(time);
		try {
			String repository = env.getProperty("user.file.upload");
			String fname = "";
			if( file != null && file.getSize() > 0 ) {
				fname = file.getOriginalFilename();
				FileOutputStream fos = new FileOutputStream(new File(repository+File.separator+fname));
				IOUtils.copy(file.getInputStream(), fos);
				fos.close();
			}
			BoardMongoVO in = new BoardMongoVO();
			in.setTitle(title);
			in.setContents(contents);
			in.setFname(fname);
			in.setDate(ymd);
			boardMongoRepository.insert(in);
			map.put("returnCode", "success");
			map.put("returnDesc", "");
		} catch (Exception e) {
			map.put("returnCode", "failed");
			map.put("returnDesc", "데이터 등록에 실패하였습니다.");
		}
		return map;
	}
	
	@RequestMapping(value = "/add2.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add2(@RequestParam(value = "title", required = true) String title,
			@RequestParam(value = "contents", required = false, defaultValue = "") String contents,
			@RequestParam(value="file", required=false) MultipartFile file) throws Exception {
		System.out.println("add2=====");
		Map<String, Object> map = new HashMap<>();

		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:MM");
		Date time = new Date();
		String ymd = format1.format(time);
		try {
			String repository = env.getProperty("user.file.upload");
			String fname = "";
			if( file != null && file.getSize() > 0 ) {
				fname = file.getOriginalFilename();
				FileOutputStream fos = new FileOutputStream(new File(repository+File.separator+fname));
				IOUtils.copy(file.getInputStream(), fos);
				fos.close();
			}
			BoardMongoVO in = new BoardMongoVO();
			in.setTitle(title);
			in.setContents(contents);
			in.setFname(fname);
			in.setDate(ymd);
			boardMongoRepository.insert(in);
			map.put("returnCode", "success");
			map.put("returnDesc", "");
		} catch (Exception e) {
			map.put("returnCode", "failed");
			map.put("returnDesc", "데이터 등록에 실패하였습니다.");
		}
		return map;
	}

	@RequestMapping(value = "/mod.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> mod(@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "title", required = true) String title,
			@RequestParam(value = "contents", required = false, defaultValue = "") String contents,
			@RequestParam(value="file", required=false) MultipartFile file) throws Exception {
		System.out.println("mod=====");
		Map<String, Object> map = new HashMap<>();

		try {
			String repository = env.getProperty("user.file.upload");
			String fname = "";
			if( file != null && file.getSize() > 0 ) {
				fname = file.getOriginalFilename();
				FileOutputStream fos = new FileOutputStream(new File(repository+File.separator+fname));
				IOUtils.copy(file.getInputStream(), fos);
				fos.close();
			}
			Query query = new Query();
			Criteria activityCriteria = Criteria.where("id").is(id);
			query.addCriteria(activityCriteria);
			List<BoardMongoVO> out = mongoTemplate.find(query, BoardMongoVO.class);
			if (out.size() > 0) {
				BoardMongoVO in = out.get(0);
				in.setTitle(title);
				in.setContents(contents);
				in.setFname(fname);
				boardMongoRepository.save(in);
			}
			map.put("returnCode", "success");
			map.put("returnDesc", "");
		} catch (Exception e) {
			map.put("returnCode", "failed");
			map.put("returnDesc", "데이터 수정에 실패하였습니다.");
		}
		return map;
	}
	
	@RequestMapping(value = "/mod2.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> mod2(@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "title", required = true) String title,
			@RequestParam(value = "contents", required = false, defaultValue = "") String contents,
			@RequestParam(value="file", required=false) List<MultipartFile> files) throws Exception {
		System.out.println("mod2=====");
		Map<String, Object> map = new HashMap<>();
		try {
			String repository = env.getProperty("user.file.upload");
			String fnames = "";
			for (MultipartFile file : files) {
				if( file != null && file.getSize() > 0 ) {
					String fname = file.getOriginalFilename();
					FileOutputStream fos = new FileOutputStream(new File(repository+File.separator+fname));
					IOUtils.copy(file.getInputStream(), fos);
					fos.close();
					if( "".equals(fnames)) {
						fnames = fname;
					} else {
						fnames += ","+fname;
					}
				}
			}
			Query query = new Query();
			Criteria activityCriteria = Criteria.where("id").is(id);
			query.addCriteria(activityCriteria);
			List<BoardMongoVO> out = mongoTemplate.find(query, BoardMongoVO.class);
			if (out.size() > 0) {
				BoardMongoVO in = out.get(0);
				in.setTitle(title);
				in.setContents(contents);
				in.setFname(fnames);
				boardMongoRepository.save(in);
			}
			map.put("returnCode", "success");
			map.put("returnDesc", "");
		} catch (Exception e) {
			map.put("returnCode", "failed");
			map.put("returnDesc", "데이터 수정에 실패하였습니다.");
		}
		return map;
	}

	@RequestMapping(value = "/del.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> del(@RequestParam(value = "id", required = true) String id) throws Exception {
		System.out.println("del=====");
		Map<String, Object> map = new HashMap<>();

		try {
			Query query = new Query();
			Criteria activityCriteria = Criteria.where("id").is(id);
			query.addCriteria(activityCriteria);
			List<BoardMongoVO> out = mongoTemplate.find(query, BoardMongoVO.class);

			if (out.size() > 0) {
				BoardMongoVO in = out.get(0);
				boardMongoRepository.delete(in);
			}

			map.put("returnCode", "success");
			map.put("returnDesc", "");
		} catch (Exception e) {
			map.put("returnCode", "failed");
			map.put("returnDesc", "데이터 삭제에 실패하였습니다.");
		}
		return map;
	}
	
	@RequestMapping(value = "/delimg.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delimg(@RequestParam(value = "id", required = true) String id) throws Exception {
		System.out.println("delimg=====");
		Map<String, Object> map = new HashMap<>();
		
		try {
			Query query = new Query();
			Criteria activityCriteria = Criteria.where("id").is(id);
			query.addCriteria(activityCriteria);
			List<BoardMongoVO> out = mongoTemplate.find(query, BoardMongoVO.class);
			
			if (out.size() > 0) {
				BoardMongoVO in = out.get(0);
				
				String repository = env.getProperty("user.file.upload");
				String fname = repository+File.separator+in.getFname();
				File delFile = new File(fname);
				if( delFile.exists() ) {
					System.out.println("del dir:"+fname);
					delFile.delete();
				}
				
				in.setFname("");
				boardMongoRepository.save(in);
			}
			map.put("returnCode", "success");
			map.put("returnDesc", "");
		} catch (Exception e) {
			map.put("returnCode", "failed");
			map.put("returnDesc", "데이터 삭제에 실패하였습니다.");
		}
		return map;
	}
	
	// 이미지 표시
	@RequestMapping(value="/img.do")
	@ResponseBody
	public String getImageWithMediaType(@RequestParam(value="fname", required=false, defaultValue="") String fname) throws IOException {
		System.out.println("img====="+fname);
		String repository = env.getProperty("user.file.upload");
		
		String base64Encoded = "";
		if(fname.contains(",")) {
			fname = fname.substring(0, fname.indexOf(","));
		}
		fname = repository+File.separator+fname;
		System.out.println("dir:"+fname);
		File file = new File(fname);
		if( file.exists() && file.isFile() ) {
		    InputStream in = new FileInputStream(fname);
		    byte[] bytes = IOUtils.toByteArray(in);
		    byte[] encodeBase64 = Base64.getEncoder().encode(bytes);
		    base64Encoded = new String(encodeBase64, "UTF-8");
		    in.close();
		}
		
	    return base64Encoded;
	}
	
	@RequestMapping(value="/img2.do")
	@ResponseBody
	public String getImageWithMediaType2(@RequestParam(value="fname", required=false, defaultValue="") String fname,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("img2====="+fname);
		String repository = env.getProperty("user.file.upload");
		
		String rtnTag = "";
		String base64Encoded = "";
		String[] fnameList = fname.split(",");
		for(int i=0; i<fnameList.length; i++) {
			fname = repository+File.separator+fnameList[i];
			System.out.println("dir:"+fname);
			File file = new File(fname);
			if( file.exists() && file.isFile() ) {
				InputStream in = new FileInputStream(fname);
			    byte[] bytes = IOUtils.toByteArray(in);
			    byte[] encodeBase64 = Base64.getEncoder().encode(bytes);
			    base64Encoded = new String(encodeBase64, "UTF-8");
			    in.close();
			    
			    rtnTag += "<img src=\"data:image/jpeg;base64,"+base64Encoded+"\" alt=\"image\" style=\"max-width:100%\"/><br/><br/>";
			}
		}
		System.out.println("rtnTag:"+rtnTag);
		
	    return rtnTag;
	}
	
	@RequestMapping("/login.do")
	public String login() throws Exception {
		System.out.println("login=====");
		return "login";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) throws Exception {
		System.out.println("logout=====");
		request.getSession().invalidate();
		return "login";
	}
	

	@RequestMapping(value = "/login_action.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login_action(HttpServletRequest request,
			@RequestParam("userId") String userId,
			@RequestParam("password") String password) throws Exception {
		
		System.out.println("login_action=====");
		
		Map<String, Object> map = new HashMap<>();
		
		try {
			Query query = new Query();
			Criteria activityCriteria = Criteria.where("userId").is(userId);
			query.addCriteria(activityCriteria);
			activityCriteria = Criteria.where("password").is(password);
			query.addCriteria(activityCriteria);
			BoardUserInfo userInfo = mongoTemplate.findOne(query, BoardUserInfo.class);
			
			String id = userInfo.getId();
			String name = userInfo.getName();
			String userIdSession = userInfo.getUserId();
			String passwordSession = userInfo.getPassword();
			request.getSession().setAttribute("id", id);
			request.getSession().setAttribute("name", name);
			request.getSession().setAttribute("userId", userIdSession);
			request.getSession().setAttribute("password", passwordSession);
			request.getSession().setAttribute("isLogin", "success");

			map.put("returnCode", "success");
			map.put("returnDesc", "실패");
			
//			if (out.size() > 0) {
//				request.getSession().setAttribute("name", userName);
//				map.put("returnCode", "success");
//				map.put("returnDesc", "실패");
//			}
		} catch (Exception e) {
			map.put("returnCode", "failed");
			map.put("returnDesc", "로그인 실패");
		}
		return map;
	}
	
	
	@RequestMapping("/signup.do")
	public String signup() throws Exception {
		System.out.println("signup=====");
		return "signup";
	}
	
	@RequestMapping(value = "/signup_action.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> signup_action(
			@RequestParam("userId") String userId,
			@RequestParam("password") String password,
			@RequestParam("name") String name) throws Exception {
		
		System.out.println("signup_action=====");
		
		Map<String, Object> map = new HashMap<>();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:MM");
		Date time = new Date();
		String ymd = format1.format(time);

		try {
			BoardUserInfo in = new BoardUserInfo();
			in.setName(name);
			in.setUserId(userId);
			in.setPassword(password);
			in.setDate(ymd);
			boardMongoRepository2.insert(in);

			map.put("returnCode", "success");
			map.put("returnDesc", "");
		} catch (Exception e) {
			map.put("returnCode", "failed");
			map.put("returnDesc", "데이터 등록에 실패하였습니다.");
		}
		return map;
	}
	
	@RequestMapping("/updateUser.do")
	public String updateUser(HttpServletRequest request) throws Exception {
		System.out.println("updateUser=====");
		String login = (String) request.getSession().getAttribute("isLogin");
		if(login != null && login.equals("success")) {
			return "updateUser";
		} else {
			return "updateUserEmpty";
		}
	}
	
	@RequestMapping(value = "/updateUser_action.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateUser_action(HttpServletRequest request,
			@RequestParam("userId") String userId,
			@RequestParam("password") String password,
			@RequestParam("name") String name) throws Exception {
		System.out.println("updateUser_action=====");
		Map<String, Object> map = new HashMap<>();

		String id = (String) request.getSession().getAttribute("id");
		
		try {
			Query query = new Query();
			Criteria activityCriteria = Criteria.where("id").is(id);
			query.addCriteria(activityCriteria);
			List<BoardUserInfo> out = mongoTemplate.find(query, BoardUserInfo.class);
			
			if (out.size() > 0) {
				BoardUserInfo in = out.get(0);
				in.setUserId(userId);
				in.setPassword(password);
				in.setName(name);
				boardMongoRepository2.save(in);
			}
			map.put("returnCode", "success");
			map.put("returnDesc", "");
		} catch (Exception e) {
			map.put("returnCode", "failed");
			map.put("returnDesc", "정보 수정에 실패하였습니다.");
		}
		return map;
	}
	
	@RequestMapping(value = "/leave.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> leave(HttpServletRequest request) throws Exception {
		System.out.println("leave=====");
		Map<String, Object> map = new HashMap<>();
		String id = (String) request.getSession().getAttribute("id");
		try {
			Query query = new Query();
			Criteria activityCriteria = Criteria.where("id").is(id);
			query.addCriteria(activityCriteria);
			List<BoardUserInfo> out = mongoTemplate.find(query, BoardUserInfo.class);

			if (out.size() > 0) {
				BoardUserInfo in = out.get(0);
				boardMongoRepository2.delete(in);
			}

			map.put("returnCode", "success");
			map.put("returnDesc", "");
		} catch (Exception e) {
			map.put("returnCode", "failed");
			map.put("returnDesc", "데이터 삭제에 실패하였습니다.");
		}
		return map;
	}
	
}
