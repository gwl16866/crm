package com.hy.crmsystem.flowable;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.flowable.engine.impl.delegate.ActivityBehavior;

public class Sysout implements JavaDelegate {


    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println("我是机器");
    }
}
