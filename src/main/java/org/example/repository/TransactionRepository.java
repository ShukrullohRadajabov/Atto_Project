package org.example.repository;

import org.example.db.DataBase;
import org.example.dto.Card;
import org.example.dto.Profile;
import org.example.dto.Transaction;
import org.example.enums.GeneralStatus;
import org.example.enums.ProfileRole;
import org.example.enums.TransactionType;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class TransactionRepository {

    public int createTransaction(Transaction transaction) {
        try (Connection connection = DataBase.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into transaction(card_id,terminal_id,amount,type,created_date) " +
                            "values (?,?,?,?,?)");
            statement.setInt(1, transaction.getCardId());

            if (transaction.getTerminalId() != null) {
                statement.setInt(2, transaction.getTerminalId());
            } else {
                statement.setObject(2, null);
            }
            statement.setDouble(3, transaction.getAmount());
            statement.setString(4, transaction.getTransactionType().name());
            statement.setTimestamp(5, Timestamp.valueOf(transaction.getCreatedDate()));

            int resultSet = statement.executeUpdate();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    public List<Transaction> admintransactionList() {
        try (Connection connection = DataBase.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from transaction");
            List<Transaction> transactionList = new LinkedList<>();
            while (resultSet.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(resultSet.getInt("id"));
                transaction.setCardId(resultSet.getInt("card_id"));
                transaction.setAmount(resultSet.getDouble("amount"));
                transaction.setTerminalId(resultSet.getInt("terminal_id"));
                transaction.setTransactionType(TransactionType.valueOf(resultSet.getString("type")));
                transaction.setCreatedDate(resultSet.getTimestamp("created_date").toLocalDateTime());
                transactionList.add(transaction);
            }
            return transactionList;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }

    public List<Transaction> usertransactionList() {
        try (Connection connection = DataBase.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from transaction");
            List<Transaction> transactionList = new LinkedList<>();
            while (resultSet.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(resultSet.getInt("id"));
                transaction.setCardId(resultSet.getInt("card_id"));
                transaction.setAmount(resultSet.getDouble("amount"));
                transaction.setTerminalId(resultSet.getInt("terminal_id"));
                transaction.setTransactionType(TransactionType.valueOf(resultSet.getString("type")));
                transaction.setCreatedDate(resultSet.getTimestamp("created_date").toLocalDateTime());
                transactionList.add(transaction);
            }
            return transactionList;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }


    public List<Transaction> getTransactionByTerminal(String terminalCode) {
        try (Connection connection = DataBase.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from terminal t right join transaction tr on tr.terminal_id = t.id where t.code = '" + terminalCode + "';");
            List<Transaction> transactionList = new LinkedList<>();
            while (resultSet.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(resultSet.getInt("id"));
                transaction.setCardId(resultSet.getInt("card_id"));
                transaction.setAmount(resultSet.getDouble("amount"));
                transaction.setTerminalId(resultSet.getInt("terminal_id"));
                transaction.setTransactionType(TransactionType.valueOf(resultSet.getString("type")));
                transaction.setCreatedDate(resultSet.getTimestamp("created_date").toLocalDateTime());
                transactionList.add(transaction);
            }
            return transactionList;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }

    public List<Transaction> getTransactionByCard(String cardNumber) {
        try (Connection connection = DataBase.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from card c right join transaction tr on tr.card_id = c.id where c.card_number = '" + cardNumber + "';");
            List<Transaction> transactionList = new LinkedList<>();
            while (resultSet.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(resultSet.getInt("id"));
                transaction.setCardId(resultSet.getInt("card_id"));
                transaction.setAmount(resultSet.getDouble("amount"));
                transaction.setTerminalId(resultSet.getInt("terminal_id"));
                transaction.setTransactionType(TransactionType.valueOf(resultSet.getString("type")));
                transaction.setCreatedDate(resultSet.getTimestamp("created_date").toLocalDateTime());
                transactionList.add(transaction);
            }
            return transactionList;
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }
}
