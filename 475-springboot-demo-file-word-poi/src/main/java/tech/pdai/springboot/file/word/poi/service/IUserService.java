package tech.pdai.springboot.file.word.poi.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 * @author pdai
 */
public interface IUserService {

    XWPFDocument generateWordXWPFDocument();
}
