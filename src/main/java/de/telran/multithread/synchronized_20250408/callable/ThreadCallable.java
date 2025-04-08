package de.telran.multithread.synchronized_20250408.callable;

import java.util.concurrent.Callable;

public class ThreadCallable implements Callable<Integer> {
    private int start;
    private int end;
    private int div;

    public ThreadCallable(int start, int end, int div) {
        this.start = start;
        this.end = end;
        this.div = div;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" -> начал просчет интервала "+start+" -- "+end);

        long currentTime = System.currentTimeMillis();

        int count = 0;
        for (int i = start; i <= end; i++) {
            if(i % div == 0) {
                count++;
            }
        }
        System.out.println(Thread.currentThread().getName()+" -> время выполнения (Thread) = "+(System.currentTimeMillis()-currentTime));

        return count;
    }
}
