package group05;

// import java.math.BigInteger;
// import java.security.MessageDigest;
// import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.IOException;
import java.io.Console;

import group05.BL.CustomerBL;
import group05.BL.FoodBL;
import group05.BL.OrderDetailBL;
import group05.BL.OrdersBL;
import group05.BL.RestaurantBL;
import group05.Model.Customer;
import group05.Model.Food;
import group05.Model.OrderDetail;
import group05.Model.Orders;
import group05.Model.Restaurant;

public class App {
    public static void main(final String[] args) throws SQLException {
        final RestaurantBL restaurantBL = new RestaurantBL();
        final ArrayList<Restaurant> restaurants = restaurantBL.gList();

        final CustomerBL customerBL = new CustomerBL();
        String choice = "1";

        Orders order = new Orders();
        OrderDetailBL orderDetailBL = new OrderDetailBL();
        OrdersBL orderBL = new OrdersBL();

        ArrayList<OrderDetail> orderDetails = new ArrayList<>();

        Boolean login = false;

        final Scanner sc = new Scanner(System.in);

        ArrayList<Restaurant> searching;

        do {
            switch (choice) {
                case "1":
                    listRestaurantPro(0, 10, restaurants);
                    System.out.printf(
                            "\n                                                                              < [1]  2  3  4  5 >\n\n");
                    break;
                case "2":
                    listRestaurantPro(10, 20, restaurants);
                    System.out.printf(
                            "\n                                                                              < 1  [2]  3  4  5 >\n\n");
                    break;
                case "3":
                    listRestaurantPro(20, 30, restaurants);
                    System.out.printf(
                            "\n                                                                              < 1  2  [3]  4  5 >\n\n");
                    break;
                case "4":
                    listRestaurantPro(30, 40, restaurants);
                    System.out.printf(
                            "\n                                                                              < 1  2  3  [4]  5 >\n\n");
                    break;
                case "5":
                    listRestaurantPro(40, 50, restaurants);
                    System.out.printf(
                            "\n                                                                              < 1  2  3  4  [5] >\n\n");
                    break;
                case "l":
                    System.out.println("\nĐăng nhập");
                    System.out.printf("Tên người dùng : ");
                    String userName = sc.nextLine();
                    System.out.printf("Mật khẩu: ");

                    choice = "1";
                    Console con = System.console();
                    char[] pass = con.readPassword();

                    String password = String.valueOf(pass);
                    clrscr();
                    choice = "1";

                    // password = MD5(password);
                    if (customerBL.login(userName, password)) {
                        System.out.println("Đăng nhập thành công!");
                        login = true;
                    } else {
                        System.out.println("Đăng nhập thất bại!");
                        login = false;
                    }
                    break;
                case "s":
                    clrscr();
                    System.out.printf("Nhập từ khóa :");
                    String keyWord = sc.nextLine();
                    searching = searchByName(keyWord);

                    Line();
                    System.out.printf("\n| %-6s | %-57s | %-80s | %-23s |\n", "ID", "Tên CỬA HÀNG", "ĐỊA CHỈ",
                            "TIME OPEN - TIME CLOSE");
                    Line();
                    for (int i = 0; i < searching.size(); i++) {
                        System.out.printf("\n| %-6d | %-57s | %-80s | %-23s |\n", searching.get(i).getRestaurant_id(),
                                searching.get(i).getRestaurant_name(), searching.get(i).getRestaurant_address(),
                                searching.get(i).getRestaurant_timeOC());
                        Line();
                    }
                    break;

                case "p":
                    System.out.printf("Nhập id cửa hàng : ");
                    final int Id = Integer.parseInt(sc.nextLine());

                    if (Id > 10000 && Id < 10051) {

                    } else {
                        System.out.println("Mã cửa hàng bạn nhập không tồn tại!");
                        break;
                    }

                    final FoodBL foodBL = new FoodBL();
                    final ArrayList<Food> foods = foodBL.gList(Id);

                    int choiceOrder = 1;

                    do {
                        Line2();
                        System.out.printf("\n|  %-78s|", foods.get(1).getRestaurant_name());
                        System.out.printf("\n|  %-78s|", foods.get(1).getRestaurant_address());
                        System.out.printf("\n|  %-78s|\n", foods.get(1).getRestaurant_timeOC());
                        Line1();
                        for (int i = 0; i < foods.size(); i++) {
                            System.out.printf("\n| %-6d | %-40s | %-26s |\n", foods.get(i).getFood_id(),
                                    foods.get(i).getFood_name(), priceToString(foods.get(i).getFood_price()));
                            Line1();
                        }

                        mainMenuOrder();
                        choiceOrder = Integer.parseInt(sc.nextLine());
                        clrscr();

                        switch (choiceOrder) {
                            case 1:
                                if (orderDetails == null) {
                                    System.out.println("Đơn hàng của bạn rỗng! Mời bạn chọn món ăn.");
                                } else {
                                    System.out.printf(
                                            "+------------+----------------------------------------------------+-----------------+------------+");
                                    System.out.printf("\n| %-10s | %-50s | %-15s | %-10s |\n", "STT", "Tên món ăn",
                                            "Giá", "Số lượng");
                                    Food foodx = null;
                                    System.out.printf(
                                            "+------------+----------------------------------------------------+-----------------+------------+");
                                    for (int i = 0; i < orderDetails.size(); i++) {
                                        foodx = foodBL.getFood(orderDetails.get(i).getFood_id());
                                        System.out.printf("\n| %-10d | %-50s | %-15s | %-10d |\n", i + 1,
                                                foodx.getFood_name(), priceToString(foodx.getFood_price()),
                                                orderDetails.get(i).getOrders_amount());
                                        System.out.printf(
                                                "+------------+----------------------------------------------------+-----------------+------------+");
                                    }

                                    int choicePayment;

                                    System.out.println("\n1.Đặt hàng");
                                    System.out.println("2.Tiếp tục chọn món ăn");
                                    System.out.printf("Nhập lựa chọn của bạn : ");

                                    choicePayment = Integer.parseInt(sc.nextLine());

                                    if (choicePayment == 1) {
                                        if (login) {

                                        } else {
                                            System.out.println("\nĐăng nhập");
                                            System.out.printf("Tên người dùng : ");
                                            userName = sc.nextLine();
                                            System.out.printf("Mật khẩu: ");

                                            choice = "1";
                                            Console con1 = System.console();
                                            char[] pass1 = con1.readPassword();

                                            password = String.valueOf(pass1);
                                            clrscr();

                                            // password = MD5(password);
                                            if (customerBL.login(userName, password)) {
                                                System.out.println("Đăng nhập thành công!");
                                                login = true;
                                            } else {
                                                System.out.println("Đăng nhập thất bại!");
                                                login = false;
                                            }
                                        }

                                        Customer customer = customerBL.getCustomer();
                                        order.setCustomer_id(customer.getCustomer_id());
                                        orderBL.addOrder(order);
                                        order = orderBL.getOrders(customer.getCustomer_id());
                                        for (int i = 0; i < orderDetails.size(); i++) {
                                            orderDetails.get(i).setOrders_id(order.getOrders_id());
                                            System.out.println(order.getOrders_id());
                                            orderDetailBL.addOrderDetail(orderDetails.get(i));
                                        }
                                        orderDetails.clear();
                                        orderDetails = orderDetailBL.getOrderDetail(order.getOrders_id());
                                        clrscr();
                                        System.out.printf(
                                                "+-------------------------------------------------------------------------------------------------------------------------------------------+\n");
                                        System.out.printf(
                                                "| Đơn hàng số : %-60d                                                                |\n",
                                                order.getOrders_id());
                                        System.out.printf(
                                                "| Họ và tên : %-60s                                                                  |\n",
                                                customer.getCustomer_name());
                                        System.out.printf(
                                                "| Email : %-60s                                                                      |\n",
                                                customer.getCustomer_email());
                                        System.out.printf(
                                                "| Số điện thoại : %-60s                                                              |\n",
                                                customer.getCustomer_phone());
                                        System.out.printf(
                                                "| Thời gian đặt hàng : %-60s                                                         |\n",
                                                order.getOrders_date());
                                        System.out.printf(
                                                "+-------------------------------------------------------------------------------------------------------------------------------------------+");
                                        System.out.printf("\n| %-10s | %-80s | %-10s | %-10s | %-15s |\n", "STT",
                                                "Tên món ăn", "Giá", "Số lượng", "Tạm tính");

                                        Food f = null;
                                        int priceCart = 0;
                                        for (int i = 0; i < orderDetails.size(); i++) {
                                            f = foodBL.getFood(orderDetails.get(i).getFood_id());
                                            priceCart += f.getFood_price() * orderDetails.get(i).getOrders_amount();
                                            System.out.printf(
                                                    "+------------+----------------------------------------------------------------------------------+------------+------------+-----------------+");
                                            System.out.printf("\n| %-10d | %-80s | %-10s | %-10d | %-15s |\n", i + 1,
                                                    f.getFood_name(), priceToString(f.getFood_price()),
                                                    orderDetails.get(i).getOrders_amount(), priceToString(priceCart));
                                        }
                                        System.out.printf(
                                                "+-------------------------------------------------------------------------------------------------------------------------------------------+\n");
                                        System.out.printf(
                                                "|                                                                                                            Phí giao hàng : %-13s  |\n",
                                                "15,000 ₫");
                                        priceCart += 15000;
                                        System.out.printf(
                                                "|                                                                                                            Tổng tiền : %-17s  |\n",
                                                priceToString(priceCart));
                                        System.out.printf(
                                                "+-------------------------------------------------------------------------------------------------------------------------------------------+");
                                        choiceOrder = 0;
                                        break;
                                    }
                                }

                                break;

                            case 2:
                                System.out.printf("Nhập ID món ăn: ");
                                int IdFood = Integer.parseInt(sc.nextLine());
                                Food food = foodBL.getFood(IdFood);

                                if (food != null) {
                                    System.out.printf("Nhập số lượng :");
                                    int amount = Integer.parseInt(sc.nextLine());
                                    if (amount > 0) {
                                        OrderDetail orderDetail = new OrderDetail();
                                        orderDetail.setOrders_amount(amount);
                                        orderDetail.setFood_id(IdFood);
                                        orderDetail.setOrders_id(order.getOrders_id());
                                        orderDetails.add(orderDetail);
                                    }
                                } else {
                                    System.out.println("Món ăn bạn chọn không tồn tại!");
                                }
                                break;

                            default:
                                System.out.println("Lỗi! Nhập lại lựa chọn của bạn!");
                                break;
                        }

                    } while (choiceOrder != 0);

                    break;
                default:
                    System.out.println("Lỗi! Nhập lại lựa chọn của bạn!");
                    break;
            }

            if (login) {
                mainMenuLogin();
            } else {
                mainMenu();
            }

            if (choice == "l") {
                break;
            } else {
                choice = sc.nextLine();
            }
            clrscr();

        } while (!choice.equals("0"));
        sc.close();
    }

