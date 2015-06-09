package sun.jtutorial.core.xml;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;
import sun.jtutorial.core.xml.entity.Foo;

import java.io.IOException;

/**
 * Created by 148112 on 2015/6/5.
 */

/*
    Reference URL: http://commons.apache.org/proper/commons-digester/guide/core.html#doc.Stack
 */
public class DigesterDemo {
    public static void main(String[] args) throws Exception{

        Digester digester = new Digester();
        digester.setUseContextClassLoader(true);
        digester.setValidating(false);

        digester.addObjectCreate("foo","sun.jtutorial.core.xml.entity.Foo");
        digester.addSetProperties("foo");
        digester.addObjectCreate("foo/bar", "sun.jtutorial.core.xml.entity.Bar");
        digester.addSetProperties("foo/bar");
        digester.addObjectCreate("foo/bar/zoo", "sun.jtutorial.core.xml.entity.Zoo");
        digester.addSetProperties("foo/bar/zoo");
        digester.addSetNext("foo/bar", "setBar", "sun.jtutorial.core.xml.entity.Bar");
        digester.addSetNext("foo/bar/zoo", "setZoo", "sun.jtutorial.core.xml.entity.Zoo");

        Foo foo = (Foo)digester.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("xml/foo.xml"));
        System.out.println(foo.getName());
        System.out.println(foo.getBar().getZoo().getName());

    }
}
