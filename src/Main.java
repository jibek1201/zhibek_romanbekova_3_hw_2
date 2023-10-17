public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(0.0);
        account.deposit(15000);
        while (true) {
            try {
                account.withDraw(6000);
                System.out.println("Снято 6000 сом, текущий баланс: " + account.getAmount() + " сом.");
            } catch (LimitException e) {
                try {
                    account.withDraw(account.getAmount());
                    System.out.println("Снято 6000 сом, текущий баланс: " + account.getAmount() + " сом.");
                } catch (LimitException ex) {
                    throw new RuntimeException(ex);
                }
                    System.out.println("Исключение: " + e.getMessage());
                    System.out.println("Максимальная доступная сумма для снятия: " + e.getRemainingAmount() + " сом.");
                    System.out.println("Снято " + e.getRemainingAmount() + " сом.");
                    System.out.println("Остаток на счете:0 ");
                    break;
                }
            }
        }
    }
}
