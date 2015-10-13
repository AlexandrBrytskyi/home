package week3home.objtoxml;

import week3home.reflection.Man;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.*;

/**
 * User: huyti
 * Date: 13.10.15
 */
public class Test {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IllegalAccessException {

        Man[] men = new Man[]{new Man(24, "Vasia", new Date()),
                new Man(28, "Petia", new Date())};

        //success
//        XMLObjectParser.objectToXML(new Man[]{new Man(24, "Vasia", new Date()),
//                new Man(28, "Petia", new Date())}, "src/temp/men.xml") ;
//
        //success
// XMLObjectParser.objectToXML(new Man(24, "Vasia", new Date()), "src/temp/men.xml");

//        success
//        ArrayList<Man> mens = new ArrayList<Man>();
//        mens.add(new Man(24, "Vasia", new Date()));
//        mens.add(new Man(28, "Petia", new Date()));
//        XMLObjectParser.objectToXML(mens, "src/temp/men.xml");



        System.out.println(men.getClass().getTypeName());
    }
}
