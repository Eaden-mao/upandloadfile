package com.mao;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;




public class uploadservlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		try {
		boolean ismultipart = ServletFileUpload.isMultipartContent(request);
		if(ismultipart) { //判断前台表单是否有multipart属性
		    FileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload upload=new ServletFileUpload(factory);
			//解析请求保存到fileitem
			List<FileItem> items=upload.parseRequest(request);
			Iterator<FileItem> iter=items.iterator();
			while(iter.hasNext()) {
				FileItem item=iter.next();
				//String itemName=item.getFieldName();
				String filename=item.getName();
				String path="D:\\KwDownload\\upandload";
				File file=new File(path,filename);
				item.write(file);
				System.out.println(filename+"上传成功");
				return;
			}
		  }
		}catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
