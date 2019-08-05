package kr.or.ddit.user.model;

public class UserVo {
	private String userId;		//사용자 아이디
	private String pass;		//사용자 비밀번호
	private String userName;	//사용자 이름
	
	
	
	public UserVo() {
		
	}
	


	public UserVo(String userName) {
		super();
		this.userName = userName;
	}




	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", pass=" + pass + ", userName=" + userName + "]";
	}
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	//이름 바꿀때 alt + shift + r


	
	
	
}
