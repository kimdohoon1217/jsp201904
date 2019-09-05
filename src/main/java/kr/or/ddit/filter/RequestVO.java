package kr.or.ddit.filter;

public class RequestVO {
	String method;
	int uriCount;
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + uriCount;
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestVO other = (RequestVO) obj;
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
			return false;
		if (uriCount != other.uriCount)
			return false;
		return true;
	}




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
