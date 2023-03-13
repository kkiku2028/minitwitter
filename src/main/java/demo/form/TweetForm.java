package demo.form;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class TweetForm implements Serializable {
	
	@NotEmpty(message = "本文を入力してください")
	private String content;

	private Integer user_id;
	
	private MultipartFile multipartFile;
	
	private String str;
}
