package demo.form;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class TweetForm {
	
	@NotEmpty(message = "本文を入力してください")
	private String content;
	
	private Integer user_id;
}
