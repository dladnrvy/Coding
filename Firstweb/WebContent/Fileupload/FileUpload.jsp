
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.util.Iterator"%>

<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = "";
	String sNum = "";
	String fileName = "";
	long filesize = 0;
	String saveFileName = "";
	String uploadpath = "/upload";
	String dir = request.getSession().getServletContext().getRealPath(uploadpath);

	boolean isMultipart = ServletFileUpload.isMultipartContent(request);

	DiskFileItemFactory factory = new DiskFileItemFactory();
	
	ServletFileUpload upload = new ServletFileUpload(factory);

	//fileItem <- 홈 페이지에서 전송한 데이터들, uName, sNumber, report
	List<FileItem> items = upload.parseRequest(request);
	
	Iterator<FileItem> itr = items.iterator();
	
	while(itr.hasNext()){
		
		FileItem item = itr.next();
		
		if(item.isFormField()){
			//type="file"이 아닌경우
			if(item.getFieldName().equals("uName")){
				name = item.getString("utf-8");
			}
			if(item.getFieldName().equals("sNumber")){
				sNum = item.getString("utf-8");
			}
		}else{
			//type="file"인 경우
			if(item.getFieldName().equals("report")){
				//파일 이름
				fileName = item.getName();
				filesize = item.getSize();
				/* saveFileName = System.currentTimeMillis()+"_"+fileName; */
				saveFileName = System.nanoTime()+"_"+fileName;
				item.write(new File(dir,saveFileName));
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
	<h1>
		이름 : <%= name %><br>
		학번 : <%= sNum %><br>
		리포트 파일 : <%= fileName %>(<%= filesize %>)<br>
		저장파일 이름 : <%= saveFileName %><br>
		저장 폴더 : <%= dir %>
		
	
	</h1>

</body>
</html>