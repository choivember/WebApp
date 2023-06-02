package com.section02.commonsio;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class CommonsFileUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(ServletFileUpload.isMultipartContent(request)) {

            System.out.println("파일 저장 ROOT 경로 : " + rootLocation);
            System.out.println("최대 업로드 파일 용량 : " + maxFileSize);
            System.out.println("인코딩 방식 : " + encodingType);

            String fileUploadDirectory = rootLocation + "\\commons";
            File directory = new File(rootLocation + "\\commons");
            if(!directory.exists()) {
                System.out.println("폴더 생성 : " + directory.mkdirs());
            }

            Map<String, String> parameter = new HashMap<>();
            List<Map<String, String>> fileList = new ArrayList<>();

            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            fileItemFactory.setRepository(new File(fileUploadDirectory));
            fileItemFactory.setSizeThreshold(maxFileSize);

            ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);

            try {
                List<FileItem> fileItems = fileUpload.parseRequest(request);

                for(FileItem item : fileItems) {
                    System.out.println(item);
                }

                for(int i = 0; i < fileItems.size(); i++){
                    FileItem item = fileItems.get(i);

                    if(!item.getSize() > 0) {

                        String fileName = item.getFieldName();
                        String originFileName = item.getName();

                        int dot = originFileName.lastIndexOf(".");
                        String ext = originFileName.substring(dot);
                        String randomFileName = UUID.randomUUID().toString().replace("-", "") + ext;

                        File storeFile = new File(fileUploadDirectory + "\\" + randomFileName);

                        item.write(storeFile);

                        Map<String, String> filMap = new HashMap<>();
                        fileMap.put("fileName", fileName);
                        fileMap.put("originFileName", originFileName);
                        fileMap.put("saveFileName", randomFileName);
                        fileMap.put("savePath", fileUploadDirectory);

                        fileList.add(fileMap);
                    }
                }
            }
        }
    }
}
