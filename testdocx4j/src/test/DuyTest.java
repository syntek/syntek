/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.docx4j.TraversalUtil;
import org.docx4j.XmlUtils;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.Body;
import org.docx4j.wml.Document;

/**
 *
 * @author MrOnly
 */
public class DuyTest {

    static int dem = 1;
    static String current = "";

    static void tangDem() {
        dem++;
    }

    static void giamDem() {
        dem--;
    }

    public static void main(String[] args) {
        try {
            WordprocessingMLPackage mLPackage = WordprocessingMLPackage.load(new File("D:/test_5.docx"));
            MainDocumentPart mainDocumentPart = mLPackage.getMainDocumentPart();
            Document doc = mainDocumentPart.getJaxbElement();
            Body body = doc.getBody();

            TraversalUtil util = new TraversalUtil(body, new TraversalUtil.Callback() {
                String indent = "";

                @Override
                public void walkJAXBElements(Object parent) {
                    indent += "    ";
                    List children = getChildren(parent);
                    if (children != null) {
                        for (Object o : children) {
                            o = XmlUtils.unwrap(o);
                            this.apply(o);
                            if (this.shouldTraverse(o)) {
                                walkJAXBElements(o);
                            }
                        }
                    }

                    indent = indent.substring(0, indent.length() - 4);
                }

                @Override
                public List<Object> getChildren(Object o) {
                    return TraversalUtil.getChildrenImpl(o);
                }

                @Override
                public List<Object> apply(Object o) {
                    String text = "";
                    if (o instanceof org.docx4j.wml.Text) {
                        text = ((org.docx4j.wml.Text) o).getValue();
                    }
                    System.out.println(indent + o.getClass().getName() + "  \""
                            + text + "\"");
                    if (o instanceof org.docx4j.wml.R.LastRenderedPageBreak) {
                        current = "Last";
                        System.out.println("this is " + current);
                        tangDem();
                    }
                    if (o instanceof org.docx4j.wml.Br) {
                        current = "Br";
                        System.out.println("this is " + current);
                        tangDem();
                    }
                    return null;
                }

                @Override
                public boolean shouldTraverse(Object o) {
                    return true;
                }
            });
            if (current.equals("Br")) {
                giamDem();
            }
            System.out.println(dem);
        } catch (Docx4JException ex) {
            Logger.getLogger(DuyTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
