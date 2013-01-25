package model.order;

/**
 * Created with IntelliJ IDEA.
 * User: olupas
 * Date: 1/25/13
 * Time: 5:07 PM
 * To change this template use File | Settings | File Templates.
 */

import javax.xml.bind.annotation.*;
import java.util.Date;

 @XmlType(propOrder = { "orderDate", "orderNumber", "lineItems" } )
 @XmlAccessorType(XmlAccessType.FIELD)
 public class Order {
  @XmlElement
  public Date orderDate;

   @XmlElement
   public long orderNumber;

   @XmlElement
   @XmlElementWrapper(name = "lineItems")
   public LineItem[] lineItems;

   public long getOrderNumber() {
    return orderNumber;
   }

   public void setOrderNumber(long orderNumber) {
     this.orderNumber = orderNumber;
   }

   public Date getOrderDate() {
     return orderDate;
   }

   public void setOrderDate(Date orderDate) {
     this.orderDate = orderDate;
   }

   public LineItem[] getLineItems() {
     return lineItems;
   }

   public void setLineItems(LineItem[] lineItems) {
     this.lineItems = lineItems;
   }
 }