    private static void Line() {
        System.out.printf(
                "+--------+-----------------------------------------------------------+----------------------------------------------------------------------------------+-------------------------+");
    }

    private static void Line2() {
        System.out.printf("\n+--------------------------------------------------------------------------------+");
    }

    private static void Line1() {
        System.out.printf("+--------+-----------------------------------------------------------------------+");
    }

    private static void listRestaurantPro(final int x, final int y, final ArrayList<Restaurant> restaurants) {
        Line();
        System.out.printf("\n| %-6s | %-57s | %-80s | %-23s |\n", "ID", "Tên CỬA HÀNG", "ĐỊA CHỈ",
                "TIME OPEN - TIME CLOSE");
        Line();
        for (int i = x; i < y; i++) {
            System.out.printf("\n| %-6d | %-57s | %-80s | %-23s |\n", restaurants.get(i).getRestaurant_id(),
                    restaurants.get(i).getRestaurant_name(), restaurants.get(i).getRestaurant_address(),
                    restaurants.get(i).getRestaurant_timeOC());
            Line();
        }
    }

    // private static String MD5(final String text) {
    // try {

    // // Static getInstance method is called with hashing MD5
    // final MessageDigest md = MessageDigest.getInstance("MD5");

    // // digest() method is called to calculate message digest
    // // of an input digest() return array of byte
    // final byte[] messageDigest = md.digest(text.getBytes());

