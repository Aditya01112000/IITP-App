package com.example.collegeapp.pdf;

public class ebookData {

    private String pdfTitle, downloadURL;

    public ebookData() {
    }

    public ebookData(String pdfTitle, String downloadURL) {
        this.pdfTitle = pdfTitle;
        this.downloadURL = downloadURL;
    }

    public String getPdfTitle() {
        return pdfTitle;
    }

    public void setPdfTitle(String pdfTitle) {
        this.pdfTitle = pdfTitle;
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public void setDownloadURL(String downloadURL) {
        this.downloadURL = downloadURL;
    }
}
