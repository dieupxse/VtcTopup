package vn.ctnet.thanhtoan.topup.vtc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;

public class SendRequestXML {
	
     public String sendRequest(String apiUrl, String xmlData, String action) {
    	 return socketSend(apiUrl, xmlData, action);
     }
     public String sendRequest(String apiUrl, String xmlData) {
    	 return socketSend(apiUrl, xmlData, "http://tempuri.org/RequestTransaction");
     }
     
     private String socketSend(String url, String xmldata,String action){
         try {
            URL aUrl=new URL(url);
            //Create socket
            int port = 80;
            InetAddress addr = InetAddress.getByName(aUrl.getHost());
            Socket sock = new Socket(addr, port);

            //Send header
            
            
           BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream(), "UTF-8"));
            // You can use "UTF8" for compatibility with the Microsoft virtual machine.
            wr.write("POST " + aUrl.getPath() + " HTTP/1.0\r\n");
            wr.write("User-Agent: Mozilla/4.0 (compatible; MSIE 6.0; MS Web Services Client Protocol 2.0.50727.5420)\r\n");
            wr.write("Content-Type: text/xml; charset=\"utf-8\"\r\n");
            wr.write("SOAPAction:"+action+"\r\n");
            wr.write("Host: "+aUrl.getHost()+"\r\n");
            wr.write("Content-Length: " + xmldata.length() + "\r\n");
            wr.write("\r\n");

            //Send data
            wr.write(xmldata);
            wr.flush();

            // Response
            BufferedReader rd = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String line;
            String xre="";
            while ((line = rd.readLine()) != null) {
                xre=line;
            }
            sock.close();
            return xre;
        } catch (Exception e) {
            return e.toString();
        } 
    }
     
     private String[] httpPost(String url, String action, String xml) throws Exception {


        //Authenticator cosmoteAuthenticator = new VAuthenticator(username, password);
        //Authenticator.setDefault(cosmoteAuthenticator);
        // System.setProperty("http.proxyHost", "203.162.168.2");
        // System.setProperty("http.proxyPort", "80");
        // # System.setProperty("http.proxyHost", "proxy host");
        // System.setProperty("http.proxyPort", "port");

        HttpClient client = new HttpClient();

        HttpState state = client.getState();
//        state.setCredentials(new AuthScope(null, -1),
//                new UsernamePasswordCredentials(username, password));

        client.setState(state);
        PostMethod method = new PostMethod(url);
        method.setDoAuthentication(true);

        method.getHostAuthState().setAuthAttempted(true);
        method.getHostAuthState().setAuthRequested(true);
        method.getHostAuthState().setPreemptive();
        method.addRequestHeader("Content-Type", "text/xml ; charset=utf-8");
        method.addRequestHeader("SOAPAction", action);
        try {
            method.setRequestBody(xml);

        } catch (Exception e) {
            try {
                ByteArrayRequestEntity entity = new ByteArrayRequestEntity(
                        xml.getBytes());
                method.setRequestEntity(entity);

            } catch (Exception e1) {
               //logger.error(e);
            }
        }

        int iRes = client.executeMethod(method);
        Header[] headers = method.getRequestHeaders();
        //logger.info(xml);

        for (int i = 0; i < headers.length; i++) {
            Header header = headers[i];

        }


        byte[] response = method.getResponseBody();

        String textResponse = new String(response);


        String[] toReturn = {"" + iRes, textResponse};

        return toReturn;
    }
     
     public String getValue(String xml, String tagName) {
        String openTag = "<" + tagName + ">";
        String closeTag = "</" + tagName + ">";
        int f = xml.indexOf(openTag) + openTag.length();
        int l = xml.indexOf(closeTag);
        return (f > l) ? "" : xml.substring(f, l);
    }
     
    public String getValue(String xml) {
    	return getValue(xml,"RequestTransactionResult");
    }
     
}
