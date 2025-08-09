package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StopwatchAspect {

	@Around("execution(* com.example.dao.*.save*(..))")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {

		Stopwatch stopwatch = new Stopwatch();
		stopwatch.start();

        Object result = null;
        try {

        	result = joinPoint.proceed(); 
            
        } catch (Throwable e) {

            throw e;

        } finally {
            String methodName = 
                joinPoint.getSignature().getDeclaringTypeName() + 
                "." + 
                joinPoint.getSignature().getName();

            //  Call the stopwatch's displayElapsedTime() method, passing the methodName defined above.
            //  (Notice how the methodName is derived above):
            stopwatch.stop();
            stopwatch.displayElapsedTime(methodName);
        }
        return result;
    }


    

    // Stopwatch logic.
    private static class Stopwatch {
        private long start;
        private long elapsedTime;

        public void start() {
            start = System.currentTimeMillis();
        }

        public void stop() {
            elapsedTime = System.currentTimeMillis() - start;
        }

        public double getElapsedTime() {
            if (elapsedTime == 0) {
                return (System.currentTimeMillis() - start) / 1000.0;
            }
            return elapsedTime / 1000.0;
        }

        public void displayElapsedTime(String methodName) {
            System.out.println("Elapsed time for " + methodName + " is " + getElapsedTime() + " seconds");
        }
    }

}
