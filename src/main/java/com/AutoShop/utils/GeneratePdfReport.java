package com.AutoShop.utils;

import com.AutoShop.model.Order;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Optional;

public class GeneratePdfReport {

    private static final Logger logger = LoggerFactory.getLogger(GeneratePdfReport.class);

    public static ByteArrayInputStream ordersReport(Optional<Order> newOrder) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            table.setWidths(new int[]{1, 3, 3});

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("Order number", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Client data", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Product specification", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);


            PdfPCell cell;

            cell = new PdfPCell(new Phrase(newOrder.get().getId().toString()));
            cell.setPadding(20);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(newOrder.get().getClient().getFirstName() + ' ' + newOrder.get().getClient().getLastName() + "\n\n" + newOrder.get().getClient().getAddress()));
            cell.setPadding(20);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell = new PdfPCell(new Phrase(newOrder.get().getVehicle().getName() + "\n\nPrice: " + newOrder.get().getVehicle().getPrice() + " PLN"));
            cell.setPadding(20);
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);


            PdfWriter.getInstance(document, out);
            document.open();
            document.add(new Paragraph("Invoice \n\n"));
            document.add(table);

            document.close();

        } catch (DocumentException ex) {

            logger.error("Error occurred: {0}", ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
