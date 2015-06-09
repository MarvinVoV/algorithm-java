package sun.jtutorial.core.classloader;


import java.net.URL;

/**
 * Created by 148112 on 2015/6/3.
 */
public class ClassLoaderTree {
    /*
        1. Bootstrap classLoader
        2. Extension classLoader
        3. System classLoader

     */
    public static void main(String[] args) {
        // ClassLoader tree
        ClassLoader loader = ClassLoaderTree.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }

        // Bootstrap classLoader load resources.jar, rt.jar, charsets.jar, jsse.jar, sunrsasign.jar, jdk.boot.jar from JAVA_HOME/jre/lib
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.toExternalForm());
        }

        // Get SystemClassLoader
        URL url = ClassLoader.getSystemClassLoader().getResource("");
        if(url!=null)
            System.out.println(url.toExternalForm());



    }
}
