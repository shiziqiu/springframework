package com.shiziqiu.beans.io;

import java.io.IOException;
import java.io.InputStream;

import junit.framework.Assert;

import org.junit.Test;

import com.shiziqiu.springframework.beans.io.Resource;
import com.shiziqiu.springframework.beans.io.ResourceLoader;

/**
 * @title : ResourceLoaderTest
 * @author : shiziqiu
 * @date : 2017年9月11日 下午5:08:23
 * @Fun :
 */
public class ResourceLoaderTest {

	@Test
	public void ResourcLoaderTest() throws IOException {
		ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("testioc.xml");
        InputStream inputStream = resource.getInputStream();
        System.out.println(inputStream);
        Assert.assertNotNull(inputStream);
	}
}
