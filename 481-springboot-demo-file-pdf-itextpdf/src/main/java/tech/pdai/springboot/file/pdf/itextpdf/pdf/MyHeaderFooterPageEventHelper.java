package tech.pdai.springboot.file.pdf.itextpdf.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author pdai
 */
public class MyHeaderFooterPageEventHelper extends PdfPageEventHelper {

    private String headLeftTitle;

    private String headRightTitle;

    private String footerLeft;

    private String waterMark;

    private PdfTemplate total;

    public MyHeaderFooterPageEventHelper(String headLeftTitle, String headRightTitle, String footerLeft, String waterMark) {
        this.headLeftTitle = headLeftTitle;
        this.headRightTitle = headRightTitle;
        this.footerLeft = footerLeft;
        this.waterMark = waterMark;
    }

    @Override
    public void onOpenDocument(PdfWriter writer, Document document) {
        total = writer.getDirectContent().createTemplate(30, 16);
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        BaseFont bf = null;
        try {
            bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // page header and footer
        addPageHeaderAndFooter(writer, document, bf);

        // watermark
        if (waterMark!=null) {
            addWaterMark(writer, document, bf);
        }
    }

    private void addPageHeaderAndFooter(PdfWriter writer, Document document, BaseFont bf) {
        PdfContentByte cb = writer.getDirectContent();
        cb.saveState();

        cb.beginText();

        cb.setColorFill(BaseColor.GRAY);
        cb.setFontAndSize(bf, 10);


        // header
        float x = document.top(-10);
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT,
                headLeftTitle,
                document.left(), x, 0);
        cb.showTextAligned(PdfContentByte.ALIGN_RIGHT,
                headRightTitle,
                document.right(), x, 0);

        // footer
        float y = document.bottom(-10);
        cb.showTextAligned(PdfContentByte.ALIGN_LEFT,
                footerLeft,
                document.left(), y, 0);
        cb.showTextAligned(PdfContentByte.ALIGN_CENTER,
                String.format("- %d -", writer.getPageNumber()),
                (document.right() + document.left()) / 2,
                y, 0);

        cb.endText();

        cb.restoreState();
    }

    private void addWaterMark(PdfWriter writer, Document document, BaseFont bf) {
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 10; j++) {
                PdfContentByte cb = writer.getDirectContent();
                cb.saveState();
                cb.beginText();
                cb.setColorFill(BaseColor.GRAY);
                PdfGState gs = new PdfGState();
                gs.setFillOpacity(0.1f);
                cb.setGState(gs);
                cb.setFontAndSize(bf, 12);
                cb.showTextAligned(Element.ALIGN_MIDDLE, waterMark, 75 * i,
                        80 * j, 30);
                cb.endText();
                cb.restoreState();
            }
        }
    }

    @Override
    public void onCloseDocument(PdfWriter writer, Document document) {
        ColumnText.showTextAligned(total, Element.ALIGN_LEFT, new Phrase(String.valueOf(writer.getPageNumber() - 1)), 2,
                2, 0);
    }
}
