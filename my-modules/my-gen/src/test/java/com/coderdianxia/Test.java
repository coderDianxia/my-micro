package com.coderdianxia;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: Test
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/9/19 14:18
 */
@SpringBootTest(classes = GenApplication.class)
@RunWith(SpringRunner.class)
//@TestPropertySource("classpath:swagger.properties")
//@PropertySources(@PropertySource("classpath:swagger.properties"))
public class Test {

    @Autowired
    FastAutoGenerator fastAutoGenerator;

    @org.junit.Test
    public void main() {

       fastAutoGenerator.globalConfig(builder -> {
            builder.outputDir("D:\\0_java\\2_gitrepository\\my-micro\\my-modules\\my-gen\\src\\test\\java\\com\\coderdianxia");
        }).execute();
    }

    @org.junit.Test
    public void test01() {
        System.out.println("测试代码");
    }

}
