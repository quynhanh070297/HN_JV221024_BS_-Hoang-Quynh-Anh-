package ra.main;

import ra.businessImp.Product;
import ra.config.InputMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductManagement
{

    public static  List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(0,"Ao","tieu de","mota",1562,1567567,true));
        productList.add(new Product(8,"Quan","tieu de","mota",1662,1564,true));
        productList.add(new Product(12,"Khau trang","tieu de","mota",13562,14633,true));
        productList.add(new Product(2,"Mu","tieu de","mota",1562,1346535,true));


    }
    public static void main(String[] args)
    {


        while (true){
            System.out.println("-----------MENU----------------");
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số sản phẩm và nhập thông tin sản phẩm [15 điểm]\n" +
                    "2. Hiển thị thông tin các sản phẩm [15 điểm]\n" +
                    "3. Sắp xếp sản phẩm theo lợi nhuận tăng dần [15 điểm]\n" +
                    "4. Xóa sản phẩm theo mã sản phẩm [10 điểm]\n" +
                    "5. Tìm kiếm sản phẩm theo tên sản phẩm [10 điểm]\n" +
                    "6. Thay đổi trạng thái của sản phẩm theo mã sản phẩm [10 điểm]\n" +
                    "7. Thoát [05 điểm]");
            System.out.println("mời bạn nhập");
            byte choice = InputMethods.getByte();
            switch (choice)
            {
                case 1:
                    creatProduct(); 
                    break;
                case 2:
                    displayProduct(); 
                    break;
                case 3:
                    sortByInterest();
                    break;
                case 4:
                    deleteByID(); 
                    break;
                case 5:
                    searchProductByName(); 
                    break;
                case 6:
                    chageStatusByID(); 
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Lựa chọn không đúng");
                    break;
            }
        }
    }

    private static void deleteByID()
    {
        System.out.println("Moi ban nhap ID muon xoa");
        int deleteId = InputMethods.getInteger();
        for (Product product1 : productList)
        {
            if (deleteId == product1.getProductId()){
                productList.remove(product1);
                System.out.println("Xoa thanh cong");
                break;
            }
        }
    }

    private static void searchProductByName()
    {
        System.out.println("Moi ban nhap ten san pham");
        String inputName = InputMethods.getString();
        boolean check = false;
        for (Product product : productList)
        {
            if (product.getProductName().contains(inputName)){
                System.out.println("San pham ban muon tim");
                product.displayData();
                check = true;
            }
        }
        if (!check){
            System.out.println("Khong tim thay san pham muon xoa");
        }
    }

    private static void chageStatusByID()
    {
        System.out.println("Nhap vao ma san pham");
        int changeStatus = InputMethods.getInteger();
        for (Product product1 : productList)
        {if (changeStatus == product1.getProductId()){
            if (product1.getProductStatus()){
                product1.setProductStatus(false);
            }else {
                product1.setProductStatus(true);
            }
            System.out.println("Da thay doi trang thai");
        }
        }

    }

    private static void sortByInterest()
    {
        Collections.sort(productList);
    }

    private static void displayProduct()
    {
        System.out.println("Thong tin tat ca cac san pham");
        productList.forEach(Product::displayData);
    }

    private static void creatProduct()
    {
        System.out.println("Ban muon them may san pham");
        int inputChoice = InputMethods.getInteger();
        for (int i = 0; i < inputChoice; i++)
        {
            Product product = new Product();
            product.inputData();
            productList.add(product);
        }
    }
}
