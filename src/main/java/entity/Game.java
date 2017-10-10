package entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Game implements Serializable {
	// 游戏编号
	private Integer game_id;
	// 游戏名
	private String name;
	// 游戏排名
	private Integer rank;
	// 游戏种类
	private String gameType;
	// 游戏描述
	private String inform;
	// 上传时间
	private Timestamp gameTime;
	// 游戏图
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
