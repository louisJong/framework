package com.song.framework.dao.routing;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import com.song.framework.support.datasource.routing.RoutingDataSource;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2016-12-30 16:59
 */
public class DBReadWriteSeparateAspect {

    private final Logger logger = Logger.getLogger(getClass());

    public void before(JoinPoint point) {
        Object target = point.getTarget();
        String methodName = point.getSignature().getName();
        Class<?>[] clazz = target.getClass().getInterfaces();
        
        logger.info("before class:"+clazz[0].getName()+" method:"+methodName+" execute");

        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
        try {
            Method method = clazz[0].getMethod(methodName, parameterTypes);
            if (method != null && method.isAnnotationPresent(RoutingDataSource.class)) {
                RoutingDataSource data = method.getAnnotation(RoutingDataSource.class);
                DynamicRoutingContextHolder.setRouteStrategy(data.value());
                logger.info("class:"+clazz[0].getName()+" method:"+methodName+" 切换数据源:"+data.value()+" 成功");
            }
        } catch (Exception e) {
            logger.error("数据源切换切面异常", e);
        }
    }
    
    public void after(){
    	if(DynamicRoutingContextHolder.getRouteStrategy()!=null)
    	DynamicRoutingContextHolder.clearRouteStrategy();
    }
}
