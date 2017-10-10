package entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Game implements Serializable {
	// ��Ϸ���
	private Integer game_id;
	// ��Ϸ��
	private String name;
	// ��Ϸ����
	private Integer rank;
	// ��Ϸ����
	private String gameType;
	// ��Ϸ����
	private String inform;
	// �ϴ�ʱ��
	private Timestamp gameTime;
	// ��Ϸͼ
	private String gameImg;
	public Integer getGame_id() {
		return game_id;
	}
	public void setGame_id(Integer game_id) {
		this.game_id = game_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public String getGameType() {
		return gameType;
	}
	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	public String getInform() {
		return inform;
	}
	public void setInform(String inform) {
		this.inform = inform;
	}
	public Timestamp getGameTime() {
		return gameTime;
	}
	public void setGameTime(Timestamp gameTime) {
		this.gameTime = gameTime;
	}
	public String getGameImg() {
		return gameImg;
	}
	public void setGameImg(String gameImg) {
		this.gameImg = gameImg;
	}
	
}
