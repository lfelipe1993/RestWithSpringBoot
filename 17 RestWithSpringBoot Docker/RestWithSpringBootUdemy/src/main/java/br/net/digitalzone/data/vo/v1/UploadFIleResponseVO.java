package br.net.digitalzone.data.vo.v1;

import java.io.Serializable;
import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

import io.swagger.annotations.ApiModelProperty;


public class UploadFIleResponseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fileName;
	private String fileDownloadUri;
	private String fileType;
	private Long size;

	
	public UploadFIleResponseVO() {
		
	}


	public UploadFIleResponseVO(String fileName, String fileDownloadUri, String fileType, Long size) {
		this.fileName = fileName;
		this.fileDownloadUri = fileDownloadUri;
		this.fileType = fileType;
		this.size = size;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getFileDownloadUri() {
		return fileDownloadUri;
	}


	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}


	public String getFileType() {
		return fileType;
	}


	public void setFileType(String fileType) {
		this.fileType = fileType;
	}


	public Long getSize() {
		return size;
	}


	public void setSize(Long size) {
		this.size = size;
	}

}
