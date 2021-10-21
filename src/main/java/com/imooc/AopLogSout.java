package com.imooc;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class AopLogSout {
    /**
     * AOP 的通知类型
     * 1. 前置通知
     * 2. 后置通知
     * 3. 环绕通知
     * 4. 异常通知
     * 5. 最终通知
     */

    @Around("execution(* com.imooc.service.impl..*.*(..))")
    public Object calTimeOfService(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("正在执行{}.{}",
                    joinPoint.getTarget().getClass(),
                    joinPoint.getSignature().getName());
        Long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        Long end = System.currentTimeMillis();
        Long totalTime = end - start;
        if (totalTime > 3000) {
            log.error("当前执行耗时：{}\t， 超过 3 s", totalTime);
        } else if (totalTime > 2000) {
            log.warn("当前执行耗时：{}\t， 超过 2 s", totalTime);
        } else {
            log.info("当前执行耗时：{}", totalTime);
        }
        return result;
    }
}
