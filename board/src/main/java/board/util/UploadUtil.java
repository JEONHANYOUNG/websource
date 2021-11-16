package board.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadUtil {
	public Map<String, String> map = new HashMap<>();
	
	public Map<String, String> requestParse(HttpServletRequest request){
		
		// enctype이 "multipart/form-data" 이걸로 왔는지 확인
		boolean isMultipart = ServletFileUpload.isMultipartContent(request); // 사용자가 어떤 요청을 했는가?

		if(isMultipart){
			// 전송된 파일을 디스크에 저장하기 위한 객체
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			//업로드 가능 사이즈 지정(2000*1024)
			upload.setSizeMax(2000*1024);
			
			//사용자의 request 분석(List : 차례대로 담겠다)
			List<FileItem> fileItems = null;
			try {
				fileItems = upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}	
		
			Iterator<FileItem> iter = fileItems.iterator(); // 담는 방식
			
			String fieldName = null, fileName=null, value = null;
			while(iter.hasNext()) {//가지고 나올 구조가 있으면
				FileItem item = iter.next();
				
				//if ~ else 구문
				// text,password,checkbox....
				if(item.isFormField()){
					//요소명
					fieldName = item.getFieldName(); //필드명을 가지고 오는 것(uploadForm.jsp에 File to upload에서 name="upfile"를 가져오는 것)
					//요소 안에 들어있는 value 값
					try {
						value = item.getString("utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					
					map.put(fieldName, value);
					
					//출력한 값
				}else { //type이 file로 넘어오는 경우에만 해당
					//요소명
					fieldName = item.getFieldName();
					//파일명
					fileName= item.getName();
					
					File file = null;
					if(!fileName.isEmpty() && item.getSize() > 0){ //파일이 비어있지 않으면
						//파일 저장(로컬디스크 (C:)에 upload 파일에 넣기(path 값))
						String path = "c:\\upload\\";
					
						//중복되지 않는 고유한 키 값 생성 
						UUID uuid = UUID.randomUUID();
					
						//c:\\upload\\(path 값)고유값_업로드 파일명
						file = new File(path+uuid.toString()+"_"+fileName); 
						try {
							item.write(file);
						} catch (Exception e) {
							e.printStackTrace();
						}	
						map.put(fieldName, file.getName());
					}
				}		
			}
		}
		return map;
		
			}

	}
