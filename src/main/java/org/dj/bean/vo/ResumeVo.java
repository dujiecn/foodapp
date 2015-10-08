package org.dj.bean.vo;

import org.dj.bean.po.Resume;

@SuppressWarnings("serial")
public class ResumeVo extends Resume {
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
