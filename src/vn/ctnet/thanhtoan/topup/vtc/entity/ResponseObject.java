package vn.ctnet.thanhtoan.topup.vtc.entity;

import java.util.List;

public class ResponseObject {
	private String responseCode ;
	private String orgTranID ;
	private List<String> listCard ;
	private String VtcTransID ;
	private String partnerBalance ;
	private String dataSign ;
	private String listQuantityCard ;
	private String data ;
	private String amount ;
	private String salePrice ;
	private String extent ;
	private boolean isValidateSign ;
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getOrgTranID() {
		return orgTranID;
	}
	public void setOrgTranID(String orgTranID) {
		this.orgTranID = orgTranID;
	}
	
	public List<String> getListCard() {
		return listCard;
	}
	public void setListCard(List<String> listCard) {
		this.listCard = listCard;
	}
	public String getVtcTransID() {
		return VtcTransID;
	}
	public void setVtcTransID(String vtcTransID) {
		VtcTransID = vtcTransID;
	}
	public String getPartnerBalance() {
		return partnerBalance;
	}
	public void setPartnerBalance(String partnerBalance) {
		this.partnerBalance = partnerBalance;
	}
	public String getDataSign() {
		return dataSign;
	}
	public void setDataSign(String dataSign) {
		this.dataSign = dataSign;
	}
	public String getListQuantityCard() {
		return listQuantityCard;
	}
	public void setListQuantityCard(String listQuantityCard) {
		this.listQuantityCard = listQuantityCard;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	public String getExtent() {
		return extent;
	}
	public void setExtent(String extent) {
		this.extent = extent;
	}
	public boolean isValidateSign() {
		return isValidateSign;
	}
	public void setValidateSign(boolean isValidateSign) {
		this.isValidateSign = isValidateSign;
	}

}
