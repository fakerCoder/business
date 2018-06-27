package com.all.win.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BusinessApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
        //修改Banner的模式为OFF
//        SpringApplicationBuilder builder = new SpringApplicationBuilder(SupplyDistributionApplication.class);
//        builder.bannerMode(Banner.Mode.OFF).run(args);
    }
}
