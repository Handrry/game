package entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Informat implements Serializable {
	// ����id
	private Integer informatId;
	// ������
	private String name;
	// ��������
	private String inform;
	// ����ʱ��
	private Timestamp upTime;
	// ����ͼƬ
	private String img;
	// ��ͼ
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
