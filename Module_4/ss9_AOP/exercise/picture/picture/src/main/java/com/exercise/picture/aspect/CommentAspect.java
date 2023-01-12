package com.exercise.picture.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CommentAspect {
    private Logger logger = Logger.getLogger(CommentAspect.class.getName());

    @After("execution(* com.exercise.picture.service.BadCommentService.save(*))")
    public void getLogAfter(JoinPoint joinPoint) throws Throwable {
        String methodInfo = joinPoint.getSignature().getName();
        logger.info("Bad words: " + methodInfo );
    }
}
