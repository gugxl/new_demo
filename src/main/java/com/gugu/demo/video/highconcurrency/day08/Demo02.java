package com.gugu.demo.video.highconcurrency.day08;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Demo02 {
    @SneakyThrows
    public static void main(String[] args) {
        ThreadGroup threadGroup1 = new ThreadGroup("thread-group-1");
        Thread t1 = new Thread(threadGroup1, new R1(), "t1");
        Thread t2 = new Thread(threadGroup1, new R1(), "t2");

        t1.start();
        t2.start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("threadGroup1活动线程数:" + threadGroup1.activeCount());
        System.out.println("threadGroup1活动线程组:" + threadGroup1.activeGroupCount());
        System.out.println("threadGroup1线程组名称:" + threadGroup1.getName());
        System.out.println("threadGroup1父线程组名称:" + threadGroup1.getParent().getName());

        ThreadGroup threadGroup2 = new ThreadGroup(threadGroup1, "thread-group-2");
        Thread t3 = new Thread(threadGroup2, new R1(), "t3");
        Thread t4 = new Thread(threadGroup2, new R1(), "t4");

        t3.start();
        t4.start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("threadGroup2活动线程数:" + threadGroup2.activeCount());
        System.out.println("threadGroup2活动线程组:" + threadGroup2.activeGroupCount());
        System.out.println("threadGroup2线程组名称:" + threadGroup2.getName());
        System.out.println("threadGroup2父线程组名称:" + threadGroup2.getParent().getName());

        System.out.println("---------------");
        System.out.println("threadGroup1活动线程数:" + threadGroup1.activeCount());
        System.out.println("threadGroup1活动线程组:" + threadGroup1.activeGroupCount());
        System.out.println("---------------");

        threadGroup1.list();
    }

    static class R1 implements Runnable {


        @SneakyThrows
        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            System.out.println("所属线程组:" + thread.getThreadGroup().getName() + ",线程名称:" + thread.getName());
            TimeUnit.SECONDS.sleep(3);
        }
    }


}
