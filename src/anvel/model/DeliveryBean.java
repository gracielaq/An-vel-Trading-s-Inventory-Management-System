package anvel.model;

public class DeliveryBean {
	
	private String Driver;
	private String sell_no;
	private String Helper;
	private String PlateNum;
	private String CodingDay;
	private java.sql.Date DeliveryDate;



	private int batch_no;

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
	
	
}
