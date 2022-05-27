package org.sonar.samples.java.checks.assignmentexpression;

import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.AssignmentExpressionTree;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.Collections;
import java.util.List;

/**
 * description: AssignmentExpressionCheck
 * date: 5/26/22 7:28 PM
 * author: fourwood
 */
public abstract class AssignmentExpressionCheck extends IssuableSubscriptionVisitor {
    @Override
    public List<Tree.Kind> nodesToVisit() {
        return Collections.singletonList(Tree.Kind.ASSIGNMENT);
    }

    @Override
    public void visitNode(Tree tree) {
        AssignmentExpressionTree assignmentExpressionTree = (AssignmentExpressionTree) tree;
        ruleCheck(assignmentExpressionTree);
    }

    /**
     * description: ruleCheck
     * date: 5/27/22 10:53 AM
     * author: fourwood
     *
     * @param assignmentExpressionTree 赋值表达式对应的 AST，存储变量、操作符和表达式
     */
    abstract public void ruleCheck(AssignmentExpressionTree assignmentExpressionTree);
}
