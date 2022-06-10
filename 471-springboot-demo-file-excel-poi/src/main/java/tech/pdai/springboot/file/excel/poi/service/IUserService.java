package tech.pdai.springboot.file.excel.poi.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 * @author pdai
 */
public interface IUserService {

    SXSSFWorkbook generateExcelWorkbook();

    void upload(InputStream inputStream) throws IOException;
}
