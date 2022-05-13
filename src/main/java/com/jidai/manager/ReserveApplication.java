package com.jidai.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.jidai.manager.mapper")
@EnableCaching
public class ReserveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReserveApplication.class, args);
        System.out.println(
                "                     .::::.\n" +
                "                   .::::::::.\n" +
                "                  :::::::::::  FUCK YOU\n" +
                "              ..:::::::::::'\n" +
                "            '::::::::::::'\n" +
                "              .::::::::::\n" +
                "         '::::::::::::::..\n" +
                "              ..::::::::::::.\n" +
                "            ``::::::::::::::::\n" +
                "             ::::``:::::::::'        .:::.\n" +
                "            ::::'   ':::::'       .::::::::.\n" +
                "          .::::'      ::::     .:::::::'::::.\n" +
                "         .:::'       :::::  .:::::::::' ':::::.\n" +
                "        .::'        :::::.:::::::::'      ':::::.\n" +
                "       .::'         ::::::::::::::'         ``::::.\n" +
                "   ...:::           ::::::::::::'              ``::.\n" +
                "  ```` ':.          ':::::::::'                  ::::..\n" +
                "                     '.:::::'                    ':'````..\n");
    }

}
