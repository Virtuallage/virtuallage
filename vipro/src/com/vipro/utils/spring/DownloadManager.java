package com.vipro.utils.spring;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class DownloadManager {

	public void downloadDocument(byte[] data, String documentName){
		try
		{
			FacesContext context = FacesContext.getCurrentInstance();
			HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
			response.reset();

			{
				int length = data.length;
				response.setContentType("application/force-download");
				String downloadFile = documentName;
				response.addHeader("Content-Disposition", "attachment; filename=\"" + downloadFile + "\"");
				ServletOutputStream out = response.getOutputStream();
				response.setContentLength(length);
				out.write(data);
				out.close();
			}
			context.responseComplete();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
