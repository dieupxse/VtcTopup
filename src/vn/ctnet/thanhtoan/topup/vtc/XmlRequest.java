package vn.ctnet.thanhtoan.topup.vtc;

public class XmlRequest {
	
	/***
	 * XML Request String for Topup Telco API
	 * @param serviceCode
	 * @param account
	 * @param amount
	 * @param transDate
	 * @param orgTransID
	 * @param dataSign
	 * @return
	 */
	public static String topupTelco(
			String serviceCode, 
			String account,
			String amount,
			String transDate,
			String orgTransID,
			String dataSign){
        try { 
        String xmlre=  "&lt;?xml version=\"1.0\" encoding=\"utf-16\"?&gt;\n" +
                       "&lt;RequestData xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"&gt;\n" +
                       "  &lt;ServiceCode&gt;"+serviceCode+"&lt;/ServiceCode&gt;\n" +
                       "  &lt;Account&gt;"+account+"&lt;/Account&gt;\n" +
                       "  &lt;Amount&gt;"+amount+"&lt;/Amount&gt;\n" +
                       "  &lt;TransDate&gt;"+transDate+"&lt;/TransDate&gt;\n" +
                       "  &lt;OrgTransID&gt;"+orgTransID+"&lt;/OrgTransID&gt;\n" +
                       "  &lt;DataSign&gt;"+dataSign+"&lt;/DataSign&gt;\n" +
                       "&lt;/RequestData&gt;";
           return xmlre;
       } catch (Exception ex) {
           return  ex.toString();
       }
    }
   
   /***
    * XML Request String for Topup Partner API
    * @param serviceCode
    * @param account
    * @param amount
    * @param transDate
    * @param orgTransID
    * @param dataSign
    * @return
    */
   public static String topupPartner(
		   String serviceCode, 
		   String account,
		   String amount,
		   String transDate,
		   String orgTransID,
		   String dataSign){
        try { 
        String xmlre=  "&lt;?xml version=\"1.0\" encoding=\"utf-16\"?&gt;\n" +
                       "&lt;RequestData xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"&gt;\n" +
                       "  &lt;ServiceCode&gt;"+serviceCode+"&lt;/ServiceCode&gt;\n" +
                       "  &lt;Account&gt;"+account+"&lt;/Account&gt;\n" +
                       "  &lt;Amount&gt;"+amount+"&lt;/Amount&gt;\n" +
                       "  &lt;TransDate&gt;"+transDate+"&lt;/TransDate&gt;\n" +
                       "  &lt;OrgTransID&gt;"+orgTransID+"&lt;/OrgTransID&gt;\n" +
                       "  &lt;DataSign&gt;"+dataSign+"&lt;/DataSign&gt;\n" +
                       "  &lt;Description&gt;"+serviceCode+"|"+account+"|"+transDate+"|"+amount+"&lt;/Description&gt;\n" +
                       "&lt;/RequestData&gt;";
           return xmlre;
       } catch (Exception ex) {
           return  ex.toString();
       }
    }
   
   /***
    * XML Request String for Check Account API
    * @param serviceCode
    * @param account
    * @param dataSign
    * @return
    */
   public static String checkAccount (
		   String serviceCode, 
		   String account,
		   String dataSign){
        try { 
        String xmlre=  "&lt;?xml version=\"1.0\" encoding=\"utf-16\"?&gt;\n" +
                       "&lt;RequestData xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"&gt;\n" +
                       "  &lt;ServiceCode&gt;"+serviceCode+"&lt;/ServiceCode&gt;\n" +
                       "  &lt;Account&gt;"+account+"&lt;/Account&gt;\n" +
                       "  &lt;DataSign&gt;"+dataSign+"&lt;/DataSign&gt;\n" +
                       "&lt;/RequestData&gt;";
           return xmlre;
       } catch (Exception ex) {
           return  ex.toString();
       }
    }
   
   /***
    * XML Request String for Buy Card API
    * @param serviceCode
    * @param amount
    * @param quantity
    * @param transDate
    * @param orgTransID
    * @param dataSign
    * @return
    */
   public static String buyCard(
		   String serviceCode,
		   String amount,
		   String quantity,
		   String transDate,
		   String orgTransID,
		   String dataSign){
        try { 
        String xmlre=  "&lt;?xml version=\"1.0\" encoding=\"utf-16\"?&gt;\n" +
                       "&lt;RequestData xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"&gt;\n" +
                       "  &lt;ServiceCode&gt;"+serviceCode+"&lt;/ServiceCode&gt;\n" +
                       "  &lt;Amount&gt;"+amount+"&lt;/Amount&gt;\n" +
                       "  &lt;Quantity&gt;"+quantity+"&lt;/Quantity&gt;\n" +
                       "  &lt;TransDate&gt;"+transDate+"&lt;/TransDate&gt;\n" +
                       "  &lt;OrgTransID&gt;"+orgTransID+"&lt;/OrgTransID&gt;\n" +
                       "  &lt;DataSign&gt;"+dataSign+"&lt;/DataSign&gt;\n" +
                       "&lt;/RequestData&gt;";
           return xmlre;
       } catch (Exception ex) {
           return  ex.toString();
       }
    }
   
