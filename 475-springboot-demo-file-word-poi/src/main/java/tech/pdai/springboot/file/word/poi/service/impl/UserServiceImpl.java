package tech.pdai.springboot.file.word.poi.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import tech.pdai.springboot.file.word.poi.entity.User;
import tech.pdai.springboot.file.word.poi.service.IUserService;

/**
 * @author pdai
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Override
    public XWPFDocument generateWordXWPFDocument() {
        XWPFDocument doc = new XWPFDocument();

        // Title
        createTitle(doc, "Java 全栈知识体系");

        // Chapter 1
        createChapterH1(doc, "1. 知识准备");
        createChapterH2(doc, "1.1 什么是POI");
        createParagraph(doc, "Apache POI 是创建和维护操作各种符合Office Open XML（OOXML）标准和微软的OLE 2复合文档格式（OLE2）的Java API。用它可以使用Java读取和创建,修改MS Excel文件.而且,还可以使用Java读取和创建MS Word和MSPowerPoint文件。更多请参考[官方文档](https://poi.apache.org/index.html)");
        createChapterH2(doc, "1.2 POI中基础概念");
        createParagraph(doc, "生成xls和xlsx有什么区别？POI对Excel中的对象的封装对应关系？");

        // Chapter 2
        createChapterH1(doc, "2. 实现案例");
        createChapterH2(doc, "2.1 用户列表示例");
        createParagraph(doc, "以导出用户列表为例");

        // 表格
        List<User> userList = getUserList();
        XWPFParagraph paragraph = doc.createParagraph();
        XWPFTable table = paragraph.getDocument().createTable(userList.size(), 5);
        table.setWidth(500);
        table.setCellMargins(20, 20, 20, 20);

        //表格属性
        CTTblPr tablePr = table.getCTTbl().addNewTblPr();
        //表格宽度
        CTTblWidth width = tablePr.addNewTblW();
        width.setW(BigInteger.valueOf(8000));

        for(int i = 0; i< userList.size(); i++) {
            List<XWPFTableCell> tableCells = table.getRow(i).getTableCells();
            tableCells.get(0).setText(userList.get(i).getId()+"");
            tableCells.get(1).setText(userList.get(i).getUserName());
            tableCells.get(2).setText(userList.get(i).getEmail());
            tableCells.get(3).setText(userList.get(i).getPhoneNumber()+"");
            tableCells.get(4).setText(userList.get(i).getDescription());
        }

        createChapterH2(doc, "2.2 图片导出示例");
        createParagraph(doc, "以导出图片为例");
        // 图片
        InputStream stream = null;
        try {
            XWPFParagraph paragraph2 = doc.createParagraph();
            Resource resource = new ClassPathResource("pdai-guli.png");
            stream = new FileInputStream(resource.getFile());
            XWPFRun run = paragraph2.createRun();
            run.addPicture(stream, Document.PICTURE_TYPE_PNG, "Generated", Units.toEMU(256), Units.toEMU(256));
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }

        return doc;
    }

    private void createTitle(XWPFDocument doc, String content) {
        XWPFParagraph title = doc.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun r1 = title.createRun();
        r1.setBold(true);
        r1.setFontFamily("宋体");
        r1.setText(content);
        r1.setFontSize(22);
    }

    private void createChapterH1(XWPFDocument doc, String content) {
        XWPFParagraph actTheme = doc.createParagraph();
        actTheme.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun runText1 = actTheme.createRun();
        runText1.setBold(true);
        runText1.setText(content);
        runText1.setFontSize(18);
    }

    private void createChapterH2(XWPFDocument doc, String content) {
        XWPFParagraph actType = doc.createParagraph();
        XWPFRun runText2 = actType.createRun();
        runText2.setBold(true);
        runText2.setText(content);
        runText2.setFontSize(15);
    }

    private void createParagraph(XWPFDocument doc, String content) {
        XWPFParagraph actType = doc.createParagraph();
        XWPFRun runText2 = actType.createRun();
        runText2.setText(content);
        runText2.setFontSize(11);
    }

    private List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userList.add(User.builder()
                    .id(Long.parseLong(i + "")).userName("pdai" + i).email("pdai@pdai.tech" + i).phoneNumber(121231231231L)
                    .description("hello world" + i)
                    .build());
        }
        return userList;
    }

}
