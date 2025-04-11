package de.telran.multithread.synchronized_20250408.ht.task2;
//
//2*. Вы пишете книгу и вы автор. Есть 2 человека, которые выступают у вас соавторами.
// На этапе написания книги, они пишут разные главы, помогая таким образом вам полностью ее закончить.
// После того как вы и все соавторы закончили свою работу, вы отправляете книгу на рецензирование.
// В группу рецензентов входит 3 человека, каждый из которых является специалистом в своей области
// и проверяет Вашу книгу на правильность отражения фактов в вашем произведении.
// После того. как все рецензии получены, Вы отправляете книгу в издательский дом.
// В редакции главный редактор и руководитель издательства читают ваше творение и утверждают
// его в печать.
// Вы относите утвержденные рукописи печатникам, они печатают книгу, переплетчики делают ей переплет
// а служба доставки развозят книги по магазинам.
// Поздравляю Вас, вы полностью прошли все фазы становления известного писателя, т.к. Ваша книга
// стала бестселлером! )
// Создайте приложение, которое сымитирует работу процесса создания книги, с учетом что каждый человек,
// который встречается в описанной схеме будет представлен отдельным потоком.
// Какой синхронизатор с библиотеки concurrent мог бы быть Вам полезен при выполнении данной задачи?
//
import java.util.concurrent.Phaser;

public class Author {
    public static void main(String[] args) {

        Phaser phaser = new Phaser(1);
        String name = "автор";

        System.out.println(phaser.getPhase() + " - Написание книги:");
        System.out.println("Я - " + name + " - пишу книгу");

        new CoAuthor(phaser, "первый соавтор").start();
        new CoAuthor(phaser, "второй соавтор").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        phaser.arriveAndAwaitAdvance();

//------------------------------------------------------------------------------------------------------------

        System.out.println(phaser.getPhase() + " - Книга на рецензировании:");
        System.out.println("Я - " + name + " - отправил книгу на рецензирование");

        new Reviewer(phaser, "первый рецензент").start();
        new Reviewer(phaser, "второй рецензент").start();
        new Reviewer(phaser, "третий рецензент").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        phaser.arriveAndAwaitAdvance();

//------------------------------------------------------------------------------------------------------------

        System.out.println(phaser.getPhase() + " - Книга в издательском доме:");
        System.out.println("Я - " + name + " - отправил книгу в издательский дом");

        new ChiefEditor(phaser, "главный редактор").start();
        new PublishingHouseChief(phaser, "руководитель издательства").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        phaser.arriveAndAwaitAdvance();

//------------------------------------------------------------------------------------------------------------

        System.out.println(phaser.getPhase() + " - Книга в печати:");
        System.out.println("Я - " + name + " - отправил книгу типографию");

        new Pressmen(phaser, "печатники").start();
        new BookBinders(phaser, "переплетчики").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        phaser.arriveAndAwaitAdvance();

//------------------------------------------------------------------------------------------------------------

        System.out.println(phaser.getPhase() + " - Книга в службе доставки:");
        System.out.println("Я - " + name + " - отправил книгу в службу доставки");

        new DeliveryService(phaser, "служба доставки").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        phaser.arriveAndDeregister();

//------------------------------------------------------------------------------------------------------------

        System.out.println("Можете меня поздравить, моя книга стала бестселлером!");


    }
}


