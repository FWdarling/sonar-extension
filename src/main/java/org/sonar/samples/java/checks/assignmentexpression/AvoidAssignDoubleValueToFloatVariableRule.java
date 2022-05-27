package org.sonar.samples.java.checks.assignmentexpression;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.semantic.Type;
import org.sonar.plugins.java.api.tree.AssignmentExpressionTree;
import org.sonar.plugins.java.api.tree.ExpressionTree;

@Rule(key = "AvoidAssignDoubleValueToFloatVariableRule")
public class AvoidAssignDoubleValueToFloatVariableRule extends AssignmentExpressionCheck {

    @Override
    public void ruleCheck(AssignmentExpressionTree assignmentExpressionTree) {
        ExpressionTree variable = assignmentExpressionTree.variable();
        ExpressionTree expression = assignmentExpressionTree.expression();
        if(variable.symbolType().is("java.lang.Float") || variable.symbolType().isPrimitive(Type.Primitives.FLOAT)) {
            if(expression.symbolType().is("java.lang.Double") || expression.symbolType().isPrimitive(Type.Primitives.DOUBLE)){
                reportIssue(assignmentExpressionTree, "Avoid assign double value to float variable!");
            }
        }
    }
}