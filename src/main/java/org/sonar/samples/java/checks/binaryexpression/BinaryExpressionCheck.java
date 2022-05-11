package org.sonar.samples.java.checks.binaryexpression;

import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.*;
import org.sonar.plugins.java.api.tree.Tree.Kind;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * description: BinaryExpressionCheck
 * date: 5/10/22 4:53 PM
 * author: fourwood
 */
public abstract class BinaryExpressionCheck extends IssuableSubscriptionVisitor {
  @Override
  public List<Kind> nodesToVisit() {
    return Collections.unmodifiableList(Arrays.asList( Kind.MULTIPLY, Kind.DIVIDE,
      Kind.REMAINDER, Kind.PLUS, Kind.MINUS, Kind.LEFT_SHIFT,
      Kind.RIGHT_SHIFT, Kind.UNSIGNED_RIGHT_SHIFT, Kind.LESS_THAN,
      Kind.GREATER_THAN, Kind.LESS_THAN_OR_EQUAL_TO, Kind.GREATER_THAN_OR_EQUAL_TO,
      Kind.EQUAL_TO, Kind.NOT_EQUAL_TO, Kind.AND, Kind.XOR, Kind.OR));
  }

  @Override
  public void visitNode(Tree tree) {
    BinaryExpressionTree binaryExpressionTree = (BinaryExpressionTree) tree;
    ruleCheck(binaryExpressionTree);
  }

  /**
   * description: ruleCheck
   * date: 5/10/22 9:41 PM
   * author: fourwood
   *
   * @param binaryExpressionTree 包括二元运算的左右表达式以及运算符
   */
  abstract public void ruleCheck(BinaryExpressionTree binaryExpressionTree);
}
