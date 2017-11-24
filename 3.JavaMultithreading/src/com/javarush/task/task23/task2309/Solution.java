package com.javarush.task.task23.task2309;

import com.javarush.task.task23.task2309.vo.*;
//import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.List;

/* 
Анонимность иногда так приятна!
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //print(solution.getUsers());
        //print(solution.getLocations());
        int i = 123;
        String s = Integer.toBinaryString(i);
        System.out.println(s);
        byte b = Byte.MIN_VALUE;
        System.out.println(b);
    }

/*    public List getLocations() {
        return new AbstractDbSelectExecutor<Location>(){

            @Override
            public String getQuery() {
                return "SELECT * FROM LOCATION";
            }

            @Override
            public List execute() {
                return super.execute();
            }
        }.execute();
    }
    public List getUsers() {
        return new AbstractDbSelectExecutor<User>(){

            @Override
            public String getQuery() {
                return "SELECT * FROM USER";
            }

            @Override
            public List execute() {
                return super.execute();
            }
        }.execute();
    }
    public List getServers() {
        return new AbstractDbSelectExecutor<Server>(){

            @Override
            public String getQuery() {
                return "SELECT * FROM SERVER";
            }

            @Override
            public List execute() {
                return super.execute();
            }
        }.execute();
    }
    public List getSubjects() {
        return new AbstractDbSelectExecutor<Subject>(){

            @Override
            public String getQuery() {
                return "SELECT * FROM SUBJECT";
            }

            @Override
            public List execute() {
                return super.execute();
            }
        }.execute();
    }
    public List getSubscriptions() {
        return new AbstractDbSelectExecutor<Subscription>(){

            @Override
            public String getQuery() {
                return "SELECT * FROM SUBSCRIPTION";
            }

            @Override
            public List execute() {
                return super.execute();
            }
        }.execute();
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            NamedItem item = (NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }*/


}
