package org.sonar.samples.java.checks.method;

import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.BinaryExpressionTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.Collections;
import java.util.List;

/**
 * description: MethodCheck
 * date: 5/27/22 1:37 PM
 * author: fourwood
 */
public abstract class MethodCheck extends IssuableSubscriptionVisitor {
    @Override
    public List<Tree.Kind> nodesToVisit() {
        return Collections.singletonList(Tree.Kind.METHOD);
    }

    @Override
    public void visitNode(Tree tree) {
        MethodTree methodTree = (MethodTree) tree;
        ruleCheck(methodTree);
    }

    /**
     * description: ruleCheck
     * date: 5/27/22 1:40 PM
     * author: fourwood
     *
     * @param methodTree 方法对应的AST 记录了每个方法的信息 其中cfg是控制流图 symbol是语义信息 block是方法的代码块
     */
    abstract public void ruleCheck(MethodTree methodTree);
}
