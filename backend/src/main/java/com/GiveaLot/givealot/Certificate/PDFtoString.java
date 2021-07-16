package com.GiveaLot.givealot.Certificate;

/*
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
*/

import javax.swing.text.Document;
import java.io.File;
import java.io.IOException;

public class PDFtoString {
    public String PDFtoString() {

        /*StringBuilder sb = new StringBuilder();
        try (
                PDDocument document = PDDocument.load(new File("C:\\generateCertificates\\TheOrganisation.pdf"))) {
            document.getClass();
            if (!document.isEncrypted()) {
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                PDFTextStripper tStripper = new PDFTextStripper();
                String pdfFileInText = tStripper.getText(document);
                String lines[] = pdfFileInText.split("\\r?\\n");
                for (String line : lines) {
                    sb.append(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();*/
        return "";
    }

}
