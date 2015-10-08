package org.dj.bean.po;

import java.io.Serializable;

public class Resume implements Serializable {
	private static final long serialVersionUID = -297870275121680904L;
	private String resumeId;
	private String name;
	private String userId;

	public String getResumeId() {
		return resumeId;
	}

	public void setResumeId(String resumeId) {
		this.resumeId = resumeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
