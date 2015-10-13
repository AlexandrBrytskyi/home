package week3home.objtoxml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import sun.reflect.generics.scope.MethodScope;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * User: huyti
 * Date: 12.10.15
 */


//using DOM parser write XML from object or make instance of object from XML file
public class XMLObjectParser {

    //obj to parse
    //path where will be XML
    public static boolean objectToXML(Object obj, String path) throws
            ParserConfigurationException,
            TransformerException,
            IllegalAccessException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document docXML = factory.newDocumentBuilder().newDocument();
        Element root;
        if (typeOfObj(obj) == null) {
            root = docXML.createElement(obj.getClass().getName());
            docXML.appendChild(root);
            appendFields(root, obj.getClass().getDeclaredFields(), obj, docXML);
        } else {
            docXML.appendChild(buildByType(docXML, typeOfObj(obj), obj));
        }


        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transformer = transFactory.newTransformer();
        DOMSource source = new DOMSource(docXML);
        StreamResult result = new StreamResult(fileController(path));
        transformer.transform(source, result);
        return true;
    }

    private static Element buildByType(Document document, String type, Object obj) throws IllegalAccessException {
        if (type.equals("Array")) return buildArray(document, obj);
        if (type.equals("AbstractList")) return buildAstractList(document, obj);
        return null;
    }

    private static Element buildAstractList(Document document, Object obj) throws IllegalAccessException {
        Element root = document.createElement("Array");
        List arr = (List) obj;
        int i = 0;
        for (Object ob : arr) {
            if (typeOfObj(ob) == null) {
                Element ele = document.createElement(ob.getClass().getName());
                ele.setAttribute("num", String.valueOf(i));
                i++;
                appendFields(ele, ob.getClass().getDeclaredFields(), ob, document);
                root.appendChild(ele);
            } else {
                buildByType(document, typeOfObj(ob), ob);
            }
        }
        return root;
    }

    private static Element buildArray(Document document, Object obj) throws IllegalAccessException {
        Element root = document.createElement("Array");
        Object[] arr = (Object[]) obj;
        int i = 0;
        for (Object ob : arr) {
            if (typeOfObj(ob) == null) {
                Element ele = document.createElement(ob.getClass().getName());
                ele.setAttribute("num", String.valueOf(i));
                i++;
                appendFields(ele, ob.getClass().getDeclaredFields(), ob, document);
                root.appendChild(ele);
            } else {
                buildByType(document, typeOfObj(ob), ob);
            }
        }
        return root;
    }

    private static Element appendFields(Element element, Field[] fields, Object obj, Document document) throws IllegalAccessException {
        for (Field field : fields) {
            field.setAccessible(true);
            if (typeOfObj(field.get(obj)) == null) {
                Element el = document.createElement(field.get(obj).getClass().getName());
                el.appendChild(document.createTextNode(field.get(obj).toString()));
                element.appendChild(el);
            } else {
                buildByType(document, typeOfObj(field.get(obj)), obj);
            }
        }
        return element;
    }


    private static String typeOfObj(Object obj) {
        if (obj.getClass().getSuperclass().getSimpleName().equals("AbstractList")) return "AbstractList";
        if (obj.getClass().getSimpleName().equals("Entry")) return "Entry";
        if (obj.getClass().getSuperclass().getSimpleName().equals("AbstractSet")) return "AbstractSet";
        if (obj.getClass().getSuperclass().getSimpleName().equals("AbstractMap")) return "AbstractMap";
        if (obj.getClass().isArray()) return "Array";
        return null;
    }


    private static File fileController(String path) {
        File file = new File(path);
        if (!file.exists()) try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Can not create file" + e.getMessage());
        }
        return file;
    }

    public static Object xmlToObject() {
        return null;
    }

}

