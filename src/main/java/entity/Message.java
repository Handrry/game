package entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Message implements Serializable {
	private Integer id;
	private String nickName;
	private Timestamp sayTime;
	private String words;
	private String path;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Timestamp getSayTime() {
		return sayTime;
	}
	public void setSayTime(Timestamp sayTime) {
		this.sayTime = sayTime;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
