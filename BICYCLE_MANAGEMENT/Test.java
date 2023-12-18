package BICYCLE_MANAGEMENT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Test {
    static void test1() {
        Station station1 = new Station("Thanh Xuân");
        Station station2 = new Station("Đống Đa");
        Station station3 = new Station("Hoàn Kiếm");

        for (int i = 0; i < 100; i++) {
            Bicycle bicycle = new Bicycle();
            station1.insertBicycle(bicycle);
        }

        for (int i = 0; i < 100; i++) {
            Bicycle bicycle = new Bicycle();
            station2.insertBicycle(bicycle);
        }

        for (int i = 0; i < 100; i++) {
            Bicycle bicycle = new Bicycle();
            station3.insertBicycle(bicycle);
        }


        System.out.println(station3.isStationEmpty());
        Customer customer1 = new Customer("Vu Quang Huy");
        customer1.buyTicketForHour(3);
        System.out.println(customer1.getCurrentTicketInfor());
        customer1.rentBicycle(station1);
//        Customer customer2 = new Customer("Vu quang huy");
//        customer2.rentBicycle(customer2, station1);
        customer1.returnBicycle(station1);
    }

    static void test2() {
        BicyclePriorityManager bicyclePriorityManager1 = new BicyclePriorityManager();
        Station s1 = new Station(bicyclePriorityManager1, "station1");
        Bicycle b1 = new Bicycle();
        Bicycle b2 = new Bicycle();
        Bicycle b3 = new Bicycle();
        Bicycle b4 = new Bicycle();
        Bicycle b5 = new Bicycle();
        b1.updateTraveledTime(230);
        b2.updateTraveledTime(123);
        b3.updateTraveledTime(33);
        b4.updateTraveledTime(34);
        b5.updateTraveledTime(90);
        bicyclePriorityManager1.insert(b1);
        bicyclePriorityManager1.insert(b2);
        bicyclePriorityManager1.insert(b3);
        bicyclePriorityManager1.insert(b4);
        bicyclePriorityManager1.insert(b5);
        System.out.println("=======================");
        for (int i = 0; i < bicyclePriorityManager1.size(); i++) {
            System.out.println(bicyclePriorityManager1.getBike(i) + " ");
        }
        System.out.println("=======================");
        Customer c1 = new Customer("hang");
        Customer c2 = new Customer("Huy");
        c1.buyTicketForHour(5);
        c2.buyTicketForHour(6);
        System.out.println(c1.getCurrentTicketInfor());
        System.out.println(c2.getCurrentTicketInfor());
        c1.rentBicycle(s1);
        c2.rentBicycle(s1);
//        c1.returnBicycle(s1);
        System.out.println("########################");
        for (int i = 0; i < bicyclePriorityManager1.size(); i++) {
            System.out.println(bicyclePriorityManager1.getBike(i) + " ");
        }
        System.out.println("########################");
        System.out.println("Customer: ");
        s1.printListCustomer();
        System.out.println(s1.getRevenue());


        MasterManager masterManager = new MasterManager();
        masterManager.addStation(s1);
        masterManager.addCustomer(c1);
        masterManager.addCustomer(c2);
        System.out.println("test masterManager");
        for(Customer c : masterManager.getCustomerMasterList()){
            System.out.println(c.getName());
        }
        System.out.println("test again");
        System.out.println(masterManager.hasCustomer("hang").getName());
    }

    static void test3() {
        Station station1 = new Station("Thanh Xuân");
        Station station2 = new Station("Đống Đa");
        Station station3 = new Station("Hoàn Kiếm");
        Station station4 = new Station("Bắc Từ Liêm");
        Station station5 = new Station("Nam Từ Liêm");
        Station station6 = new Station("Hà Đông");
        Station station7 = new Station("Cầu Giấy");

        Vertex v1 = new Vertex(station1);
        Vertex v2 = new Vertex(station2);
        Vertex v3 = new Vertex(station3);
        Vertex v4 = new Vertex(station4);
        Vertex v5 = new Vertex(station5);
        Vertex v6 = new Vertex(station6);
        Vertex v7 = new Vertex(station7);

        Vertex diem1 = new Vertex("diem1");
        Vertex diem2 = new Vertex("diem2");
        Vertex diem3 = new Vertex("diem3");
        Vertex diem4 = new Vertex("diem4");
        Vertex diem5 = new Vertex("diem5");
        Vertex diem6 = new Vertex("diem6");
        Vertex diem7 = new Vertex("diem7");
        Vertex diem8 = new Vertex("diem8");
        Vertex diem9 = new Vertex("diem9");
        Vertex diem10 = new Vertex("diem10");
        Vertex diem11 = new Vertex("diem11");
        Vertex diem12 = new Vertex("diem12");


        v1.addNeighbour(new Edge(300, v1, diem1));
        v1.addNeighbour(new Edge(100, v1, diem3));
        v1.addNeighbour(new Edge(280, v1, diem6));

        diem1.addNeighbour(new Edge(500, diem1, v2));

        v2.addNeighbour(new Edge(170, v2, diem2));

        diem6.addNeighbour(new Edge(120, diem6, v3));
        diem6.addNeighbour(new Edge(250, diem6, diem5));

        v3.addNeighbour(new Edge(260, v3, diem7));

        diem7.addNeighbour(new Edge(600, diem7, diem8));
        diem7.addNeighbour(new Edge(900, diem7, v4));

        diem8.addNeighbour(new Edge(420, diem8, v7));
        diem8.addNeighbour(new Edge(270, diem8, v4));

        v7.addNeighbour(new Edge(550, v7, diem4));

        diem4.addNeighbour(new Edge(800, diem4, diem3));

        diem5.addNeighbour(new Edge(320, diem5, v6));

        v6.addNeighbour(new Edge(360, v6, diem11));

        diem11.addNeighbour(new Edge(270, diem11, diem12));

        diem12.addNeighbour(new Edge(580, diem12, v5));

        v5.addNeighbour(new Edge(380, v5, diem10));

        diem10.addNeighbour(new Edge(190, diem10, diem9));


        Vertex khachHang = new Vertex("khachHang");
        khachHang.addCustomerPosition(300, diem8, 300, diem7);

        Dijkstra shortestPath = new Dijkstra();
//        shortestPath.findTheShortestPath(khachHang);
//        System.out.println(v3.getDistance());
//        shortestPath.printList(v3);
        Vertex s = shortestPath.findTheNearestStation(khachHang);
        System.out.println(s.getName()+": "+s.getDistance()+"m");
        shortestPath.printList(s);

    }

    static void test4() {
        BicyclePriorityManager bicyclePriorityManager1 = new BicyclePriorityManager();
        Station s1 = new Station(bicyclePriorityManager1, "station1");
        Bicycle b1 = new Bicycle();
        Bicycle b2 = new Bicycle();
        Bicycle b3 = new Bicycle();
        Bicycle b4 = new Bicycle();
        Bicycle b5 = new Bicycle();
        b1.updateTraveledTime(230);
        b2.updateTraveledTime(123);
        b3.updateTraveledTime(33);
        b4.updateTraveledTime(34);
        b5.updateTraveledTime(90);
        bicyclePriorityManager1.insert(b1);
        bicyclePriorityManager1.insert(b2);
        bicyclePriorityManager1.insert(b3);
        bicyclePriorityManager1.insert(b4);
        bicyclePriorityManager1.insert(b5);
        System.out.println("=======================");
        for (int i = 0; i < bicyclePriorityManager1.size(); i++) {
            System.out.println(bicyclePriorityManager1.getBike(i) + " ");
        }
        System.out.println("=======================");
        Customer c1 = new Customer("minh hang");
        c1.buyTicketForDaily();
        System.out.println(c1.getCurrentTicketInfor());
        c1.rentBicycle(s1);
        c1.returnBicycle(s1);
        System.out.println("########################");
        for (int i = 0; i < bicyclePriorityManager1.size(); i++) {
            System.out.println(bicyclePriorityManager1.getBike(i) + " ");
        }
        System.out.println("########################");
    }

    static void test5() throws FileNotFoundException {
        Random r = new Random();
        BicyclePriorityManager PQ1 = new BicyclePriorityManager();
        Station station = new Station(PQ1,"station");
        for (int i = 0; i < 10000; i++) {
            Bicycle b = new Bicycle();
            double hour = (r.nextInt(234)+1) *1.0;
            b.updateTraveledTime(hour);
            PQ1.insert(b);
        }
        MasterManager masterManager = new MasterManager();
        masterManager.addStation(station);
//        for (int i = 0; i < PQ1.size(); i++) {
//            System.out.println(PQ1.getBike(i)+" ");
//        }
//        System.out.println("===================");
        String url = "C:\\Users\\Admin\\DSA\\output.txt";
        // Đọc dữ liệu từ File với Scanner
        FileInputStream fileInputStream = new FileInputStream(url);
        Scanner scanner = new Scanner(fileInputStream);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] elements = getWord(s);
            Customer customer = masterManager.hasCustomer(elements[0]);
            if(customer==null){
                customer = new Customer(elements[0]);
            }
            if(elements[1].equals("0")){
                if(elements[2].equals("0")){
                    customer.buyTicketForDaily();
                    masterManager.addCustomer(customer);
                } else{
                    customer.buyTicketForHour(Integer.parseInt(elements[3]));
                    masterManager.addCustomer(customer);
                }
            } else if(elements[1].equals("1")){
                customer.rentBicycle(station);
            } else if(elements[1].equals("2")){
                customer.returnBicycle(station);
            } else{
                customer.renewalTicket(Integer.parseInt(elements[2]));
            }
        }
    }

    static String[] getWord(String s){
        String[] result = s.split(" ");
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        test5();
    }
}
