import java.util.LinkedList;
import java.util.Queue;

class TaskQueue {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int maxSize;

    public TaskQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    // Метод для добавления задачи в очередь
    public synchronized void addTask(int task) throws InterruptedException {
        while (queue.size() == maxSize) {
            wait(); // Ждем, пока очередь не освободится место
        }
        queue.offer(task);
        System.out.println("Добавлена задача: " + task);
        notifyAll(); // Оповещаем потоки, что задача добавлена
    }

    // Метод для получения задачи из очереди
    public synchronized int getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Ждем, пока очередь не станет пустой
        }
        int task = queue.poll();
        notifyAll(); // Оповещаем потоки, что задача взята
        return task;
    }
}

class WorkerThread implements Runnable {
    private final TaskQueue taskQueue;

    public WorkerThread(TaskQueue taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Получаем задачу из очереди
                int task = taskQueue.getTask();
                // Выполняем задачу (например, выводим число)
                System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + task);
                Thread.sleep(500); // Имитация времени обработки задачи
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class TaskPool {
    public static void main(String[] args) {
        TaskQueue taskQueue = new TaskQueue(10); // Ограничиваем очередь до 10 задач

        // Создаем несколько рабочих потоков
        Thread worker1 = new Thread(new WorkerThread(taskQueue), "Worker 1");
        Thread worker2 = new Thread(new WorkerThread(taskQueue), "Worker 2");
        Thread worker3 = new Thread(new WorkerThread(taskQueue), "Worker 3");

        worker1.start();
        worker2.start();
        worker3.start();

        // Добавляем задачи в очередь
        try {
            for (int i = 1; i <= 20; i++) {
                taskQueue.addTask(i); // Добавляем задачи в очередь
                Thread.sleep(300); // Имитация времени на добавление задач
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