   /***
    * XML Request String for Get Card API
    * @param serviceCode
    * @param amount
    * @param orgTransID
    * @param dataSign
    * @return
    */
   public static String getCard(
		   String serviceCode, 
		   String amount,
		   String orgTransID,
		   String dataSign){
        try { 
        String xmlre=  "&lt;?xml version=\"1.0\" encoding=\"utf-16\"?&gt;\n" +
                       "&lt;RequestData xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"&gt;\n" +
                       "  &lt;ServiceCode&gt;"+serviceCode+"&lt;/ServiceCode&gt;\n" +
                       "  &lt;Amount&gt;"+amount+"&lt;/Amount&gt;\n" +
                       "  &lt;OrgTransID&gt;"+orgTransID+"&lt;/OrgTransID&gt;\n" +
                       "  &lt;DataSign&gt;"+dataSign+"&lt;/DataSign&gt;\n" +
                       "&lt;/RequestData&gt;";
           return xmlre;
       } catch (Exception ex) {
           return  ex.toString();
       }
    }
   
   /***
    * XML Request String for Get Balance API
    * @param quantity
    * @param dataSign
    * @return
    */
   public static String getBalance(String quantity,String dataSign){
        try { 
        String xmlre=  "&lt;?xml version=\"1.0\" encoding=\"utf-16\"?&gt;\n" +
                       "&lt;RequestData xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"&gt;\n" +
                       "  &lt;Quantity&gt;"+quantity+"&lt;/Quantity&gt;\n" +
                       "  &lt;DataSign&gt;"+dataSign+"&lt;/DataSign&gt;\n" +
                       "&lt;/RequestData&gt;";
           return xmlre;
       } catch (Exception ex) {
           return  ex.toString();
       }
    }
   
   /***
    * XML Request String for Get Quantity Card API
    * @param serviceCode
    * @param amount
    * @param quantity
    * @param orgTransID
    * @param dataSign
    * @return
    */
   public static String getQuantiyCard(
		   String serviceCode,
		   String amount,
		   String quantity,
		   String orgTransID,
		   String dataSign){
        try { 
        String xmlre=  "&lt;?xml version=\"1.0\" encoding=\"utf-16\"?&gt;\n" +
                       "&lt;RequestData xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"&gt;\n" +
                       "  &lt;ServiceCode&gt;"+serviceCode+"&lt;/ServiceCode&gt;\n" +
                       "  &lt;Amount&gt;"+amount+"&lt;/Amount&gt;\n" +
                       "  &lt;Quantity&gt;"+quantity+"&lt;/Quantity&gt;\n" +
                       "  &lt;OrgTransID&gt;"+orgTransID+"&lt;/OrgTransID&gt;\n" +
                       "  &lt;DataSign&gt;"+dataSign+"&lt;/DataSign&gt;\n" +
                       "&lt;/RequestData&gt;";
           return xmlre;
       } catch (Exception ex) {
           return  ex.toString();
       }
    }
  
   /***
    * XML Request String for Get Promotion Date API
    * @param quantity
    * @param dataSign
    * @return
    */
    public static String getPromotionDate(String quantity,String dataSign){
        try { 
        String xmlre=  "&lt;?xml version=\"1.0\" encoding=\"utf-16\"?&gt;\n" +
                       "&lt;RequestData xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"&gt;\n" +
                       "  &lt;Quantity&gt;"+quantity+"&lt;/Quantity&gt;\n" +
                       "  &ltDataSign&gt;"+dataSign+"&lt;/DataSign&gt;\n" +
                       "&lt;/RequestData&gt;";
           return xmlre;
       } catch (Exception ex) {
           return  ex.toString();
       }
    }
    
    /***
     * Generate XML Request
     * @param requestData
     * @param partnerCode
     * @param commandType
     * @param version
     * @return
     */
    public static String GenerateXmlRequest(String requestData,String partnerCode,String commandType,String version){
        return "<?xml version=\"1.0\" encoding=\"utf-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><soap:Body><RequestTransaction xmlns=\"http://tempuri.org/\"><requesData>"+requestData+"</requesData><partnerCode>"+partnerCode+"</partnerCode><commandType>"+commandType+"</commandType><version>"+version+"</version></RequestTransaction></soap:Body></soap:Envelope>";
    }
}
