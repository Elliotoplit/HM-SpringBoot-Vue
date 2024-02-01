package org.example.anno;

import org.example.config.CommonImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //Target注解表示该注解可以标注在类上
@Retention(RetentionPolicy.RUNTIME) //Retention注解表示该注解在运行时有效
@Import(CommonImportSelector.class)  //在本组合注解导入ImportSelector实现类 简化启动类里面的代码
public @interface EnableCommonConfig {

}
