package com.zhbit.car.service.core.threadpool;

public class ServiceThread extends Thread {

    public ServiceThread(Runnable r) {
        super(r);

    }
}