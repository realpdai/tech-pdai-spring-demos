# Spring Boot - 自定义Starter封装
> 在Springboot封装一个自定义的Starter的一个Demo，从创建一个模块->封装starter->使用。 @pdai

## 思路

 * 1 - 创建一个Demo Project，模拟一个需要被封装的DemoModule模块，其中核心方法为exeModuleMethod
 * 2 - 通过starter封装可以直接初始化DemoModule的实例到Spring容器
 * 3 - 在Maven中引入starter，且在yml中配置相应到参数即可直接初始化DemoModule的实例
 * 4 - 在应用中注入DemoModule即可使用其exeModuleMethod方法


## 新建一个com.pdai.demo项目

  pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.7.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.pdai</groupId>
    <artifactId>demo</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>demo</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <!-- 注意不要引入Springboot模块-->
    </dependencies>

    <build>
        
    </build>

</project>
```

  创建一个测试模块

```java
package com.pdai.demo.module;

/**
 *
 */
public class DemoModule {

    private String version;

    private String name;

    public String exeModuleMethod() {
        return "Demo module, name = "   name   ", version = "   version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

  install

![](https://imgconvert.csdnimg.cn/aHR0cHM6Ly93d3cucGRhaS50ZWNoL19pbWFnZXMvc3ByaW5nL3NwcmluZ2Jvb3Qtc3RhcnRlci1kZW1vLTEucG5n?x-oss-process=image/format,png)

## 封装Starter

  创建项目 - pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.7.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.pdai</groupId>
    <artifactId>demo-springboot-starter</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>demo-springboot-starter</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-autoconfigure</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>com.pdai</groupId>
            <artifactId>demo</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

</project>
```

  Properties

```java
package com.pdai.demospringbootstarter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.pdai")
public class DemoProperties {
    private String version;
    private String name;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

  AutoConfiguration

```java
package com.pdai.demospringbootstarter;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DemoProperties.class)
public class DemoAutoConfiguration {

    @Bean
    public com.pdai.demo.module.DemoModule demoModule(DemoProperties properties){
        com.pdai.demo.module.DemoModule demoModule = new com.pdai.demo.module.DemoModule();
        demoModule.setName(properties.getName());
        demoModule.setVersion(properties.getVersion());
        return demoModule;

    }
}
```


  spring.factory

> 在META-INF下创建spring.factory文件

```bash
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
com.pdai.demospringbootstarter.DemoAutoConfiguration
```

  install

![](https://imgconvert.csdnimg.cn/aHR0cHM6Ly93d3cucGRhaS50ZWNoL19pbWFnZXMvc3ByaW5nL3NwcmluZ2Jvb3Qtc3RhcnRlci1kZW1vLTIucG5n?x-oss-process=image/format,png)

## 使用starter

只需要在application.yml中

  application.yml
```json
com:
    pdai:
        name: DEMO
        version: v1
```

  pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.7.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.pdai</groupId>
    <artifactId>demo-usage</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>demo-usage</name>
    <description>Demo starter usage</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>com.pdai</groupId>
            <artifactId>demo-springboot-starter</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```

  app

```java
package com.pdai.demo.usage;

import com.pdai.demo.module.DemoModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoUsageApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoUsageApplication.class, args);
    }

    @Autowired
    private DemoModule demoModule;


    @GetMapping("demo")
    public String demo(){
        return demoModule.exeModuleMethod();
    }
}
```

  输出

http://localhost:8080/demo

```bash
Demo module, name = DEMO, version = v1
```

## 代码实例

@see https://github.com/realpdai/springboot-starter-demo

> 更多内容请访问，[Java全栈知识体系](https://www.pdai.tech)
