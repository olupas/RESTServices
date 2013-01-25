package model.order;

/**
 * Created with IntelliJ IDEA.
 * User: olupas
 * Date: 1/25/13
 * Time: 5:07 PM
 * To change this template use File | Settings | File Templates.
 */
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Customer")
public class Customer {
    private long customerNumber;
    private String firstName;
    private String lastName;

    @XmlElement(name = "CustomerNumber")
    public long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(long customerNumber) {
        this.customerNumber = customerNumber;
    }


    @XmlElement(name = "FirstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement(name = "LastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

