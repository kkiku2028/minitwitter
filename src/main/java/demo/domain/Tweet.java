package demo.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Tweet {
	private Integer id;
	private Integer user_id;
	private String content;
	private Timestamp create_time;
	private Timestamp update_time;
}
