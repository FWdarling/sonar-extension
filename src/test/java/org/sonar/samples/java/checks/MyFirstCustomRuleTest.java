package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;

/**
 * description: MyFirstCustomCheckTest
 * date: 5/6/22 7:01 PM
 * author: fourwood
 */

class MyFirstCustomRuleTest {

  @Test
  void test() {
    CheckVerifier.newVerifier()
      .onFile("src/test/files/MyFirstCustomCheck.java")
      .withCheck(new MyFirstCustomRule())
      .verifyIssues();
  }

}
