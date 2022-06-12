package tech.pdai.springboot.file.excel.easyexcel.service;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author pdai
 */
public interface IUserService {

    void upload(InputStream inputStream) throws IOException;

    void downloadExcel(ServletOutputStream outputStream);

    void fillExcelTemplate(ServletOutputStream outputStream);
}
