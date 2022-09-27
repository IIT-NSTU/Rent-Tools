package backend;

public class Customer {
    private String id;
    private String name;
    private String fatherName;
    private String motherName;
    private String mobileNumber;
    private String address;
    private String deleted;

    public Customer(String id, String name, String fatherName, String motherName, String mobileNumber, String address, String deleted) {
        this.id = id;
        this.name = name;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.deleted = deleted;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getDeleted() {
        return deleted;
    }
}
