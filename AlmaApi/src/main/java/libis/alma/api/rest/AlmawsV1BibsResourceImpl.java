/**
 * Created by Apache CXF WadlToJava code generator
**/
package libis.alma.api.rest;

import javax.ws.rs.core.Response;

public class AlmawsV1BibsResourceImpl implements AlmawsV1BibsResource {


    public Response get(String mms_id, String ie_id, String holdings_id, String representation_id, 
                String nz_mms_id, String view, String expand) {
        //TODO: implement
        return null;
    }


    public Response post(String from_nz_mms_id, String normalization, String validate) {
        //TODO: implement
        return null;
    }


    public String getBfentityinstancemms_id(String mms_id) {
        //TODO: implement
        return null;
    }


    public String getBfentityworkfrbr_id(String frbr_id) {
        //TODO: implement
        return null;
    }


    public Response getCollections(String level, String q) {
        //TODO: implement
        return null;
    }


    public Response postCollections(String record_format) {
        //TODO: implement
        return null;
    }


    public void deleteCollectionspid(String pid) {
        //TODO: implement
    }


    public Response getCollectionspid(String pid, String level) {
        //TODO: implement
        return null;
    }


    public Response putCollectionspid(String pid) {
        //TODO: implement
        return null;
    }


    public Response getCollectionspidbibs(String pid, String offset, Integer limit) {
        //TODO: implement
        return null;
    }


    public Response postCollectionspidbibs(String pid) {
        //TODO: implement
        return null;
    }


    public void deleteCollectionspidbibsmms_id(String pid, String mms_id) {
        //TODO: implement
    }


    public String getLinkedopendataauthoritymms_id(String mms_id) {
        //TODO: implement
        return null;
    }


    public String getLinkedopendatamms_id(String mms_id) {
        //TODO: implement
        return null;
    }


    public String getRdaentitymanifestationmms_id(String mms_id) {
        //TODO: implement
        return null;
    }


    public String getRdaentityworkfrbr_id(String frbr_id) {
        //TODO: implement
        return null;
    }


    public String getTest() {
        //TODO: implement
        return null;
    }


    public String postTest() {
        //TODO: implement
        return null;
    }


    public void deleteMmsIdholdingsholdingIditemsitemPidrequestsrequestId(String mmsId, String holdingId, String itemPid, String requestId, 
                String reason, String note, Boolean notify_user) {
        //TODO: implement
    }


    public void deleteMmsIdrequestsrequestId(String mmsId, String requestId, String reason, String note, 
                Boolean notify_user) {
        //TODO: implement
    }


    public void deleteMms_id(String mms_id, String override, String cataloger_level) {
        //TODO: implement
    }


    public Response getMms_id(String mms_id, String view, String expand) {
        //TODO: implement
        return null;
    }


    public Response postMms_id(String mms_id, String op) {
        //TODO: implement
        return null;
    }


    public Response putMms_id(String mms_id, String normalization, String validate, String stale_version_check, 
                String cataloger_level) {
        //TODO: implement
        return null;
    }


    public Response getMms_idbookingavailability(String mms_id, Integer period, String period_type, String user_id, 
                String user_id_type) {
        //TODO: implement
        return null;
    }


    public Response getMms_idecollections(String mms_id, Integer limit, Integer offset) {
        //TODO: implement
        return null;
    }


    public Response getMms_idecollectionscollection_id(String mms_id, String collection_id) {
        //TODO: implement
        return null;
    }


    public Response getMms_idholdings(String mms_id) {
        //TODO: implement
        return null;
    }


    public Response postMms_idholdings(String mms_id) {
        //TODO: implement
        return null;
    }


    public void deleteMms_idholdingsholding_id(String mms_id, String holding_id, String bib) {
        //TODO: implement
    }


    public Response getMms_idholdingsholding_id(String mms_id, String holding_id) {
        //TODO: implement
        return null;
    }


    public Response putMms_idholdingsholding_id(String mms_id, String holding_id) {
        //TODO: implement
        return null;
    }


    public Response getMms_idholdingsholding_iditems(String mms_id, String holding_id, Integer limit, Integer offset, 
                String expand, String user_id, String current_library, String current_location, 
                String q, String order_by, String direction) {
        //TODO: implement
        return null;
    }


    public Response postMms_idholdingsholding_iditems(String mms_id, String holding_id) {
        //TODO: implement
        return null;
    }


    public Response getMms_idholdingsholding_iditemsitem_idloans(String mms_id, String holding_id, String item_id) {
        //TODO: implement
        return null;
    }


    public Response getMms_idholdingsholding_iditemsitem_idrequests(String mms_id, String holding_id, String item_id, String request_type, 
                String status) {
        //TODO: implement
        return null;
    }


    public Response getMms_idholdingsholding_iditemsitem_idrequestsrequest_id(String mms_id, String holding_id, String item_id, String request_id) {
        //TODO: implement
        return null;
    }


    public String deleteMms_idholdingsholding_iditemsitem_pid(String mms_id, String holding_id, String item_pid, String override, 
                String holdings) {
        //TODO: implement
        return null;
    }


    public Response getMms_idholdingsholding_iditemsitem_pid(String mms_id, String holding_id, String item_pid, String view, 
                String expand, String user_id) {
        //TODO: implement
        return null;
    }


    public Response postMms_idholdingsholding_iditemsitem_pid(String mms_id, String holding_id, String item_pid, String op, 
                String external_id, String request_id, String library, String circ_desk, 
                String department, String work_order_type, String status, String done, 
                String auto_print_slip, String place_on_hold_shelf, String confirm, String register_in_house_use) {
        //TODO: implement
        return null;
    }


