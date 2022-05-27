package org.sonar.samples.java.checks.binaryexpression;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.semantic.Type;
import org.sonar.plugins.java.api.tree.BinaryExpressionTree;
import org.sonar.plugins.java.api.tree.ExpressionTree;

@Rule(key = "AvoidEqualsOperatorWithBasicFloatRule")
public class AvoidEqualsOperatorWithBasicFloatRule extends BinaryExpressionCheck {

    @Override
    public void ruleCheck(BinaryExpressionTree binaryExpressionTree) {
        if(binaryExpressionTree.operatorToken().text().equals("==")) {
            ExpressionTree leftOpe = binaryExpressionTree.leftOperand(), rightOpe = binaryExpressionTree.rightOperand();
            if(leftOpe.symbolType().isPrimitive(Type.Primitives.FLOAT) && rightOpe.symbolType().isPrimitive(Type.Primitives.FLOAT)) {
                reportIssue(binaryExpressionTree, "Avoid use equals operator with float variables!");
            }
        }
    }
}