    // // Convert byte array into signum representation
    // final BigInteger no = new BigInteger(1, messageDigest);

    // // Convert message digest into hex value
    // String hashtext = no.toString(16);
    // while (hashtext.length() < 32) {
    // hashtext = "0" + hashtext;
    // }
    // return hashtext;
    // }

    // // For specifying wrong message digest algorithms
    // catch (final NoSuchAlgorithmException e) {
    // throw new RuntimeException(e);
    // }
    // }

    private static void mainMenuOrder() {
        System.out.println("\n 0.Thoát !");
        System.out.println(" 1.Xem giỏ hàng");
        System.out.println(" 2.Chọn món ăn");
        System.out.printf("\n Nhập lựa chọn của bạn : ");
    }

    private static void mainMenu() {
        System.out.printf("\n 0.Thoát !");
        System.out.printf("\n 1-5.Chọn trang");
        System.out.printf("\n l.Đăng nhập");
        System.out.printf("\n p.Chọn cửa hàng");
        System.out.printf("\n s.Tìm kiếm tên cửa hàng");
        System.out.printf("\n Nhập lựa chọn của bạn : ");
    }

    private static void mainMenuLogin() {
        System.out.printf("\n 0.Thoát !");
        System.out.printf("\n 1-5.Chọn trang");
        System.out.printf("\n p.Chọn cửa hàng");
        System.out.printf("\n s.Tìm kiếm tên cửa hàng");
        System.out.printf("\n Nhập lựa chọn của bạn : ");
    }

