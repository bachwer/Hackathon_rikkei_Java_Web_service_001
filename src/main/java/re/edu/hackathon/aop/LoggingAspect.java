package re.edu.hackathon.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    @Before("""
            
                execution(* re.edu.hackathon.service.BookServiceImpl.create*(..))
           
                ||
           
                execution(* re.edu.hackathon.service.BookServiceImpl.update*(..))
            
            """)
    public void logMethod(JoinPoint joinPoint) {
        log.info("Method Name: {}", joinPoint.getSignature().getName());
    }
}
