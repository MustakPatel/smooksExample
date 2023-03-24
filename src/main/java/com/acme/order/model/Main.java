package com.acme.order.model;



import java.io.*;
import java.util.List;

import com.acme.order.itrade.ChelanOrderParty;
import com.acme.order.itrade.FobPaymentMethod;
import com.acme.order.itrade.OrderPurpose;
import com.acme.order.itrade.OrderRole;
import org.milyn.Smooks;
import org.milyn.container.ExecutionContext;
import org.milyn.event.report.HtmlReportGenerator;
import org.milyn.io.FileUtils;
import org.milyn.payload.JavaResult;
import org.milyn.payload.JavaSource;
import org.xml.sax.SAXException;

public class Main {
    public static void main(String[] args) throws IOException, SAXException {
        String ediMessage = new String(FileUtils.readFile(new File("input-message.edi")));
        StringReader ediStream = new StringReader(ediMessage);

        PurchaseOrderFactory purchaseOrderFactory = PurchaseOrderFactory.getInstance();

        // Bind the EDI message stream data into the EJC generated Order model...
        PurchaseOrder purchaseOrder = purchaseOrderFactory.fromEDI(ediStream);
        System.out.println();
        System.out.println("======================Input EDI Message=====================");
        System.out.println(ediMessage);
        System.out.println("============================================================");

        System.out.println();
        System.out.println("Populated EJC Generated Model:");
        List<TransactionSet> transactionSetList = purchaseOrder.getTransactionSet();
        for (TransactionSet transactionSet : transactionSetList) {
            List<Po1Loop> po1LoopList =  transactionSet.getPo1Loop();
            for (Po1Loop po1Loop : po1LoopList) {
                BaseLineItemData itemData = po1Loop.getBaseLineItemData();
                System.out.println("Populated EJC Generated Model data for order item:");
                System.out.println("assignedIdentification: " + itemData.getAssignedIdentification());
                System.out.println("quantityOrdered: " + itemData.getQuantityOrdered());
                System.out.println("unitOrBasisForMeasurementCode: " + itemData.getUnitOrBasisForMeasurementCode());
                System.out.println("unitPrice: " + itemData.getUnitPrice());
                System.out.println("=================================================");
                System.out.println();
            }
        }

        ChelanOrder chelanOrder = runSmooksTransform(purchaseOrder);
        System.out.println("==============ChelanOrder Java Object Graph===============");
        System.out.println(chelanOrder.toString());
        System.out.println("==========================================================\n\n");
//        if (OrderPurpose.ORIGINAL == chelanOrder.getPurpose()) {
//            System.out.println("Purpose:: ORIGINAL");
//        }else {
//            System.out.println("Purpose:: REPLACE");
//        }

//        if (FobPaymentMethod.DELIVERED == chelanOrder.getFobPaymentMethod()) {
//            System.out.println("PaymentMethod::DELIVERED_GROUND");
//        } else if (FobPaymentMethod.FOB == chelanOrder.getFobPaymentMethod()) {
//            System.out.println("PaymentMethod::FOB_GROUND");
//        }
//        ChelanOrderParty shipTo = chelanOrder.getRoles().get(OrderRole.SHIP_TO);
//        System.out.println(shipTo);
//        System.out.println();
//        System.out.println("Write the modified model to System.out ...");
//        System.out.println();
//
//        purchaseOrderFactory.toEDI(purchaseOrder, new PrintWriter(System.out));
//        File ediFile = new File("runtime/upload/file.edi");
//        try (PrintWriter writer = new PrintWriter(ediFile)) {
//            purchaseOrderFactory.toEDI(purchaseOrder, writer);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }

//    runSmookTransform use for JAVA TO JAVA binding
    public static ChelanOrder runSmooksTransform(PurchaseOrder srcOrder) throws SAXException, IOException {
    Smooks smooks = new Smooks("smooks-config.xml");
    ExecutionContext executionContext = smooks.createExecutionContext();

    // Transform the source Order to the target LineOrder via a
    // JavaSource and JavaResult instance...
    JavaSource source = new JavaSource(srcOrder);
    JavaResult result = new JavaResult();

    // Configure the execution context to generate a report...
    executionContext.setEventListener(new HtmlReportGenerator("runtime/report/report.html"));

    smooks.filterSource(executionContext, source, result);
        System.out.println("==============JAVA as XML=============");
        System.out.println(result.toString());
        System.out.println("======================================\n\n");
        return (ChelanOrder) result.getBean("PurchaseOrder");
}
}
