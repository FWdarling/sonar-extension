package org.sonar.samples.java.checks.variable;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.semantic.Type;
import org.sonar.plugins.java.api.tree.VariableTree;

@Rule(key = "AvoidUseFloatVariableRule")
public class AvoidUseFloatVariableRule extends VariableCheck {

    @Override
    public void ruleCheck(VariableTree variableTree) {
        if(variableTree.symbol().type().isPrimitive(Type.Primitives.FLOAT) || variableTree.symbol().type().is("java.lang.Float")) {
            reportIssue(variableTree, "Avoid use float variable!");
        }
    }
}