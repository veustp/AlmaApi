/**
 * Created by Apache CXF WadlToJava code generator
**/
package libis.alma.api.rest;

import javax.ws.rs.core.Response;

import libis.invoice.pkg.Invoice;
import libis.invoice.pkg.InvoiceLine;

public class AlmawsV1AcqResourceImpl implements AlmawsV1AcqResource {


    public Response getFunds(Integer limit, Integer offset, String q, String library, 
                String view) {
        //TODO: implement
        return null;
    }


    public Response getFundsfund_id(String fund_id, String view) {
        //TODO: implement
        return null;
    }


    public Response postInvoices(Invoice inv) {
        //TODO: implement
        return null;
    }


    public Response getInvoices(String q, Integer limit, Integer offset, String view, 
                String base_status, String invoice_workflow_status, String owner, String creation_form) {
        //TODO: implement
        return null;
    }


    public Response getInvoicesinvoice_id(String apikey, String invoice_id, String view) {
        //TODO: implement
        return null;
    }


    public Response postInvoicesinvoice_id(String invoice_id, String op) {
        //TODO: implement
        return null;
    }


    public Response getInvoicesinvoice_idlines(String invoice_id, String q, Integer limit, Integer offset) {
        //TODO: implement
        return null;
    }


    public Response postInvoicesinvoice_idlines(String invoice_id) {
        //TODO: implement
        return null;
    }


    public Response getInvoicesinvoice_idlinesinvoice_line_id(String invoice_id, String invoice_line_id) {
        //TODO: implement
        return null;
    }


    public Response postLicenses() {
        //TODO: implement
        return null;
    }


    public Response getLicenses(String q, String status, String review_status, Integer limit, 
                Integer offset) {
        //TODO: implement
        return null;
    }


    public Response getLicenseslicense_code(String license_code) {
        //TODO: implement
        return null;
    }


    public void deleteLicenseslicense_code(String license_code) {
        //TODO: implement
    }


    public Response putLicenseslicense_code(String license_code) {
        //TODO: implement
        return null;
    }


    public Response getLicenseslicense_codeamendments(String license_code) {
        //TODO: implement
        return null;
    }


    public Response postLicenseslicense_codeamendments(String license_code) {
        //TODO: implement
        return null;
    }


    public void deleteLicenseslicense_codeamendmentsamendment_code(String license_code, String amendment_code) {
        //TODO: implement
    }


    public Response getLicenseslicense_codeamendmentsamendment_code(String license_code, String amendment_code) {
        //TODO: implement
        return null;
    }


    public Response putLicenseslicense_codeamendmentsamendment_code(String license_code, String amendment_code) {
        //TODO: implement
        return null;
    }


    public Response getPolines(String q, String status, Integer limit, Integer offset, 
                String order_by, String direction, String acquisition_method, String expand, 
                String library, String min_expected_arrival_date, String max_expected_arrival_date) {
        //TODO: implement
        return null;
    }


    public Response postPolines() {
        //TODO: implement
        return null;
    }


    public void deletePolinespo_line_id(String po_line_id, String reason, String comment, Boolean inform_vendor, 
                Boolean override, String bib) {
        //TODO: implement
    }


    public Response getPolinespo_line_id(String po_line_id) {
        //TODO: implement
        return null;
    }


    public Response putPolinespo_line_id(String po_line_id) {
        //TODO: implement
        return null;
    }


    public Response getPolinespo_line_iditems(String po_line_id) {
        //TODO: implement
        return null;
    }


    public Response postPolinespo_line_iditems(String po_line_id, String receive_date, String department, String department_library) {
        //TODO: implement
        return null;
    }


    public Response postPolinespo_line_iditemsitem_id(String po_line_id, String item_id, String op, String receive_date, 
                String department, String department_library) {
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


    public Response getVendors(String status, String type, String q, Integer limit, 
                Integer offset) {
        //TODO: implement
        return null;
    }


    public Response postVendors() {
        //TODO: implement
        return null;
    }


    public String deleteVendorsvendorCode(String vendorCode) {
        //TODO: implement
        return null;
    }


    public Response getVendorsvendorCode(String vendorCode) {
        //TODO: implement
        return null;
    }


    public Response putVendorsvendorCode(String vendorCode) {
        //TODO: implement
        return null;
    }


    public Response getVendorsvendorCodeinvoices(String vendorCode, Integer limit, Integer offset) {
        //TODO: implement
        return null;
    }


    public Response getVendorsvendorCodepolines(String vendorCode, Integer limit, Integer offset) {
        //TODO: implement
        return null;
    }


	@Override
	public Response getInvoicesinvoice_id(String invoice_id, String view) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Response postInvoicesinvoice_idlines(String invoice_id, InvoiceLine invLine) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Response postInvoicesinvoice_id(Invoice inv, String invoice_id, String op) {
		// TODO Auto-generated method stub
		return null;
	}

}