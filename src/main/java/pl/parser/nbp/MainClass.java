package pl.parser.nbp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

public class MainClass
{
    public static void main(String[] args)
    {
        if (args.length == 3)
        {
            Properties properties = System.getProperties();
            properties.setProperty("currency", args[0]);
            properties.setProperty("dateBeg", args[1]);
            properties.setProperty("dateEnd", args[2]);
            ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
            applicationContext.start();
        }
        else
        {
            System.out.print("Sample usage: EUR 2013-01-28 2013-01-31");
        }
    }
}
