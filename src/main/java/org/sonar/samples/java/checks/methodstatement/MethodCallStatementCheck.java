package org.sonar.samples.java.checks.methodstatement;

import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.*;

import java.util.Collections;
import java.util.List;

/**
 * description: MethodCallStatementCheck
 * date: 5/10/22 3:05 PM
 * author: fourwood
 */
public abstract class MethodCallStatementCheck extends IssuableSubscriptionVisitor {
  @Override
  public List<Tree.Kind> nodesToVisit() {
    return Collections.singletonList(Tree.Kind.METHOD_INVOCATION);
  }

  @Override
  public void visitNode(Tree tree) {
    // methodInvocationTree 记录了方法调用的参数
    MethodInvocationTree methodInvocationTree = (MethodInvocationTree) tree;
    // memberSelectExpressionTree 记录下面两条信息
    MemberSelectExpressionTree memberSelectExpressionTree = (MemberSelectExpressionTree) methodInvocationTree.methodSelect();
    // 嵌套调用从后向前递归 identifier 记录被调用的方法 expression 记录调用方
    IdentifierTree identifier = memberSelectExpressionTree.identifier();
    // 因为调用方可能有多种情况（比如对象、嵌套方法调用）此处使用 ExpressionTree 接收 下层可以使用 is 判断后 cast
    ExpressionTree expression = memberSelectExpressionTree.expression();
    ruleCheck(methodInvocationTree, memberSelectExpressionTree, identifier, expression);
  }

  /**
   * description: 因为调用方可能有多种情况（比如对象、嵌套方法调用）此处使用 ExpressionTree 接收 下层可以使用 is 判断后 cast
   * date: 5/10/22 5:58 PM
   * author: fourwood
   *
   * @param methodInvocationTree 记录了方法调用的参数
   * @param memberSelectExpressionTree 记录下面两条信息 嵌套调用从后向前递归
   * @param identifier 记录被调用的方法
   * @param expression 记录调用方
   */
  abstract public void ruleCheck(MethodInvocationTree methodInvocationTree, MemberSelectExpressionTree memberSelectExpressionTree,
                                 IdentifierTree identifier, ExpressionTree expression);
}
