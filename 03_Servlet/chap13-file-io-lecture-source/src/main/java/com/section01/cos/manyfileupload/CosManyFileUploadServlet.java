package com.section01.cos.manyfileupload;

import com.common.UUIDFileRenamePolicy;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/cos/many")
public class CosManyFileUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(ServletFileUpload.isMultipartContent(request)){

            ServletContext context = request.getServletContext();

            String rootlocation = context.getInitParameter('upload-location');
            int maxFileSize = Integer.parseInt(context.getInitParameter("max-file-size"));
            String encodingType = context.getInitParameter("encoding-type");

            System.out.println("파일 저장 ROOT 경로 : " + rootlocation);
            System.out.println("최대 업로드 파일 용량 : " + maxFileSize);
            System.out.println("인코딩 방식 : " + encodingType);

            String manyFileUploadDirectory = rootlocation + "\\cos\\many";

            File directory = new File(manyFileUploadDirectory);
            if(!directory.exists()){
                System.out.println("폴더 생성 : " + directory.mkdirs());
            }

            MultipartRequest multiRequest = new MultipartRequest(request, manyFileUploadDirectory, maxFileSize, encodingType, new UUIDFileRenamePolicy());

            String description = multiRequest.getParameter("description");
            System.out.println(description);

            for(int i = 0l i < nameList.size(); i++) {
                originFileNameList.add(multiRequest.getORiginalFileName(nameList.get(i)));
                filrSystemNameList.add(multiRequest.getFilesystemName(nameList.get(i)));
            }

            System.out.println(originFileNameList);
            System.out.println(fileSystemNameList);

            int cnt = 0;
            for(int i = 0; i < fileSystemNameList.size(); i++) {
                boolean isDeleted = new File(manyFileUploadDirectory + "\\" + fileSystemNameList.get(i)).delete();
                if(isDeleted || fileSystemNameList.get(i) == null) {
                    cnt++;
                }
            }
        }
    }
}
