import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class EasyLangListenerImpl extends EasyLangBaseListenerExt {

    public String finalCode = "";

    //TODO: done
//    @Override
//    public void enterStart(EasyLangParser.StartContext ctx) {
//        super.enterStart(ctx);
//
//        finalCode += "public class Main {\n";
//    }
//
//    @Override
//    public void exitStart(EasyLangParser.StartContext ctx) {
//        super.exitStart(ctx);
//
//        finalCode += "}";
//    }

    @Override
    public void enterProgram(EasyLangParser.ProgramContext ctx) {
        super.enterProgram(ctx);
    }

    @Override
    public void exitProgram(EasyLangParser.ProgramContext ctx) {
        super.exitProgram(ctx);
    }

    private void ifProgram(EasyLangParser.ProgramContext ctx) {

    }

    @Override
    public void enterCode(EasyLangParser.CodeContext ctx) {
        super.enterCode(ctx);

    }

    @Override
    public void exitCode(EasyLangParser.CodeContext ctx) {
        super.exitCode(ctx);
    }

    private void ifCode(EasyLangParser.CodeContext ctx) {

    }

    //TODO: done
//    @Override
//    public void enterExpression(EasyLangParser.ExpressionContext ctx) {
//        super.enterExpression(ctx);
//
//        ifExpression(ctx);
//    }
//
//    @Override
//    public void exitExpression(EasyLangParser.ExpressionContext ctx) {
//        super.exitExpression(ctx);
//    }

    private void ifExpression(EasyLangParser.ExpressionContext ctx) {
        if (ctx.varDeclaration() != null)
            ifVarDeclaration(ctx.varDeclaration());
        if (ctx.varExpression() != null)
            enterVarExpression(ctx.varExpression());
        if (ctx.printExpression() != null)
            ifPrint(ctx.printExpression());
        if (ctx.functionCall() != null)
            enterFunctionCall(ctx.functionCall());
//        if (ctx.logicalExpression() != null)
//            ifLogicalExpression(ctx.logicalExpression());
    }

    @Override
    public void enterFlowExpression(EasyLangParser.FlowExpressionContext ctx) {
        super.enterFlowExpression(ctx);
    }

    @Override
    public void exitFlowExpression(EasyLangParser.FlowExpressionContext ctx) {
        super.exitFlowExpression(ctx);
    }

    //TODO: done
//    @Override
//    public void enterPrintExpression(EasyLangParser.PrintExpressionContext ctx) {
//        super.enterPrintExpression(ctx);
//
//        ifPrint(ctx);
//    }
//
//    @Override
//    public void exitPrintExpression(EasyLangParser.PrintExpressionContext ctx) {
//        super.exitPrintExpression(ctx);
//    }

    private void ifPrint(EasyLangParser.PrintExpressionContext ctx) {
        if (ctx.T_ID() != null) {
            finalCode += "System.out.println(" + ctx.T_ID() + ")";
        }

        if (ctx.T_PRINT() != null){
            finalCode += "System.out.println(" + ctx.value().getText() + ")";
        }
    }

    //TODO: done
//    @Override
//    public void enterStartFunction(EasyLangParser.StartFunctionContext ctx) {
//        super.enterStartFunction(ctx);
//
//        finalCode += "\n\tpublic static void main(String[] args) {\n";
//
//        ifCode(ctx.code());
//    }
//
//    @Override
//    public void exitStartFunction(EasyLangParser.StartFunctionContext ctx) {
//        super.exitStartFunction(ctx);
//
//        finalCode += "\t}\n";
//    }

//    @Override
//    public void enterBool_val(EasyLangParser.Bool_valContext ctx) {
//        super.enterBool_val(ctx);
//
//        ifBool(ctx);
//    }
//
//    @Override
//    public void exitBool_val(EasyLangParser.Bool_valContext ctx) {
//        super.exitBool_val(ctx);
//    }
//
    private void ifBool(EasyLangParser.Bool_valContext ctx) {
        if (ctx.T_BOOL_TRUE() != null) {
            finalCode += "true";
        }

        if (ctx.T_BOOL_FALSE() != null) {
            finalCode += "false";
        }
    }

    //TODO: done
//    @Override
//    public void enterType(EasyLangParser.TypeContext ctx) {
//        super.enterType(ctx);
//
//        ifType(ctx);
//    }
//
//    @Override
//    public void exitType(EasyLangParser.TypeContext ctx) {
//        super.exitType(ctx);
//    }

    private void ifType(EasyLangParser.TypeContext ctx) {
        if (ctx.T_INTEGER() != null) {
            finalCode += "int ";
        }

        if (ctx.T_BOOL() != null) {
            finalCode += "boolean ";
        }

        if (ctx.T_STRING() != null) {
            finalCode += "String ";
        }
    }

    //TODO: done
//    @Override
//    public void enterValue(EasyLangParser.ValueContext ctx) {
//        super.enterValue(ctx);
//
//        ifValue(ctx);
//    }
//
//    @Override
//    public void exitValue(EasyLangParser.ValueContext ctx) {
//        super.exitValue(ctx);
//    }

    private void ifValue(EasyLangParser.ValueContext ctx) {
        if (ctx.T_INTEGER_VAL() != null) {
            finalCode += ctx.T_INTEGER_VAL();
        }

        if (ctx.T_STRING_VAL() != null) {
            finalCode += ctx.T_STRING_VAL();
        }

        if (ctx.bool_val() != null) {
            ifBool(ctx.bool_val());
        }
    }

    //TODO: done
//    @Override
//    public void enterVarDeclaration(EasyLangParser.VarDeclarationContext ctx) {
//        super.enterVarDeclaration(ctx);
//
//        ifVarDeclaration(ctx);
//    }
//
//    @Override
//    public void exitVarDeclaration(EasyLangParser.VarDeclarationContext ctx) {
//        super.exitVarDeclaration(ctx);
//    }

    private void ifVarDeclaration(EasyLangParser.VarDeclarationContext ctx) {
        if (ctx.factor() != null) {
            ifType(ctx.type());

            finalCode += ctx.T_ID() + " = ";

            ifFactor(ctx.factor());
        } else {
            ifType(ctx.type());

            finalCode += ctx.T_ID();
        }
    }

    //TODO: done
//    @Override
//    public void enterVarExpression(EasyLangParser.VarExpressionContext ctx) {
//        super.enterVarExpression(ctx);
//
//        finalCode += ctx.T_ID() + " = ";
//        ifFactor(ctx.factor());
//    }
//
//    @Override
//    public void exitVarExpression(EasyLangParser.VarExpressionContext ctx) {
//        super.exitVarExpression(ctx);
//    }

    //TODO: done
//    @Override
//    public void enterFactor(EasyLangParser.FactorContext ctx) {
//        super.enterFactor(ctx);
//
//        ifFactor(ctx);
//    }
//
//    @Override
//    public void exitFactor(EasyLangParser.FactorContext ctx) {
//        super.exitFactor(ctx);
//    }

    private void ifFactor(EasyLangParser.FactorContext ctx) {
        if (ctx.T_ID() != null) {
            finalCode += ctx.T_ID();
        }

        if (ctx.value() != null) {
            ifValue(ctx.value());
        }

        if (ctx.arithmeticExpression() != null) {
            ifArithmeticExpression(ctx.arithmeticExpression());
        }
    }

// TODO done
    @Override
    public void enterArithmeticExpression(EasyLangParser.ArithmeticExpressionContext ctx) {
        super.enterArithmeticExpression(ctx);
    }

    @Override
    public void exitArithmeticExpression(EasyLangParser.ArithmeticExpressionContext ctx) {
        super.exitArithmeticExpression(ctx);
    }

    private void ifArithmeticExpression(EasyLangParser.ArithmeticExpressionContext ctx) {
        enterArithmeticExpression(ctx);
    }

    //TODO: done
//    @Override
//    public void enterParenthesisExp(EasyLangParser.ParenthesisExpContext ctx) {
//        super.enterParenthesisExp(ctx);
//
//        finalCode += '(';
//    }
//
//    @Override
//    public void exitParenthesisExp(EasyLangParser.ParenthesisExpContext ctx) {
//        super.exitParenthesisExp(ctx);
//
//        finalCode += ')';
//    }

//    @Override
//    public void enterMulDivExp(EasyLangParser.MulDivExpContext ctx) {
//        super.enterMulDivExp(ctx);
//
//
//        ifEnterMulDiv(ctx);
//    }



//    @Override
//    public void exitMulDivExp(EasyLangParser.MulDivExpContext ctx) {
//        super.exitMulDivExp(ctx);
//
//        ifExitMulDiv(ctx);
//    }


//    @Override
//    public void enterAddSubExp(EasyLangParser.AddSubExpContext ctx) {
//        super.enterAddSubExp(ctx);
//
//        ifEnterAddSub(ctx);
//    }



//    @Override
//    public void exitAddSubExp(EasyLangParser.AddSubExpContext ctx) {
//        super.exitAddSubExp(ctx);
//
//        ifExitAddSub(ctx);
//    }



    //TODO: done
//    @Override
//    public void enterReturnn(EasyLangParser.ReturnnContext ctx) {
//        super.enterReturnn(ctx);
//
//        ifReturnn(ctx);
//    }
//
//    @Override
//    public void exitReturnn(EasyLangParser.ReturnnContext ctx) {
//        super.exitReturnn(ctx);
//    }

    private void ifReturnn(EasyLangParser.ReturnnContext ctx) {
        if (ctx.T_ID() != null) {
            finalCode += "return " + ctx.T_ID() + ";";
        }

        if (ctx.value() != null) {
            ifValue(ctx.value());
        }
    }

    //TODO: done
//    @Override
//    public void enterFunction(EasyLangParser.FunctionContext ctx) {
//        super.enterFunction(ctx);
//
//        finalCode += "function ";
//
//        ifType(ctx.type());
//
//        finalCode += ctx.T_ID() + "(";
//
//        ifTypedArgList(ctx.typedArgList());
//
//        finalCode += ") {\n";
//
//        ifCode(ctx.code());
//
//        ifReturnn(ctx.returnn());
//
//        finalCode += "\n}";
//    }
//
//    @Override
//    public void exitFunction(EasyLangParser.FunctionContext ctx) {
//        super.exitFunction(ctx);
//    }

    private void ifTypedArgList(EasyLangParser.TypedArgListContext ctx) {
        if (ctx.T_COMMA() != null) {
            ifType(ctx.left);
            finalCode += ctx.T_ID() + ", ";
            ifTypedArgList(ctx.right);
        }
        if (ctx.T_COMMA() == null) {
            ifType(ctx.type());
            finalCode += ctx.T_ID();
        }
    }

    private void ifArgList(EasyLangParser.ArgListContext ctx) {
        if (ctx.T_COMMA() != null) {
            finalCode += ctx.left.getText() + ", ";
            ifArgList(ctx.right);
        }
        if (ctx.T_COMMA() == null)
            ifFactor(ctx.factor());
    }

    //TODO: done
//    @Override
//    public void enterFunctionCall(EasyLangParser.FunctionCallContext ctx) {
//        super.enterFunctionCall(ctx);
//
//        finalCode += ctx.T_ID().getText() + '(';
//
//        ifArgList(ctx.argList());
//
//        finalCode += ')';
//    }
//
//    @Override
//    public void exitFunctionCall(EasyLangParser.FunctionCallContext ctx) {
//        super.exitFunctionCall(ctx);
//    }


// TODO: done
    private void ifLogicalExpression(EasyLangParser.LogicalExpressionContext ctx) {

        if (ctx.getChildCount() == 1) {
            if (ctx instanceof EasyLangParser.LogicCompareExprContext) {
                ifCompare(((EasyLangParser.LogicCompareExprContext) ctx).compareExpression());
            }
            if (ctx instanceof EasyLangParser.LogicFunctionCallContext) {
                enterFunctionCall(((EasyLangParser.LogicFunctionCallContext) ctx).functionCall());
            }
            if (ctx instanceof EasyLangParser.LogicIdContext) {
                finalCode += ((EasyLangParser.LogicIdContext) ctx).T_ID();
            }
            if (ctx instanceof EasyLangParser.LogicNotContext) {
                finalCode += "!";
            }
        }
    }

    @Override
    public void enterLogicParenthesis(EasyLangParser.LogicParenthesisContext ctx) {
        super.enterLogicParenthesis(ctx);

        finalCode += '(';
    }

    @Override
    public void exitLogicParenthesis(EasyLangParser.LogicParenthesisContext ctx) {
        super.exitLogicParenthesis(ctx);

        finalCode += ')';
    }

    @Override
    public void enterLogicAndOr(EasyLangParser.LogicAndOrContext ctx) {
        super.enterLogicAndOr(ctx);

        ifEnterLogicAndOr(ctx);
    }

    private void ifEnterLogicAndOr(EasyLangParser.LogicAndOrContext ctx) {

        if (ctx.logicalExpression(0).getChildCount() == 1) {
            ifLogicalExpression(ctx.logicalExpression(0));
            if (ctx.T_AND() != null)
                finalCode += " && ";
            else if (ctx.T_OR() != null)
                finalCode += " || ";

        }

        if (ctx.children.get(ctx.children.size() - 1) == ctx.logicalExpression(1)) {
            if (ctx.logicalExpression(1) instanceof EasyLangParser.LogicCompareExprContext) {
                ifCompare(((EasyLangParser.LogicCompareExprContext) ctx.logicalExpression(1)).compareExpression());
            }
            if (ctx.logicalExpression(1) instanceof EasyLangParser.LogicFunctionCallContext) {
                enterFunctionCall(((EasyLangParser.LogicFunctionCallContext) ctx.logicalExpression(1)).functionCall());
            }
            if (ctx.logicalExpression(1) instanceof EasyLangParser.LogicIdContext) {
                finalCode += ((EasyLangParser.LogicIdContext) ctx.logicalExpression(1)).T_ID();
            }
            if (ctx.logicalExpression(1) instanceof EasyLangParser.LogicNotContext) {
                finalCode += "!";
                ifLogicalExpression((EasyLangParser.LogicalExpressionContext) ctx.logicalExpression(1).getChild(1));
            }
        }
    }

    @Override
    public void exitLogicAndOr(EasyLangParser.LogicAndOrContext ctx) {
        super.exitLogicAndOr(ctx);
    }

    //TODO: done
//        @Override
//    public void enterCompareExpression(EasyLangParser.CompareExpressionContext ctx) {
//        super.enterCompareExpression(ctx);
//
//        ifCompare(ctx);
//    }
//
//
//    @Override
//    public void exitCompareExpression(EasyLangParser.CompareExpressionContext ctx) {
//        super.exitCompareExpression(ctx);
//    }

    private void ifCompare(EasyLangParser.CompareExpressionContext ctx) {
        if (ctx.T_EQ() != null) {
            ifFactor(ctx.left);
            finalCode += " = ";
            ifFactor(ctx.right);
        }
        if (ctx.T_NEQ() != null) {
            ifFactor(ctx.left);
            finalCode += " != ";
            ifFactor(ctx.right);
        }
        if (ctx.T_L() != null) {
            ifFactor(ctx.left);
            finalCode += " < ";
            ifFactor(ctx.right);
        }
        if (ctx.T_G() != null) {
            ifFactor(ctx.left);
            finalCode += " > ";
            ifFactor(ctx.right);
        }
        if (ctx.T_LEQ() != null) {
            ifFactor(ctx.left);
            finalCode += " <= ";
            ifFactor(ctx.right);
        }
        if (ctx.T_GEQ() != null) {
            ifFactor(ctx.left);
            finalCode += " >= ";
            ifFactor(ctx.right);
        }
    }


    @Override
    public void enterConditionalExpression(EasyLangParser.ConditionalExpressionContext ctx) {
        super.enterConditionalExpression(ctx);
    }

    @Override
    public void exitConditionalExpression(EasyLangParser.ConditionalExpressionContext ctx) {
        super.exitConditionalExpression(ctx);
    }

    @Override
    public void enterUntilExpression(EasyLangParser.UntilExpressionContext ctx) {
        super.enterUntilExpression(ctx);

        finalCode += "while (";

        ifLogicalExpression(ctx.logicalExpression());

    }

    @Override
    public void exitUntilExpression(EasyLangParser.UntilExpressionContext ctx) {
        super.exitUntilExpression(ctx);

        finalCode += ") {\n";

        ifCode(ctx.code());

        finalCode += "\n}";
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        super.enterEveryRule(ctx);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        super.exitEveryRule(ctx);
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        super.visitTerminal(node);
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
