package com.springCareer.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springCareer.domain.CareerBoardVO;
import com.springCareer.service.CareerBoardService;
import com.springCareer.service.FollowService;
import com.springCareer.service.FreeBoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/career/*")
@Log4j
@AllArgsConstructor
public class CareerBoardController {

	private final CareerBoardService service;
	private final FreeBoardService boardservice;
	private final FollowService followService;

	@GetMapping("/register")
	public String register() {

		return "addCareer";
	}

	@PostMapping("/upload")
	public String upload(@RequestParam("prPic") MultipartFile file, Model model, HttpSession session)
			throws IOException {

		String fileRealName = file.getOriginalFilename();
		long size = file.getSize();

		log.info("-----------------파일 업로드-----------------");
		log.info("Upload File Name : " + fileRealName);
		log.info("Upload File size : " + size);

		String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."), fileRealName.length());
		String uploadFolder = "C:\\upload\\tmp";

		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
		String[] uuids = uuid.toString().split("-");
		String uniqueName = uuids[0];

		CareerBoardVO career = service.getCareer((String) session.getAttribute("userId"));
		career.setPrPic(uniqueName + fileExtension);
		System.out.println("확인 ------------------");
		service.modifyCareer(career);

		File saveFile = new File(uploadFolder + "\\" + uniqueName + fileExtension);
		try {
			file.transferTo(saveFile);
			model.addAttribute("imagePath", saveFile.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/career/get";
	}

	@GetMapping("/display")
	public ResponseEntity<Resource> display(@Param("prPic") String prPic) {

		String path = "C:\\upload\\tmp\\";
		String folder = "";

		Resource resource = new FileSystemResource(path + folder + prPic);

		if (!resource.exists()) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
		HttpHeaders header = new HttpHeaders();
		Path filePath = null;

		try {
			filePath = Paths.get(path + folder + prPic);

			header.add("Content-Type", Files.probeContentType(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);

	}

	@PostMapping("/register")
	public String register(CareerBoardVO career, RedirectAttributes rttr) throws IOException {

		log.info("커리어 등록 : " + career);
		service.registerCareer(career);
		rttr.addFlashAttribute("result", career.getCrbId());
		return "redirect:get";
	}

	@GetMapping("/get")
	public String get(HttpSession session, Model model) {
		log.info("/get");
		String userId = (String) session.getAttribute("userId");
		if (userId != null) {
			CareerBoardVO career = service.getCareer(userId);

			model.addAttribute("board", service.getMyBoard(userId));
			model.addAttribute("career", career);
			model.addAttribute("follower", followService.getFollower(userId));
			model.addAttribute("following", followService.getFollowing(userId));
			model.addAttribute("followerList", followService.getFollowers(userId));
			model.addAttribute("followingList", followService.getFollowings(userId));
			log.info("여기까지 오는지 최종 확인용 " + career);
			return "myCareer";
		} else {
			return "home";
		}

	}

	@GetMapping("/getuser")
	public String get(@RequestParam("userId") String userId, HttpSession session, Model model) {
		log.info("/get");
		if (userId != null) {
			CareerBoardVO career = service.getCareer(userId);

			String userId2 = (String) session.getAttribute("userId");

			model.addAttribute("board", service.getMyBoard(userId));
			model.addAttribute("career", career);

			model.addAttribute("following1", followService.following(userId, userId2));
			model.addAttribute("follower1", followService.follower(userId, userId2));
			model.addAttribute("follower", followService.getFollower(userId));
			model.addAttribute("following", followService.getFollowing(userId));
			model.addAttribute("followerList", followService.getFollowers(userId));
			model.addAttribute("followingList", followService.getFollowings(userId));
			log.info("여기까지 오는지 최종 확인용 " + career);
			return "userCareer";
		} else {
			return "home";
		}

	}

	@GetMapping("/modify")
	public String modify() {

		return "updateMember";
	}

	@PostMapping("/modify")
	public String modify(CareerBoardVO career, RedirectAttributes rttr) {

		log.info("커리어 수정 : " + career);

		if (service.modifyCareer(career)) {
			rttr.addFlashAttribute("result", "success");
		}

		return "redirect:get";
	}

	@RequestMapping(value = "/remove", method = { RequestMethod.GET, RequestMethod.POST })
	public String remove(@RequestParam("crbId") Long crbId, RedirectAttributes rttr) {

		log.info("삭제 : " + crbId);
		if (service.deleteCareer(crbId)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:get";
	}
}
