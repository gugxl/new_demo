package com.gugu.demo.util.redis;

/**
 * @author Administrator
 * @Classname TaskContext
 * @Description TODO
 * @Date 2021/11/21 15:06
 */
public class TaskContext {

    private Task task;
    private long cost;
    private boolean ok;
    private Throwable e;

    public TaskContext(Task task, long cost, boolean ok, Throwable e) {
        this.task = task;
        this.cost = cost;
        this.ok = ok;
        this.e = e;
    }

    public Task task() {
        return task;
    }

    public long cost() {
        return cost;
    }

    public boolean ok() {
        return ok;
    }

    public Throwable error() {
        return e;
    }
}
