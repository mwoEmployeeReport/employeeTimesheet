package reports;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDSimpleFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PDFGenerator {

    public static void makePDF(HashMap<String, Integer> innerDataModel, String reportTitle) throws IOException {
        ArrayList<String> simplifiedList = new ArrayList<>();
        PDDocument report = new PDDocument();
        for (Map.Entry<String, Integer> k : innerDataModel.entrySet()) {
            simplifiedList.add("Pracownik: " + k.getKey() + "|| Ilosc godzin: " + k.getValue());
        }

        for (int i = 0; i < (innerDataModel.size() / 40) + 1; i++) {
            PDPage page = new PDPage();
            report.addPage(page);
        }

        for (PDPage p : report.getPages()) {
            PDPageContentStream contentStream = new PDPageContentStream(report, p);
            int topOffset = 720;
            contentStream.setFont(PDType1Font.COURIER, 14);
            for (String s : simplifiedList) {
                int offsetCounter = 20;
                contentStream.beginText();
                contentStream.newLineAtOffset(25, topOffset - offsetCounter);
                contentStream.showText(s);
                contentStream.endText();
                offsetCounter += 20;
            }
            contentStream.close();

            report.save(new File(reportTitle));
        }
    }
    public static void draw() {

    }

}
