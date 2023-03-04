package com.tenzaWeb.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tenzaWeb.product.fileuploader.FileUploaderHelper;

@RestController
public class FileUploaderController {
	@Autowired
	FileUploaderHelper fileuploadhelper;
	
	
	@PostMapping("/uploadfile")
	ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file ){
		
		
		try {
			
		
		if(file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file cannot be empty");
		}
		boolean f=fileuploadhelper.uploadfile(file);
		if(f) {
			return ResponseEntity.ok("file is succesfully uploader");
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
		
	}

}
