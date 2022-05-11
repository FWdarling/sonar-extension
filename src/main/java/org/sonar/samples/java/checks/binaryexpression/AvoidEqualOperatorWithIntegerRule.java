package org.sonar.samples.java.checks.binaryexpression;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.tree.BinaryExpressionTree;
import org.sonar.plugins.java.api.tree.ExpressionTree;
import org.sonar.plugins.java.api.tree.Tree;

@Rule(key = "AvoidEqualOperatorWithIntegerRule")
public class AvoidEqualOperatorWithIntegerRule extends BinaryExpressionCheck {

  @Override
  public void ruleCheck(BinaryExpressionTree binaryExpressionTree) {
    if(binaryExpressionTree.operatorToken().text().equals("==")) {
      ExpressionTree leftOpe = binaryExpressionTree.leftOperand(), rightOpe = binaryExpressionTree.rightOperand();
      if(leftOpe.symbolType().is("java.lang.Integer") && rightOpe.symbolType().is("java.lang.Integer")) {
        reportIssue(binaryExpressionTree, "Avoid use equals operator with Integers!");
      }
    }
  }
}