    public Response putMms_idholdingsholding_iditemsitem_pid(String mms_id, String holding_id, String item_pid) {
        //TODO: implement
        return null;
    }


    public Response getMms_idholdingsholding_iditemsitem_pidbookingavailability(String mms_id, String holding_id, String item_pid, Integer period, 
                String period_type, String user_id, String user_id_type) {
        //TODO: implement
        return null;
    }


    public Response postMms_idholdingsholding_iditemsitem_pidloans(String mms_id, String holding_id, String item_pid, String user_id, 
                String user_id_type) {
        //TODO: implement
        return null;
    }


    public Response getMms_idholdingsholding_iditemsitem_pidloansloan_id(String mms_id, String holding_id, String item_pid, String loan_id) {
        //TODO: implement
        return null;
    }


    public Response postMms_idholdingsholding_iditemsitem_pidloansloan_id(String mms_id, String holding_id, String item_pid, String loan_id, 
                String op) {
        //TODO: implement
        return null;
    }


    public Response putMms_idholdingsholding_iditemsitem_pidloansloan_id(String mms_id, String holding_id, String item_pid, String loan_id) {
        //TODO: implement
        return null;
    }


    public Response getMms_idholdingsholding_iditemsitem_pidrequestoptions(String mms_id, String holding_id, String item_pid, String user_id) {
        //TODO: implement
        return null;
    }


    public Response postMms_idholdingsholding_iditemsitem_pidrequests(String mms_id, String holding_id, String item_pid, String user_id, 
                String user_id_type) {
        //TODO: implement
        return null;
    }


    public Response postMms_idholdingsholding_iditemsitem_pidrequestsrequest_id(String mms_id, String holding_id, String item_pid, String request_id, 
                String op, String release_item) {
        //TODO: implement
        return null;
    }


    public Response putMms_idholdingsholding_iditemsitem_pidrequestsrequest_id(String mms_id, String holding_id, String item_pid, String request_id) {
        //TODO: implement
        return null;
    }


    public Response getMms_idloans(String mms_id) {
        //TODO: implement
        return null;
    }


    public Response getMms_idloansloan_id(String mmsId, String loan_id) {
        //TODO: implement
        return null;
    }


    public Response getMms_idportfolios(String mms_id, Integer limit, Integer offset) {
        //TODO: implement
        return null;
    }


    public Response postMms_idportfolios(String mms_id) {
        //TODO: implement
        return null;
    }


    public Response getMms_idportfoliosportfolio_id(String mms_id, String portfolio_id) {
        //TODO: implement
        return null;
    }


    public Response putMms_idportfoliosportfolio_id(String mms_id, String portfolio_id) {
        //TODO: implement
        return null;
    }


    public Response getMms_idreminders(String mms_id, String type, String status, String from, 
                String to, String order_by, String direction, Integer limit, 
                Integer offset) {
        //TODO: implement
        return null;
    }


    public Response postMms_idreminders(String mms_id) {
        //TODO: implement
        return null;
    }


    public void deleteMms_idremindersreminder_id(String mms_id, String reminder_id) {
        //TODO: implement
    }


    public Response getMms_idremindersreminder_id(String mms_id, String reminder_id) {
        //TODO: implement
        return null;
    }


    public Response putMms_idremindersreminder_id(String mms_id, String reminder_id) {
        //TODO: implement
        return null;
    }


    public Response getMms_idrepresentations(String mms_id, Integer limit, Integer offset) {
        //TODO: implement
        return null;
    }


    public Response postMms_idrepresentations(String mms_id, String generate_label) {
        //TODO: implement
        return null;
    }


    public Response deleteMms_idrepresentationsrep_id(String mms_id, String rep_id, String override, String bibs) {
        //TODO: implement
        return null;
    }


    public Response getMms_idrepresentationsrep_id(String mms_id, String rep_id) {
        //TODO: implement
        return null;
    }


    public Response putMms_idrepresentationsrep_id(String mms_id, String rep_id, String generate_label) {
        //TODO: implement
        return null;
    }


    public Response getMms_idrepresentationsrep_idfiles(String mms_id, String rep_id, String expand) {
        //TODO: implement
        return null;
    }


    public Response postMms_idrepresentationsrep_idfiles(String mms_id, String rep_id) {
        //TODO: implement
        return null;
    }


    public Response deleteMms_idrepresentationsrep_idfilesfile_id(String mms_id, String rep_id, String file_id, String representations, 
                String bibs) {
        //TODO: implement
        return null;
    }


    public Response getMms_idrepresentationsrep_idfilesfile_id(String mms_id, String rep_id, String file_id, String expand) {
        //TODO: implement
        return null;
    }


    public Response putMms_idrepresentationsrep_idfilesfile_id(String mms_id, String rep_id, String file_id) {
        //TODO: implement
        return null;
    }


    public Response getMms_idrequestoptions(String mms_id, String user_id) {
        //TODO: implement
        return null;
    }


    public Response getMms_idrequests(String mms_id, String request_type, String status) {
        //TODO: implement
        return null;
    }


    public Response postMms_idrequests(String mms_id, String user_id, String user_id_type) {
        //TODO: implement
        return null;
    }


    public Response getMms_idrequestsrequest_id(String mms_id, String request_id) {
        //TODO: implement
        return null;
    }


    public Response postMms_idrequestsrequest_id(String mms_id, String request_id, String op, String release_item) {
        //TODO: implement
        return null;
    }


    public Response putMms_idrequestsrequest_id(String mms_id, String request_id) {
        //TODO: implement
        return null;
    }

}