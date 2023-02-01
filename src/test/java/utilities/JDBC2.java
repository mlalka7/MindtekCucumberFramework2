package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBC2 {

    public static void main(String[] args) throws SQLException {

        Connection cnn = DriverManager.getConnection(
                "jdbc:postgresql://localhost/HR_Production",
                "postgres",
                "admin"
        );
        Statement stt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        String query="Select * from employees";
        ResultSet rs=stt.executeQuery(query);
       // rs.next();- to heck the connection with db
       // System.out.println(rs.getString("first_name"));

        ResultSetMetaData rsMeta =rs.getMetaData();

       // System.out.println("Column count: "+rsMeta.getColumnCount());
      //  System.out.println("Column #2: "+rsMeta.getColumnName(2));
      //  System.out.println("Table name is: "+rsMeta.getTableName(4));
      //  System.out.println("Is Nullable: "+rsMeta.isNullable(5));

        //print all the columns name
       // for(int i=1; i<= rsMeta.getColumnCount(); i++){
         //   System.out.println("Column Number"+ i+":"+rsMeta.getColumnName(i));
       // }
        Map<Integer,String> map= new HashMap<>();
        System.out.println(map);
        map.put(5,"Chicago");
        map.put(6,"Park Ridge");
        map.put(7,"Lincoln Park");

        Map<Integer,String> map1= new HashMap<>();
        System.out.println(map1);
        map1.put(5,"Mount Prospect");
        map1.put(6,"Schaumburg");
        map1.put(7,"Mundedlein");

        Map<Integer,String> map2= new HashMap<>();
        System.out.println(map2);
        map2.put(5,"Liberyville");
        map2.put(6,"Evanston");
        map2.put(7,"Skokie");

       // List<String> list=new ArrayList<>();
       // list.add("city");
       // list.add("suburb");
       // System.out.println(list);

        List<Map<Integer,String>> list=new ArrayList<>();
        list.add(map);
        list.add(map1);
        list.add(map2);
        System.out.println(list);

        for(int i=0; i<list.size();i++){
            System.out.println("Map # "+(i+ 1));
            for(int j=5; j<8; j++){
                System.out.println(list.get(i).get(j));
            }
            System.out.println("---------------");
        }

    }
}
