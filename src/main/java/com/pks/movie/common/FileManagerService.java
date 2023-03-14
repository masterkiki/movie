package com.pks.movie.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileManagerService {
	public static final String FILE_UPLOAD_PATH =  "C:\\pks\\springProject\\upload\\movieposters";
	
	private static Logger logger = LoggerFactory.getLogger(FileManagerService.class);
	
	public static String saveFile(String movietitle, MultipartFile file) {
		
		String directoryName = "/" + movietitle + "_" + System.currentTimeMillis() + "/";
		
		String directoryPath = FILE_UPLOAD_PATH + directoryName;
		File directory = new File(directoryPath);
		if(directory.mkdir() == false) {
			
			logger.error("savefile : 디렉토리 생성 실패 " + directoryPath);
			return null;
		}
		
		String filePath = null;
		
		try {
			byte[] bytes = file.getBytes();
			
			filePath = directoryPath + file.getOriginalFilename();
			Path path = Paths.get(filePath);
			Files.write(path, bytes);
		
		} catch (IOException e) {
			
			e.printStackTrace();
			logger.error("savefile 파일 생성 에러 - " + filePath);
			return null;
		}
		
		return "/movieposters" + directoryName + file.getOriginalFilename();
	}
	
	// 파일 삭제 메소드
	public static boolean removeFile(String filePath) {  ///images/2_1676378311769/30424_20492_2048.jpg
		// 삭제 경로  /images 를 제거 하고
		// 실제 파일 저장 경로에 이어 붙여준다.
		// C:\\pks\\springProject\\upload\\images/2_1676378311769/30424_20492_2048.jpg
		
		String realFilePath= FILE_UPLOAD_PATH + filePath.replace("/images", "");
		Path path = Paths.get(realFilePath);
		 
		// 삭제전에 파일이 존재하는지 확인하고 지워야한다
		if(Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				
				e.printStackTrace();
				
				return false;
			}
		}
		
		// C:\\pks\\springProject\\upload\\images/2_1676378311769/30424_20492_2048.jpg
		// 디렉토리 경로
		
		Path dirPath = path.getParent();
		
		if(Files.exists(path)){
			try {
				Files.delete(dirPath);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		return true;
		
		
	}
	
	
}
