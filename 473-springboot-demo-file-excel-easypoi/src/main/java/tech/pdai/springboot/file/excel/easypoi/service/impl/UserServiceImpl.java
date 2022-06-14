package tech.pdai.springboot.file.excel.easypoi.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import tech.pdai.springboot.file.excel.easypoi.entity.User;
import tech.pdai.springboot.file.excel.easypoi.service.IUserService;


/**
 * @author pdai
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    private static final int POSITION_ROW = 1;

    @Override
    public void upload(InputStream inputStream) throws Exception {
        ImportParams importParams = new ImportParams();
        importParams.setHeadRows(POSITION_ROW);
        importParams.setTitleRows(1);
        List<User> userList = ExcelImportUtil.importExcel(inputStream, User.class, importParams);
        userList.stream().peek(user -> log.info(user.toString()));
    }

    @Override
    public void downloadExcel(ServletOutputStream outputStream) throws IOException {
        ExportParams exportParams = new ExportParams();
        exportParams.setTitle("User Table");
        exportParams.setSheetName("User Sheet");
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, User.class, getUserList());
        workbook.write(outputStream);
        workbook.close();
    }

    @Override
    public void fillExcelTemplate(ServletOutputStream outputStream) throws IOException {
        // 确保文件可访问，这个例子的excel模板，放在根目录下面
        String templateFileName = "E://user_excel_template.xlsx";
        TemplateExportParams params = new TemplateExportParams(templateFileName);

        Map<String, Object> map = new HashMap<>();
        map.put("user", "pdai");
        map.put("date", new Date());
        map.put("userList", getUserList());
        map.put("userList2", getUserList());
        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
        workbook.write(outputStream);
        workbook.close();
    }

    private List<User> getUserList() {
        return Collections.singletonList(User.builder()
                .id(1L).userName("pdai").email("pdai@pdai.tech").phoneNumber(121231231231L)
                .description("hello world")
                .build());
    }

}
