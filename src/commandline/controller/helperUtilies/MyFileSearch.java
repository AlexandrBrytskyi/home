package commandline.controller.helperUtilies;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: Brytskyi
 * Date: 12.09.15
 * Time: 17:39
 * To change this template use File | Settings | File Templates.
 */
public class MyFileSearch {

    String key;
    String rootPath;

    public MyFileSearch(String key, String rootPath) {
        TreeSet<String> res = search(key, rootPath, new TreeSet<String>());
        for (String re : res) {
            System.out.println(re);
        }
    }

    public TreeSet<String> search(String key, String rootPath, TreeSet<String> result) {

        try {
            File file = new File(rootPath);
            if (file.exists()) {
                if (file.canExecute()) {
                    if (file.getName().contains(key)) {
                        result.add(file.getAbsolutePath());
                    }
                    if (file.isDirectory()) {
                        String[] filesInDirectory = file.list();
                        //        print(filesInDirectory);
                        for (String s : filesInDirectory) {
                            File filein = new File(file.getAbsolutePath() + "\\" + s);
                            if (filein.exists()) {
                                if (filein.canExecute()) {
                                    if (filein.getName().contains(key)) {
                                        result.add(filein.getAbsolutePath());
                                    }
                                    if (filein.isDirectory()) {
                                        search(key, filein.getAbsolutePath(), result);
                                    }
                                }
                            }
                        }
                    }
                }
            }


            return result;
        } catch (NullPointerException e) {
            return result;
        }
    }

}
