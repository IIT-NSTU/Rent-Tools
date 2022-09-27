package backend;

public class Tool {
    private String id;
    private String name;
    private String customerID;
    private String rentDate;
    private String returnDate;

    public Tool(String id, String name, String customerID, String rentDate, String returnDate) {
        this.id = id;
        this.name = name;
        this.customerID = customerID;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getRentDate() {
        return rentDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
