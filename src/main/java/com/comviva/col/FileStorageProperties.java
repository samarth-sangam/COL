package com.comviva.col;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * File Properties.
 * 
 * @author samarth.sangam
 *
 */
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
	private String uploadDir;

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
}