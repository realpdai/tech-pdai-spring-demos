package tech.pdai.springboot.file.pdf.itextpdf.service.impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import tech.pdai.springboot.file.pdf.itextpdf.entity.User;
import tech.pdai.springboot.file.pdf.itextpdf.pdf.MyHeaderFooterPageEventHelper;
import tech.pdai.springboot.file.pdf.itextpdf.service.IUserService;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pdai
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {


    @Override
    public Document generateItextPdfDocument(OutputStream os) throws Exception {
        // document
        Document document = new Document(PageSize.A4);
        PdfWriter pdfWriter = PdfWriter.getInstance(document, os);
        pdfWriter.setPageEvent(new MyHeaderFooterPageEventHelper("Java 全栈知识体系", "SpringBoot集成ItextPDF导出", "https://pdai.tech", "https://pdai.tech"));

        // open
        document.open();

        // add content - pdf meta information
        document.addAuthor("pdai");
        document.addCreationDate();
        document.addTitle("pdai-pdf-itextpdf");
        document.addKeywords("pdf-pdai-keyword");
        document.addCreator("pdai");

        // add content -  page content

        // Title
        document.add(createTitle("Java 全栈知识体系"));

        // Chapter 1
        document.add(createChapterH1("1. 知识准备"));
        document.add(createChapterH2("1.1 什么是POI"));
        document.add(createParagraph("Apache POI 是创建和维护操作各种符合Office Open XML（OOXML）标准和微软的OLE 2复合文档格式（OLE2）的Java API。用它可以使用Java读取和创建,修改MS Excel文件.而且,还可以使用Java读取和创建MS Word和MSPowerPoint文件。更多请参考[官方文档](https://poi.apache.org/index.html)"));
        document.add(createChapterH2("1.2 POI中基础概念"));
        document.add(createParagraph("生成xls和xlsx有什么区别？POI对Excel中的对象的封装对应关系？"));

        // Chapter 2
        document.add(createChapterH1("2. 实现案例"));
        document.add(createChapterH2("2.1 用户列表示例"));
        document.add(createParagraph("以导出用户列表为例"));

        // 表格
        List<User> userList = getUserList();
        PdfPTable table = new PdfPTable(new float[]{20, 40, 50, 40, 40});
        table.setTotalWidth(500);
        table.setLockedWidth(true);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.getDefaultCell().setBorder(1);

        for (int i = 0; i < userList.size(); i++) {
            table.addCell(createCell(userList.get(i).getId() + ""));
            table.addCell(createCell(userList.get(i).getUserName()));
            table.addCell(createCell(userList.get(i).getEmail()));
            table.addCell(createCell(userList.get(i).getPhoneNumber() + ""));
            table.addCell(createCell(userList.get(i).getDescription()));
        }
        document.add(table);

        document.add(createChapterH2("2.2 图片导出示例"));
        document.add(createParagraph("以导出图片为例"));
        // 图片
        Resource resource = new ClassPathResource("pdai-guli.png");
        Image image = Image.getInstance(resource.getURL());
        image.setAlignment(Element.ALIGN_CENTER);
        image.scalePercent(60); // 缩放
        document.add(image);

        // close
        document.close();
        return document;
    }


    private Paragraph createTitle(String content) throws IOException, DocumentException {
        Font font = new Font(getBaseFont(), 24, Font.BOLD);
        Paragraph paragraph = new Paragraph(content, font);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        return paragraph;
    }


    private Paragraph createChapterH1(String content) throws IOException, DocumentException {
        Font font = new Font(getBaseFont(), 22, Font.BOLD);
        Paragraph paragraph = new Paragraph(content, font);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        return paragraph;
    }

    private Paragraph createChapterH2(String content) throws IOException, DocumentException {
        Font font = new Font(getBaseFont(), 18, Font.BOLD);
        Paragraph paragraph = new Paragraph(content, font);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        return paragraph;
    }

    private Paragraph createParagraph(String content) throws IOException, DocumentException {
        Font font = new Font(getBaseFont(), 12, Font.NORMAL);
        Paragraph paragraph = new Paragraph(content, font);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        paragraph.setIndentationLeft(12); //设置左缩进
        paragraph.setIndentationRight(12); //设置右缩进
        paragraph.setFirstLineIndent(24); //设置首行缩进
        paragraph.setLeading(20f); //行间距
        paragraph.setSpacingBefore(5f); //设置段落上空白
        paragraph.setSpacingAfter(10f); //设置段落下空白
        return paragraph;
    }

    public PdfPCell createCell(String content) throws IOException, DocumentException {
        PdfPCell cell = new PdfPCell();
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        Font font = new Font(getBaseFont(), 12, Font.NORMAL);
        cell.setPhrase(new Phrase(content, font));
        return cell;
    }

    private BaseFont getBaseFont() throws IOException, DocumentException {
        return BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
    }

    private List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            userList.add(User.builder()
                    .id(Long.parseLong(i + "")).userName("pdai" + i).email("pdai@pdai.tech" + i).phoneNumber(121231231231L)
                    .description("hello world" + i)
                    .build());
        }
        return userList;
    }


}
