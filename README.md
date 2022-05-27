# SonarQube 自定义java规则扩展工具

### 简介

本项目用于毕业设计，是用于 sonarqube 自定义 java 规则扩展的工具，主要是解决官方文档内容较少、官方 demo 及源代码中没有注释等痛点，为了减少学习成本和写重复代码的时间成本而设计

### 如何使用

-   运行项目根目录下的 `code-gen.py` 按照提示生成代码

    ```bash
    python3 code-gen.py
    ```

-   成功后需要先在`src/main/java/org/sonar/samples/java/checks`中生成的源代码文件中实现父类预留的抽象方法来自定义规则

-   实现完成后需要在`src/main/java/org/sonar/samples/java/RuleList.java`的 `getJavaChecks` 方法中注册自己的规则

-   在 `src/test/files`对应的测试文件中加入测试用例，要求至少有一处代码是不满足规则的（即要被检测出来的），在对应代码行后添加注释 `// Noncompliant`

-   此时已经可以编译插件了 在项目根目录运行以下命令 成功后会出现一个新的目录`/target` 里面会有打包好的 jar 文件

    ```bash
    mvn clean install
    ```

-   确保已经安装了[sonarqube](https://www.sonarqube.org/downloads/) 将打包好的 jar 移动到 `$SONAR_HOME/extensions/plugins` 而后启动 SonarQube 即可在 rules 中看到我们自定义的规则

-   更多信息或者有其他自定义需求可以参考下面的 reference

### 自定义规则模式

-   如果您自定义了某一个规则模式，想要添加到此脚本中，可以直接打开根目录下的 `code-gen.py`修改最上面的全局变量

-   在 `rule_type_list`  添加规则模式的名字（使用全小写，与包命名完全匹配）

-   在 `rule_type_desc`  添加规则模式的描述（可以用中文，仅用于脚本运行后提示用户选择规则类型）

-   在 `rule_type_name`  添加规则模式的类命名（必须用大驼峰，且与规则类型的 java 类名完全一致）

### License

 [MIT No Attribution](LICENSE.txt) license.

### Reference

[SonarJava](https://github.com/SonarSource/sonar-java)

[Writing Custom Java Rules 101](https://github.com/SonarSource/sonar-java/blob/master/docs/CUSTOM_RULES_101.md).
