package com.waston.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 传统文件上传方式，文件会封装在HttpServletRequest中
     * @return
     */
    @RequestMapping("/fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
        System.out.println("传统文件上传...");
        //使用fileupload组件完成文件上传
        //上传位置
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(realPath);
        if(!file.exists()){
            //创建文件夹
            file.mkdir();
        }

        //解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);

        //遍历
        for(FileItem item : items){
            //判断当前item对象是否是上传文件项
            if(item.isFormField()){
                //普通表单项
            }else{
                //上传文件项
                //获取上传文件的名称
                String filename = item.getName();
                //把文件名称设置唯一值，uuid
                String uuid = UUID.randomUUID().toString().replace("-","");
                filename = uuid + "_" + filename;
                //完成文件上传
                item.write(new File(realPath, filename));
                //删除临时文件
                item.delete();
            }
        }
        //上传成功会在target目录下的文件找到upload文件夹和上传的文件
        return "success";
    }

    /**
     * Spring MVC文件上传方式,upload必须与表单名字一样
     * @return
     */
    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("Spring MVC文件上传...");
        //上传位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if(!file.exists()){
            //创建文件夹
            file.mkdir();
        }
        //已经由框架帮我们拿到文件项了
        String filename = upload.getOriginalFilename();
        //把文件名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid + "_" + filename;
        //完成文件上传
        upload.transferTo(new File(path, filename));
        return "success";
    }

    /**
     * 跨服务器文件上传方式，因为上传到其他服务器中，因此不需要传入request域对象
     * @return
     */
    @RequestMapping("/fileupload3")
    public String fileupload3(MultipartFile upload) throws Exception {
        System.out.println("跨服务器文件上传...");
        //定义上传文件服务器地址，部署在9090端口
        String path = "http://localhost:9090/uploads/";
        //已经由框架帮我们拿到文件项了
        String filename = upload.getOriginalFilename();
        //把文件名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid + "_" + filename;
        //完成文件上传，跨服务器上传
        //创建客户端对象
        Client client = Client.create();
        //和文件服务器进行连接
        WebResource resource = client.resource(path + filename);
        //上传文件
        resource.put(upload.getBytes());
        return "success";
    }
}
