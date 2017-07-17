package com.zhbit.car.service.core.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by lz on 2016/5/18 11:07.
 */
public class BeanUtils implements ApplicationContextAware {

    private static Logger log = LoggerFactory.getLogger(BeanUtils.class);

    private ApplicationContext applicationContext;

    private static BeanUtils instance;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void init(){
        instance = this;
    }

    public static <T> T getBean(String beanName) {
        return (T) getContext().getBean(beanName);
    }

    public static ApplicationContext getContext() {
        return instance.applicationContext;
    }

}
