package demo.form;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class LoginForm {

	@NotEmpty(message = "ユーザ名を入力してください")
	private String username;
	
	@NotEmpty(message = "パスワードを入力してください")
	private String password;
}
