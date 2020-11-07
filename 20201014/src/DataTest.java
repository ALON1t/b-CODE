import java.util.Date;

public class DataTest {

    public static void main1(String[] args) {
        // 传入Long类型夫人数字，表示1970经过了10000毫秒后，到达的时间
        java.util.Date d = new java.util.Date(10000);
        //Date d  = new Date();
        java.sql.Date d2 = new java.sql.Date(100000);
        //java,sql.Timestape类似

        //无参的构造方法：代码执行时，当前的时间
        java.util.Date d1 = new java.util.Date();


    }
}
