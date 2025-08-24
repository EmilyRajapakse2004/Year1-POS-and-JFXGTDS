package com.lidiya.taxsystem.programmingcoursework.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.lidiya.taxsystem.programmingcoursework.model.Transaction;
import com.lidiya.taxsystem.programmingcoursework.util.ChecksumUtil;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TaxController {

    @FXML private TableView<Transaction> transactionTable;
    @FXML private TableColumn<Transaction, String> itemCodeColumn;
    @FXML private TableColumn<Transaction, Double> internalPriceColumn;
    @FXML private TableColumn<Transaction, Double> discountColumn;
    @FXML private TableColumn<Transaction, Double> salePriceColumn;
    @FXML private TableColumn<Transaction, Integer> quantityColumn;
    @FXML private TableColumn<Transaction, Integer> checksumColumn;
    @FXML private TableColumn<Transaction, Double> profitColumn;
    @FXML private TableColumn<Transaction, Double> taxColumn;

    private final ObservableList<Transaction> transactions = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        itemCodeColumn.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        internalPriceColumn.setCellValueFactory(new PropertyValueFactory<>("internalPrice"));
        discountColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
        salePriceColumn.setCellValueFactory(new PropertyValueFactory<>("salePrice"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        checksumColumn.setCellValueFactory(new PropertyValueFactory<>("checksum"));
        profitColumn.setCellValueFactory(new PropertyValueFactory<>("profit"));
        taxColumn.setCellValueFactory(new PropertyValueFactory<>("tax"));

        transactionTable.setItems(transactions);
    }

    @FXML
    public void importFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open CSV File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            importCSVFile(selectedFile);
        }
    }

    public void importCSVFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            // Skip the header line
            br.readLine();

            // Read each line of the CSV file
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                if (values.length == 6) { // Ensure the line has 6 columns
                    String itemCode = values[0];
                    double internalPrice = Double.parseDouble(values[1]);
                    double discount = Double.parseDouble(values[2]);
                    double salePrice = Double.parseDouble(values[3]);
                    int quantity = Integer.parseInt(values[4]);
                    int checksum = Integer.parseInt(values[5]);

                    // Create a new Transaction object and add it to the ObservableList
                    Transaction transaction = new Transaction(itemCode, internalPrice, discount, salePrice, quantity, checksum);
                    transactions.add(transaction);
                } else {
                    System.out.println("Skipping invalid line (wrong number of columns): " + line);
                }
            }

            // Refresh the TableView
            transactionTable.setItems(transactions);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void validateTransactions() {
        for (Transaction t : transactions) {
            String line = t.getItemCode() + "," + t.getInternalPrice() + "," +
                    t.getDiscount() + "," + t.getSalePrice() + "," + t.getQuantity();
            int computedChecksum = ChecksumUtil.calculateChecksum(line);
            boolean validCode = ChecksumUtil.isValidItemCode(t.getItemCode());
            boolean nonNegative = t.getInternalPrice() >= 0 && t.getSalePrice() >= 0;

            if (computedChecksum != t.getChecksum() || !validCode || !nonNegative) {
                t.setItemCode("INVALID");
            }
        }
        transactionTable.refresh();
        showAlert("Validation complete.");
    }

    @FXML
    public void calculateProfit() {
        for (Transaction t : transactions) {
            double profit = (t.getSalePrice() * t.getQuantity()) - (t.getInternalPrice() * t.getQuantity());
            t.setProfit(profit);
        }
        transactionTable.refresh();
        showAlert("Profit calculated.");
    }

    @FXML
    public void deleteZeroProfitTransactions() {
        transactions.removeIf(t -> t.getProfit() == 0);
        transactionTable.refresh();
        showAlert("Zero-profit transactions deleted.");
    }

    @FXML
    public void calculateTax() {
        for (Transaction t : transactions) {
            double tax = t.getProfit() > 5000 ? t.getProfit() * 0.15 : t.getProfit() * 0.1;
            t.setTax(tax);
        }
        transactionTable.refresh();
        showAlert("Tax calculated.");
    }

    // NEW METHODS BELOW

    @FXML
    private void handleUpdateInvalid(ActionEvent event) {
        Transaction selected = transactionTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            updateInvalidRecord(selected);
            transactionTable.refresh();
            showAlert("Invalid record updated with new checksum.");
        } else {
            showAlert("No transaction selected.");
        }
    }

    @FXML
    private void handleDeleteInvalid(ActionEvent event) {
        Transaction selected = transactionTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            deleteInvalidRecord(selected);
            transactionTable.refresh();
            showAlert("Invalid record deleted.");
        } else {
            showAlert("No transaction selected.");
        }
    }

    // Helper methods
    public void updateInvalidRecord(Transaction t) {
        String line = t.getItemCode() + "," + t.getInternalPrice() + "," +
                t.getDiscount() + "," + t.getSalePrice() + "," + t.getQuantity();
        t.setChecksum(ChecksumUtil.calculateChecksum(line));
    }

    public void deleteInvalidRecord(Transaction t) {
        transactions.remove(t);
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
