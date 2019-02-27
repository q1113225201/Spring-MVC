package com.sjl.springmvc.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/file")
public class FileController {
    private static final Log log = LogFactory.getLog(FileController.class);
    @RequestMapping(value = "/upload")
    public String upload(HttpServletRequest request,
                         @RequestParam("desc") String desc,
                         @RequestParam("file") MultipartFile file,
                         Model model) throws IOException {
        log.info("upload:"+desc);
        if(!file.isEmpty()){
            //上传文件路径
            String path = request.getServletContext().getRealPath("/file/");
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            //不存在创建
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }
            //保存
            file.transferTo(new File(path+File.separator+filename));
            model.addAttribute("filename",filename);
            return "success";
        }else{
            return "failure";
        }
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("filename") String filename,
                                           Model model) throws IOException {
        String path = request.getServletContext().getRealPath("/file");
        File file = new File(path+File.separator+filename);
        log.info(file.getAbsolutePath());
        HttpHeaders httpHeaders = new HttpHeaders();
        String downloadFileName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        //通知浏览器以attachment（下载方式）打开
        httpHeaders.setContentDispositionFormData("attachment",downloadFileName);
        //流形式
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),httpHeaders, HttpStatus.CREATED);
    }
}
