package kr.or.ddit.user.model;

public class UserVo {
	private String userName;	//사용자 이름
	

	//이름 바꿀때 alt + shift + r
	public UserVo(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserVo [userName=" + userName + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
