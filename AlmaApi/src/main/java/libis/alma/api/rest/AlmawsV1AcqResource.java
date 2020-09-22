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

import libis.invoice.pkg.Invoice;
import libis.invoice.pkg.InvoiceLine;

@Path("/almaws/v1/acq")
public interface AlmawsV1AcqResource {

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/funds")
    Response getFunds(@QueryParam("limit") @DefaultValue("10") Integer limit, @QueryParam("offset") @DefaultValue("0") Integer offset, @QueryParam("q") String q, @QueryParam("library") String library, 
                @QueryParam("view") @DefaultValue("full") String view);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/funds/{fund_id}")
    Response getFundsfund_id(@PathParam("fund_id") String fund_id, @QueryParam("view") @DefaultValue("full") String view);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/invoices")
    Response postInvoices(Invoice inv);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/invoices/")
    Response getInvoices(@QueryParam("q") @DefaultValue("all") String q, @QueryParam("limit") @DefaultValue("10") Integer limit, @QueryParam("offset") @DefaultValue("0") Integer offset, @QueryParam("view") String view, 
                @QueryParam("base_status") String base_status, @QueryParam("invoice_workflow_status") String invoice_workflow_status, @QueryParam("owner") String owner, @QueryParam("creation_form") String creation_form);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/invoices/{invoice_id}")
    Response getInvoicesinvoice_id(@PathParam("invoice_id") String invoice_id, @QueryParam("view") String view);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/invoices/{invoice_id}")
    Response postInvoicesinvoice_id(Invoice inv, @PathParam("invoice_id") String invoice_id, @QueryParam("op") String op);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/invoices/{invoice_id}/lines")
    Response getInvoicesinvoice_idlines(@PathParam("invoice_id") String invoice_id, @QueryParam("q") String q, @QueryParam("limit") @DefaultValue("10") Integer limit, @QueryParam("offset") @DefaultValue("0") Integer offset);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/invoices/{invoice_id}/lines")
    Response postInvoicesinvoice_idlines(@PathParam("invoice_id") String invoice_id, InvoiceLine invLine);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/invoices/{invoice_id}/lines/{invoice_line_id}")
    Response getInvoicesinvoice_idlinesinvoice_line_id(@PathParam("invoice_id") String invoice_id, @PathParam("invoice_line_id") String invoice_line_id);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/licenses")
    Response postLicenses();

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/licenses/")
    Response getLicenses(@QueryParam("q") @DefaultValue("all") String q, @QueryParam("status") @DefaultValue("ALL") String status, @QueryParam("review_status") @DefaultValue("ALL") String review_status, @QueryParam("limit") @DefaultValue("10") Integer limit, 
                @QueryParam("offset") @DefaultValue("0") Integer offset);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/licenses/{license_code}")
    Response getLicenseslicense_code(@PathParam("license_code") String license_code);

    @DELETE
    @Path("/licenses/{license_code}")
    void deleteLicenseslicense_code(@PathParam("license_code") String license_code);

    @PUT
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/licenses/{license_code}")
    Response putLicenseslicense_code(@PathParam("license_code") String license_code);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/licenses/{license_code}/amendments")
    Response getLicenseslicense_codeamendments(@PathParam("license_code") String license_code);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/licenses/{license_code}/amendments")
    Response postLicenseslicense_codeamendments(@PathParam("license_code") String license_code);

    @DELETE
    @Path("/licenses/{license_code}/amendments/{amendment_code}")
    void deleteLicenseslicense_codeamendmentsamendment_code(@PathParam("license_code") String license_code, @PathParam("amendment_code") String amendment_code);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/licenses/{license_code}/amendments/{amendment_code}")
    Response getLicenseslicense_codeamendmentsamendment_code(@PathParam("license_code") String license_code, @PathParam("amendment_code") String amendment_code);

