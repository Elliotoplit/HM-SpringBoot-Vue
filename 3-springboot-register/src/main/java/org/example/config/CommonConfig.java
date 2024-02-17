package org.example.config;

import cn.itcast.pojo.Country;
import cn.itcast.pojo.Province;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    @ConditionalOnProperty(prefix = "country",value={"name","system"}) //条件装配,当yml配置文件中有country.name和country.system时才装配
    @Bean // 默认模式（常用）：没有指定name时直接通过方法名获取
    public Country country(@Value("${country.name}") String name,@Value("${country.system}") String system){
        Country country = new Country();
        country.setName(name);
        country.setSystem(system);
        return country;
    }

//    @Bean("pv") //指定 name 时 方法名province 失效
//    public Province province(Country country){
//        System.out.println("province: " + country);
//        return new Province();
//    }

    //
    @Bean
//    @ConditionalOnMissingBean(Country.class) //当容器中没有Country bean时才装配 适用于多个实现类时
    @ConditionalOnClass(name="org.springframework.web.servlet.DispatcherServlet")
    public Province province(){
        return new Province();
    }
}
