package demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import demo.entity.TweetEntity;
import demo.form.TweetForm;
import demo.service.AddTweetService;

@Controller
@RequestMapping("minitwitter/add")
public class AddTweetController {

	@Autowired
	private AddTweetService addTweetService;
	
	@GetMapping
	public String show(Model model) {
		TweetForm form = new TweetForm();
		model.addAttribute(form);
		return "add";
	}
	
	@PostMapping
	public String create(@RequestParam("file") MultipartFile file, TweetForm form) throws IOException {

		TweetEntity savedFile = addTweetService.store(file, form);
		byte[] bytes = savedFile.getData();
		// ポイント4: Base64.getEncoder().encodeToString(bytes)でbyteをStringにして、Viewに渡す

//		//登録された画像データからファイル名を取得
//		String fileName = form.getMultipartFile().getOriginalFilename();
//		String str = form.getStr();
//		File filePath = new File(tweetImg.getOriginalFilename());
		addTweetService.save(form);
		return "redirect:/minitwitter/tweet-list";
	}
}
