package org.sonar.samples.java.checks.methodstatement;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.semantic.Symbol;
import org.sonar.plugins.java.api.tree.ExpressionTree;
import org.sonar.plugins.java.api.tree.IdentifierTree;
import org.sonar.plugins.java.api.tree.MemberSelectExpressionTree;
import org.sonar.plugins.java.api.tree.MethodInvocationTree;

/**
 * description: AvoidEqualsWithPackagingFloatRule
 * date: 5/10/22 5:04 PM
 * author: fourwood
 */
@Rule(key = "AvoidEqualsWithPackagingFloatRule")
public class AvoidEqualsWithPackagingFloatRule extends MethodCallStatementCheck{

  @Override
  public void ruleCheck(MethodInvocationTree methodInvocationTree, MemberSelectExpressionTree memberSelectExpressionTree, IdentifierTree identifier, ExpressionTree expression) {
    if("equals".equals(identifier.name())) {
      Symbol symbol = methodInvocationTree.symbol();
       if(symbol.owner().type().is("java.lang.Double") || symbol.owner().type().is("java.lang.Float")) {
         reportIssue(methodInvocationTree, "Avoid use equals with packaging float type!");
       }
    }
  }
}
