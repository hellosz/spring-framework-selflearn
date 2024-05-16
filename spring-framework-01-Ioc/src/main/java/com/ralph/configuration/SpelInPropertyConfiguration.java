package com.ralph.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @ClassName: SpelInPropertyConfiguration
 * @description:
 * @author: Neng.Tian
 * @create: 2024-04-18 16:05
 **/
@Configuration
public class SpelInPropertyConfiguration {

    @Bean
    public Integer evalDynamicValue(Environment environment) {
//        System.out.println("environment = " + environment);

        String expression = environment.getProperty("dynamic.expression");
        SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
        StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
        Integer calculatedExpression = spelExpressionParser.parseExpression(expression).getValue(evaluationContext, Integer.class);
        return calculatedExpression;
    }
}