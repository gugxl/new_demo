package com.gugu.demo.util.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author Administrator
 * @Classname JMHSample_03_States
 * @Description TODO
 * @Date 2022/2/28 22:53
 */
public class JMHSample_03_States {

    @State(Scope.Benchmark)
    public static class BenchmarkState{
        volatile double x = Math.PI;
    }

    @State(Scope.Thread)
    public static class ThreadState{
        volatile double x = Math.PI;
    }

    @Benchmark
    public void measureUnshared(ThreadState state){
        state.x ++;
    }

    @Benchmark
    public void measureShared(BenchmarkState state){
        state.x ++;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHSample_03_States.class.getSimpleName())
                .threads(4)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
