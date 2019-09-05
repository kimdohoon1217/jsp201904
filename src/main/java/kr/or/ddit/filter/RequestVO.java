package kr.or.ddit.filter;

public class RequestVO {
	String method;
	int uriCount;
	
	
	
	public RequestVO() {
		super();
	}


	
	
	@Override
	public String toString() {
		return method + (uriCount+"");
	}



	public RequestVO(String method, int uriCount) {
		super();
		this.method = method;
		this.uriCount = uriCount;
	}
	
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public int getUriCount() {
		return uriCount;
	}
	public void setUriCount(int uriCount) {
		this.uriCount = uriCount;
	}
	
	

}
