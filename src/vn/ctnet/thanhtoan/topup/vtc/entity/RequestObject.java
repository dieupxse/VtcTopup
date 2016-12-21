package vn.ctnet.thanhtoan.topup.vtc.entity;

public class RequestObject {
	private String serviceCode;
	private String account;
	private String amount;
	private String transDate;
	private String orgTransID;
	private String dataSign;
	private String quantity ;
	
	public RequestObject() {
		super();
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	public String getOrgTransID() {
		return orgTransID;
	}
	public void setOrgTransID(String orgTransID) {
		this.orgTransID = orgTransID;
	}
	public String getDataSign() {
		return dataSign;
	}
	public void setDataSign(String dataSign) {
		this.dataSign = dataSign;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	/***
	 * This method user for Topup Partner
	 * @param serviceCode
	 * @param account
	 * @param amount
	 * @param transDate
	 * @param orgTransID
	 * @param dataSign
	 * @param quantity
	 */
	public RequestObject(String serviceCode, String account, String amount, String transDate, String orgTransID,
			String dataSign, String quantity) {
		super();
		this.serviceCode = serviceCode;
		this.account = account;
		this.amount = amount;
		this.transDate = transDate;
		this.orgTransID = orgTransID;
		this.dataSign = dataSign;
		this.quantity = quantity;
	}
	/***
	 * This method using for Topup Telco
	 * @param serviceCode
	 * @param account
	 * @param amount
	 * @param transDate
	 * @param orgTransID
	 * @param dataSign
	 */
	public RequestObject(String serviceCode, String account, String amount, String transDate, String orgTransID,
			String dataSign) {
		super();
		this.serviceCode = serviceCode;
		this.account = account;
		this.amount = amount;
		this.transDate = transDate;
		this.orgTransID = orgTransID;
		this.dataSign = dataSign;
	}
	/***
	 * This method using for Check Account
	 * @param serviceCode
	 * @param account
	 * @param dataSign
	 * @param quantity
	 */
	public RequestObject(String serviceCode, String account, String dataSign, String quantity) {
		super();
		this.serviceCode = serviceCode;
		this.account = account;
		this.dataSign = dataSign;
		this.quantity = quantity;
	}
	
	
}
