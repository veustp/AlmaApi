package libis.alma.api.rest;

import java.io.StringReader;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

public class AlmaUserAPIClient {
	private AlmawsV1UsersResource almaApi;
	public AlmawsV1UsersResource getAlmaApi() {
		return almaApi;
	}
	public void setAlmaApi(AlmawsV1UsersResource almaApi) {
		this.almaApi = almaApi;
	}
	public void handleError(Response resp) throws Exception{
		try {
			JAXBContext jaxbContext;			
			jaxbContext 				= JAXBContext.newInstance(WebServiceResult.class);
			Unmarshaller unmarshaller 	= jaxbContext.createUnmarshaller();
			StringReader reader 		= new StringReader(resp.readEntity(String.class));
			WebServiceResult wsr  		= (WebServiceResult) unmarshaller.unmarshal(reader);
			String errorMessage 		= "Error Response From Alma API:\n";
			for (Error ele: wsr.getErrorList().getError()) {
				errorMessage = errorMessage + ele.getErrorCode()+" - "+ele.getErrorMessage()+"\n"+
							   "(tracking id = "+ele.getTrackingId()+")\n";
			}
			throw new Exception (errorMessage);
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			throw e1;
		}
	}
	public AlmaUserAPIClient(String inst) throws Exception {
		try {
			this.almaApi = JAXRSClientFactory.create(AlmaAPIUtility.getAlmaApiBaseUrl(), AlmawsV1UsersResource.class);
			MultivaluedMap<String, String> almaHeaders = new MultivaluedHashMap<String,String>();
			almaHeaders.add("Authorization", "apikey "+AlmaAPIUtility.getAlmaAPIKey(inst));		
			WebClient.client(almaApi).headers(almaHeaders);
			HTTPClientPolicy clientConfig = WebClient.getConfig(almaApi).getHttpConduit().getClient();
		    clientConfig.setReceiveTimeout(60000); //milliseconds			
		} catch (Exception e) {
			throw e;
		}
	}
	@SuppressWarnings("unused")
	public static void responseToString(Response resp) {
		String value = resp.readEntity(String.class);
		System.out.println(value);
	}
}