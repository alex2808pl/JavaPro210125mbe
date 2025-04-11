package de.telran.multithread.threadpool_20250411;

import java.util.*;

public class MainSynchronized {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(10));
        }
        System.out.println(list);

        List<Integer> list2 = new ArrayList<>(List.copyOf(list));
        System.out.println(list2);

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) % 2 ==0)
                list.remove(i);
        }
        System.out.println(list);


        Iterator<Integer> it = list2.iterator();
        while(it.hasNext()) {
            Integer val = it.next();
            if(val % 2 ==0)
                it.remove();
        }

        System.out.println(list2);

        // --- synchronizedList ---

        List<Integer> listThread = new ArrayList<>();



        listThread = Collections.synchronizedList(listThread); // синхронизация

        Thread adder = new Thread(new Adder(listThread), "Adder");
        Thread remover = new Thread(new Remover(listThread), "Remover");

        adder.start();
        remover.start();

        adder.join();
        remover.join();

        System.out.println(listThread);

    }

}


class Adder implements Runnable {
    private List<Integer> list;

    public Adder(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        Random r = new Random();
        for (int i = 0; i < 100 ; i++) {
            Integer val = r.nextInt(100);
            list.add(val);
            System.out.println(Thread.currentThread().getName()+" добавил "+val + " ,size = "+list.size());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Remover implements Runnable {
    private List<Integer> list;

    public Remover(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        Random r = new Random();
        for (int i = 0; i < 100 ; i++) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Integer ind = 0;
            list.remove(ind);
            System.out.println(Thread.currentThread().getName()+" удалил "+ind + " ,size = "+list.size());
        }

    }
}


