package com.fh.typete.vo;

public class RespData {
private Integer status;
	
	private String info;
	
	private Object data;
	
	public static RespData success(Object data) {
		RespData rd=new RespData();
		rd.setInfo("处理成功");
		rd.setStatus(200);
		rd.setData(data);
		return rd;
		
	}
	public static RespData error(Integer status, String info) {
		RespData rd=new RespData();
		rd.setInfo(info);
		rd.setStatus(status);
		rd.setData(null);
		return rd;
		
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
