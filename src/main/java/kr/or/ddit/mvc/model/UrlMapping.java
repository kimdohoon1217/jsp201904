package kr.or.ddit.mvc.model;

public class UrlMapping {
	private String url;
	private String controller;
	
	
	
	public UrlMapping(String url, String controller) {
		this.url = url;
		this.controller = controller;
	}

	public UrlMapping() {
		
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getController() {
		return controller;
	}
	public void setController(String controller) {
		this.controller = controller;
	}

	@Override
	public String toString() {
		return "UrlMapping [url=" + url + ", controller=" + controller + "]";
	}
	
	
	
	
}
