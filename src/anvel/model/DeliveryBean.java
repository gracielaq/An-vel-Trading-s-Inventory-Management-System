package anvel.model;

public class DeliveryBean {

    private String Driver;
    private String sell_no;
    private String Helper;
    private String PlateNum;
    private String CodingDay;
    private java.sql.Date DeliveryDate;
    private String destination;
    private String trucking;
    private String items;
    private int quantity;
    private int batch_no;

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public int getBatch_no() {
        return batch_no;
    }

    public void setBatch_no(int batch_no) {
        this.batch_no = batch_no;
    }

    public String getDriver() {
        return Driver;
    }

    public void setDriver(String driver) {
        Driver = driver;
    }

    public String getSell_no() {
        return sell_no;
    }

    public void setSell_no(String sell_no) {
        this.sell_no = sell_no;
    }

    public String getHelper() {
        return Helper;
    }

    public void setHelper(String helper) {
        Helper = helper;
    }

    public String getPlateNum() {
        return PlateNum;
    }

    public void setPlateNum(String plateNum) {
        PlateNum = plateNum;
    }

    public String getCodingDay() {
        return CodingDay;
    }

    public void setCodingDay(String codingDay) {
        CodingDay = codingDay;
    }

    public java.sql.Date getDeliveryDate() {
        return DeliveryDate;
    }

    public void setDeliveryDate(java.sql.Date deliveryDate) {
        DeliveryDate = deliveryDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTrucking() {
        return trucking;
    }

    public void setTrucking(String trucking) {
        this.trucking = trucking;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
