package service;

import javax.servlet.http.HttpServletRequest;

public class OtherService implements service{

	public String getViewPage(HttpServletRequest request) {
		
		request.setAttribute("result", "Invlid Type");
		
		return "/SimplePage.jsp";
	}
}
