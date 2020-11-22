package frank;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {

        List<Student> list = query("许仙");
    }

    public static List<Student> query(String name) {
        //先准备数据库驱动包，并添加到项目的依赖中
        Connection connection = null;
        PreparedStatement statement = null;
        //com.mysql.jdbc.PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // 加载JDBC驱动程序：反射，这样调用初始化com.mysql.jdbc.Driver类，即将该类加载到JVM方法
            //区，并执行该类的静态方法块、静态属性。

            //不需要加载驱动了，直接new MysqlDataSource();
            //Class.forName("com.mysql.jdbc.Driver");//类加载

            //1.创建数据库连接
            //URL：网址，连接自己Mysql，password为自己的密码
            //数据库连接池  使用DataSource
            MysqlDataSource ds = new MysqlDataSource();
            ds.setUrl("jdbc:mysql://localhost:3306/test?user=root&password=102917&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
            connection = ds.getConnection();
            System.out.println(connection);
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=102917&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
            //System.out.println(connection);

            //2.创建操作命令对象Statement
            //statement = connection.createStatement();//创作简单的操作命令对象Statement
            //3.执行sql
            //占位符就是先占住一个固定的位置，等着再往里面添加内容的符号
            String sql = "select id,sn,name,qq_mail,classes_id from student where name=?";//指定多个占位符，在执行sql的时候替换值
            //PreparedStatement预编译操作命令对象 注意使用String sql传入参数
            //发送sql，让数据库预编译：语法分析，执行顺序分析，执行优化
            statement = connection.prepareStatement(sql);
            //替换占位符:指定占位符的位置（从1开始），数据类型，

            statement.setString(1, name);
            resultSet = statement.executeQuery();
            List<Student> studentList = new ArrayList<>();
            //4.处理结果集（查询操作）
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int sn = resultSet.getInt("sn");
                //String name = resultSet.getString("name");
                String qq_mail = resultSet.getString("qq_mail");
                int classes_id = resultSet.getInt("classes_id");
                System.out.println(String.format("student: id=%d ,sn=%d, name=%s, qq_mail=%s, classes_id=%d", id, sn, name, qq_mail, classes_id));
                Student student = new Student();
                student.setId(id);
                //student.id = id;
                student.setSn(sn);
                student.setName(name);
                student.setQq_mail(qq_mail);
                student.setClasses_id(classes_id);
                studentList.add(student);
            }
            System.out.println(studentList);
            return studentList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("出错", e);
        } finally {
            //5.释放资源
            try {
                //connection.close();
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //一般来说，对象中的属性不提供对外直接修改
    //1.getter 和 setter 方法
    //2.构造方法来设置
    private static class Student {//内部类
        private Integer id;
        private Integer sn;
        private String name;
        private String qq_mail;
        private Integer classes_id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getSn() {
            return sn;
        }

        public void setSn(Integer sn) {
            this.sn = sn;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getQq_mail() {
            return qq_mail;
        }

        public void setQq_mail(String qq_mail) {
            this.qq_mail = qq_mail;
        }

        public Integer getClasses_id() {
            return classes_id;
        }

        public void setClasses_id(Integer classes_id) {
            this.classes_id = classes_id;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", sn=" + sn +
                    ", name='" + name + '\'' +
                    ", qq_mail='" + qq_mail + '\'' +
                    ", classes_id=" + classes_id +
                    '}';
        }
    }
}

