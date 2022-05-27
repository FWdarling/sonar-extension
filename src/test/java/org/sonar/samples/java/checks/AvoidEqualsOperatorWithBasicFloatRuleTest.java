package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;
import org.sonar.samples.java.checks.binaryexpression.AvoidEqualsOperatorWithBasicFloatRule;

public class AvoidEqualsOperatorWithBasicFloatRuleTest {

    @Test
    void test() {
        CheckVerifier.newVerifier()
            .onFile("src/test/files/AvoidEqualsOperatorWithBasicFloatCheck.java")
            .withCheck(new AvoidEqualsOperatorWithBasicFloatRule())
            .verifyIssues();
    }
}