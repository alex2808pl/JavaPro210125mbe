package de.telran.multithread.base_20250326;

// Если уже есть предок - множественное наследование у нас запрещено
@Deprecated
public class RunnableTask extends Object implements Runnable{
    private int start;
    private int end;
    private int div;
    public int count;

    public RunnableTask(int start, int end, int div) {
        this.start = start;
        this.end = end;
        this.div = div;
    }

    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();

        for (int i = start; i <= end; i++) {
            if(i % div == 0) {
                count++;
            }
        }
        System.out.println(Thread.currentThread().getName()+" -> количество (Runnable) = "+count);
        System.out.println(Thread.currentThread().getName()+" -> время выполнения (Runnable) = "+(System.currentTimeMillis()-currentTime));

    }
}