    public static void clrscr() {

        // Clears Screen in java

        try {

            if (System.getProperty("os.name").contains("Windows"))

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            else

                Runtime.getRuntime().exec("clear");

        } catch (IOException | InterruptedException ex) {
        }

    }

    public static String priceWithDecimal(int price) {
        DecimalFormat formatter = new DecimalFormat("###,###,###.00 ₫");
        return formatter.format(price);
    }

    public static String priceWithoutDecimal(int price) {
        DecimalFormat formatter = new DecimalFormat("###,###,###.## ₫");
        return formatter.format(price);
    }

    public static String priceToString(int price) {
        String toShow = priceWithoutDecimal(price);
        if (toShow.indexOf(".") > 0) {
            return priceWithDecimal(price);
        } else {
            return priceWithoutDecimal(price);
        }
    }

    public void passwordExample() {
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }

        console.printf("Testing password%n");
        char[] passwordArray = console.readPassword("Enter your secret password: ");
        console.printf("Password entered was: %s%n", new String(passwordArray));

    }

    private static String covertToString(String value) {
        try {
            String temp = Normalizer.normalize(value, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(temp).replaceAll("").replaceAll("đ", "d");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static ArrayList<Restaurant> searchByName(String keyWord) throws SQLException {
        keyWord = covertToString(keyWord).toLowerCase();
        ArrayList<Restaurant> restaurants = new RestaurantBL().gList();
        ArrayList<Restaurant> searching = new ArrayList<>();
        for (int i = 0; i < restaurants.size(); i++) {
            if (covertToString(restaurants.get(i).getRestaurant_name().toLowerCase()).contains(keyWord)) {
                searching.add(restaurants.get(i));
            }
        }
        return searching;
    }
}