import org.apache.log4j.Logger;

/**
 * @Author: yanshilong
 * @Date: 18-8-12 上午11:24
 * @Version 1.0
 */
public class Log4jTest {
    static Logger logger=Logger.getLogger(Log4jTest.class);
    public static void main(String[] args) {
        System.out.println("this is a log4j test");
        logger.debug("this is a test ");
    }
}
