package com.seo.dj.common.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
	Header header;
	Object data;
	
	public Response(Object data) {
		this.data = data;
	}
	
	public Response(Header header, Object data) {
		this.header = header;
		this.data = data;
	}
	
}
