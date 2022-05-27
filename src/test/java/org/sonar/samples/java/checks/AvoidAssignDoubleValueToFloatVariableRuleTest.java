package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;
import org.sonar.samples.java.checks.assignmentexpression.AvoidAssignDoubleValueToFloatVariableRule;

public class AvoidAssignDoubleValueToFloatVariableRuleTest {

    @Test
    void test() {
        CheckVerifier.newVerifier()
            .onFile("src/test/files/AvoidAssignDoubleValueToFloatVariableCheck.java")
            .withCheck(new AvoidAssignDoubleValueToFloatVariableRule())
            .verifyIssues();
    }
}