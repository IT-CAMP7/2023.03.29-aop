package pl.camp.it.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import pl.camp.it.aop.model.User;

@Component
@Aspect
public class UserServiceAspect {

    @Pointcut("execution(pl.camp.it.aop.model.User pl.camp.it.aop.services.impl.UserServiceImpl.getUser1())")
    public void getUser1Pointcut(){}

    @Pointcut("execution(* pl.camp.it.aop.services.impl.UserServiceImpl.*(..))")
    public void getAllUsersPointcut() {}

    @Pointcut("within(pl.camp.it.aop.services.impl.UserServiceImpl)")
    public void getAllUsersPointcut2() {}

    @Pointcut("within(pl.camp.it.aop.services.impl.*)")
    public void getAllUsersPackage() {}

    @Pointcut("target(pl.camp.it.aop.services.IUserService)")
    public void getAllUsersByInterface() {}

    /*@Before(value = "getAllUsersPointcut2()")
    public void printAdditionalData() {
        System.out.println("Wykonuje sie porada !!!");
    }*/

    /*@Before(value = "getUser1Pointcut()")
    public void printAdditionalData3() {
        System.out.println("Wykonuje sie porada 3!!!");
    }*/

    /*@After(value = "getAllUsersPointcut2()")
    public void printAdditionalData2() {
        System.out.println("Wykonuje sie porada po punkcie przeciecia !!");
    }*/

    /*@AfterReturning(value = "getAllUsersByInterface()", returning = "value")
    public void printAdditionalData(User value) {
        System.out.println(value.getId());
        System.out.println(value.getLogin());
        System.out.println(value.getPassword());
        System.out.println("Logujemy rzeczy !!");
    }*/

    @Around("getAllUsersByInterface()")
    public User aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("wykryto wywolanie metody !!");
        System.out.println("robimy jakies operacje przed !!");
        Object proceedResult = joinPoint.proceed();
        if(proceedResult instanceof User user) {
            user.setId(100);
            user.setLogin(user.getLogin()+"cos");
            return user;
        }

        return null;
    }
}
