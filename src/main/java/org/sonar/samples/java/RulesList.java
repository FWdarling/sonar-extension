/*
 * Copyright (C) 2012-2022 SonarSource SA - mailto:info AT sonarsource DOT com
 * This code is released under [MIT No Attribution](https://opensource.org/licenses/MIT-0) license.
 */
package org.sonar.samples.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.sonar.plugins.java.api.JavaCheck;
import org.sonar.samples.java.checks.*;
import org.sonar.samples.java.checks.assignmentexpression.AvoidAssignDoubleValueToFloatVariableRule;
import org.sonar.samples.java.checks.binaryexpression.AvoidEqualOperatorWithIntegerRule;
import org.sonar.samples.java.checks.binaryexpression.AvoidEqualsOperatorWithBasicFloatRule;
import org.sonar.samples.java.checks.classtree.BooleanMemberVariableNamingRule;
import org.sonar.samples.java.checks.method.SpringControllerRequestMethodReturnCheckRule;
import org.sonar.samples.java.checks.methodstatement.AvoidEqualsWithPackagingFloatRule;
import org.sonar.samples.java.checks.variable.AvoidUseFloatVariableRule;

public final class RulesList {

  private RulesList() {
  }

  public static List<Class<? extends JavaCheck>> getChecks() {
    List<Class<? extends JavaCheck>> checks = new ArrayList<>();
    checks.addAll(getJavaChecks());
    checks.addAll(getJavaTestChecks());
    return Collections.unmodifiableList(checks);
  }

  /**
   * These rules are going to target MAIN code only
   */
  public static List<Class<? extends JavaCheck>> getJavaChecks() {
    return Collections.unmodifiableList(Arrays.asList(
            MyFirstCustomRule.class,
            AvoidEqualsWithPackagingFloatRule.class,
            AvoidEqualOperatorWithIntegerRule.class,
            AvoidEqualsOperatorWithBasicFloatRule.class,
            AvoidAssignDoubleValueToFloatVariableRule.class,
            BooleanMemberVariableNamingRule.class,
            AvoidUseFloatVariableRule.class,
            SpringControllerRequestMethodReturnCheckRule.class
    ));
  }

  /**
   * These rules are going to target TEST code only
   */
  public static List<Class<? extends JavaCheck>> getJavaTestChecks() {
    return Collections.unmodifiableList(Arrays.asList());
  }
}
