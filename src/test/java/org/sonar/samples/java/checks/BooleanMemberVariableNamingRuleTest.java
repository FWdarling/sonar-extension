package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;
import org.sonar.samples.java.checks.classtree.BooleanMemberVariableNamingRule;

public class BooleanMemberVariableNamingRuleTest {

    @Test
    void test() {
        CheckVerifier.newVerifier()
            .onFile("src/test/files/BooleanMemberVariableNamingCheck.java")
            .withCheck(new BooleanMemberVariableNamingRule())
            .verifyIssues();
    }
}