package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;
import org.sonar.samples.java.checks.$_ruletype.$_rulenameRule;

public class $_rulenameRuleTest {

    @Test
    void test() {
        CheckVerifier.newVerifier()
            .onFile("src/test/files/$_rulenameCheck.java")
            .withCheck(new $_rulenameRule())
            .verifyIssues();
    }
}