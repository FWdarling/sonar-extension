package org.sonar.samples.java.checks.classtree;

import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.VariableTree;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description: ClassTreeCheck
 * date: 5/26/22 6:52 PM
 * author: fourwood
 */
public abstract class ClassTreeCheck extends IssuableSubscriptionVisitor {

    @Override
    public List<Tree.Kind> nodesToVisit() {
        return Collections.singletonList(Tree.Kind.CLASS);
    }

    @Override
    public void visitNode(Tree tree) {
        ClassTree classTree = (ClassTree) tree;
        List<Tree> members = classTree.members();
        List<MethodTree> memberMethods = members.stream().filter(member -> member.is(Tree.Kind.METHOD)).
                map(member -> (MethodTree)member).collect(Collectors.toList());
        List<VariableTree> memberVars = members.stream().filter(member -> member.is(Tree.Kind.VARIABLE)).
                map(member -> (VariableTree)member).collect(Collectors.toList());
        ruleCheck(classTree, memberMethods, memberVars);
     }

    /**
     * description: ruleCheck
     * date: 5/27/22 10:44 AM
     * author: fourwood
     *
     * @param classTree 所有 sonar 扫描到的 class 信息都在这里 其中 symbol 是语义
     *       *                  members 存储了类内的所有成员 需要检查某一类成员可以直接用 is 判断后 cast
     * @param memberMethods 所有的类成员方法树
     * @param memberVars 所有的类成员变量树
     */
    abstract public void ruleCheck(ClassTree classTree, List<MethodTree> memberMethods, List<VariableTree> memberVars);

}
