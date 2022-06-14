package tech.pdai.springboot.file.excel.easypoi.service;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;

/**
 * @author pdai
 */
public interface IUserService {

    void upload(InputStream inputStream) throws Exception;

    void downloadExcel(ServletOutputStream outputStream) throws IOException;

    void fillExcelTemplate(ServletOutputStream outputStream) throws IOException;
}
