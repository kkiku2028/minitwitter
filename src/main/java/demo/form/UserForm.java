package demo.form;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserForm {

	/** ユーザー名 */
	@NotEmpty(message = "ユーザ名を入力してください")
	private String username;
	
	/** パスワード */
	@NotEmpty(message = "パスワードを入力してください")
	private String password;
}
