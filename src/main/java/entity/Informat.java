package entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Informat implements Serializable {
	// 新闻id
	private Integer informatId;
	// 新闻名
	private String name;
	// 新闻内容
	private String inform;
	// 更新时间
	private Timestamp upTime;
	// 新闻图片
	private String img;
	// 大图
	private String bigImg;
	public Integer getInformatId() {
		return informatId;
	}
	public void setInformatId(Integer informatId) {
		this.informatId = informatId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInform() {
		return inform;
	}
	public void setInform(String inform) {
		this.inform = inform;
	}
	public Timestamp getUpTime() {
		return upTime;
	}
	public void setUpTime(Timestamp upTime) {
		this.upTime = upTime;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getBigImg() {
		return bigImg;
	}
	public void setBigImg(String bigImg) {
		this.bigImg = bigImg;
	}
	
}
