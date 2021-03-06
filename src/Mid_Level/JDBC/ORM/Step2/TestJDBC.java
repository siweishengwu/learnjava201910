package Mid_Level.JDBC.ORM.Step2;

import Mid_Level.JDBC.ORM.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestJDBC {
    public static Hero get(int id) {
        Hero hero = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root","admin");
             Statement s = c.createStatement();) {
            String sql = "select * from hero where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            // 因为id是唯一的，ResultSet最多只能由一条记录
            // 所以使用if替代while
            if (rs.next()) {
                hero = new Hero();
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                hero.id = id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hero;
    }

    public static void add(Hero h) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "insert into hero values(null,?,?,?)";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "admin");

             PreparedStatement ps = c.prepareStatement(sql);) {
            // 设置参数
            ps.setString(1,h.name);
            ps.setFloat(2,h.hp);
            ps.setInt(3,h.damage);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void delete(Hero h) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "delete from hero where id = ?";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root","admin");
            PreparedStatement ps = c.prepareStatement(sql);){

            // 设置参数
            ps.setInt(1,h.id);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Hero h) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "update hero set name = ? , hp = ? , damage = ? where id = ?";
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1/how2java?characterEncoding=UTF-8","root","admin");
            PreparedStatement ps = c.prepareStatement(sql);) {

            // 设置参数
            ps.setString(1,h.name);
            ps.setFloat(2,h.hp);
            ps.setInt(3,h.damage);
            ps.setInt(4,h.id);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Hero> list() {
        List<Hero> heros = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root","admin");
            Statement s = c.createStatement();) {

            String sql = "select * from hero";
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                Hero hero = new Hero();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.name = name;
                hero.hp = hp;
                hero.id = id;
                heros.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heros;
    }

    public static void main(String[] args) {
        List<Hero> hs = list();
        System.out.println("数据库中总共有" + hs.size() + " 条数据");
        Hero h  = new Hero();
        h.name = "新的英雄";
        System.out.println("新家一条数据");
        add(h);
        hs = list();
        System.out.println("数据库中总共有" + hs.size() + " 条数据");
        System.out.println("取出id=10151的数据，它的name是：");
        h.name = "英雄10151";
        update(h);
        System.out.println("取出id=10151的数据，它的name是：");
        h = get(10151);
        System.out.println(h.name);
        System.out.println("删除id=0400的数据");
        delete(h);
        hs = list();
        System.out.println("数据库中总共有" + hs.size() + " 条数据");
    }
}
