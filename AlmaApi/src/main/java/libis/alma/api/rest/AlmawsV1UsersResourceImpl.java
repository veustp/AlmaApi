/**
 * Created by Apache CXF WadlToJava code generator
**/
package libis.alma.api.rest;

import javax.ws.rs.core.Response;
import libis.user.pkg.*;

public class AlmawsV1UsersResourceImpl implements AlmawsV1UsersResource {


    public Response get(Integer limit, Integer offset, String q, String order_by, 
                String source_institution_code, String source_user_id) {
        //TODO: implement
        return null;
    }


    public Response post(User u, String social_authentication, String send_pin_number_letter, String source_institution_code, String source_user_id) {
        //TODO: implement
        return null;
    }


    public String getOperationtest() {
        //TODO: implement
        return null;
    }


    public String postOperationtest() {
        //TODO: implement
        return null;
    }


    public String deleteUser_id(String user_id, String user_id_type) {
        //TODO: implement
        return null;
    }


    public Response getUser_id(String user_id, String user_id_type, String view, String expand, 
                String source_institution_code) {
        //TODO: implement
        return null;
    }


    public Response postUser_id(String user_id, String user_id_type, String op, String password) {
        //TODO: implement
        return null;
    }


    public Response putUser_id(User u, String user_id, String user_id_type, String override, String send_pin_number_letter) {
        //TODO: implement
        return null;
    }


    public Response getUser_iddeposits(String user_id, String user_id_type, String status, Integer limit, 
                Integer offset, String order_by, String direction) {
        //TODO: implement
        return null;
    }


    public Response postUser_iddeposits(String user_id, String user_id_type, String draft) {
        //TODO: implement
        return null;
    }


    public Response getUser_iddepositsdeposit_id(String user_id, String deposit_id, String user_id_type) {
        //TODO: implement
        return null;
    }


    public Response postUser_iddepositsdeposit_id(String user_id, String deposit_id, String op, String user_id_type) {
        //TODO: implement
        return null;
    }


    public Response getUser_idfees(String user_id, String user_id_type, String status) {
        //TODO: implement
        return null;
    }


    public Response postUser_idfees(String user_id) {
        //TODO: implement
        return null;
    }


    public Response postUser_idfeesall(String user_id, String user_id_type, String op, String amount, 
                String method, String comment, String external_transaction_id) {
        //TODO: implement
        return null;
    }


    public Response getUser_idfeesfee_id(String user_id, String fee_id, String user_id_type) {
        //TODO: implement
        return null;
    }


    public Response postUser_idfeesfee_id(String user_id, String fee_id, String user_id_type, String op, 
                String amount, String method, String reason, String comment, 
                String external_transaction_id) {
        //TODO: implement
        return null;
    }


    public Response getUser_idloans(String user_id, String user_id_type, Integer limit, Integer offset, 
                String order_by, String direction, String expand) {
        //TODO: implement
        return null;
    }


    public Response postUser_idloans(String user_id, String item_pid, String user_id_type, String item_barcode) {
        //TODO: implement
        return null;
    }


    public Response getUser_idloansloan_id(String user_id, String loan_id) {
        //TODO: implement
        return null;
    }


    public Response postUser_idloansloan_id(String user_id, String loan_id, String user_id_type, String op) {
        //TODO: implement
        return null;
    }


    public Response putUser_idloansloan_id(String user_id, String loan_id) {
        //TODO: implement
        return null;
    }


    public Response getUser_idpurchaserequests(String user_id, String user_id_type, Integer limit, Integer offset, 
                String status) {
        //TODO: implement
        return null;
    }


    public Response postUser_idpurchaserequests(String user_id, String user_id_type) {
        //TODO: implement
        return null;
    }


    public Response getUser_idpurchaserequestspurchase_request_id(String user_id, String purchase_request_id, String user_id_type) {
        //TODO: implement
        return null;
    }


    public Response getUser_idrequests(String user_id, String request_type, String user_id_type, Integer limit, 
                String offset, String status) {
        //TODO: implement
        return null;
    }


    public Response postUser_idrequests(String user_id, String user_id_type, String mms_id, String item_pid) {
        //TODO: implement
        return null;
    }


    public void deleteUser_idrequestsrequest_id(String user_id, String request_id, String reason, String note, 
                Boolean notify_user) {
        //TODO: implement
    }


    public Response getUser_idrequestsrequest_id(String user_id, String request_id, String user_id_type) {
        //TODO: implement
        return null;
    }


    public Response postUser_idrequestsrequest_id(String user_id, String request_id, String op, String release_item) {
        //TODO: implement
        return null;
    }


    public Response putUser_idrequestsrequest_id(String user_id, String request_id) {
        //TODO: implement
        return null;
    }


    public Response postUser_idresource_sharing_requests(String user_id, String user_id_type, String override_blocks) {
        //TODO: implement
        return null;
    }


    public Response getUser_idresource_sharing_requestsrequest_id(String user_id, String request_id, String request_id_type) {
        //TODO: implement
        return null;
    }


    public Response postUser_idresource_sharing_requestsrequest_id(String user_id, String request_id, String request_id_type, String op, 
                String shipping_cost, String fund_code) {
        //TODO: implement
        return null;
    }


    public Response getUser_namelegantonotifications(String user_name, String notificationType, String limit, String from, 
                String to) {
        //TODO: implement
        return null;
    }

}