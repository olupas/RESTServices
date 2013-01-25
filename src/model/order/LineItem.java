package model.order;

/**
 * Created with IntelliJ IDEA.
 * User: olupas
 * Date: 1/25/13
 * Time: 5:08 PM
 * To change this template use File | Settings | File Templates.
 */

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"sku", "description", "quantity", "unitPrice",
        "subTotal", "tax", "total"})
public class LineItem {
    private long sku;
    private String description;
    private short quantity;
    private double unitPrice;

    @XmlElement
    public long getSku() {
        return sku;
    }

    public void setSku(long sku) {
        this.sku = sku;
    }

    @XmlElement
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement
    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    @XmlElement
    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @XmlElement
    public double getSubTotal() {
        return unitPrice * quantity;
    }

    @XmlElement
    public double getTax() {
        return getSubTotal() * 0.15F;
    }

    @XmlElement
    public double getTotal() {
        return getSubTotal() + getTax();
    }
}


