# coverage-across-modules-demo

[![Build Status](https://travis-ci.org/ujjboy/coverage-across-modules-demo.svg?branch=master)](https://travis-ci.org/ujjboy/coverage-across-modules-demo)
[![Coverage Status](https://codecov.io/gh/ujjboy/coverage-across-modules-demo/branch/master/graph/badge.svg)](https://codecov.io/gh/ujjboy/coverage-across-modules-demo)
![License](https://img.shields.io/badge/license-Apache--2.0-green.svg)


某些工程结构下，我们会将 core 代码和 test 代码分开，例如：

```
+parent
|--core
    |--api
    |--spi
|--test
    |--test-common
    |--test-integration
```

如果这个时候我们适用 jacoco 去跑测试覆盖率，你会发现测试覆盖率并不是期望中的值。

这是因为 test 模块没有包含任何 core 源码，所以是无法统计到测试覆盖率的。

这时候我们就需要用到 jacoco 0.7.7 的一个新特性 [`report-aggregate`](http://www.jacoco.org/jacoco/trunk/doc/report-aggregate-mojo.html)

使用方式：

第一步：在主`pom.xml` 加入

```xml

<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.7.9</version>
    <executions>
        <execution>
            <id>default-prepare-agent</id>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>
        <execution>
            <id>default-report</id>
            <phase>test</phase>
            <goals>
                <goal>report-aggregate</goal>
            </goals>
        </execution>
    </executions>
</plugin>  
```

第二步：在没用源码的工程里加入 `<dependency />` 依赖
例如在：`test/test-integration/pom.xml`里加入
```
<dependencies>
    <dependency>
        <groupId>xx</groupId>
        <artifactId>test-common</artifactId>
    </dependency>
    <dependency>
        <groupId>xx</groupId>
        <artifactId>spi</artifactId>
    </dependency>
    <dependency>
        <groupId>xx</groupId>
        <artifactId>api</artifactId>
    </dependency>
<dependencies>
```

第三步：直接 `mvn test` 即可。
