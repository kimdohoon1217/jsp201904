package kr.or.ddit.utill;

public class CookieUtil {

	/**
	 * Method : getCookie
	 * 작성자 : PC-18
	 * 변경이력 :
	 * @param cookieString
	 * @param string
	 * @return
	 * Method 설명 : 쿠키 문자열로부터 특정 쿠기의 값을 조회
	 */
	public static String getCookie(String cookieString, String cookieId) {
		
		String[] cookie = cookieString.trim().split(";");
		
		
		String[] value = null;
		String result = "";
		for(int i = 0; i < cookie.length; i++) {
			if(cookie[i].contains(cookieId)){
				String arr[] = cookie[i].split("=");
				result = arr[1];
//				result = cookie[i].substring(cookie[i].lastIndexOf('=')+1);
				return result; 
			}
		}
		return null;
		
		
		
	}
	

}
