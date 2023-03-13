package demo.domain;

import lombok.Data;

@Data
public class User {
	private Integer id;
	private Integer user_id;
	private String username;
	private String password;
}
