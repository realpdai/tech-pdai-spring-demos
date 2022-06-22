# SpringBoot集成文件 - 集成POI之Excel导入导出
> Apache POI 是用Java编写的免费开源的跨平台的 Java API，Apache POI提供API给Java程序对Microsoft Office格式档案读和写的功能。本文主要介绍通过SpringBoot集成POI工具实现Excel的导入和导出功能。@pdai

- [SpringBoot集成文件 - 集成POI之Excel导入导出](#springboot集成文件---集成poi之excel导入导出)
  - [知识准备](#知识准备)
    - [什么是POI](#什么是poi)
    - [POI中基础概念](#poi中基础概念)
  - [实现案例](#实现案例)
    - [Pom依赖](#pom依赖)
    - [导出Excel](#导出excel)
    - [导入Excel](#导入excel)
  - [示例源码](#示例源码)
  - [参考文章](#参考文章)

## 知识准备
> 需要了解POI工具，以及POI对Excel中的对象的封装对应关系。

### 什么是POI
> Apache POI 是用Java编写的免费开源的跨平台的 Java API，Apache POI提供API给Java程序对Microsoft Office格式档案读和写的功能。POI为“Poor Obfuscation Implementation”的首字母缩写，意为“简洁版的模糊实现”。

Apache POI 是创建和维护操作各种符合Office Open XML（OOXML）标准和微软的OLE 2复合文档格式（OLE2）的Java API。用它可以使用Java读取和创建,修改MS Excel文件.而且,还可以使用Java读取和创建MS Word和MSPowerPoint文件。更多请参考[官方文档](https://poi.apache.org/index.html)。

### POI中基础概念
> 生成xls和xlsx有什么区别？POI对Excel中的对象的封装对应关系？

生成xls和xlsx有什么区别呢？

|XLS |	XLSX|
|---|---|
|只能打开xls格式，无法直接打开xlsx格式|	可以直接打开xls、xlsx格式|
|只有65536行、256列|	可以有1048576行、16384列|
|占用空间大	|占用空间小，运算速度也会快一点|

POI对Excel中的对象的封装对应关系如下：

|Excel|	POI XLS| POI XLSX(Excel 2007+)|
|---|---|---|
|Excel 文件	|HSSFWorkbook （xls）| XSSFWorkbook（xlsx）|
|Excel 工作表	|HSSFSheet|XSSFSheet|
|Excel 行	|HSSFRow|XSSFRow|
|Excel 单元格	|HSSFCell|XSSFCell|
|Excel 单元格样式	|HSSFCellStyle|HSSFCellStyle|
|Excel 颜色	|HSSFColor|XSSFColor|
|Excel 字体	|HSSFFont|XSSFFont|

## 实现案例
> 这里展示SpringBoot集成POI导出用户列表的和导入用户列表的例子。

### Pom依赖

引入poi的依赖包

```xml
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi</artifactId>
    <version>5.2.2</version>
</dependency>
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.2.2</version>
</dependency>
```

### 导出Excel

UserController中导出的方法

```java
@ApiOperation("Download Excel")
@GetMapping("/excel/download")
public void download(HttpServletResponse response) {
    try {
        SXSSFWorkbook workbook = userService.generateExcelWorkbook();
        response.reset();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition",
                "attachment;filename=user_excel_" + System.currentTimeMillis() + ".xlsx");
        OutputStream os = response.getOutputStream();
        workbook.write(os);
        workbook.dispose();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

UserServiceImple中导出Excel的主方法

```java
private static final int POSITION_ROW = 1;
private static final int POSITION_COL = 1;

/**
  * @return SXSSFWorkbook
  */
@Override
public SXSSFWorkbook generateExcelWorkbook() {
    SXSSFWorkbook workbook = new SXSSFWorkbook();
    Sheet sheet = workbook.createSheet();

    int rows = POSITION_ROW;
    int cols = POSITION_COL;

    // 表头
    Row head = sheet.createRow(rows++);
    String[] columns = new String[]{"ID", "Name", "Email", "Phone", "Description"};
    int[] colWidths = new int[]{2000, 3000, 5000, 5000, 8000};
    CellStyle headStyle = getHeadCellStyle(workbook);
    for (int i = 0; i < columns.length; ++i) {
        sheet.setColumnWidth(cols, colWidths[i]);
        addCellWithStyle(head, cols++, headStyle).setCellValue(columns[i]);
    }

    // 表内容
    CellStyle bodyStyle = getBodyCellStyle(workbook);
    for (User user : getUserList()) {
        cols = POSITION_COL;
        Row row = sheet.createRow(rows++);
        addCellWithStyle(row, cols++, bodyStyle).setCellValue(user.getId());
        addCellWithStyle(row, cols++, bodyStyle).setCellValue(user.getUserName());
        addCellWithStyle(row, cols++, bodyStyle).setCellValue(user.getEmail());
        addCellWithStyle(row, cols++, bodyStyle).setCellValue(String.valueOf(user.getPhoneNumber()));
        addCellWithStyle(row, cols++, bodyStyle).setCellValue(user.getDescription());
    }
    return workbook;
}

private Cell addCellWithStyle(Row row, int colPosition, CellStyle cellStyle) {
    Cell cell = row.createCell(colPosition);
    cell.setCellStyle(cellStyle);
    return cell;
}

private List<User> getUserList() {
    return Collections.singletonList(User.builder()
            .id(1L).userName("pdai").email("pdai@pdai.tech").phoneNumber(121231231231L)
            .description("hello world")
            .build());
}

private CellStyle getHeadCellStyle(Workbook workbook) {
    CellStyle style = getBaseCellStyle(workbook);

    // fill
    style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

    return style;
}

private CellStyle getBodyCellStyle(Workbook workbook) {
    return getBaseCellStyle(workbook);
}

private CellStyle getBaseCellStyle(Workbook workbook) {
    CellStyle style = workbook.createCellStyle();

    // font
    Font font = workbook.createFont();
    font.setBold(true);
    style.setFont(font);

    // align
    style.setAlignment(HorizontalAlignment.CENTER);
    style.setVerticalAlignment(VerticalAlignment.TOP);

    // border
    style.setBorderBottom(BorderStyle.THIN);
    style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
    style.setBorderLeft(BorderStyle.THIN);
    style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
    style.setBorderRight(BorderStyle.THIN);
    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
    style.setBorderTop(BorderStyle.THIN);
    style.setTopBorderColor(IndexedColors.BLACK.getIndex());

    return style;
}

```

导出后的excel如下

![](https://pdai.tech/_images/spring/springboot/springboot-file-excel-poi-2.png)

### 导入Excel
> 我们将上面导出的excel文件导入。

UserController中导入的方法

```java
@ApiOperation("Upload Excel")
@PostMapping("/excel/upload")
public ResponseResult<String> upload(@RequestParam(value = "file", required = true) MultipartFile file) {
    try {
        userService.upload(file.getInputStream());
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseResult.fail(e.getMessage());
    }
    return ResponseResult.success();
}
```

UserServiceImple中导入Excel的主方法

```java
@Override
public void upload(InputStream inputStream) throws IOException {
    XSSFWorkbook book = new XSSFWorkbook(inputStream);
    XSSFSheet sheet = book.getSheetAt(0);
    // add some validation here

    // parse data
    int cols;
    for (int i = POSITION_ROW; i < sheet.getLastRowNum(); i++) {
        XSSFRow row = sheet.getRow(i + 1); // 表头不算
        cols = POSITION_COL;
        User user = User.builder()
                .id(getCellLongValue(row.getCell(cols++)))
                .userName(getCellStringValue(row.getCell(cols++)))
                .email(getCellStringValue(row.getCell(cols++)))
                .phoneNumber(Long.parseLong(getCellStringValue(row.getCell(cols++))))
                .description(getCellStringValue(row.getCell(cols++)))
                .build();
        log.info(user.toString());
    }

    book.close();
}

private String getCellStringValue(XSSFCell cell) {
    try {
        if (null!=cell) {
            return String.valueOf(cell.getStringCellValue());
        }
    } catch (Exception e) {
        return String.valueOf(getCellIntValue(cell));
    }
    return "";
}

private long getCellLongValue(XSSFCell cell) {
    try {
        if (null!=cell) {
            return Long.parseLong("" + (long) cell.getNumericCellValue());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0L;
}

private int getCellIntValue(XSSFCell cell) {
    try {
        if (null!=cell) {
            return Integer.parseInt("" + (int) cell.getNumericCellValue());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0;
}
```

通过PostMan进行接口测试

![](https://pdai.tech/_images/spring/springboot/springboot-file-excel-poi-1.png)

执行接口后，后台的日志如下

```bash
2022-06-10 21:36:01.720  INFO 15100 --- [nio-8080-exec-2] t.p.s.f.e.p.s.impl.UserServiceImpl       : User(id=1, userName=pdai, email=pdai@pdai.tech, phoneNumber=121231231231, description=hello world)
```

## 示例源码

https://github.com/realpdai/tech-pdai-spring-demos

## 参考文章

https://poi.apache.org/index.html
