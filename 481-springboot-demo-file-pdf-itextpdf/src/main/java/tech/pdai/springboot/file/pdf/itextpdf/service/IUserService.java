package tech.pdai.springboot.file.pdf.itextpdf.service;

import com.itextpdf.text.Document;

import java.io.OutputStream;

/**
 * @author pdai
 */
public interface IUserService {

    Document generateItextPdfDocument(OutputStream os) throws Exception;
}
