class Account {
    private int balance;

    public Account(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
    }

    public synchronized boolean withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public synchronized int getBalance() {
        return balance;
    }
}

class BankTransfer implements Runnable {
    private Account fromAccount;
    private Account toAccount;
    private int amount;

    public BankTransfer(Account fromAccount, Account toAccount, int amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        // Пытаемся выполнить перевод
        if (fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
            System.out.println("Successfully transferred " + amount + " from Account A to Account B.");
        } else {
            System.out.println("Insufficient funds for the transfer.");
        }
    }
}

public class racecondition {
    public static void main(String[] args) {
        // Создаем два счета с начальным балансом
        Account accountA = new Account(1000);
        Account accountB = new Account(500);

        // Создаем несколько потоков для перевода между счетами
        Thread t1 = new Thread(new BankTransfer(accountA, accountB, 100));
        Thread t2 = new Thread(new BankTransfer(accountA, accountB, 200));
        Thread t3 = new Thread(new BankTransfer(accountB, accountA, 50));
        Thread t4 = new Thread(new BankTransfer(accountA, accountB, 300));

        // Запускаем потоки
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Ждем завершения всех потоков
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Выводим остаточные балансы счетов
        System.out.println("Account A balance: " + accountA.getBalance());
        System.out.println("Account B balance: " + accountB.getBalance());
    }
}
