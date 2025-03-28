package de.telran.multithread.state_20200328.interrupt;

public class TaskRun implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " работает " + i + " раз");

            try {
                System.out.println(Thread.currentThread().getName()+" сам засыпает "+i+" раз");
                Thread.sleep(500);  // статус WAITING
                System.out.println(Thread.currentThread().getName()+" сам просыпается "+i+" раз");


                // Полезная работу (в статусе RUNNABLE)
                int count = 0;
                for (int j = 2; j < 100_000_000; j++) {
                    if(Thread.interrupted()) { // проверка isInterrupted
                        System.out.println("Закрываем сами поток по просьбе, выполнялся "+j+" раз. "+i);
                        //своя логика, обрабатывающая корректное завершение
                        return;  //завершаем работу потока, если необходимо!
                    }
                    boolean isPrime = true;
                    for (int k = 2; k < i; k++) {
                        if (i % k == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                   if (isPrime) {
                        count++;
                    }
                }

            } catch (InterruptedException e) {
                System.out.println("InterruptedException - проснулся принудительно "+i+" шаг.");
                //Выполняет какую то работу по корректному завершению потока
                return; //завершаю работу потока
            }
        }
    }
}
