package week3home.reflection;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by serhii on 16.05.15.
 */
public class ReflectSerializer {

    public static void save(Object o, String path) {

        Class cl = o.getClass();

        // try with resources
        try (PrintWriter pw = new PrintWriter(path)) {
            pw.println("class=" + cl.getName());//

            for (Field field : cl.getDeclaredFields()) {
                field.setAccessible(true);
                Save annot = field.getAnnotation(Save.class);
                boolean isAnnotation = field.isAnnotationPresent(Save.class);
                if (annot != null) {
                    pw.println(annot.name() + "=" + field.get(o));
                }
            }
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static Object read(String path) {
        try {
            Scanner sc = new Scanner(new File(path));
            Map<String, String> map = new LinkedHashMap<>();

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] keyVal = line.split("=");
                map.put(keyVal[0], keyVal[1]);
            }

            // load class
            Class cl = Class.forName(map.get("class"));
            Object inst = cl.newInstance();

            map.remove("class");

            for (String fieldName : map.keySet()) {
                Field field = cl.getDeclaredField(fieldName);
                field.setAccessible(true);
                // define type of value
                field.set(inst, getFieldValue(field, map.get(fieldName)));

            }

            return inst;
        } catch (FileNotFoundException | ClassNotFoundException
                | InstantiationException | NoSuchFieldException
                | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Object getFieldValue(Field field, String value) {
        if (field.getType().equals(Integer.class)) return Integer.valueOf(value);
        if (field.getType().equals(String.class)) return value;
        if (field.getType().equals(Date.class)) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss zzz yyyy");
            try {
                return sdf.parse(value.substring(11));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
