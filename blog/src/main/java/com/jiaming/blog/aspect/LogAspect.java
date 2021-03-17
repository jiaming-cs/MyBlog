package com.jiaming.blog.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@Component
// Indicates that an annotated class is a "component". Such classes are considered 
// as candidates for auto-detection when using annotation-based configuration and classpath scanning.

// Other class-level annotations may be considered as identifying a component as well, 
// typically a special kind of component: e.g. the @Repository annotation or AspectJ's @Aspect annotation.
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    // excution ({return type} {packeage name}.{class name}.{method name}({arguments})) 
    // annotation Pointcut define and management pointcut
    @Pointcut("execution (* com.jiaming.blog.web.*.*(..))")     
    public void log() {

    }


    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String method = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object [] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url, ip, method, args);

        logger.info("Request : {}", requestLog);
        logger.info("--------do before----------");
    }

    @After("log()")
    public void doAfter() {
        logger.info("---------do after----------");

    }

    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturn(Object result) {
        logger.info("Result {}", result);

    }

    private class RequestLog {
        private String url;
        private String ip;
        private String method;
        private Object[] args;

        public RequestLog(String url, String ip, String method, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.method = method;
            this.args = args;
        }

        @Override
        public String toString() {
            return "RequestLog [args=" + Arrays.toString(args) + ", ip=" + ip + ", method=" + method + ", url=" + url
                    + "]";
        }
        
        
    }
}



