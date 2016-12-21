package vn.ctnet.thanhtoan.topup.vtc;

import java.util.ArrayList;
import java.util.List;

import vn.ctnet.thanhtoan.topup.vtc.entity.ResponseObject;

public class CallApi {
	
	private String apiUrl;
	private String version;
	private String partnerCode;
	private String tripleDesKey;
	private String urlRsaPublicKey;
	private String urlRsaPrivateKey;
	private SendRequestXML srxml;
	
	/***
	 * Setup API call
	 * @param apiUrl
	 * @param version
	 * @param partnerCode
	 * @param tripleDesKey
	 * @param urlRsaPublicKey
	 * @param urlRsaPrivateKey
	 */
	public CallApi(String apiUrl, String version, String partnerCode, String tripleDesKey, String urlRsaPublicKey,
			String urlRsaPrivateKey) {
		super();
		this.apiUrl = apiUrl;
		this.version = version;
		this.partnerCode = partnerCode;
		this.tripleDesKey = tripleDesKey;
		this.urlRsaPublicKey = urlRsaPublicKey;
		this.urlRsaPrivateKey = urlRsaPrivateKey;
		this.srxml = new SendRequestXML();
	}
	
	/***
	 * Call API Topup Telco
	 * @param serviceCode
	 * @param account
	 * @param amount
	 * @param transDate
	 * @param orgTransID
	 * @return {@link ResponseObject}
	 */
	public ResponseObject topupTelco(
			String serviceCode, 
			String account, 
			String amount, 
			String transDate, 
			String orgTransID) throws Exception  {
		try {
			ResponseObject rs = new ResponseObject();
			String data = serviceCode+"-"+account+"-"+amount+"-"+this.partnerCode+"-"+transDate+"-"+orgTransID;
			String sign = vn.ctnet.helper.Security.createSignRSA(data, this.urlRsaPrivateKey);
			String xml = XmlRequest.topupTelco(serviceCode, account, amount, transDate, orgTransID, sign);
			xml = XmlRequest.GenerateXmlRequest(xml, this.partnerCode,"TopupTelco", this.version);
			String response = srxml.sendRequest(this.apiUrl, xml);
			String result = srxml.getValue(response);
			String[] val = result.replace("|","<>").split("<>");
			rs.setResponseCode(val[0]);
			rs.setOrgTranID(val[1]);
			rs.setPartnerBalance(val[2]);
			rs.setDataSign(val[3]);
			rs.setAmount(amount);
			rs.setData(data);
			boolean verifySign = vn.ctnet.helper.Security.checkSignRSA(
					rs.getDataSign(),
					rs.getResponseCode()+"-"+rs.getOrgTranID()+"-"+rs.getPartnerBalance(), 
					this.urlRsaPublicKey);
			rs.setValidateSign(verifySign);
			return rs;	
		} catch (Exception e) {
			throw e;
		}
	}
	
	/***
	 * Call API Topup Partner
	 * @param serviceCode
	 * @param account
	 * @param amount
	 * @param transDate
	 * @param orgTransID
	 * @return
	 */
	public ResponseObject topupPartner( 
			String serviceCode,  
			String account, 
			String amount,
			String transDate,
			String orgTransID) throws Exception {
		try
		{
			ResponseObject rs = new ResponseObject();
			String data = serviceCode+"-"+account+"-"+amount+"-"+this.partnerCode+"-"+transDate+"-"+orgTransID;
			String sign = vn.ctnet.helper.Security.createSignRSA(data, this.urlRsaPrivateKey);
			String xml = XmlRequest.topupPartner(serviceCode, account, amount, transDate, orgTransID, sign);
			xml = XmlRequest.GenerateXmlRequest(xml, this.partnerCode,"TopupParner", this.version);
			String response = srxml.sendRequest(this.apiUrl, xml);
			
			String result = srxml.getValue(response);
			String[] val = result.replace("|","<>").split("<>");
			rs.setResponseCode(val[0]);
			rs.setOrgTranID(val[1]);
			rs.setPartnerBalance(val[2]);
			rs.setDataSign(val[3]);
			rs.setAmount(amount);
			rs.setData(data);
			boolean verifySign = vn.ctnet.helper.Security.checkSignRSA(
					rs.getDataSign(),
					rs.getResponseCode()+"-"+rs.getOrgTranID()+"-"+rs.getPartnerBalance(), 
					this.urlRsaPublicKey);
			rs.setValidateSign(verifySign);
			return rs;	
			
		}catch (Exception e) {
			throw e;
		}
	}
	
