/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

/**
 *
 * @author MrOnly
 */
public class DuyTest {
    public static void main(String[] args) {
        try {
            WordprocessingMLPackage mLPackage = WordprocessingMLPackage.load(new File("D:/test.docx"));
        } catch (Docx4JException ex) {
            Logger.getLogger(DuyTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
