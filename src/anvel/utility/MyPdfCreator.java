package anvel.utility;
import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;

import java.io.*;
import java.net.MalformedURLException;

//import java.net.URL;
//import java.net.UnknownHostException;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
public class MyPdfCreator {
	
	public static void generatePDF(ResultSet accounts, String filename) throws MalformedURLException, IOException
	{
		Document docu = new Document(PageSize.LETTER, 36, 36, 36, 36);
		
		DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy");
		Calendar cal = Calendar.getInstance();
		try{
			File theFile = new File("C:/Anvel Reports/"); 
            theFile.mkdirs();
			PdfWriter.getInstance(docu, new FileOutputStream("C:/Anvel Reports/"+filename+".pdf"));
	
			docu.open();
	
			 Paragraph p = new Paragraph("84-E Scout Alcaraz St. Corner Ubay St., Brgy. Siena, Quezon City", new Font(FontFamily.HELVETICA, 12)); 
			 p.setAlignment(Element.ALIGN_CENTER);
			 Paragraph p1 = new Paragraph("Telephone # 712-6523, Telefax # 749-3011", new Font(FontFamily.HELVETICA, 12));
			 p1.setAlignment(Element.ALIGN_CENTER);
			 
			 
			 Paragraph pH = new Paragraph(dateFormat.format(cal.getTime()), new Font(FontFamily.HELVETICA, 12, Font.BOLD));
			pH.setAlignment(Element.ALIGN_RIGHT);
			
			 Paragraph p3 = new Paragraph("                 ", new Font(FontFamily.HELVETICA, 12));
		//	Image img = Image.getInstance(new URL("http://www.mrtsystems.com/mrt-logo.png"));
		//	img.scaleToFit(300, 150);
		//   img.setAlignment(Element.ALIGN_CENTER);
		   
			Paragraph f1 = new Paragraph("           Prepared by:                                  Approved by:                               Received by:    ", new Font(FontFamily.HELVETICA, 12, Font.BOLD));
		    f1.setAlignment(Element.ALIGN_LEFT);
		    
		   
		    
		   // docu.add(img);
		   
		  
		    docu.add(p);
		    docu.add(p1);
		    docu.add(p3);
		    docu.add(p3);
		    docu.add(pH);
		    docu.add(p3);
		    
		    PdfPTable tablesup= new PdfPTable(8);
		    tablesup.setWidthPercentage(100);
		    
		    BaseColor headerColor = WebColors.getRGBColor("#87bbe1");
		    BaseColor myColor = WebColors.getRGBColor("#e6f3ff");
		    
		    PdfPCell cell = new PdfPCell(new Phrase("Products Report", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD)));
            cell.setColspan(8);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(headerColor);
            
            
            
            PdfPCell h1 = new PdfPCell(new Paragraph("#"));
            h1.setHorizontalAlignment(Element.ALIGN_CENTER);
            h1.setBackgroundColor(myColor);
            
            
            PdfPCell h2 = new PdfPCell(new Paragraph("Product Code"));
            h2.setHorizontalAlignment(Element.ALIGN_CENTER);
            h2.setFixedHeight(10);
            h2.setBackgroundColor(myColor);
            
            PdfPCell h3 = new PdfPCell(new Paragraph("Product Name"));
            h3.setHorizontalAlignment(Element.ALIGN_CENTER);
            h3.setBackgroundColor(myColor);
            
            PdfPCell h4 = new PdfPCell(new Paragraph("Status"));
            h4.setHorizontalAlignment(Element.ALIGN_CENTER);
            h4.setBackgroundColor(myColor);
            
            PdfPCell h5 = new PdfPCell(new Paragraph("Delivery Date"));
            h5.setHorizontalAlignment(Element.ALIGN_CENTER);
            h5.setBackgroundColor(myColor);
            
            PdfPCell h6 = new PdfPCell(new Paragraph("Date Received"));
            h6.setHorizontalAlignment(Element.ALIGN_CENTER);
            h6.setBackgroundColor(myColor);
            
            PdfPCell h7 = new PdfPCell(new Paragraph("Quantity"));
            h7.setHorizontalAlignment(Element.ALIGN_CENTER);
            h7.setBackgroundColor(myColor);
            
            PdfPCell h8 = new PdfPCell(new Paragraph("Total Amount"));
            h8.setHorizontalAlignment(Element.ALIGN_CENTER);
            h8.setBackgroundColor(myColor);
            
            
            
            tablesup.addCell(cell);
            //tablesup.addCell("Username");
            tablesup.addCell(h1);
            tablesup.addCell(h2);
            tablesup.addCell(h3);
            tablesup.addCell(h4);
            tablesup.addCell(h5);
            tablesup.addCell(h6);
            tablesup.addCell(h7);
            tablesup.addCell(h8);
    
            int ctr = 0;
            double totalAm = 0;
            while (accounts.next())
            {
            			String ex = "";
            			
            			ctr++;
             		    
             		    String pcode = accounts.getString("product_code");
             		    String pname = accounts.getString("product_name");
             		    String status = accounts.getString("status");
             		    String deliverydate = accounts.getString("delivery_date");
             		    String datereceived = accounts.getString("date_received");
             		    String qty = accounts.getInt("quantity")+"";
             		    String total = accounts.getDouble("total_amount")+"";
             		  
             		    totalAm+=accounts.getDouble("total_amount");
             		    
             		   PdfPCell b = new PdfPCell(new Phrase(ctr+"", FontFactory.getFont(FontFactory.HELVETICA, 11))); 
             		   
             		   PdfPCell b1 = new PdfPCell(new Phrase(pcode, FontFactory.getFont(FontFactory.HELVETICA, 11)));
             		   b1.setHorizontalAlignment(Element.ALIGN_CENTER);
             		  h2.setFixedHeight(8);
             		   PdfPCell b2 = new PdfPCell(new Phrase(pname, FontFactory.getFont(FontFactory.HELVETICA, 11)));
             		  b2.setHorizontalAlignment(Element.ALIGN_CENTER);
             		   PdfPCell b3 = new PdfPCell(new Phrase(status, FontFactory.getFont(FontFactory.HELVETICA, 11)));
             		  b3.setHorizontalAlignment(Element.ALIGN_CENTER);
             		   PdfPCell b4 = new PdfPCell(new Phrase(deliverydate, FontFactory.getFont(FontFactory.HELVETICA, 11))); 
             		  b4.setHorizontalAlignment(Element.ALIGN_CENTER);
             		   PdfPCell b5 = new PdfPCell(new Phrase(datereceived, FontFactory.getFont(FontFactory.HELVETICA, 11)));
             		  b5.setHorizontalAlignment(Element.ALIGN_CENTER);
             		   PdfPCell b6 = new PdfPCell(new Phrase(qty, FontFactory.getFont(FontFactory.HELVETICA, 11))); 
             		  b6.setHorizontalAlignment(Element.ALIGN_CENTER);
             		   PdfPCell b7 = new PdfPCell(new Phrase("P "+total+"0", FontFactory.getFont(FontFactory.HELVETICA, 11))); 
             		  b7.setHorizontalAlignment(Element.ALIGN_CENTER);
             		    System.out.println(pcode);
             		    
             		    
             		    
             		   tablesup.addCell(b);
                       tablesup.addCell(b1);
                       tablesup.addCell(b2);
                       tablesup.addCell(b3);
                       tablesup.addCell(b4);
                       tablesup.addCell(b5);
                       tablesup.addCell(b6);
                       tablesup.addCell(b7);
                       
             		   // PdfPCell cell1 = new PdfPCell(new Paragraph("Name:" + pcode));
                       // cell1.setColspan(4);
                        //cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                       // cell1.setBackgroundColor(BaseColor.ORANGE);
                        /*
             		    tablesup.addCell(ctr+"");
                        tablesup.addCell(pcode);
                        tablesup.addCell(pname);
                        tablesup.addCell(status);
                        tablesup.addCell(deliverydate);
                        tablesup.addCell(datereceived);
                        tablesup.addCell(qty);
                        tablesup.addCell(total);*/
                        
                        float[] columnWidths = new float[] {5f, 19f, 18f, 12f, 21f, 21f, 16f, 24f};
                        tablesup.setWidths(columnWidths);
                        /*
             		    if (accounts.getString("product_code").equals(ex))
             		    {
                           tablesup.addCell(pname);
                           tablesup.addCell(supplier);
                           tablesup.addCell(desc);
                           tablesup.addCell(size);
             		    	 
             		    }
             		    else
             		    {
             		    	/*tablesup.addCell(cell1);
             		    	  tablesup.addCell(pw);
                              tablesup.addCell(email);
                              tablesup.addCell(fname);
                              tablesup.addCell(lname);
             		    	tablesup.addCell(cell1);
             		    	tablesup.addCell(pname);
                            tablesup.addCell(supplier);
                            tablesup.addCell(desc);
                            tablesup.addCell(size);
                            ex=pcode;
             		    	
             		    }*/
             		 
             		    /*
             		   tablesup.addCell(uname);
                       tablesup.addCell(pw);
                       tablesup.addCell(email);
                       tablesup.addCell(fname);
                       tablesup.addCell(lname);*/
            }
            
            PdfPCell total = new PdfPCell(new Paragraph("Total: P "+totalAm +"0",FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD)));
            total.setColspan(8);
            total.setHorizontalAlignment(Element.ALIGN_RIGHT);
            total.setBackgroundColor(headerColor);
           
            tablesup.addCell(total);
            docu.add(tablesup);
            docu.add(p3);
            docu.add(f1);
            docu.addCreator("CHICKEN SAD - University of Santo Tomas");
		   
		   
		    docu.close();
						/*
			docu.add(new Paragraph("TOTAL FARE FOR ALL STOP 1: P" + cb.totalFare1  ));
			docu.add(new Paragraph("TOTAL FARE FOR ALL STOP 2: P" + cb.totalFare2 ));
			docu.add(new Paragraph("TOTAL FARE FOR ALL STOP 3: P" + cb.totalFare3   ));
			docu.add(new Paragraph("TOTAL FARE FOR ALL STOP 4: P" + cb.totalFare4    ));
			docu.add(new Paragraph("TOTAL FARE FOR ALL STOP 5: P" + cb.totalFare5    ));
			docu.add(new Paragraph("TOTAL FARE FOR ALL STOP 6: P" + cb.totalFare6    ));
			*/
			
			
		}
		catch(DocumentException de)
		{
			de.printStackTrace();
		}
	
		catch(FileNotFoundException fnfe)
		{
			fnfe.printStackTrace();
		}	
		catch(Exception e)
		{
			
		}
		finally
		{
			docu.close();
		}
		
		
	}


}