	/***
	 * Call API Buy Card
	 * @param serviceCode
	 * @param amount
	 * @param quantity
	 * @param transDate
	 * @param orgTransID
	 * @return
	 */
	public ResponseObject buyCard( String serviceCode,String amount,String quantity,
			    String transDate,String orgTransID) throws Exception {
		try {
			ResponseObject rs = new ResponseObject();
			String data = serviceCode+"-"+amount+"-"+quantity+"-"+this.partnerCode+"-"+transDate+"-"+orgTransID;
			String sign = vn.ctnet.helper.Security.createSignRSA(data, this.urlRsaPrivateKey);
			String xml = XmlRequest.buyCard(serviceCode, amount, quantity, transDate, orgTransID, sign);
			xml = XmlRequest.GenerateXmlRequest(xml, this.partnerCode,"BuyCard", this.version);
			String response = srxml.sendRequest(this.apiUrl, xml);
			String result = srxml.getValue(response);
			String[] val = result.replace("|","<>").split("<>");
			
			
			rs.setResponseCode(val[0]);
			rs.setOrgTranID(val[1]);
			rs.setVtcTransID(val[2]);
			rs.setPartnerBalance(val[3]);
			rs.setDataSign(val[4]);
			rs.setAmount(amount);
			rs.setData(data);
			boolean verifySign = vn.ctnet.helper.Security.checkSignRSA(
					rs.getDataSign(),
					rs.getResponseCode()+"-"+rs.getOrgTranID()+"-"+rs.getVtcTransID()+"-"+rs.getPartnerBalance(), 
					this.urlRsaPublicKey);
			rs.setValidateSign(verifySign);
			return rs;	
			
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	/***
	 * Call API Check Account Exist or Not
	 * @param serviceCode
	 * @param account
	 * @return
	 */
	public ResponseObject checkAccountGameExist(String serviceCode, String account) throws Exception {
		try {
			
			ResponseObject rs = new ResponseObject();
			String data = serviceCode+"-"+account+"-"+this.partnerCode;
			String sign = vn.ctnet.helper.Security.createSignRSA(data, this.urlRsaPrivateKey);
			String xml = XmlRequest.checkAccount(serviceCode, account,sign);
			xml = XmlRequest.GenerateXmlRequest(xml, this.partnerCode,"CheckAccount", this.version);
			String response = srxml.sendRequest(this.apiUrl, xml);
			String result = srxml.getValue(response);
			String[] val = result.replace("|","<>").split("<>");
			
			
			rs.setResponseCode(val[0]);
			rs.setDataSign(val[1]);
			rs.setData(data);
			boolean verifySign = vn.ctnet.helper.Security.checkSignRSA(
					rs.getDataSign(),
					rs.getResponseCode(), 
					this.urlRsaPublicKey);
			rs.setValidateSign(verifySign);
			return rs;	
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	/***
	 * Call API Get Card
	 * @param serviceCode
	 * @param amount
	 * @param vtcTransId
	 * @return
	 * @throws Exception
	 */
	public ResponseObject getCard(String serviceCode,String amount,String vtcTransId) throws Exception {
		try {
			ResponseObject rs = new ResponseObject();
			String data = serviceCode+"-"+amount+"-"+this.partnerCode+"-"+vtcTransId;
			String sign = vn.ctnet.helper.Security.createSignRSA(data, this.urlRsaPrivateKey);
			String xml = XmlRequest.getCard(serviceCode, amount,vtcTransId,sign);
			xml = XmlRequest.GenerateXmlRequest(xml, this.partnerCode,"GetCard", this.version);
			String response = srxml.sendRequest(this.apiUrl, xml);
			String res = srxml.getValue(response);
			String result = vn.ctnet.helper.Security.decryptTripleDES(this.tripleDesKey, res);
			String[] val = result.replace("|","<>").split("<>");
			rs.setResponseCode(val[0]);
			rs.setVtcTransID(val[1]);
			List<String> listCard = new ArrayList<>();
			for(int i=2; i<val.length;i++) {
				listCard.add(val[i]);
			}
			rs.setListCard(listCard);
			rs.setData(data);
			rs.setValidateSign(true);
			return rs;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
}
