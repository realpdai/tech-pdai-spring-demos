package com.pdai.demo.module;

/**
 * 1 - 创建一个Demo Project，模拟一个需要被封装的DemoModule模块，其中核心方法为exeModuleMethod
 * 2 - 通过starter封装可以直接初始化DemoModule的实例到Spring容器
 * 3 - 在Maven中引入starter，且在yml中配置相应到参数即可直接初始化DemoModule的实例
 * 4 - 在应用中注入DemoModule即可使用其exeModuleMethod方法
 */
public class DemoModule {

    private String version;

    private String name;

    public String exeModuleMethod() {
        return "Demo module, name = " + name + ", version = " + version;
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
