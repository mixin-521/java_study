package cn.itheima.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Configuration 告诉IOC容器这是一个配置类(取代xml)
 * @ComponentScan 开启包扫描, value <==>basePackages ,都是指定要扫描的包的路径,value和basePackages都可以不写
 * @Import 导入其他的配置类,value 要导入的配置类的字节码文件,value是个数组,只导入单个配置类的时候,value和{} 都可以省略
 *          如果要导入多个配置类,value可以省略,{} 不能省略
 *          自配置类的@Configuration 可以省略
 */
@Configuration
@ComponentScan({"cn.itheima"})
@Import(value={JdbcAnnoConfig.class,RedisAnnoConfig.class})
public class PureAnnoConfig {

}
