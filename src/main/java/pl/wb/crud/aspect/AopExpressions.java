package pl.wb.crud.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    // setup pointcut declarations  https://www.baeldung.com/spring-aop-pointcut-tutorial
    @Pointcut("execution(* pl.wb.crud.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* pl.wb.crud.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("within(pl.wb.crud.dao.*)") //
    private void forDaoPackage() {
    }

    @Pointcut("execution(public void pl.wb.crud.service.UserService.deleteById(int))")
    public void forDeletingAccount() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    public void forAppFlow() {
    }
}
