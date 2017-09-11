package com.shiziqiu.springframework.beans.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @title : UrlResource
 * @author : shiziqiu
 * @date : 2017年9月11日 下午1:36:10
 * @Fun :
 */
public class UrlResource implements Resource {

	private final URL url;

	public UrlResource(URL url) {
		this.url = url;
	}

	public InputStream getInputStream() throws IOException {
		URLConnection urlConnection = url.openConnection();
		urlConnection.connect();
		return urlConnection.getInputStream();
	}

}
