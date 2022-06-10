package tech.pdai.springboot.file.excel.poi.controller;


import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tech.pdai.springboot.file.excel.poi.entity.response.ResponseResult;
import tech.pdai.springboot.file.excel.poi.service.IUserService;

/**
 * @author pdai
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation("Upload Excel")
    @PostMapping("/excel/upload")
    public ResponseResult<String> upload(@RequestParam(value = "file", required = true) MultipartFile file) {
        try {
            userService.upload(file.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.fail(e.getMessage());
        }
        return ResponseResult.success();
    }

    @ApiOperation("Download Excel")
    @GetMapping("/excel/download")
    public void download(HttpServletResponse response) {
        try {
            SXSSFWorkbook workbook = userService.generateExcelWorkbook();
            response.reset();
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition",
                    "attachment;filename=user_excel_" + System.currentTimeMillis() + ".xlsx");
            OutputStream os = response.getOutputStream();
            workbook.write(os);
            workbook.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
