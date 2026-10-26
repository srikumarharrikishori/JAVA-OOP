package uk.ac.westminster.products_api;

public class DigitalProduct extends Product{
    private String downloadURL;
    private double fileSizeMB;


    public DigitalProduct(long id,String name,double price, String downloadUrl,double fileSizeMB) {
        super(id,name,price);
        this.downloadURL=downloadUrl;
        this.fileSizeMB=fileSizeMB;

    }

    public String getDownloadURL(){return downloadURL;}
    public double getFileSizeMB(){return fileSizeMB;}


}