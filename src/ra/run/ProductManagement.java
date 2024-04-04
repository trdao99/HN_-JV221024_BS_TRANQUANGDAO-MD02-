package ra.run;

import ra.bussiness.entity.Product;

import java.util.Scanner;

public class ProductManagement {
    public static void main(String[] args) {
        Product product = new Product();
        Scanner scanner = new Scanner(System.in);
        int choice; // tạo biến chọn
        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************");
            System.out.println("1. Nhập số sản phẩm và nhập thông tin sản phẩm: ");
            System.out.println("2. Hiển thị thông tin các sản phẩm: ");
            System.out.println("3. Sắp xếp sản phẩm theo lợi nhuận tăng dần: ");
            System.out.println("4. Xóa sản phẩm theo mã sản phẩm: ");
            System.out.println("5. Tìm kiếm sản phẩm theo tên sản phẩm: ");
            System.out.println("6. Thay đổi trạng thái của sản phẩm theo mã sản phẩm: ");
            System.out.println("7. Thoát: ");
            System.out.print("Chọn một số từ 1 đến 7: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    product.addData();
                    break;
                case 2:
                    product.display();
                    break;
                case 3:
                    product.sortByprofit();
                    break;
                case 4:
                    product.deleteData();
                    break;
                case 5:
                    product.findByName();
                    break;
                case 6:
                    product.switchStatus();
                    break;
                case 7:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 7);
    }
}
