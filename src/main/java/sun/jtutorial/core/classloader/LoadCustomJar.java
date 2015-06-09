package sun.jtutorial.core.classloader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by 148112 on 2015/6/3.
 */
public class LoadCustomJar {
    public static void main(String[] args) throws Exception {
        File file = new File("E:\\test\\commons-io-2.4.jar");
        URL url = file.toURI().toURL();
        URL[] urls = new URL[]{url};

        ClassLoader loader = new URLClassLoader(urls);
        Class demoClazz = loader.loadClass("org.apache.commons.io.FileUtils");
        Method[] methods = demoClazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        /* Another method */
        Class clazz2 = Class.forName("org.apache.commons.io.FileUtils", true, loader);
        System.out.println(clazz2.getCanonicalName());


    }
}
