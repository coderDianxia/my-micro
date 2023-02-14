package com.coderdianxia;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: Test
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/9/19 14:18
 */
@SpringBootTest(classes = GenApplication.class)
@RunWith(SpringRunner.class)
public class Test {

    @Autowired
    FastAutoGenerator fastAutoGenerator;

    @org.junit.Test
    public void main() {

       fastAutoGenerator.globalConfig(builder -> {
            builder.outputDir("D:\\0_java\\2_gitrepository\\my-micro\\my-modules\\my-gen\\src\\test\\java\\com\\coderdianxia");
        }).execute();
    }

}
