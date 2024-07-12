import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Class to represent the bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            JOptionPane.showMessageDialog(null, "Deposit successful. New balance: " + balance);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
                balance -= amount;
                JOptionPane.showMessageDialog(null, "Withdrawal successful. New balance: " + balance);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid withdrawal amount or insufficient balance.");
        }
    }
}

// Class to represent the ATM machine
class ATMApplicationGUI extends JFrame {
    private BankAccount account;
    private JTextField amountField;
    private JLabel balanceLabel;

    public ATMApplicationGUI(BankAccount account) {
        this.account = account;
        createUI();
    }

    private void createUI() {
        setTitle("ATM Machine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel label = new JLabel("Enter amount:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(label, gbc);

        amountField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(amountField, gbc);

        JButton checkBalanceButton = new JButton("Check Balance");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(checkBalanceButton, gbc);

        JButton depositButton = new JButton("Deposit");
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(depositButton, gbc);

        JButton withdrawButton = new JButton("Withdraw");
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(withdrawButton, gbc);

        balanceLabel = new JLabel("Balance: " + account.getBalance());
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        panel.add(balanceLabel, gbc);

        add(panel);

        checkBalanceButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            checkBalance();
        }
        });

    depositButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                deposit(amount);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
            }
        }
    });

    withdrawButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                double amount = Double.parseDouble(amountField.getText());
                withdraw(amount);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
            }
        }
    });
    }

    private void checkBalance() {
        balanceLabel.setText("Balance: " + account.getBalance());
    }

    private void deposit(double amount) {
        account.deposit(amount);
        checkBalance();
    }

    private void withdraw(double amount) {
        account.withdraw(amount);
        checkBalance();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BankAccount account = new BankAccount(1000); // Initial balance
                ATMApplicationGUI atm = new ATMApplicationGUI(account);
                atm.setVisible(true);
            }
        });
    }
}
