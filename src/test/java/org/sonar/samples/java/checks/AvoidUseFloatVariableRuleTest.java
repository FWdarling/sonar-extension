package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;
import org.sonar.samples.java.checks.variable.AvoidUseFloatVariableRule;

public class AvoidUseFloatVariableRuleTest {

    @Test
    void test() {
        CheckVerifier.newVerifier()
            .onFile("src/test/files/AvoidUseFloatVariableCheck.java")
            .withCheck(new AvoidUseFloatVariableRule())
            .verifyIssues();
    }
}