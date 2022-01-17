import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * Project name(项目名称)：JDBC工具类
 * Package(包名): PACKAGE_NAME
 * Class(类名): Function
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/17
 * Time(创建时间)： 20:49
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Function_old implements Function_interface
{
    /**
     * 连接数据库
     */
    public static Connection getConnection() throws Exception
    {
        Connection connection = null;

        Class.forName("com.mysql.cj.jdbc.Driver");  //新版
        //旧版：com.mysql.jdbc.Driver
        //Loading class `com.mysql.jdbc.Driver'. This is deprecated.
        // The new driver class is `com.mysql.cj.jdbc.Driver'.
        // The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "20010713");

        return connection;
    }

    @Override
    public ArrayList<Student> find()
    {
        ArrayList<Student> list = new ArrayList<>();
        Connection connection = null;
        //PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try
        {
            //加载驱动,获得链接
            connection = getConnection();
            //创建一个Statement对象
            statement = connection.createStatement();
            String sql = "select * from information";
            //执行sql语句，返回结果集
            resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                Integer no = resultSet.getInt("no");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                Integer age = resultSet.getInt("age");
                Student student = new Student(no, name, sex, age);
                list.add(student);
            }
        }
        catch (SQLException e)                   //数据库异常
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("异常！异常内容为：" + e.getMessage());
            //调试使用：
            //e.printStackTrace();
        }
        catch (Exception e)                     //其它异常
        {
            e.printStackTrace();
        }
        finally                                 //关闭
        {
            if (resultSet != null)
            {
                try
                {
                    resultSet.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            if (statement != null)
            {
                try
                {
                    statement.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            if (connection != null)
            {
                try
                {
                    connection.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    public Student findById(Integer no)
    {
        Student student = null;
        Connection connection = null;
        //PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try
        {
            //加载驱动,获得链接
            connection = getConnection();
            //创建一个Statement对象
            statement = connection.createStatement();
            String sql = "select * from information where no=" + no;
            //执行sql语句，返回结果集
            resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                Integer no1 = resultSet.getInt("no");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                Integer age = resultSet.getInt("age");
                student = new Student(no1, name, sex, age);
            }
        }
        catch (SQLException e)                   //数据库异常
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("异常！异常内容为：" + e.getMessage());
            //调试使用：
            //e.printStackTrace();
        }
        catch (Exception e)                     //其它异常
        {
            e.printStackTrace();
        }
        finally                                 //关闭
        {
            if (resultSet != null)
            {
                try
                {
                    resultSet.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            if (statement != null)
            {
                try
                {
                    statement.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            if (connection != null)
            {
                try
                {
                    connection.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        return student;
    }

    @Override
    public int insert(Student student)
    {
        int result = 0;
        Connection connection = null;
        //PreparedStatement preparedStatement = null;
        Statement statement = null;
        try
        {
            //加载驱动,获得链接
            connection = getConnection();
            //创建一个Statement对象
            statement = connection.createStatement();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("insert into information values");
            stringBuilder.append("('");
            stringBuilder.append(student.getNo());
            stringBuilder.append("','");
            stringBuilder.append(student.getName());
            stringBuilder.append("','");
            stringBuilder.append(student.getSex());
            stringBuilder.append("','");
            stringBuilder.append(student.getAge());
            stringBuilder.append("')");
            String sql = stringBuilder.toString();
            System.out.println(sql);
            //执行sql语句，返回结果集
            result = statement.executeUpdate(sql);

        }
        catch (SQLException e)                   //数据库异常
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("异常！异常内容为：" + e.getMessage());
            //调试使用：
            //e.printStackTrace();
        }
        catch (Exception e)                     //其它异常
        {
            e.printStackTrace();
        }
        finally                                 //关闭
        {
            if (statement != null)
            {
                try
                {
                    statement.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            if (connection != null)
            {
                try
                {
                    connection.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public int update(Student student)
    {
        int result = 0;
        Connection connection = null;
        //PreparedStatement preparedStatement = null;
        Statement statement = null;
        try
        {
            //加载驱动,获得链接
            connection = getConnection();
            //创建一个Statement对象
            statement = connection.createStatement();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("update  information set ");
            stringBuilder.append("no='");
            stringBuilder.append(student.getNo());
            stringBuilder.append("',name='");
            stringBuilder.append(student.getName());
            stringBuilder.append("',sex='");
            stringBuilder.append(student.getSex());
            stringBuilder.append("',age='");
            stringBuilder.append(student.getAge());
            stringBuilder.append("' where no=");
            stringBuilder.append(student.getNo());
            String sql = stringBuilder.toString();
            System.out.println(sql);
            //执行sql语句，返回结果集
            result = statement.executeUpdate(sql);

        }
        catch (SQLException e)                   //数据库异常
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("异常！异常内容为：" + e.getMessage());
            //调试使用：
            //e.printStackTrace();
        }
        catch (Exception e)                     //其它异常
        {
            e.printStackTrace();
        }
        finally                                 //关闭
        {
            if (statement != null)
            {
                try
                {
                    statement.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            if (connection != null)
            {
                try
                {
                    connection.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public int update(Student student, int old_no)
    {
        int result = 0;
        Connection connection = null;
        //PreparedStatement preparedStatement = null;
        Statement statement = null;
        try
        {
            //加载驱动,获得链接
            connection = getConnection();
            //创建一个Statement对象
            statement = connection.createStatement();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("update  information set ");
            stringBuilder.append("no='");
            stringBuilder.append(student.getNo());
            stringBuilder.append("',name='");
            stringBuilder.append(student.getName());
            stringBuilder.append("',sex='");
            stringBuilder.append(student.getSex());
            stringBuilder.append("',age='");
            stringBuilder.append(student.getAge());
            stringBuilder.append("' where no=");
            stringBuilder.append(old_no);
            String sql = stringBuilder.toString();
            System.out.println(sql);
            //执行sql语句，返回结果集
            result = statement.executeUpdate(sql);

        }
        catch (SQLException e)                   //数据库异常
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("异常！异常内容为：" + e.getMessage());
            //调试使用：
            //e.printStackTrace();
        }
        catch (Exception e)                     //其它异常
        {
            e.printStackTrace();
        }
        finally                                 //关闭
        {
            if (statement != null)
            {
                try
                {
                    statement.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            if (connection != null)
            {
                try
                {
                    connection.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public int delete(Integer no)
    {
        int result = 0;
        Connection connection = null;
        //PreparedStatement preparedStatement = null;
        Statement statement = null;
        try
        {
            //加载驱动,获得链接
            connection = getConnection();
            //创建一个Statement对象
            statement = connection.createStatement();
            String sql = "delete from information where no=" + no;
            System.out.println(sql);
            //执行sql语句，返回结果集
            result = statement.executeUpdate(sql);
        }
        catch (SQLException e)                   //数据库异常
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("异常！异常内容为：" + e.getMessage());
            //调试使用：
            //e.printStackTrace();
        }
        catch (Exception e)                     //其它异常
        {
            e.printStackTrace();
        }
        finally                                 //关闭
        {
            if (statement != null)
            {
                try
                {
                    statement.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            if (connection != null)
            {
                try
                {
                    connection.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public ArrayList<Student> sort(String column, String asc_or_desc)
    {
        ArrayList<Student> list = new ArrayList<>();
        Connection connection = null;
        //PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try
        {
            //加载驱动,获得链接
            connection = getConnection();
            //创建一个Statement对象
            statement = connection.createStatement();
            String sql = "select * from information order by " + column + " " + asc_or_desc;
            //执行sql语句，返回结果集
            resultSet = statement.executeQuery(sql);
            while (resultSet.next())
            {
                Integer no = resultSet.getInt("no");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                Integer age = resultSet.getInt("age");
                Student student = new Student(no, name, sex, age);
                list.add(student);
            }
        }
        catch (SQLException e)                   //数据库异常
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println("异常！异常内容为：" + e.getMessage());
            //调试使用：
            //e.printStackTrace();
        }
        catch (Exception e)                     //其它异常
        {
            e.printStackTrace();
        }
        finally                                 //关闭
        {
            if (resultSet != null)
            {
                try
                {
                    resultSet.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            if (statement != null)
            {
                try
                {
                    statement.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            if (connection != null)
            {
                try
                {
                    connection.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
