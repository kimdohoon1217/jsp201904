package kr.or.ddit.utill;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileuploadUtilTest {

	/**
	 * Method : getFilenametest
	 * 작성자 : PC-18
	 * 변경이력 :
	 * Method 설명 : Content-disposition 헤더 문자열로 부터 파일이름 추출 테스트
	 */
	@Test
	public void getFilenametest() {
		
		/***Given***/
		String contentDispostion = "form-data; name=\"file\"; filename=\"brown.png\"";
		String contentDispostion2 = "form-data; name=\"file\"; filename=\"moon.png\"";

		/***When***/
		String filename = FileuploadUtil.getFilename(contentDispostion);
		String filename2 = FileuploadUtil.getFilename(contentDispostion2);

		/***Then***/
		assertEquals("brown.png", filename);
		assertEquals("moon.png", filename2);
	}
	
	/**
	 * Method : getFileExtentionTest
	 * 작성자 : PC-18
	 * 변경이력 :
	 * Method 설명 : Content-disposition 헤더 문자열로 부터 파일확장자 추출 테스트
	 */
	@Test
	public void getFileExtensionTest() {
		
		/***Given***/
		String contentDispostion = "form-data; name=\"file\"; filename=\"brown.png\"";
		String contentDispostion2 = "form-data; name=\"file\"; filename=\"moon.png\"";
		String contentDispostion3 = "form-data; name=\"file\"; filename=\"moon\"";
		String contentDispostion4 = "form-data; name=\"file\"; filename=\"moon.xx.jpg\"";
		
		/***When***/
		String fileExtensionName = FileuploadUtil.getFileExtension(contentDispostion);
		String fileExtensionName2 = FileuploadUtil.getFileExtension(contentDispostion2);
		String fileExtensionName3 = FileuploadUtil.getFileExtension(contentDispostion3);
		String fileExtensionName4 = FileuploadUtil.getFileExtension(contentDispostion4);
		
		/***Then***/
		assertEquals(".png", fileExtensionName);
		assertEquals(".png", fileExtensionName2);
		assertEquals("", fileExtensionName3);
		assertEquals(".jpg", fileExtensionName4);
	}
	
	/**
	 * Method : getPathTest
	 * 작성자 : PC-18
	 * 변경이력 :
	 * Method 설명 : 파일 업로드 경로 조회하기 테스트
	 */
	@Test
	public void getPathTest() {
		/***Given***/
		
		/***When***/
		String path = FileuploadUtil.getPath();

		/***Then***/
		assertEquals("d:\\upload\\2019\\08\\", path);
	}
	

}
