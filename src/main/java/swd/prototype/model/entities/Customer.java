package swd.prototype.model.entities;

public class Customer {

    private int customer_id;
    private String cvr;
    private String company;
    private String streetadress;
    private String postelCode;
    private String contact_name;
    private String contact_lastname;
    private String contact_email;
    private String contact_phone;

    public Customer() {
    }

    public Customer(int customer_id, String cvr, String company, String streetadress, String postelCode, String contact_name, String contact_lastname, String contact_email, String contact_phone) {
        this.customer_id = customer_id;
        this.cvr = cvr;
        this.company = company;
        this.streetadress = streetadress;
        this.postelCode = postelCode;
        this.contact_name = contact_name;
        this.contact_lastname = contact_lastname;
        this.contact_email = contact_email;
        this.contact_phone = contact_phone;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCvr() {
        return cvr;
    }

    public void setCvr(String cvr) {
        this.cvr = cvr;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStreetadress() {
        return streetadress;
    }

    public void setStreetadress(String streetadress) {
        this.streetadress = streetadress;
    }

    public String getPostelCode() {
        return postelCode;
    }

    public void setPostelCode(String postelCode) {
        this.postelCode = postelCode;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getContact_lastname() {
        return contact_lastname;
    }

    public void setContact_lastname(String contact_lastname) {
        this.contact_lastname = contact_lastname;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", cvr='" + cvr + '\'' +
                ", company='" + company + '\'' +
                ", streetadress='" + streetadress + '\'' +
                ", postelCode='" + postelCode + '\'' +
                ", contact_name='" + contact_name + '\'' +
                ", contact_lastname='" + contact_lastname + '\'' +
                ", contact_email='" + contact_email + '\'' +
                ", contact_phone='" + contact_phone + '\'' +
                '}';
    }
}
