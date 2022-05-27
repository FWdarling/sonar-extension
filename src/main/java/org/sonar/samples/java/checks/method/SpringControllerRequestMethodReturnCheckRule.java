package org.sonar.samples.java.checks.method;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.semantic.Symbol;
import org.sonar.plugins.java.api.semantic.SymbolMetadata;
import org.sonar.plugins.java.api.tree.MethodTree;

@Rule(key = "SpringControllerRequestMethodReturnCheckRule")
public class SpringControllerRequestMethodReturnCheckRule extends MethodCheck {

    @Override
    public void ruleCheck(MethodTree methodTree) {
        Symbol.MethodSymbol methodSymbol = methodTree.symbol();
        if(methodSymbol.owner().metadata().isAnnotatedWith("Controller")){
            if(methodSymbol.metadata().isAnnotatedWith("RequestMapping")){
                if(methodTree.symbol().returnType().metadata().isAnnotatedWith("Entity")){
                    reportIssue(methodTree, "Don't use class with @Entity annotation as return value for RequestMapping method");
                }
            }
        }
    }
}

