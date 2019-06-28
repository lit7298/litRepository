package com.spring.lwxm.common.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * 读取配置文件
 * @author Administrator
 *
 */
@Component
@ConfigurationProperties(prefix = "myProps")
public class MyProperties {
	
	private String exportPath;
	private String importPath;
	private String dataUrl;
	public String getDataUrl() {
		return dataUrl;
	}
	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}
	public String getExportPath() {
		return exportPath;
	}
	public void setExportPath(String exportPath) {
		this.exportPath = exportPath;
	}
	public String getImportPath() {
		return importPath;
	}
	public void setImportPath(String importPath) {
		this.importPath = importPath;
	}
	@Override
	public String toString() {
		return "MyProperties [exportPath=" + exportPath + ", importPath=" + importPath + ", dataUrl=" + dataUrl + "]";
	}
	
	
}
