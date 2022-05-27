package org.sonar.samples.java.checks;

import org.junit.jupiter.api.Test;
import org.sonar.java.checks.verifier.CheckVerifier;
import org.sonar.samples.java.checks.method.SpringControllerRequestMethodReturnCheckRule;

public class SpringControllerRequestMethodReturnCheckRuleTest {

    @Test
    void test() {
        CheckVerifier.newVerifier()
            .onFile("src/test/files/SpringControllerRequestMethodReturnCheckCheck.java")
            .withCheck(new SpringControllerRequestMethodReturnCheckRule())
            .verifyIssues();
    }
}