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

@Path("/almaws/v1/bibs")
public interface AlmawsV1BibsResource {

    @GET
    @Produces({"application/xml", "application/json" })
    Response get(@QueryParam("mms_id") String mms_id, @QueryParam("ie_id") String ie_id, @QueryParam("holdings_id") String holdings_id, @QueryParam("representation_id") String representation_id, 
                @QueryParam("nz_mms_id") String nz_mms_id, @QueryParam("view") @DefaultValue("full") String view, @QueryParam("expand") @DefaultValue("None") String expand);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    Response post(@QueryParam("from_nz_mms_id") String from_nz_mms_id, @QueryParam("normalization") String normalization, @QueryParam("validate") @DefaultValue("false") String validate);

    @GET
    @Produces("application/xml")
    @Path("/bf/entity/instance/{mms_id}")
    String getBfentityinstancemms_id(@PathParam("mms_id") String mms_id);

    @GET
    @Produces("application/xml")
    @Path("/bf/entity/work/{frbr_id}")
    String getBfentityworkfrbr_id(@PathParam("frbr_id") String frbr_id);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/collections")
    Response getCollections(@QueryParam("level") String level, @QueryParam("q") String q);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/collections")
    Response postCollections(@QueryParam("record_format") @DefaultValue("marc21") String record_format);

    @DELETE
    @Path("/collections/{pid}")
    void deleteCollectionspid(@PathParam("pid") String pid);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/collections/{pid}")
    Response getCollectionspid(@PathParam("pid") String pid, @QueryParam("level") String level);

    @PUT
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/collections/{pid}")
    Response putCollectionspid(@PathParam("pid") String pid);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/collections/{pid}/bibs")
    Response getCollectionspidbibs(@PathParam("pid") String pid, @QueryParam("offset") @DefaultValue("0") String offset, @QueryParam("limit") @DefaultValue("10") Integer limit);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/collections/{pid}/bibs")
    Response postCollectionspidbibs(@PathParam("pid") String pid);

    @DELETE
    @Path("/collections/{pid}/bibs/{mms_id}")
    void deleteCollectionspidbibsmms_id(@PathParam("pid") String pid, @PathParam("mms_id") String mms_id);

    @GET
    @Produces("application/json")
    @Path("/linked-open-data/authority/{mms_id}")
    String getLinkedopendataauthoritymms_id(@PathParam("mms_id") String mms_id);

    @GET
    @Produces("application/json")
    @Path("/linked-open-data/{mms_id}")
    String getLinkedopendatamms_id(@PathParam("mms_id") String mms_id);

    @GET
    @Produces("application/xml")
    @Path("/rda/entity/manifestation/{mms_id}")
    String getRdaentitymanifestationmms_id(@PathParam("mms_id") String mms_id);

    @GET
    @Produces("application/xml")
    @Path("/rda/entity/work/{frbr_id}")
    String getRdaentityworkfrbr_id(@PathParam("frbr_id") String frbr_id);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/test")
    String getTest();

    @POST
    @Produces({"application/xml", "application/json" })
    @Path("/test")
    String postTest();

    @DELETE
    @Path("/{mmsId}/holdings/{holdingId}/items/{itemPid}/requests/{requestId}")
    void deleteMmsIdholdingsholdingIditemsitemPidrequestsrequestId(@PathParam("mmsId") String mmsId, @PathParam("holdingId") String holdingId, @PathParam("itemPid") String itemPid, @PathParam("requestId") String requestId, 
                @QueryParam("reason") String reason, @QueryParam("note") String note, @QueryParam("notify_user") @DefaultValue("true") Boolean notify_user);

    @DELETE
    @Path("/{mmsId}/requests/{requestId}")
    void deleteMmsIdrequestsrequestId(@PathParam("mmsId") String mmsId, @PathParam("requestId") String requestId, @QueryParam("reason") String reason, @QueryParam("note") String note, 
                @QueryParam("notify_user") @DefaultValue("true") Boolean notify_user);

