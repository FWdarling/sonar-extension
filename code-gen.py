import re
import os.path

from cgi import print_form

rule_name = ''
rule_type_index = 0
rule_type_list = ['binaryexpression','methodstatement','classtree','variable','assignmentexpression','method']
rule_type_desc = ['二元表达式检查','方法调用检查','类信息检查','局部变量检查','赋值表达式检查','方法检查']
rule_type_name = ['BinaryExpressionCheck', 'MethodCallStatementCheck','ClassTreeCheck','VariableCheck','AssignmentExpressionCheck','MethodCheck']
rule_title = ''
rule_desc = ''

project_root_path = './'
rule_code_path_prefix = 'src/main/java/org/sonar/samples/java/checks/'
rule_info_file_path = 'src/main/resources/org/sonar/rules/java/'
rule_test_file_path = 'src/test/files/'
rule_test_code_path = 'src/test/java/org/sonar/samples/java/checks/'
template_path = './template/'

rule_code_java = 'rule_code_java'
rule_info_html = 'rule_info_html'
rule_info_json = 'rule_info_json'
rule_test_code = 'rule_test_code'
rule_test_file = 'rule_test_file'

def start():
    print("此脚本用于自动创建 sonarqube 规则扩展插件所需文件 并填充部分代码")
    print("后续需要在指定文件中实现规则并注册，也可以按需修改其他文件")
    print("如果后续有需要更改文件名 清注意在代码中全文搜索并替换 不然可能报错(不推荐)")
    print()
    
    print("====================================================================")
    print("目前支持的自定义检测规则类型有：")
    length = len(rule_type_desc)
    for i in range(length):
        print(str(i) + '.' + rule_type_desc[i], end = ' ')
    print()
    global rule_type_index
    rule_type_index = int(input("请输入对应的索引(0 - " + str(length - 1) + "): " ))
    while rule_type_index < 0 or rule_type_index >= length:
        rule_type_index = int(input("输入有误 请输入对应的索引(0 - " + str(length - 1) + "): " ))
    print()
    
    print("====================================================================")
    print("请输入规则的英文命名（用于类的名字和文件名 请使用大驼峰命名 不要带英文字母以外的字符 注意不要重复使用）")
    print("eg: MyFirstCustomCheck, AvoidEqualOperatorWithInteger")
    global rule_name
    rule_name = input()
    rule_name = re.sub('[^a-zA-Z]', '', rule_name) 
    print("规则命名为" + rule_name)
    file_name = project_root_path + rule_code_path_prefix + rule_type_list[rule_type_index] + '/' + rule_name + "Rule.java"
    if os.path.isfile(file_name):
        print('指定类型中已存在该规则 请重新运行此脚本配置')
        return
    global rule_title
    rule_title = input("请输入规则名称(用于 sonarqube 界面显示): ")
    global rule_desc
    rule_desc = input("请输入规则描述(用于 sonarqube 界面显示): ")
    print('规则将在 sonarqube 显示为' + rule_title + ': ' + rule_desc)
    print()
    
    print("====================================================================")
    print("开始创建文件...")
    excute()


def excute():
    generate_content()

    print("生成自定义规则源代码文件...")
    file_name = project_root_path + rule_code_path_prefix + rule_type_list[rule_type_index] + '/' + rule_name + "Rule.java"
    generate_file(file_name, rule_code_java)
    print("已生成文件 " + file_name)
    print()

    print("生成自定义规则测试代码文件...")
    file_name = project_root_path + rule_test_code_path + rule_name + "RuleTest.java"
    generate_file(file_name, rule_test_code)
    print("已生成文件 " + file_name)
    print()

    print("生成规则信息文件...")
    file_name = project_root_path + rule_info_file_path + rule_name + "Rule.html"
    generate_file(file_name, rule_info_html)
    print("已生成文件 " + file_name)
    file_name = project_root_path + rule_info_file_path + rule_name + "Rule.json"
    generate_file(file_name, rule_info_json)
    print("已生成文件 " + file_name)
    print()

    print("生成规则测试文件...")
    file_name = project_root_path + rule_test_file_path + rule_name + "Check.java"
    generate_file(file_name, rule_test_file)
    print("已生成文件 " + file_name)
    print()

    print("====================================================================")
    print("注意！")
    print("必须：请在自定义规则源代码文件中加入自己的规则实现（根据扩展的抽象类实现对应的抽象函数）")
    print("必须：一定要在 {project_root}/src/main/java/org/sonar/samples/java/RuleList.java 文件中将自己的规则添加到 getJavaChecks 方法中")
    print("必须: 在规则测试文件中写入自己的测试用例（必须是可编译的 java 文件）sonarqube 要求测试文件中至少包含一处不符合规则的代码 并在不符合规则的行后添加注释// Noncompliant 可以参考同目录下其他文件")
    print("可选：按需修改自定义测试代码和规则信息文件 其中规则信息文件用于展示在 sonarqube 界面 写法可参考同目录下其他文件")
    print("完成后将整个 java 项目编译成 jar 放入 sonarqube 的 plugin 文件夹 启动 sonarqube 即可使用 具体操作参考 readme")

def generate_content():

    global rule_code_java
    f = open(template_path + 'RuleCode.java', 'rb')
    rule_code_java = str(f.read(), encoding="utf-8") 
    rule_code_java = rule_code_java.replace('$_rulename', rule_name)
    rule_code_java = rule_code_java.replace('$_ruletypename', rule_type_name[rule_type_index])
    rule_code_java = rule_code_java.replace('$_ruletype', rule_type_list[rule_type_index])
    f.close()

    global rule_info_html
    f = open(template_path + 'RuleInfo.html', 'rb')
    rule_info_html = str(f.read(), encoding="utf-8") 
    rule_info_html = rule_info_html.replace('$_ruledesc', rule_desc)
    f.close()

    global rule_info_json
    f = open(template_path + 'RuleInfo.json', 'rb')
    rule_info_json = str(f.read(), encoding="utf-8") 
    rule_info_json = rule_info_json.replace('$_ruletitle', rule_title)
    f.close()

    global rule_test_code
    f = open(template_path + 'RuleTestCode.java', 'rb')
    rule_test_code = str(f.read(), encoding="utf-8") 
    rule_test_code = rule_test_code.replace('$_ruletype', rule_type_list[rule_type_index])
    rule_test_code = rule_test_code.replace('$_rulename', rule_name)
    f.close()

    global rule_test_file
    f = open(template_path + 'RuleTestFile.java', 'rb')
    rule_test_file = str(f.read(), encoding="utf-8") 
    f.close()

def generate_file(file_name, content):
    file = open(file_name, 'w')
    file.write(content)
    file.close

if __name__ == '__main__':
    start()