package com.exercise.borrow_book.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LibraryAspect {
    private Logger logger = Logger.getLogger(LibraryAspect.class.getName());

    @After("execution(* com.exercise.borrow_book.service.BookService.increaseBookQuantity(*))")
    public void getLogAfterIncrease(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After: End call " + methodName);
    }

    @After("execution(* com.exercise.borrow_book.service.BookService.decreaseBookQuantity(*))")
    public void getLogAfterDecrease(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After: End call " + methodName);
    }

    @After("execution(* com.exercise.borrow_book.controller.LibraryController.*(..))")
    public void getLogAfter(JoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("After: End call " + methodName);
    }
}
