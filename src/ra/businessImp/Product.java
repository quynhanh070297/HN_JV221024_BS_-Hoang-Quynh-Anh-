package ra.businessImp;

import ra.business.IProduct;
import ra.config.InputMethods;

public class Product implements IProduct,Comparable<Product>
{
    private int productId ;
    private String productName ;
    private String title ;
    private String descriptions ;
    private float importPrice ;
    private float exportPrice;
    private float interest ;
    private Boolean productStatus ;

    public Product()
    {
    }

    public Product(int productId, String productName, String title, String descriptions, float importPrice, float exportPrice, Boolean productStatus)
    {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
        this.interest = getInputInterest();
    }

    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescriptions()
    {
        return descriptions;
    }

    public void setDescriptions(String descriptions)
    {
        this.descriptions = descriptions;
    }

    public float getImportPrice()
    {
        return importPrice;
    }

    public void setImportPrice(float importPrice)
    {
        this.importPrice = importPrice;
    }

    public float getExportPrice()
    {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice)
    {
        this.exportPrice = exportPrice;
    }

    public float getInterest()
    {
        return interest;
    }

    public void setInterest(float interest)
    {
        this.interest = interest;
    }

    public Boolean getProductStatus()
    {
        return productStatus;
    }

    public void setProductStatus(Boolean productStatus)
    {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData()
    {
        System.out.println("Moi ban nhap ID");
        this.productId = InputMethods.getInteger();
        System.out.println("Moi ban nhap ten");
        this.productName = InputMethods.getString();
        System.out.println("Moi ban nhap tieu de ");
        this.title = InputMethods.getString();
        System.out.println("Moi ban nhap mo ta ");
        this.descriptions = InputMethods.getString();
        System.out.println("Moi ban nhap gia nhap");
        this.importPrice = InputMethods.getFloat();
        System.out.println("Moi ban nhap gia xuat");
        this.exportPrice = InputMethods.getFloat();
        System.out.println("Moi ban nhap trang thai");
        this.productStatus = InputMethods.getBoolean();
        this.interest = getInputInterest();


    }

    private float getInputInterest()
    {
        return this.exportPrice - this.importPrice;
    }

    @Override
    public void displayData()
    {
        System.out.printf("| ID : %-5d | Name : %-15s | Title : %-10s |Descriptions : %-15s |ImportPrice : %-5f | ExportPrice : %-5f | interest : %-5f |Status : %-3s\n",
                this.productId,this.productName,this.title,this.descriptions,this.importPrice,this.exportPrice,this.interest,(this.productStatus?"Dang Hoat Dong":"Ngung Hoat dong"));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    }


    @Override
    public int compareTo(Product o)
    {
        return Float.compare(this.interest,o.interest);
    }
}
