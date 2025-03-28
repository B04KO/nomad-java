class Resource {
    private final String name;

    public Resource(String name) {
        this.name = name;
    }

    // Метод блокировки ресурса
    public synchronized void lock() {
        System.out.println(Thread.currentThread().getName() + " захватывает " + name);
        try {
            Thread.sleep(1000); // Симуляция работы с ресурсом
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Метод освобождения ресурса
    public synchronized void unlock() {
        System.out.println(Thread.currentThread().getName() + " освобождает " + name);
    }
}

class DeadlockThread implements Runnable {
    private final Resource resource1;
    private final Resource resource2;

    public DeadlockThread(Resource resource1, Resource resource2) {
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        try {
            // Первый поток захватывает ресурс1, затем ресурс2
            resource1.lock();
            Thread.sleep(100); // Задержка для имитации захвата ресурса
            resource2.lock();

            // Обработать работу с ресурсами
            System.out.println(Thread.currentThread().getName() + " завершил работу с ресурсами");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // Освобождение ресурсов
            resource1.unlock();
            resource2.unlock();
        }
    }
}

public class Deadlock {
    public static void main(String[] args) {
        // Создаем два ресурса
        Resource resourceA = new Resource("Resource A");
        Resource resourceB = new Resource("Resource B");

        // Поток 1 захватывает Resource A, затем Resource B
        Thread thread1 = new Thread(new DeadlockThread(resourceA, resourceB), "Thread 1");

        // Поток 2 захватывает Resource B, затем Resource A
        Thread thread2 = new Thread(new DeadlockThread(resourceB, resourceA), "Thread 2");

        // Запускаем потоки
        thread1.start();
        thread2.start();
    }
}
