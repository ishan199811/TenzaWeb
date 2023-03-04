package com.tenzaWeb.product.fileuploader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class FileUploaderUtil {
	 public static void saveFile(String uploadDir, String fileNamee,
	            MultipartFile multipartFile) throws IOException {
	        Path uploadPath = Paths.get(uploadDir);
	     //    log.info(fileNamee+"-------------------this is file name--------------------------");
	        if (!Files.exists(uploadPath)) {
	            Files.createDirectories(uploadPath);
	        }
	       // log.info(fileNamee+"-------------------this is file name--------------------------");
	        try (InputStream inputStream = multipartFile.getInputStream()) {
	            Path filePath = uploadPath.resolve(fileNamee);
				/* Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING); */
	         //   log.info(fileNamee+"-------------------this is file name--------------------------");
	            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
	        } catch (IOException ioe) {        
	            throw new IOException("Could not save image file: " + fileNamee, ioe);
	        }      
	    }
	}
