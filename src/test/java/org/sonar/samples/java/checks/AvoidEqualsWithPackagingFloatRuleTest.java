package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;
import org.sonar.samples.java.checks.methodstatement.AvoidEqualsWithPackagingFloatRule;

/**
 * description: AvoidEqualsWithPackagingFloatRuleTest
 * date: 5/10/22 7:17 PM
 * author: fourwood
 */
public class AvoidEqualsWithPackagingFloatRuleTest {

  @Test
  void test() {
    CheckVerifier.newVerifier()
      .onFile("src/test/files/AvoidEqualsWithPackagingFloatCheck.java")
      .withCheck(new AvoidEqualsWithPackagingFloatRule())
      .verifyIssues();
  }
}
