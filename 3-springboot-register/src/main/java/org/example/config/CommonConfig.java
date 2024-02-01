package org.example.config;

import cn.itcast.pojo.Country;
import cn.itcast.pojo.Province;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {
    @Bean // 默认模式（常用）：没有指定name时直接通过方法名获取
    public Country country(){
        return new Country();
    }

    @Bean("pv") //指定 name 时方法名province失效
    public Province province(Country country){
        System.out.println("country = " + country);
        return new Province();
    }
}
