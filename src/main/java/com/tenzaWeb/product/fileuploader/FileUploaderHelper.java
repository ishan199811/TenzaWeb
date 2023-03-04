package com.tenzaWeb.product.fileuploader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploaderHelper {
	
	public final String upload_dir="G:\\tenzaApp\\tenzaWeb\\src\\main\\resources";
	
	public boolean uploadfile(MultipartFile multipartFile) {
		boolean f=false;
		
		try {
			
			/*
			 * InputStream is=multipartFile.getInputStream(); byte data[]=new
			 * byte[is.available()]; is.read(data);
			 * 
			 * //read FileOutputStream fod=new
			 * FileOutputStream(upload_dir+File.separator+multipartFile.getOriginalFilename(
			 * )); fod.write(data); fod.flush(); fod.close(); f=true;
			 */
Files.copy(multipartFile.getInputStream(),Paths.get(upload_dir+File.separator+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING)	;		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return f;
	}

}
