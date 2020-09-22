/**
 * Created by Apache CXF WadlToJava code generator
**/
package libis.alma.api.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import libis.user.pkg.*;

@Path("/almaws/v1/users")
public interface AlmawsV1UsersResource {

    @GET
    @Produces({"application/xml", "application/json" })
    Response get(@QueryParam("limit") @DefaultValue("10") Integer limit, @QueryParam("offset") @DefaultValue("0") Integer offset, @QueryParam("q") String q, @QueryParam("order_by") @DefaultValue("last_name, first_name, primary_id") String order_by, 
                @QueryParam("source_institution_code") String source_institution_code, @QueryParam("source_user_id") String source_user_id);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    Response post(User u, @QueryParam("social_authentication") @DefaultValue("false") String social_authentication, @QueryParam("send_pin_number_letter") @DefaultValue("false") String send_pin_number_letter, @QueryParam("source_institution_code") String source_institution_code, @QueryParam("source_user_id") String source_user_id);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/operation/test")
    String getOperationtest();

    @POST
    @Produces({"application/xml", "application/json" })
    @Path("/operation/test")
    String postOperationtest();

    @DELETE
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}")
    String deleteUser_id(@PathParam("user_id") String user_id, @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}")
    Response getUser_id(@PathParam("user_id") String user_id, @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type, @QueryParam("view") @DefaultValue("full") String view, @QueryParam("expand") @DefaultValue("none") String expand, 
                @QueryParam("source_institution_code") String source_institution_code);

    @POST
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}")
    Response postUser_id(@PathParam("user_id") String user_id, @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type, @QueryParam("op") @DefaultValue("auth") String op, @QueryParam("password") String password);

    @PUT
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}")
    Response putUser_id(User u, @PathParam("user_id") String user_id, @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type, @QueryParam("override") String override, @QueryParam("send_pin_number_letter") @DefaultValue("false") String send_pin_number_letter);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/deposits")
    Response getUser_iddeposits(@PathParam("user_id") String user_id, @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type, @QueryParam("status") String status, @QueryParam("limit") @DefaultValue("10") Integer limit, 
                @QueryParam("offset") @DefaultValue("0") Integer offset, @QueryParam("order_by") @DefaultValue("name") String order_by, @QueryParam("direction") @DefaultValue("ASC") String direction);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/deposits")
    Response postUser_iddeposits(@PathParam("user_id") String user_id, @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type, @QueryParam("draft") @DefaultValue("false") String draft);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/deposits/{deposit_id}")
    Response getUser_iddepositsdeposit_id(@PathParam("user_id") String user_id, @PathParam("deposit_id") String deposit_id, @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/deposits/{deposit_id}")
    Response postUser_iddepositsdeposit_id(@PathParam("user_id") String user_id, @PathParam("deposit_id") String deposit_id, @QueryParam("op") String op, @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/fees")
    Response getUser_idfees(@PathParam("user_id") String user_id, @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type, @QueryParam("status") @DefaultValue("ACTIVE") String status);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/fees")
    Response postUser_idfees(@PathParam("user_id") String user_id);

    @POST
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/fees/all")
    Response postUser_idfeesall(@PathParam("user_id") String user_id, @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type, @QueryParam("op") String op, @QueryParam("amount") String amount, 
                @QueryParam("method") String method, @QueryParam("comment") String comment, @QueryParam("external_transaction_id") String external_transaction_id);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/fees/{fee_id}")
    Response getUser_idfeesfee_id(@PathParam("user_id") String user_id, @PathParam("fee_id") String fee_id, @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type);

    @POST
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/fees/{fee_id}")
    Response postUser_idfeesfee_id(@PathParam("user_id") String user_id, @PathParam("fee_id") String fee_id, @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type, @QueryParam("op") String op, 
                @QueryParam("amount") String amount, @QueryParam("method") String method, @QueryParam("reason") String reason, @QueryParam("comment") String comment, 
                @QueryParam("external_transaction_id") String external_transaction_id);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/loans")
    Response getUser_idloans(@PathParam("user_id") String user_id, @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type, @QueryParam("limit") @DefaultValue("10") Integer limit, @QueryParam("offset") @DefaultValue("0") Integer offset, 
                @QueryParam("order_by") @DefaultValue("id") String order_by, @QueryParam("direction") @DefaultValue("ASC") String direction, @QueryParam("expand") String expand);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/loans")
    Response postUser_idloans(@PathParam("user_id") String user_id, @QueryParam("item_pid") String item_pid, @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type, @QueryParam("item_barcode") String item_barcode);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/loans/{loan_id}")
    Response getUser_idloansloan_id(@PathParam("user_id") String user_id, @PathParam("loan_id") String loan_id);

    @POST
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/loans/{loan_id}")
    Response postUser_idloansloan_id(@PathParam("user_id") String user_id, @PathParam("loan_id") String loan_id, @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type, @QueryParam("op") String op);

    @PUT
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/loans/{loan_id}")
    Response putUser_idloansloan_id(@PathParam("user_id") String user_id, @PathParam("loan_id") String loan_id);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/purchase-requests")
    Response getUser_idpurchaserequests(@PathParam("user_id") String user_id, @QueryParam("user_id_type") String user_id_type, @QueryParam("limit") @DefaultValue("10") Integer limit, @QueryParam("offset") @DefaultValue("0") Integer offset, 
                @QueryParam("status") String status);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/purchase-requests")
    Response postUser_idpurchaserequests(@PathParam("user_id") String user_id, @QueryParam("user_id_type") String user_id_type);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/purchase-requests/{purchase_request_id}")
    Response getUser_idpurchaserequestspurchase_request_id(@PathParam("user_id") String user_id, @PathParam("purchase_request_id") String purchase_request_id, @QueryParam("user_id_type") String user_id_type);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/requests")
    Response getUser_idrequests(@PathParam("user_id") String user_id, @QueryParam("request_type") String request_type, @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type, @QueryParam("limit") @DefaultValue("10") Integer limit, 
                @QueryParam("offset") @DefaultValue("0") String offset, @QueryParam("status") @DefaultValue("active") String status);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/requests")
    Response postUser_idrequests(@PathParam("user_id") String user_id, @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type, @QueryParam("mms_id") String mms_id, @QueryParam("item_pid") String item_pid);

    @DELETE
    @Path("/{user_id}/requests/{request_id}")
    void deleteUser_idrequestsrequest_id(@PathParam("user_id") String user_id, @PathParam("request_id") String request_id, @QueryParam("reason") String reason, @QueryParam("note") String note, 
                @QueryParam("notify_user") @DefaultValue("true") Boolean notify_user);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/requests/{request_id}")
    Response getUser_idrequestsrequest_id(@PathParam("user_id") String user_id, @PathParam("request_id") String request_id, @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type);

    @POST
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/requests/{request_id}")
    Response postUser_idrequestsrequest_id(@PathParam("user_id") String user_id, @PathParam("request_id") String request_id, @QueryParam("op") String op, @QueryParam("release_item") @DefaultValue("false") String release_item);

    @PUT
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/requests/{request_id}")
    Response putUser_idrequestsrequest_id(@PathParam("user_id") String user_id, @PathParam("request_id") String request_id);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/resource_sharing_requests")
    Response postUser_idresource_sharing_requests(@PathParam("user_id") String user_id, @QueryParam("user_id_type") String user_id_type, @QueryParam("override_blocks") String override_blocks);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/resource_sharing_requests/{request_id}")
    Response getUser_idresource_sharing_requestsrequest_id(@PathParam("user_id") String user_id, @PathParam("request_id") String request_id, @QueryParam("request_id_type") String request_id_type);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{user_id}/resource_sharing_requests/{request_id}")
    Response postUser_idresource_sharing_requestsrequest_id(@PathParam("user_id") String user_id, @PathParam("request_id") String request_id, @QueryParam("request_id_type") String request_id_type, @QueryParam("op") String op, 
                @QueryParam("shipping_cost") String shipping_cost, @QueryParam("fund_code") String fund_code);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{user_name}/leganto-notifications")
    Response getUser_namelegantonotifications(@PathParam("user_name") String user_name, @QueryParam("notificationType") String notificationType, @QueryParam("limit") @DefaultValue("10") String limit, @QueryParam("from") String from, 
                @QueryParam("to") String to);

}