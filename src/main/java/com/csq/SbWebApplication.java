package com.csq;

import com.csq.Interceptor.LoginInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * 指定所扫的包，会自动扫描指定包下的全部标有@Component的类，并注册成bean，
 * 当然包括@Component下的子注解@Service,@Repository,@Controller。
 *
 * @author 85060
 */
@SpringBootApplication(scanBasePackages = "com.csq.*")
@MapperScan("com.csq.mapper")
public class SbWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbWebApplication.class, args);
    }
}
