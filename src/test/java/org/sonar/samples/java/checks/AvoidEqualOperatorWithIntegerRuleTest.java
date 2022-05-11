package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;
import org.sonar.samples.java.checks.binaryexpression.AvoidEqualOperatorWithIntegerRule;

public class AvoidEqualOperatorWithIntegerRuleTest {

  @Test
  void test() {
    CheckVerifier.newVerifier()
      .onFile("src/test/files/AvoidEqualOperatorWithIntegerCheck.java")
      .withCheck(new AvoidEqualOperatorWithIntegerRule())
      .verifyIssues();
  }
}
