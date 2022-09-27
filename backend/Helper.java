package backend;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    private static final String CUSTOMER_FILE_NAME = "customer.txt";
    private static final String TOOL_FILE_NAME = "tool.txt";
    private List<Customer> customerList;
    private List<Tool> toolList;

    public Helper(){
        setCustomerList();
        setToolList();
    }

    public void setCustomerList() {
        customerList = new ArrayList<>();

        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(CUSTOMER_FILE_NAME));
            String line;
            while ((line = bufferedReader.readLine()) !=null) {
                String[] data = line.split(",");
                customerList.add(new Customer(data[0], data[1], data[2], data[3], data[4], data[5], data[6]));
            }
            bufferedReader.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Customer File Not Found");
        }
    }

    public void setToolList() {
        toolList = new ArrayList<>();
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(TOOL_FILE_NAME));
            String line;
            while ((line = bufferedReader.readLine()) !=null) {
                String[] data = line.split(",");
                toolList.add(new Tool(data[0], data[1], data[2], data[3], data[4]));
            }
            bufferedReader.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Tool File Not Found");
        }
    }

    public void addTool(String name, int quantity) {
        for (int i = 0; i < quantity; i++) {
            toolList.add(new Tool("T"+ getRandomNumber(), name, "none", "none", "none"));
        }
        writeToolToFile();
        JOptionPane.showMessageDialog(null, quantity + " piece " + name + " added successfully.");
    }

    public void rentTool(String customerID, String rentDate) {
        for (Tool tool : toolList) {
            if ((tool.getRentDate().equals("none") && tool.getReturnDate().equals("none")) || (!tool.getRentDate().equals("none") && !tool.getReturnDate().equals("none"))) {
                tool.setCustomerID(customerID);
                tool.setRentDate(rentDate);
                break;
            }
        }
        writeToolToFile();
        JOptionPane.showMessageDialog(null, "Tool Rented Successfully.");
    }

    public void returnTool(String toolID, String returnDate) {
        for (Tool tool : toolList) {
            if (tool.getId().equals(toolID)) {
                tool.setReturnDate(returnDate);
                break;
            }
        }
        writeToolToFile();
        JOptionPane.showMessageDialog(null, "Tool Returned Successfully.");
    }


    public void addCustomer(String customerName, String fatherName, String motherName, String mobileNumber, String address) {
        for (Customer customer : customerList) {
            if (customer.getName().equals(customerName) && customer.getMobileNumber().equals(mobileNumber)) {
                JOptionPane.showMessageDialog(null, "Customer name " + customerName + " with mobile number " + mobileNumber + " already exits.");
                return;
            }
        }

        customerList.add(new Customer("C"+ getRandomNumber(), customerName, fatherName, motherName, mobileNumber, address, "no"));
        writeCustomerToFile();
        JOptionPane.showMessageDialog(null, "Customer name " + customerName + " added successfully.");
    }

    public void deleteCustomer(String id) {
        for (Customer customer : customerList) {
            if (customer.getId().equals(id)) {
                customer.setDeleted("yes");
            }
        }
        writeCustomerToFile();
        JOptionPane.showMessageDialog(null, "Customer deleted successfully.");
    }

    public int getCustomerIndex(String id) {
        for(int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void writeCustomerToFile() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Customer customer : customerList) {
            stringBuilder.append(customer.getId()).append(",")
                    .append(customer.getName()).append(",")
                    .append(customer.getFatherName()).append(",")
                    .append(customer.getMotherName()).append(",")
                    .append(customer.getMobileNumber()).append(",")
                    .append(customer.getAddress()).append(",")
                    .append(customer.getDeleted()).append("\n");
        }

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(CUSTOMER_FILE_NAME));
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Customer File Not Found");
        }
    }

    public void writeToolToFile() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Tool tool : toolList) {
            stringBuilder.append(tool.getId()).append(",")
                    .append(tool.getName()).append(",")
                    .append(tool.getCustomerID()).append(",")
                    .append(tool.getRentDate()).append(",")
                    .append(tool.getReturnDate()).append("\n");
        }

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(TOOL_FILE_NAME));
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Tool File Not Found");
        }
    }

    public Object[] getCustomerIDWithName() {
        List<String> list = new ArrayList<>();

        for(Customer customer : customerList) {
            if (customer.getDeleted().equals("no")) {
                list.add(customer.getId() + " " + customer.getName());
            }
        }

        return list.toArray();
    }

    public String getCustomerDetails(String id) {
        for(Customer customer : customerList) {
            if (customer.getId().equals(id)) {
                return "ID = " + customer.getId() + "\n"
                        + "Name = " + customer.getName() + "\n"
                        + "Father's Name = " + customer.getFatherName() + "\n"
                        + "Mother's Name = " + customer.getMotherName() + "\n"
                        + "Mobile Number = " + customer.getMobileNumber() + "\n"
                        + "Address = " + customer.getAddress() + "\n";
            }
        }
        return "";
    }

    public Object[] getToolNames() {
        List<String> list = new ArrayList<>();

        for(Tool tool : toolList) {
            if (!list.contains(tool.getName())) {
                list.add(tool.getName());
            }
        }

        return list.toArray();
    }

    public Object[] getRentedToolNames() {
        List<String> list = new ArrayList<>();

        for(Tool tool : toolList) {
            if (!tool.getRentDate().equals("none") && tool.getReturnDate().equals("none")) {
                list.add(tool.getId() + " " + tool.getName());
            }
        }

        return list.toArray();
    }

    public int getTotalTool(String name) {
        int quantity = 0;

        for(Tool tool : toolList) {
            if (tool.getName().equals(name) && (tool.getRentDate().equals("none") || !tool.getReturnDate().equals("none"))) {
                quantity++;
            }
        }

        return quantity;
    }

    public String getToolDetails(String id) {
        for(Tool tool : toolList) {
            if (tool.getId().equals(id)) {
                return "ID = " + tool.getId() + "\n"
                        + "Name = " + tool.getName() + "\n"
                        + "Customer ID = " + tool.getCustomerID() + "\n"
                        + "Rent Date = " + tool.getRentDate() + "\n";
            }
        }
        return "";
    }

    public String getSearchByLastName(String name) {
        StringBuilder output = new StringBuilder().append("\n");
        for(Customer customer : customerList) {
            String[] customerName = customer.getName().split(" ");
            try{
                if (customerName[customerName.length - 1].contains(name)) {
                    output.append("ID = ").append(customer.getId()).append("\n")
                            .append("Name = ").append(customer.getName()).append("\n")
                            .append("Father's Name = ").append(customer.getFatherName()).append("\n")
                            .append("Mother's Name = ").append(customer.getMotherName()).append("\n")
                            .append("Mobile Number = ").append(customer.getMobileNumber()).append("\n")
                            .append("Address = ").append(customer.getAddress()).append("\n");
                }
            } catch (Exception ex) {

            }
        }
        return output.toString();
    }

    public String getSearchByFirstName(String name) {
        StringBuilder output = new StringBuilder().append("\n");
        for(Customer customer : customerList) {
            String[] customerName = customer.getName().split(" ");
            try{
                if (customerName[0].contains(name)) {
                    output.append("ID = ").append(customer.getId()).append("\n")
                            .append("Name = ").append(customer.getName()).append("\n")
                            .append("Father's Name = ").append(customer.getFatherName()).append("\n")
                            .append("Mother's Name = ").append(customer.getMotherName()).append("\n")
                            .append("Mobile Number = ").append(customer.getMobileNumber()).append("\n")
                            .append("Address = ").append(customer.getAddress()).append("\n");
                }
            } catch (Exception ex) {

            }
        }
        return output.toString();
    }

    public String getSearchByBothName(String name) {
        StringBuilder output = new StringBuilder().append("\n");
        for(Customer customer : customerList) {
            String[] customerName = customer.getName().split(" ");
            try{
                if (customerName[0].contains(name) || customerName[customerName.length - 1].contains(name)) {
                    output.append("ID = ").append(customer.getId()).append("\n")
                            .append("Name = ").append(customer.getName()).append("\n")
                            .append("Father's Name = ").append(customer.getFatherName()).append("\n")
                            .append("Mother's Name = ").append(customer.getMotherName()).append("\n")
                            .append("Mobile Number = ").append(customer.getMobileNumber()).append("\n")
                            .append("Address = ").append(customer.getAddress()).append("\n");
                }
            } catch (Exception ex) {

            }
        }
        return output.toString();
    }

    public String showActiveCustomer() {
        StringBuilder output = new StringBuilder().append("\n");
        for(Customer customer : customerList) {
                if (customer.getDeleted().equals("no")) {
                    output.append("ID = ").append(customer.getId()).append("\n")
                            .append("Name = ").append(customer.getName()).append("\n")
                            .append("Father's Name = ").append(customer.getFatherName()).append("\n")
                            .append("Mother's Name = ").append(customer.getMotherName()).append("\n")
                            .append("Mobile Number = ").append(customer.getMobileNumber()).append("\n")
                            .append("Address = ").append(customer.getAddress()).append("\n");
                }

        }
        return output.toString();
    }

    public String showDeletedCustomer() {
        StringBuilder output = new StringBuilder().append("\n");
        for(Customer customer : customerList) {
            if (customer.getDeleted().equals("yes")) {
                output.append("ID = ").append(customer.getId()).append("\n")
                        .append("Name = ").append(customer.getName()).append("\n")
                        .append("Father's Name = ").append(customer.getFatherName()).append("\n")
                        .append("Mother's Name = ").append(customer.getMotherName()).append("\n")
                        .append("Mobile Number = ").append(customer.getMobileNumber()).append("\n")
                        .append("Address = ").append(customer.getAddress()).append("\n");
            }

        }
        return output.toString();
    }

    public String showRentedToolCustomer() {
        StringBuilder output = new StringBuilder().append("\n");
        for(Tool tool : toolList) {
            if (!tool.getRentDate().equals("none") && tool.getReturnDate().equals("none")) {
                output.append("ID = ").append(tool.getId()).append("\n")
                        .append("Name = ").append(tool.getName()).append("\n")
                        .append("Customer ID = ").append(tool.getCustomerID()).append("\n")
                        .append("Rent Date = ").append(tool.getRentDate()).append("\n");
            }

        }
        return output.toString();
    }

    public static int getRandomNumber() {
        return (int) ((Math.random() * (200000 - 100000)) + 100000);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public List<Tool> getToolList() {
        return toolList;
    }
}
