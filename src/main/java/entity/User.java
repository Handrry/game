package entity;

import java.io.Serializable;

public class User implements Serializable {
	// ”√ªßid
	private Integer userId;
	// ” œ‰
	private String email;
	// √‹¬Î
	private String password;
	// Í«≥∆
	private String nickName;
	// œ≤∞Æ”Œœ∑
	private String games;
	// ¬€Ã≥¡Ù—‘
	private String words;
	// Õº∆¨¬∑æ∂
	private String photo;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getGames() {
		return games;
	}
	public void setGames(String games) {
		this.games = games;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}
