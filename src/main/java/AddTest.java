import java.text.DecimalFormat;
import java.util.Random;

/**
 * Project name(项目名称)：JDBC工具类
 * Package(包名): PACKAGE_NAME
 * Class(类名): AddTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/1/17
 * Time(创建时间)： 22:49
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class AddTest
{
    public static int getIntRandom(int min, int max)         //空间复杂度和时间复杂度更低
    {
        if (min > max)
        {
            min = max;
        }
        return min + (int) (Math.random() * (max - min + 1));
    }

    public static int getIntRandom1(int min, int max)          //获取int型的随机数
    {
        if (min > max)
        {
            min = max;
        }
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static double getDoubleRandom(double min, double max)  //double型随机数
    {
        if (min > max)
        {
            min = max;
        }
        return min + (Math.random() * (max - min));
    }

    static DecimalFormat decimalFormat = new DecimalFormat();

    public static double getDoubleRandom(double min, double max, String format)
    {            //空间复杂度和时间复杂度都特别高，只适合获取非常少的格式化的随机数使用。farmat：##.##或00.00
        decimalFormat.applyPattern(format);
        if (min > max)
        {
            min = max;
        }
        return Double.parseDouble(decimalFormat.format(min + (Math.random() * (max - min))));
    }

    public static void main(String[] args)
    {
        Function function = new Function();
        char[] lastName = {'赵', '钱', '孙', '李', '周', '吴', '郑', '王', '冯',
                '陈', '褚', '卫', '蒋', '沈', '韩', '杨', '朱', '秦', '尤', '许', '何', '吕', '施', '张'};
        String name_str = "戚谢邹喻柏水窦章费廉岑薛雷贺倪汤伍余元卜顾孟平黄计伏成戴谈宋茅" +
                "庞杜阮蓝闵席季麻强丁宣贲邓郁单杭洪经房裘缪干解应宗虞万支柯昝管卢莫赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨高夏蔡田樊胡凌霍" +
                "包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠，甄曲家封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎";

        String[] subject = {"语文", "数学", "英语", "化学", "物理", "生物", "政治", "历史", "地理"};
        //System.out.println(lastName.length);
        //System.out.println(name_str.length());
        {
            String name = String.valueOf(lastName[getIntRandom(0, lastName.length - 1)]);
            String name1 = String.valueOf(name_str.charAt(getIntRandom(0, name_str.length() - 1)));
            String name2 = String.valueOf(name_str.charAt(getIntRandom(0, name_str.length() - 1)));
            //System.out.print(name);
            //System.out.print(name1);
            //System.out.println(name2);
            String final_name = name + name1 + name2;
            //System.out.println(final_name);
            //System.out.println(getDoubleRandom(5,10,"00.00"));
        }
        for (int i = 0; i < 800; i++)
        {
            String name = String.valueOf(lastName[getIntRandom(0, lastName.length - 1)]);
            String name1 = String.valueOf(name_str.charAt(getIntRandom(0, name_str.length() - 1)));
            String name2 = String.valueOf(name_str.charAt(getIntRandom(0, name_str.length() - 1)));
            String final_name = name + name1 + name2;
            String sex;
            int s = getIntRandom(0, 1);
            if (s == 0)
            {
                sex = "男";
            }
            else
            {
                sex = "女";
            }
            int age = getIntRandom(13, 27);
            Student student = new Student(i + 1000, final_name, sex, age);
            function.insert(student);
            System.out.print(student);
        }
    }
}
