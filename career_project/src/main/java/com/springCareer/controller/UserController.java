package com.springCareer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springCareer.domain.UserVO;
import com.springCareer.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/user/*")
@Log4j
@AllArgsConstructor
public class UserController {

	private UserService service;

	@GetMapping("/")
	public String user() {

		return "/";
	}

	@GetMapping("add")
	public String add() {

		return "addMember";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute UserVO user, HttpSession session, RedirectAttributes rttr) {
		log.info("등록 : " + user);
		service.registerUser(user, session);
		rttr.addFlashAttribute("userId", user.getUserId());
		return "redirect:/career/get";
	}

	@GetMapping("/get")
	public void get(@RequestParam("userId") String userId, Model model) {
		log.info("/get");
		model.addAttribute("user", service.getUser(userId));
	}
	
	@GetMapping("/modify")
	public String update(HttpSession session, Model model) {
		model.addAttribute("user", service.getUser((String)session.getAttribute("userId")));
		return "updateMember";
	}

	@PostMapping("/modify")
	public String modify(UserVO user, RedirectAttributes rttr) {
		log.info("수정 : " + user);

		if (service.modifyUser(user)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/career/get";
	}

	@RequestMapping(value = "/remove", method = { RequestMethod.GET, RequestMethod.POST })
	public String remove(@RequestParam("userId") String userId, RedirectAttributes rttr) {
		log.info("개발자 삭제 Id : " + userId);
		service.removeUser(userId);
		return "/";
	}

	@GetMapping("/idcheck")
	@ResponseBody
	public String getId(String userId, Model model) {

		log.info("아이디 체크 : " + userId);
		boolean check = service.checkUserId(userId);
		System.out.println(check);
		if (check) {
			log.info("아이디 사용불가" + userId);
			return "true";
		} else {
			log.info("아이디 사용가능" + userId);
			return "false";
		}

	}
	

	@RequestMapping(value = "/login", method = {RequestMethod.POST})
	public String login(UserVO user, HttpServletRequest request, Model model, HttpSession session) {

		service.login(user, session);
		if (user != null) {
			log.info("로그인 가능" + user);
			String referer = request.getHeader("Referer");
			return "redirect:" + referer;
		} else {
			log.info("로그인 불가 : " + user);
			model.addAttribute("msg", "잘못 입력하셨습니다.");
			return "redirect:/";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {

		service.logout(session);
		return "redirect:/";
	}

}