    @PUT
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/licenses/{license_code}/amendments/{amendment_code}")
    Response putLicenseslicense_codeamendmentsamendment_code(@PathParam("license_code") String license_code, @PathParam("amendment_code") String amendment_code);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/po-lines")
    Response getPolines(@QueryParam("q") String q, @QueryParam("status") @DefaultValue("ALL") String status, @QueryParam("limit") @DefaultValue("10") Integer limit, @QueryParam("offset") @DefaultValue("0") Integer offset, 
                @QueryParam("order_by") @DefaultValue("title") String order_by, @QueryParam("direction") @DefaultValue("desc") String direction, @QueryParam("acquisition_method") @DefaultValue("ALL") String acquisition_method, @QueryParam("expand") String expand, 
                @QueryParam("library") String library, @QueryParam("min_expected_arrival_date") String min_expected_arrival_date, @QueryParam("max_expected_arrival_date") String max_expected_arrival_date);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/po-lines")
    Response postPolines();

    @DELETE
    @Path("/po-lines/{po_line_id}")
    void deletePolinespo_line_id(@PathParam("po_line_id") String po_line_id, @QueryParam("reason") String reason, @QueryParam("comment") String comment, @QueryParam("inform_vendor") @DefaultValue("false") Boolean inform_vendor, 
                @QueryParam("override") @DefaultValue("false") Boolean override, @QueryParam("bib") @DefaultValue("retain") String bib);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/po-lines/{po_line_id}")
    Response getPolinespo_line_id(@PathParam("po_line_id") String po_line_id);

    @PUT
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/po-lines/{po_line_id}")
    Response putPolinespo_line_id(@PathParam("po_line_id") String po_line_id);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/po-lines/{po_line_id}/items")
    Response getPolinespo_line_iditems(@PathParam("po_line_id") String po_line_id);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/po-lines/{po_line_id}/items")
    Response postPolinespo_line_iditems(@PathParam("po_line_id") String po_line_id, @QueryParam("receive_date") String receive_date, @QueryParam("department") String department, @QueryParam("department_library") String department_library);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/po-lines/{po_line_id}/items/{item_id}")
    Response postPolinespo_line_iditemsitem_id(@PathParam("po_line_id") String po_line_id, @PathParam("item_id") String item_id, @QueryParam("op") String op, @QueryParam("receive_date") String receive_date, 
                @QueryParam("department") String department, @QueryParam("department_library") String department_library);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/test")
    String getTest();

    @POST
    @Produces({"application/xml", "application/json" })
    @Path("/test")
    String postTest();

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/vendors")
    Response getVendors(@QueryParam("status") @DefaultValue("ALL") String status, @QueryParam("type") @DefaultValue("ALL") String type, @QueryParam("q") String q, @QueryParam("limit") @DefaultValue("10") Integer limit, 
                @QueryParam("offset") @DefaultValue("0") Integer offset);

    @POST
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/vendors")
    Response postVendors();

    @DELETE
    @Produces({"application/xml", "application/json" })
    @Path("/vendors/{vendorCode}")
    String deleteVendorsvendorCode(@PathParam("vendorCode") String vendorCode);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/vendors/{vendorCode}")
    Response getVendorsvendorCode(@PathParam("vendorCode") String vendorCode);

    @PUT
    @Consumes({"application/xml", "application/json" })
    @Produces({"application/xml", "application/json" })
    @Path("/vendors/{vendorCode}")
    Response putVendorsvendorCode(@PathParam("vendorCode") String vendorCode);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/vendors/{vendorCode}/invoices")
    Response getVendorsvendorCodeinvoices(@PathParam("vendorCode") String vendorCode, @QueryParam("limit") @DefaultValue("10") Integer limit, @QueryParam("offset") @DefaultValue("0") Integer offset);

    @GET
    @Produces({"application/xml", "application/json" })
    @Path("/vendors/{vendorCode}/po-lines")
    Response getVendorsvendorCodepolines(@PathParam("vendorCode") String vendorCode, @QueryParam("limit") @DefaultValue("10") Integer limit, @QueryParam("offset") @DefaultValue("0") Integer offset);

}