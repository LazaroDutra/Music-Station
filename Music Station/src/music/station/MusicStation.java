/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.station;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author Lazaro
 */
public class MusicStation extends Application {
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.fullScreenProperty();
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException, DocumentException{
  

  
        launch(args);

    }
    
    public void gerar(Musica m){
            // criação do documento 
        
        Document document = new Document();
        String cl = Integer.toString(m.getClas());
        try { PdfWriter.getInstance(document, new FileOutputStream("/Users/lazarodutra/Documents/PDF")); 
        document.open();
         // adicionando um parágrafo no documento 
        document.add(new Paragraph("Relatório Geral"));
            
            PdfPTable table = new PdfPTable(5); // 5 columns.

            PdfPCell cell1 = new PdfPCell(new Paragraph(m.getMusica()));
            PdfPCell cell2 = new PdfPCell(new Paragraph(m.getAlbum()));
            PdfPCell cell3 = new PdfPCell(new Paragraph(m.getArtista()));
            PdfPCell cell4 = new PdfPCell(new Paragraph(m.getGenero()));
            PdfPCell cell5 = new PdfPCell(new Paragraph(cl));
            

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);

            document.add(table);
             PdfPTable table2 = new PdfPTable(5);
            PdfPCell cell11 = new PdfPCell(new Paragraph(m.getMusica()));
            PdfPCell cell22 = new PdfPCell(new Paragraph(m.getAlbum()));
            PdfPCell cell33 = new PdfPCell(new Paragraph(m.getArtista()));
            PdfPCell cell44 = new PdfPCell(new Paragraph(m.getGenero()));
            PdfPCell cell55 = new PdfPCell(new Paragraph(cl));
            

            table.addCell(cell11);
            table.addCell(cell22);
            table.addCell(cell33);
            table.addCell(cell44);
            table.addCell(cell55);
            document.add(table2);
            document.close();
        } 
        catch(DocumentException de) { System.err.println(de.getMessage());
        } 
        catch(IOException ioe) { System.err.println(ioe.getMessage()); 
        } 
        document.close(); 
        
    }
        
}
