package org.sonar.samples.java.checks.variable;

import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.VariableTree;

import java.util.Collections;
import java.util.List;

/**
 * description: VariableCheck
 * date: 5/26/22 6:52 PM
 * author: fourwood
 */
public abstract class VariableCheck extends IssuableSubscriptionVisitor {
    @Override
    public List<Tree.Kind> nodesToVisit() {
        return Collections.singletonList(Tree.Kind.VARIABLE);
    }

    @Override
    public void visitNode(Tree tree) {
        VariableTree variableTree = (VariableTree) tree;
        ruleCheck(variableTree);
    }

    /**
     * description: ruleCheck
     * date: 5/27/22 10:40 AM
     * author: fourwood
     *
     * @param variableTree sonar 扫描到的所有局部变量 其中 symbol 为语义信息
     */
    abstract public void ruleCheck(VariableTree variableTree);
}
