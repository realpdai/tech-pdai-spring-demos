package tech.pdai.springboot.file.word.poitl.service;

import java.io.IOException;

import com.deepoove.poi.XWPFTemplate;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 * @author pdai
 */
public interface IUserService {

    XWPFTemplate generateWordXWPFTemplate() throws IOException;

    XWPFTemplate generateWordXWPFTemplateMD() throws IOException;
}
