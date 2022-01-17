import com.sun.tools.javac.Main;

import java.util.ArrayList;

/**
 * Project name(项目名称)：JDBC工具类
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/17
 * Time(创建时间)： 21:29
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test
{
    public static void main(String[] args)
    {
        try
        {
            JDBC.getConnection();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
