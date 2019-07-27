package spark.web.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spark.dto.FileInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * @ClassName FileController
 * @Description TODO
 * @Author Spark
 * @Date 7/27/2019 9:37 AM
 * @Version 1.0
 **/
@RestController
@RequestMapping("/file")
public class FileController {

    private final String folder = "E://";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        String folder = "D://";

        File localFile = new File(folder, new Date().getTime() + ".txt");
        file.transferTo(localFile);
        return new FileInfo(localFile.getAbsolutePath());
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
        /**
         * jdk7 try(输入输出流) 可以自动关闭输入输出流
         */
        try (InputStream readFile = new FileInputStream(new File(folder, id + ".txt"));
            OutputStream outputStream = response.getOutputStream();) {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=test.txt");
            IOUtils.copy(readFile, outputStream);
            outputStream.flush();
        } catch (Exception e) {

        }
    }
}
