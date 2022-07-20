package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspect {

    @Pointcut("execution(* aop.UniLibrary.*(..))")
    private void allMethodsFromUniLibrary() {
    }

    @Pointcut("execution(public void aop.UniLibrary.returnMagazine())")
    private void returnMagazineFromUniLibrary() {
    }

    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
    private void allMethodsExpectReturnMagazineFromUniLibrary() {
    }

    @Before("allMethodsExpectReturnMagazineFromUniLibrary()")
    public void allMethodsExpectReturnMagazineAdvice() {
        System.out.println("allMethodsExpectReturnMagazineAdvice: Log #10");
    }

//    @Pointcut("execution(* aop.UniLibrary.get*())")
//    private void allGetMethodsFromUniLibrary() {
//
//    }
//
//    @Pointcut("execution(* aop.UniLibrary.return*())")
//    private void allReturnMethodsFromUniLibrary() {
//
//    }
//
//    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
//    private void allGetAndReturnsMethodsFromUniLibrary() {
//
//    }
//
//    @Before("allGetMethodsFromUniLibrary()")
//    public void beforeGetLoggingAdvice() {
//        System.out.println("beforeGetLoggingAdvice: writing Log #1");
//    }
//
//    @Before("allReturnMethodsFromUniLibrary()")
//    public void beforeReturnLoggingAdvice() {
//        System.out.println("beforeReturnLoggingAdvice: writing Log #2");
//    }
//
//    @Before("allGetAndReturnsMethodsFromUniLibrary()")
//    public void beforeGetAndReturnLoggingAdvice() {
//        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log #3");
//    }

//    @Pointcut("execution(* get*())")
//    private void allGetMethods() {
//    }
//
//    @Before("allGetMethods()")
//    public void beforeGetLoggingAdvice() {
//        System.out.println("beforeGetBookAdvice: попытка получить книгу/журнал");
//    }
//
//    @Before("allGetMethods()")
//    public void beforeGetSecurityAdvice() {
//        System.out.println("beforeGetSecurityAdvice проверка прав на получение"
//                + "книги/журнала");
//    }

}
