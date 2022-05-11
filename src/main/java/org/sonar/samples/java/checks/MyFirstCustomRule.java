package org.sonar.samples.java.checks;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.semantic.Symbol;
import org.sonar.plugins.java.api.semantic.Type;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;
import org.sonar.plugins.java.api.tree.Tree.Kind;

import java.util.Collections;
import java.util.List;

/**
 * description: MyFirstCustomCheck
 * date: 5/6/22 7:01 PM
 * author: fourwood
 */
@Rule(key = "MyFirstCustomRule")
public class MyFirstCustomRule extends IssuableSubscriptionVisitor {
  @Override
  public List<Kind> nodesToVisit() {
    return Collections.singletonList(Kind.METHOD);
  }

  @Override
  public void visitNode(Tree tree) {
    MethodTree method = (MethodTree) tree;
    if(method.parameters().size() == 1) {
      Symbol.MethodSymbol symbol = method.symbol();
      Type firstParameterType = symbol.parameterTypes().get(0);
      Type returnType = symbol.returnType().type();
      if(returnType.is(firstParameterType.fullyQualifiedName())) {
        reportIssue(method.simpleName(), "Never do that!");

      }
    }
  }
}
