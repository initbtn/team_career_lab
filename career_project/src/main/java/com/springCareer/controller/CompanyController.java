package com.springCareer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springCareer.company.CompanyAdmin;
import com.springCareer.service.CompanyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/company/*")
@Log4j
@AllArgsConstructor
public class CompanyController {

	private CompanyService service;

	@PostMapping("/login")
	public String login(CompanyAdmin admin, HttpSession session) {
		String userid =admin.getUserid();
		log.info("로그인 : " + admin);
		admin=service.login(admin);
		System.out.println(admin);
		if(admin!= null) {
		/*	session.setAttribute("id",email);
			session.setAttribute("name",admin.getName());
			session.setAttribute("grade", admin.getGrade());*/
			session.setAttribute("admin",admin);
			session.setAttribute("userId",userid);
			
			System.out.println(session);
			
		}else {
			return "login?error";
		}
		
		return "redirect:dashboard";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session,CompanyAdmin admin) {
		System.out.println("logout");
		session.invalidate();		
		return "/home";
	}
	
	@GetMapping("/reg_admin")
	public void newCompanyAdmin() {
	}
	
	@PostMapping("/reg_admin")
	public String insertAdmin(CompanyAdmin admin,RedirectAttributes rttr) {
		log.info("등록 : " + admin);
		service.insertAdmin(admin);
		rttr.addFlashAttribute("result",admin.getUserid());
		return "redirect:/company/login";
	}
	
	@GetMapping("/dashboard")
	public void dashboard() {
	}
	
	@GetMapping("/reg_info")
	public void reg_info() {
	}
	
	@PostMapping("/reg_info")
	public String insert_info() {
		return null;
	}
	
	@GetMapping("/reg_posting")
	public void reg_posting() {
	}
	
	@GetMapping("/main")
	public void main() {
	}
	
	@GetMapping("/listJob")
	public String listJob() {
		
		return "/company/dashboard";
	}
	
}
