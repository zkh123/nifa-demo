package com.sdkbackendpr;

import com.google.common.base.Strings;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by huanglijun on 2020/4/23
 */
public class HljTest {


    public static void main(String[] args){

        System.out.println( 100 % 3);
        System.out.println( 100 / 3);

        test4();

//        test3();
//        test1();
    }

    public static void test4(){
        String param1 = "CREATE TABLE `user_info_0";
        String param2 = "` (\n" +
                "  `user_id` bigint(19) NOT NULL,\n" +
                "  `user_name` varchar(45) DEFAULT NULL,\n" +
                "  `account` varchar(45) NOT NULL,\n" +
                "  `password` varchar(45) DEFAULT NULL,\n" +
                "  `inserttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',\n" +
                "  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',\n" +
                "  `isactive` tinyint(1) NOT NULL DEFAULT '1' COMMENT '逻辑删除',\n" +
                "  PRIMARY KEY (`user_id`),\n" +
                "  KEY `idx_inserttime` (`inserttime`),\n" +
                "  KEY `idx_updatetime` (`updatetime`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表 /*# Owner: huanglijun ;Manager: huangdada #*/';";

        StringBuffer sb = new StringBuffer();
        for (int i = 321 ; i<=384; i++){
            sb.append(param1 + i + param2);
        }

        System.out.println(sb.toString());
    }


    private static final String DATABASE_PREFIX = "sharding_appinfo0";

    private static final String[] APPINFO_DATABASES = {"sharding_appinfo01", "sharding_appinfo02",
            "sharding_appinfo03", "sharding_appinfo04","sharding_appinfo05",
            "sharding_appinfo06"};

    public static void test3(){
        for (int i = 1 ; i < 1083297; i++){
            String dataBase = "";

            for (String each : APPINFO_DATABASES) {
                if (match(each,i)) {
                    dataBase = each;
                }
            }


            String tableName = "user_info";
            String table = String.format("%s%s",tableName,Strings.padStart(i % (6*64) + "",4,'0'));

            System.out.println("dataBase: " + dataBase + " ,table: " + table );
        }

    }

    private static boolean match(String dbName,int shardingVal){
        return dbName.equals(DATABASE_PREFIX + (((shardingVal % (6*64))/64) + 1) + "");
    }



    private static final String DATABASE_PREFIX1 = "sharding_appinfo0";

    private static final String[] APPINFO_DATABASES1 = {"sharding_appinfo01", "sharding_appinfo02",
            "sharding_appinfo03", "sharding_appinfo04","sharding_appinfo05",
            "sharding_appinfo06"};

    public static void test1(){


        for (int i = 12457444 ; i < 39909277; i++){
            String param = Strings.padStart((i % (6*64))/6 + "",2,'0');
            String tableName = "user_info" + "_" + param;

            String databaseName = "---";

            for (String each : APPINFO_DATABASES1) {
                if (match1(each,i)) {
                    databaseName = each;
                }else {
                    System.out.println("**************");
                }
            }

            System.out.println("tableName: " + tableName + " ,databaseName: " + databaseName );
        }
    }

    private static boolean match1(String dbName,int shardingVal){
        String result = DATABASE_PREFIX + (((shardingVal % (64*6))/6) + 1) + "";
        return dbName.equals(result);
    }


    public static void test2(){


        String param = "CREATE TABLE `user_info_01` (\n" +
                "  `user_id` bigint(19) NOT NULL,\n" +
                "  `user_name` varchar(45) DEFAULT NULL,\n" +
                "  `account` varchar(45) NOT NULL,\n" +
                "  `password` varchar(45) DEFAULT NULL,\n" +
                "  `inserttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',\n" +
                "  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',\n" +
                "  `isactive` tinyint(1) NOT NULL DEFAULT '1' COMMENT '逻辑删除',\n" +
                "  PRIMARY KEY (`user_id`),\n" +
                "  KEY `idx_inserttime` (`inserttime`),\n" +
                "  KEY `idx_updatetime` (`updatetime`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表 /*# Owner: huanglijun ;Manager: huangdada #*/ ';";
    }



    public static void test(){

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date startTime = new Date();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant start = startTime.toInstant();
        String s = dateFormatter.format(start);

    }
}