    @DELETE
    @Path("/{mms_id}")
    void deleteMms_id(@PathParam("mms_id") String mms_id, @QueryParam("override") @DefaultValue("false") String override, @QueryParam("cataloger_level") String cataloger_level);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}")
    Response getMms_id(@PathParam("mms_id") String mms_id, @QueryParam("view") @DefaultValue("full") String view, @QueryParam("expand") @DefaultValue("None") String expand);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}")
    Response postMms_id(@PathParam("mms_id") String mms_id, @QueryParam("op") String op);

    @PUT
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}")
    Response putMms_id(@PathParam("mms_id") String mms_id, @QueryParam("normalization") String normalization, @QueryParam("validate") @DefaultValue("false") String validate, @QueryParam("stale_version_check") @DefaultValue("false") String stale_version_check, 
                @QueryParam("cataloger_level") String cataloger_level);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/booking-availability")
    Response getMms_idbookingavailability(@PathParam("mms_id") String mms_id, @QueryParam("period") Integer period, @QueryParam("period_type") String period_type, @QueryParam("user_id") String user_id, 
                @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/e-collections")
    Response getMms_idecollections(@PathParam("mms_id") String mms_id, @QueryParam("limit") @DefaultValue("10") Integer limit, @QueryParam("offset") @DefaultValue("0") Integer offset);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/e-collections/{collection_id}")
    Response getMms_idecollectionscollection_id(@PathParam("mms_id") String mms_id, @PathParam("collection_id") String collection_id);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/holdings")
    Response getMms_idholdings(@PathParam("mms_id") String mms_id);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/holdings")
    Response postMms_idholdings(@PathParam("mms_id") String mms_id);

    @DELETE
    @Path("/{mms_id}/holdings/{holding_id}")
    void deleteMms_idholdingsholding_id(@PathParam("mms_id") String mms_id, @PathParam("holding_id") String holding_id, @QueryParam("bib") @DefaultValue("retain") String bib);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/holdings/{holding_id}")
    Response getMms_idholdingsholding_id(@PathParam("mms_id") String mms_id, @PathParam("holding_id") String holding_id);

    @PUT
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/holdings/{holding_id}")
    Response putMms_idholdingsholding_id(@PathParam("mms_id") String mms_id, @PathParam("holding_id") String holding_id);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/holdings/{holding_id}/items")
    Response getMms_idholdingsholding_iditems(@PathParam("mms_id") String mms_id, @PathParam("holding_id") String holding_id, @QueryParam("limit") @DefaultValue("10") Integer limit, @QueryParam("offset") @DefaultValue("0") Integer offset, 
                @QueryParam("expand") String expand, @QueryParam("user_id") String user_id, @QueryParam("current_library") String current_library, @QueryParam("current_location") String current_location, 
                @QueryParam("q") String q, @QueryParam("order_by") @DefaultValue("none") String order_by, @QueryParam("direction") @DefaultValue("desc") String direction);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/holdings/{holding_id}/items")
    Response postMms_idholdingsholding_iditems(@PathParam("mms_id") String mms_id, @PathParam("holding_id") String holding_id);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/holdings/{holding_id}/items/{item_id}/loans")
    Response getMms_idholdingsholding_iditemsitem_idloans(@PathParam("mms_id") String mms_id, @PathParam("holding_id") String holding_id, @PathParam("item_id") String item_id);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/holdings/{holding_id}/items/{item_id}/requests")
    Response getMms_idholdingsholding_iditemsitem_idrequests(@PathParam("mms_id") String mms_id, @PathParam("holding_id") String holding_id, @PathParam("item_id") String item_id, @QueryParam("request_type") @DefaultValue("all_types") String request_type, 
                @QueryParam("status") @DefaultValue("active") String status);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/holdings/{holding_id}/items/{item_id}/requests/{request_id}")
    Response getMms_idholdingsholding_iditemsitem_idrequestsrequest_id(@PathParam("mms_id") String mms_id, @PathParam("holding_id") String holding_id, @PathParam("item_id") String item_id, @PathParam("request_id") String request_id);

    @DELETE
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/holdings/{holding_id}/items/{item_pid}")
    String deleteMms_idholdingsholding_iditemsitem_pid(@PathParam("mms_id") String mms_id, @PathParam("holding_id") String holding_id, @PathParam("item_pid") String item_pid, @QueryParam("override") @DefaultValue("false") String override, 
                @QueryParam("holdings") @DefaultValue("retain") String holdings);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/holdings/{holding_id}/items/{item_pid}")
    Response getMms_idholdingsholding_iditemsitem_pid(@PathParam("mms_id") String mms_id, @PathParam("holding_id") String holding_id, @PathParam("item_pid") String item_pid, @QueryParam("view") @DefaultValue("brief") String view, 
                @QueryParam("expand") String expand, @QueryParam("user_id") String user_id);

    @POST
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/holdings/{holding_id}/items/{item_pid}")
    Response postMms_idholdingsholding_iditemsitem_pid(@PathParam("mms_id") String mms_id, @PathParam("holding_id") String holding_id, @PathParam("item_pid") String item_pid, @QueryParam("op") String op, 
                @QueryParam("external_id") @DefaultValue("false") String external_id, @QueryParam("request_id") String request_id, @QueryParam("library") String library, @QueryParam("circ_desk") String circ_desk, 
                @QueryParam("department") String department, @QueryParam("work_order_type") String work_order_type, @QueryParam("status") String status, @QueryParam("done") @DefaultValue("false") String done, 
                @QueryParam("auto_print_slip") @DefaultValue("false") String auto_print_slip, @QueryParam("place_on_hold_shelf") @DefaultValue("false") String place_on_hold_shelf, @QueryParam("confirm") @DefaultValue("false") String confirm, @QueryParam("register_in_house_use") @DefaultValue("true") String register_in_house_use);

    @PUT
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/holdings/{holding_id}/items/{item_pid}")
    Response putMms_idholdingsholding_iditemsitem_pid(@PathParam("mms_id") String mms_id, @PathParam("holding_id") String holding_id, @PathParam("item_pid") String item_pid);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/holdings/{holding_id}/items/{item_pid}/booking-availability")
    Response getMms_idholdingsholding_iditemsitem_pidbookingavailability(@PathParam("mms_id") String mms_id, @PathParam("holding_id") String holding_id, @PathParam("item_pid") String item_pid, @QueryParam("period") Integer period, 
                @QueryParam("period_type") String period_type, @QueryParam("user_id") String user_id, @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/holdings/{holding_id}/items/{item_pid}/loans")
    Response postMms_idholdingsholding_iditemsitem_pidloans(@PathParam("mms_id") String mms_id, @PathParam("holding_id") String holding_id, @PathParam("item_pid") String item_pid, @QueryParam("user_id") String user_id, 
                @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/holdings/{holding_id}/items/{item_pid}/loans/{loan_id}")
    Response getMms_idholdingsholding_iditemsitem_pidloansloan_id(@PathParam("mms_id") String mms_id, @PathParam("holding_id") String holding_id, @PathParam("item_pid") String item_pid, @PathParam("loan_id") String loan_id);

    @POST
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/holdings/{holding_id}/items/{item_pid}/loans/{loan_id}")
    Response postMms_idholdingsholding_iditemsitem_pidloansloan_id(@PathParam("mms_id") String mms_id, @PathParam("holding_id") String holding_id, @PathParam("item_pid") String item_pid, @PathParam("loan_id") String loan_id, 
                @QueryParam("op") String op);

    @PUT
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/holdings/{holding_id}/items/{item_pid}/loans/{loan_id}")
    Response putMms_idholdingsholding_iditemsitem_pidloansloan_id(@PathParam("mms_id") String mms_id, @PathParam("holding_id") String holding_id, @PathParam("item_pid") String item_pid, @PathParam("loan_id") String loan_id);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/holdings/{holding_id}/items/{item_pid}/request-options")
    Response getMms_idholdingsholding_iditemsitem_pidrequestoptions(@PathParam("mms_id") String mms_id, @PathParam("holding_id") String holding_id, @PathParam("item_pid") String item_pid, @QueryParam("user_id") @DefaultValue("GUEST") String user_id);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/holdings/{holding_id}/items/{item_pid}/requests")
    Response postMms_idholdingsholding_iditemsitem_pidrequests(@PathParam("mms_id") String mms_id, @PathParam("holding_id") String holding_id, @PathParam("item_pid") String item_pid, @QueryParam("user_id") String user_id, 
                @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type);

    @POST
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/holdings/{holding_id}/items/{item_pid}/requests/{request_id}")
    Response postMms_idholdingsholding_iditemsitem_pidrequestsrequest_id(@PathParam("mms_id") String mms_id, @PathParam("holding_id") String holding_id, @PathParam("item_pid") String item_pid, @PathParam("request_id") String request_id, 
                @QueryParam("op") String op, @QueryParam("release_item") @DefaultValue("false") String release_item);

    @PUT
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/holdings/{holding_id}/items/{item_pid}/requests/{request_id}")
    Response putMms_idholdingsholding_iditemsitem_pidrequestsrequest_id(@PathParam("mms_id") String mms_id, @PathParam("holding_id") String holding_id, @PathParam("item_pid") String item_pid, @PathParam("request_id") String request_id);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/loans")
    Response getMms_idloans(@PathParam("mms_id") String mms_id);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/loans/{loan_id}")
    Response getMms_idloansloan_id(@PathParam("mmsId") String mmsId, @PathParam("loan_id") String loan_id);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/portfolios")
    Response getMms_idportfolios(@PathParam("mms_id") String mms_id, @QueryParam("limit") @DefaultValue("10") Integer limit, @QueryParam("offset") @DefaultValue("0") Integer offset);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/portfolios/")
    Response postMms_idportfolios(@PathParam("mms_id") String mms_id);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/portfolios/{portfolio_id}")
    Response getMms_idportfoliosportfolio_id(@PathParam("mms_id") String mms_id, @PathParam("portfolio_id") String portfolio_id);

    @PUT
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/portfolios/{portfolio_id}")
    Response putMms_idportfoliosportfolio_id(@PathParam("mms_id") String mms_id, @PathParam("portfolio_id") String portfolio_id);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/reminders")
    Response getMms_idreminders(@PathParam("mms_id") String mms_id, @QueryParam("type") String type, @QueryParam("status") String status, @QueryParam("from") String from, 
                @QueryParam("to") String to, @QueryParam("order_by") @DefaultValue("type") String order_by, @QueryParam("direction") @DefaultValue("asc") String direction, @QueryParam("limit") @DefaultValue("10") Integer limit, 
                @QueryParam("offset") @DefaultValue("0") Integer offset);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/reminders")
    Response postMms_idreminders(@PathParam("mms_id") String mms_id);

    @DELETE
    @Path("/{mms_id}/reminders/{reminder_id}")
    void deleteMms_idremindersreminder_id(@PathParam("mms_id") String mms_id, @PathParam("reminder_id") String reminder_id);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/reminders/{reminder_id}")
    Response getMms_idremindersreminder_id(@PathParam("mms_id") String mms_id, @PathParam("reminder_id") String reminder_id);

    @PUT
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/reminders/{reminder_id}")
    Response putMms_idremindersreminder_id(@PathParam("mms_id") String mms_id, @PathParam("reminder_id") String reminder_id);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/representations")
    Response getMms_idrepresentations(@PathParam("mms_id") String mms_id, @QueryParam("limit") @DefaultValue("10") Integer limit, @QueryParam("offset") @DefaultValue("0") Integer offset);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/representations")
    Response postMms_idrepresentations(@PathParam("mms_id") String mms_id, @QueryParam("generate_label") @DefaultValue("false") String generate_label);

    @DELETE
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/representations/{rep_id}")
    Response deleteMms_idrepresentationsrep_id(@PathParam("mms_id") String mms_id, @PathParam("rep_id") String rep_id, @QueryParam("override") @DefaultValue("false") String override, @QueryParam("bibs") @DefaultValue("retain") String bibs);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/representations/{rep_id}")
    Response getMms_idrepresentationsrep_id(@PathParam("mms_id") String mms_id, @PathParam("rep_id") String rep_id);

    @PUT
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/representations/{rep_id}")
    Response putMms_idrepresentationsrep_id(@PathParam("mms_id") String mms_id, @PathParam("rep_id") String rep_id, @QueryParam("generate_label") @DefaultValue("false") String generate_label);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/representations/{rep_id}/files")
    Response getMms_idrepresentationsrep_idfiles(@PathParam("mms_id") String mms_id, @PathParam("rep_id") String rep_id, @QueryParam("expand") String expand);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/representations/{rep_id}/files")
    Response postMms_idrepresentationsrep_idfiles(@PathParam("mms_id") String mms_id, @PathParam("rep_id") String rep_id);

    @DELETE
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/representations/{rep_id}/files/{file_id}")
    Response deleteMms_idrepresentationsrep_idfilesfile_id(@PathParam("mms_id") String mms_id, @PathParam("rep_id") String rep_id, @PathParam("file_id") String file_id, @QueryParam("representations") @DefaultValue("retain") String representations, 
                @QueryParam("bibs") @DefaultValue("retain") String bibs);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/representations/{rep_id}/files/{file_id}")
    Response getMms_idrepresentationsrep_idfilesfile_id(@PathParam("mms_id") String mms_id, @PathParam("rep_id") String rep_id, @PathParam("file_id") String file_id, @QueryParam("expand") String expand);

    @PUT
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/representations/{rep_id}/files/{file_id}")
    Response putMms_idrepresentationsrep_idfilesfile_id(@PathParam("mms_id") String mms_id, @PathParam("rep_id") String rep_id, @PathParam("file_id") String file_id);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/request-options")
    Response getMms_idrequestoptions(@PathParam("mms_id") String mms_id, @QueryParam("user_id") @DefaultValue("GUEST") String user_id);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/requests")
    Response getMms_idrequests(@PathParam("mms_id") String mms_id, @QueryParam("request_type") @DefaultValue("all_types") String request_type, @QueryParam("status") @DefaultValue("active") String status);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/requests")
    Response postMms_idrequests(@PathParam("mms_id") String mms_id, @QueryParam("user_id") String user_id, @QueryParam("user_id_type") @DefaultValue("all_unique") String user_id_type);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/requests/{request_id}")
    Response getMms_idrequestsrequest_id(@PathParam("mms_id") String mms_id, @PathParam("request_id") String request_id);

    @POST
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/requests/{request_id}")
    Response postMms_idrequestsrequest_id(@PathParam("mms_id") String mms_id, @PathParam("request_id") String request_id, @QueryParam("op") String op, @QueryParam("release_item") @DefaultValue("false") String release_item);

    @PUT
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/{mms_id}/requests/{request_id}")
    Response putMms_idrequestsrequest_id(@PathParam("mms_id") String mms_id, @PathParam("request_id") String request_id);

}