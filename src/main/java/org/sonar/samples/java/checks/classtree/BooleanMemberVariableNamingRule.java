package org.sonar.samples.java.checks.classtree;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.semantic.Type;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.VariableTree;

import java.util.List;

@Rule(key = "BooleanMemberVariableNamingRule")
public class BooleanMemberVariableNamingRule extends ClassTreeCheck {

    @Override
    public void ruleCheck(ClassTree classTree, List<MethodTree> memberMethods, List<VariableTree> memberVars) {
        memberVars.stream().filter(member ->
            member.symbol().type().is("java.lang.Boolean") || member.symbol().type().isPrimitive(Type.Primitives.BOOLEAN)
        ).forEach(member -> {
            String name = member.simpleName().name();
            if(!name.startsWith("is") && !name.startsWith("b")) {
                reportIssue(classTree, "boolean member variable names begin with \"b\" or \"is\"");
            }
        });
    }
}