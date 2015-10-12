package reflection;

import java.util.Date;

/**
 * User: huyti
 * Date: 11.10.15
 */
public class Test {
    public static final String PATH = "src/temp/man.txt";

    public static void main(String[] args) {
        Man man = new Man(23,"Yuriy", new Date());
        ReflectSerializer.save(man, PATH);

        Man loaded = (Man) ReflectSerializer.read(PATH);

        System.out.println(loaded);
    }
}
