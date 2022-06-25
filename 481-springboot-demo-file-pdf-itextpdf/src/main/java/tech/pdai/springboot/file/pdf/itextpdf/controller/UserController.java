package tech.pdai.springboot.file.pdf.itextpdf.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.pdai.springboot.file.pdf.itextpdf.service.IUserService;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * @author pdai
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation("Download PDF")
    @GetMapping("/pdf/download")
    public void download(HttpServletResponse response) {
        try {

            response.reset();
            response.setContentType("application/pdf");
            response.setHeader("Content-disposition",
                    "attachment;filename=user_pdf_" + System.currentTimeMillis() + ".pdf");

            OutputStream os = response.getOutputStream();
            userService.generateItextPdfDocument(os);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
