package com.atguigu.crud.controller;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.bean.SDKModel;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.service.SDKService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.spi.http.HttpContext;
import java.io.*;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;

@Controller
public class SDKController {

    @Autowired
    private SDKService sdkService;


    @RequestMapping("/sdks")
    @ResponseBody
    public Msg getEmpsWithJson(
            @RequestParam(value = "pn", defaultValue = "1") Integer pn, HttpServletRequest request, HttpServletResponse response) throws Exception {


        // 这不是一个分页查询
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<SDKModel> sdks = sdkService.selectSDKs();
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(sdks, 5);
        return Msg.success().add("pageInfo", page);
    }


    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void downloadFile(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {

        InputStream is = null;
        OutputStream os = null;
        File file = null;
        try {
            // PrintWriter out = response.getWriter();

            file = new File(request.getContextPath() + "xhttpd.c.zip");
            if (file != null && file.exists() && file.isFile()) {
                long filelength = file.length();
                is = new FileInputStream(file);
                // 设置输出的格式
                os = response.getOutputStream();
                response.setContentType("application/x-msdownload");
                response.setContentLength((int) filelength);
                response.addHeader("Content-Disposition", "attachment; filename=\"" + new String(file.getName().getBytes("GBK"),// 只有GBK才可以
                        "iso8859-1") + "\"");

                // 循环取出流中的数据
                byte[] b = new byte[4096];
                int len;
                while ((len = is.read(b)) > 0) {
                    os.write(b, 0, len);
                }
            } else {
                response.getWriter().println("<script>");
                response.getWriter().println(" modals.info('文件不存在!');");
                response.getWriter().println("</script>");
            }

        } catch (IOException e) {
            // e.printStackTrace();
        } finally {
            if (is != null) {
                is.close();
            }
            if (os != null) {
                os.close();
            }
        }
    }


    /*
     * 通过流的方式上传文件
     * @RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
     */
//    @RequestMapping("fileUpload")
//    public String  fileUpload(@RequestParam("file") CommonsMultipartFile file) throws IOException {
//
//
//        //用来检测程序运行时间
//        long  startTime=System.currentTimeMillis();
//        System.out.println("fileName："+file.getOriginalFilename());
//
//        try {
//            //获取输出流
//            OutputStream os=new FileOutputStream("E:/"+new Date().getTime()+file.getOriginalFilename());
//            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
//            InputStream is=file.getInputStream();
//            int temp;
//            //一个一个字节的读取并写入
//            while((temp=is.read())!=(-1))
//            {
//                os.write(temp);
//            }
//            os.flush();
//            os.close();
//            is.close();
//
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        long  endTime=System.currentTimeMillis();
//        System.out.println("方法一的运行时间："+String.valueOf(endTime-startTime)+"ms");
//        return "/success";
//    }


    @RequestMapping("/upload")
    public void springUpload(String sdkName, String sdkVersion, String sdkDesc, HttpServletRequest request) throws IllegalStateException, IOException {
        long startTime = System.currentTimeMillis();
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            //获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();

            while (iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                if (file != null) {
                    String path = request.getSession().getServletContext().getRealPath("upload/");
                    path = path + file.getOriginalFilename();
                    System.out.println("上传路径:" + path);
                    //上传
                    file.transferTo(new File(path));
                }

            }

        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法三的运行时间：" + String.valueOf(endTime - startTime) + "ms");

    }
}