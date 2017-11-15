package com.cowboy.sbe.spel;/**
 * Created by Administrator on 2017/11/13/0013.
 */

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-13 17:00
 **/
public class HelloSpel {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        User user = new User();
        user.setCredits(100);
        user.setName("bobo");

        ExpressionParser expressionParser = new SpelExpressionParser();
        EvaluationContext evaluationContext = new StandardEvaluationContext(user);

        String name = (String) expressionParser.parseExpression("name").getValue(evaluationContext);
        System.out.println(name);


    }


    public static void test1(){
        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("'hello' + ' tangyinbo'");
        System.out.println(expression.getValue());
    }



    /**
     * Java script spel
     * @throws Exception
     */
    public static void scriptSpel() throws Exception {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("javascript");
        String scriptText = "function sum(a,b){return a+b;}";

        scriptEngine.eval(scriptText);
        Invocable invocable = (Invocable)scriptEngine;

        Object result = invocable.invokeFunction("sum",20,53);
        System.out.println(result);
    }
}
