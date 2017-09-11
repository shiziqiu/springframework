package com.shiziqiu.springframework.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource是spring内部定位资源的接口。接口
 * @title : Resource
 * @author : shiziqiu
 * @date : 2017年9月11日 下午1:35:20
 * @Fun :
 */
public interface Resource {

	InputStream getInputStream() throws IOException;
}
