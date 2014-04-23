package com.pdf.validator;

import java.io.*;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.util.*;

public class PDFValidator {

    public boolean validateZip(String zipCode){
        PDDocument pd;

        boolean result = false;

        try {
            File input = new File("invoice.pdf");  // The PDF file from where you would like to extract
            pd = PDDocument.load(input);
            System.out.println(pd.getNumberOfPages());
            System.out.println(pd.isEncrypted());
            PDFTextStripper stripper = new PDFTextStripper();
            String strContent = stripper.getText(pd);
            System.out.println(strContent);

            if(strContent.contains(zipCode)){
                result = true;
            }

            if (pd != null) {
                pd.close();
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String args[]){
        PDFValidator validator = new PDFValidator();
        //Pass the zip code to validate.
        System.out.println("Zip Code Validation for Customer ::: " + validator.validateZip("12345"));
    }
}


