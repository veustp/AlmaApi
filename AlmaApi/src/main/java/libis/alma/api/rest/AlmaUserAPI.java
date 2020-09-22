package libis.alma.api.rest;
import java.io.StringReader;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import libis.user.pkg.*;

public class AlmaUserAPI {
		private static final Logger LOGGER = LogManager.getLogger(AlmaUserAPI.class);
		private AlmaUserAPIClient almaAPIClient;
		public AlmaUserAPIClient getAlmaAPIClient() {
			return almaAPIClient;
		}
		public void setAlmaAPIClient(AlmaUserAPIClient almaAPIClient) {
			this.almaAPIClient = almaAPIClient;
		}
		public AlmaUserAPI(String inst) throws Exception {
			try {
				this.setAlmaAPIClient(new AlmaUserAPIClient(inst));
			} catch (Exception e) {
				throw e;
			}
		}
		private User responseToUser(Response resp) throws Exception {
			try {
				JAXBContext jaxbContext;			
				jaxbContext = JAXBContext.newInstance(User.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				StringReader reader = new StringReader(resp.readEntity(String.class));
				User u = (User) unmarshaller.unmarshal(reader);
				return(u);
			} catch (JAXBException e) {
				throw new Exception("Error reading User Response Object from API ("+e.getMessage()+")");
			}
		}
		public User getUser (String id) throws Exception{
			try {
				String view = "full";
				String user_id_type = "all_unique";
				String expand = "none";
				String source_institution_code = null;
				Response resp = null;
				resp = this.getAlmaAPIClient().getAlmaApi().getUser_id(id, user_id_type, view, expand, source_institution_code);
				if (resp.getStatus() == 200) {
					//AlmaUserAPIClient.responseToString(resp);
					User uGet = this.responseToUser(resp);
					return(uGet);
				} else {
					this.getAlmaAPIClient().handleError(resp);
					throw(new Exception("Error in getUser(): "+id));
				}
			} catch (Exception e) {
				throw e;
			}
		}
		public User putUser (User u) throws Exception {
			try {
				String user_id = u.getPrimaryId();
				String user_id_type = "all_unique";
				/*
				 * user_group, job_category, pin_number, preferred_language, campus_code, rs_libraries, user_title, library_notices.
				 * To update these fields, specify the fields you want to replace in this parameter.
				 */
				String override = "";
				String send_pin_number_letter = "false"; //default false
				Response resp = null;
			    resp = this.getAlmaAPIClient().getAlmaApi().putUser_id(u, user_id, user_id_type, override, send_pin_number_letter);
				if (resp.getStatus() == 200) {
					AlmaUserAPIClient.responseToString(resp);
					User uUpd = this.ResponsetoUser(resp);
					return(uUpd);
				} else {
					this.getAlmaAPIClient().handleError(resp);					
					throw(new Exception("Error in putUser()"));
				}			    
			} catch (Exception e) {
				String eMsg = "putUser Exception Encountered";
				throw(new Exception(eMsg+" "+e.getMessage()+" "+e.getStackTrace().toString()+" "+e));
			}
		}
		public String postUser(User u) throws Exception {
			try {
				/*
				social_authentication	Optional. Default: false	When customer parameter social_authentication='True': Send social authentication email to patron. Default value: False.
				send_pin_number_letter	Optional. Default: false	The email notification for PIN setting change will be sent
				source_institution_code	Optional.	The code of the source institution from which the user was linked. Optional
				source_user_id	Optional.	The ID of the user in the source institution. Optional
				*/				
				String socialAuth = "false";
				String sendPin    = "false";
				String srcInst    = "";
				String srcUserId  = "";
				String user_id    = u.getPrimaryId();
				Response resp     = null;
				resp = this.getAlmaAPIClient().getAlmaApi().post(u, socialAuth, sendPin, srcInst, srcUserId);
				AlmaUserAPIClient.responseToString(resp);
				if (resp.getStatus() == 200) {
					user_id = postUserResponse(resp);
				} else {
					this.getAlmaAPIClient().handleError(resp);
				}
				return(user_id);
			} catch (Exception e) {
				throw e;
			}
		}
		public String postUserResponse(Response resp) throws Exception{
			try {
				User u = this.responseToUser(resp);
				return(u.getPrimaryId());
			} catch (Exception e) {
				throw e;
			}
		}		
		private User ResponsetoUser(Response resp) throws Exception{
			try {
				User u = this.responseToUser(resp);
				LOGGER.debug(u.getPrimaryId());
				LOGGER.debug(u.getLastName());
				//LOGGER.debug(u.getBirthDate().toString());
				return(u);
			} catch (Exception e) {
				throw(e);
			}
		}
	}