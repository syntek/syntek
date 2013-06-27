/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testdocx4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import org.apache.fop.afp.Factory;
import org.docx4j.convert.out.pdf.PdfConversion;
import org.docx4j.convert.out.pdf.viaXSLFO.Conversion;
import org.docx4j.convert.out.pdf.viaXSLFO.PdfSettings;
import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.Parts;
import org.docx4j.openpackaging.parts.WordprocessingML.FooterPart;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.relationships.Relationship;
import org.docx4j.wml.Br;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.STBrType;

/**
 *
 * @author ABC
 */
public class Testdocx4j {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            String filepath = "D:\\test.docx";
            WordprocessingMLPackage word = WordprocessingMLPackage.load(new File(filepath));
            MainDocumentPart mainDocumentPart = word.getMainDocumentPart();
            mainDocumentPart.addParagraphOfText("Adding text");

//            PdfConversion p = new Conversion(word);
//            OutputStream os = new FileOutputStream("D:\\test.pdf");
            ObjectFactory factory = Context.getWmlObjectFactory();
            Br br = new Br();
            br.setType(STBrType.PAGE);
            P paragraph = factory.createP();
            paragraph.getContent().add(br);
            mainDocumentPart.getJaxbElement().getBody().getContent().add(paragraph);

            //p.output(os, new PdfSettings());
            //word.save(new File(filepath));
            //System.out.println(word.getContentType());
            System.out.println("OK");
        } catch (Exception ex) {
            //Logger.getLogger(Testdocx4j.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error:");
            ex.printStackTrace();
        }
    }
}
