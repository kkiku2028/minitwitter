package demo.entity;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TweetEntity {
	private Integer id;
	private Integer user_id;
	private String content;
	private Timestamp create_time;
	private Timestamp update_time;
	
	private String name;
	private String type;	
	private byte[] data;
	
	public TweetEntity(String name, String type, byte[] data) {
		this.name = name;
		this.type = type;
		this.data = data;
	}
}
