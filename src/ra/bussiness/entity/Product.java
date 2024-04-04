package ra.bussiness.entity;


import ra.bussiness.designe.IProduc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Product implements IProduc,Comparable<Product> {
   private int productid;
   private String productName;
   private String title;
   private String descriptions;
   private float importPrice;
   private float exportPrice;
   private float interest;
   private boolean productStatus;

    public Product(int productid, String productName, String title, String descriptions, float importPrice, float exportPrice, float interest, boolean productStatus) {
        this.productid = productid;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.productStatus = productStatus;
    }

    public Product() {
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public String toString() {
        return String.format("ID: %d || Name: %s || Title: %s || Description: %s ||\n Giá nhập: %f || Giá xuất: %f || Lợi nhuận: %f || Trạng thái: %s\n",
                this.productid, this.productName, this.title, this.descriptions, this.importPrice, this.exportPrice, this.interest, this.productStatus ? "hoạt động" : "không hoạt động");
    }
    List<Product> productList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    boolean editCheck = true;

    @Override
    public Product inputData() {
        Product product = new Product();
        if (editCheck) {
            productList.add(product);
            while (true) {
                try {
                    System.out.println("nhập ID");
                    int ID = Integer.parseInt(sc.nextLine());
                    product.setProductid(ID);
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("ID không đúng định dạng");
                }
            }
        }
        System.out.println("nhập tên sản phẩm:");
        product.setProductName(sc.nextLine());
        System.out.println("nhập title sản phẩm:");
        product.setTitle(sc.nextLine());
        System.out.println("nhập mô tả sản phẩm:");
        product.setDescriptions(sc.nextLine());
        System.out.println("gía nhập sản phẩm:");
        product.setImportPrice(Float.parseFloat(sc.nextLine()));
        System.out.println("gía xuất sản phẩm:");
        product.setExportPrice(Float.parseFloat(sc.nextLine()));
        product.setInterest(product.getExportPrice()-product.getImportPrice());
        System.out.println("trang thai sản phẩm:");
        product.setProductStatus(Boolean.parseBoolean(sc.nextLine()));
        return null;
    }

    @Override
    public void addData() {
        System.out.println("nhập số lượng muốn thêm: ");
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            inputData();
        }
    }

    @Override
    public void edit() {
        System.out.println("nhập id muốn edit: ");
        int id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getProductid() == id){
                editCheck = false;
                inputData();
                break;
            }
        }
    }

    @Override
    public void deleteData() {
        System.out.println("nhập id muốn delete:");
        int id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getProductid() == id){
                productList.remove(i);
                break;
            }
        }
    }

    @Override
    public void display() {
        for (Product e : productList) {
            System.out.println(e.toString());
            System.out.println("-----------------------------");
        }
    }

    @Override
    public void sortByprofit() {
        Collections.sort(productList);
    }

    @Override
    public void switchStatus() {
        System.out.println("nhập id muốn thay đổi:");
        int id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getProductid() == id){
                productList.get(i).setProductStatus(!productList.get(i).isProductStatus());
                break;
            }
        }
    }

    @Override
    public void findByName() {
        System.out.println("nhập tên muốn tìm");
        String nameFind = sc.nextLine();
        for (int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getProductName().equals(nameFind)){
                System.out.println(productList.get(i).toString());;
                break;
            }
        }
    }

    @Override
    public int compareTo(Product o) {
        return Float.compare(this.interest, o.getInterest());
    }
}
