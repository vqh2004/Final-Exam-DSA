package BICYCLE_MANAGEMENT;

public class Test {
    static void test1(){
        Station station1 = new Station("Thanh Xuân");
        Station station2 = new Station("Đống Đa");
        Station station3 = new Station("Hoàn Kiếm");

        for (int i = 0; i < 100 ; i++) {
            Bicycle bicycle = new Bicycle();
            station1.insertBicycle(bicycle);
        }

        for (int i = 0; i < 100 ; i++) {
            Bicycle bicycle = new Bicycle();
            station2.insertBicycle(bicycle);
        }

        for (int i = 0; i < 100 ; i++) {
            Bicycle bicycle = new Bicycle();
            station3.insertBicycle(bicycle);
        }


        System.out.println(station3.isStationEmpty());
        Customer customer1 = new Customer("Vu Quang Huy");
        customer1.buyTicketForHour(3);
        System.out.println(customer1.getCurrentTicketInfor());
        customer1.rentBicycle(station1 );
//        Customer customer2 = new Customer("Vu quang huy");
//        customer2.rentBicycle(customer2, station1);
        customer1.returnBicycle(station1);
    }

    static void test2(){
        BicyclePriorityManager bicyclePriorityManager1 = new BicyclePriorityManager();
        Station s1 = new Station(bicyclePriorityManager1,"station1");
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
            System.out.println(bicyclePriorityManager1.getBike(i)+" ");
        }
        System.out.println("=======================");
        Customer c1 = new Customer("hang");
        c1.buyTicketForHour(5);
        System.out.println(c1.getCurrentTicketInfor());
        c1.rentBicycle(s1);
        c1.returnBicycle(s1);
        System.out.println("########################");
        for (int i = 0; i < bicyclePriorityManager1.size(); i++) {
            System.out.println(bicyclePriorityManager1.getBike(i)+" ");
        }
        System.out.println("########################");
    }

    static void test3(){
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

        Vertex v8 = new Vertex("diem1");
        Vertex v9 = new Vertex("diem2");
        Vertex v10 = new Vertex("diem3");
        Vertex v11 = new Vertex("diem4");
        Vertex v12 = new Vertex("diem5");
        Vertex v13 = new Vertex("diem6");
        Vertex v14 = new Vertex("diem7");
        Vertex v15 = new Vertex("diem8");
        Vertex v16 = new Vertex("diem9");
        Vertex v17 = new Vertex("diem10");
        Vertex v18 = new Vertex("diem11");
        Vertex v19 = new Vertex("diem12");

        v1.addNeighbour(new Edge(300,v1,v8));
        v1.addNeighbour(new Edge(100,v1,v10));
        v1.addNeighbour(new Edge(280,v1,v13));

        v8.addNeighbour(new Edge(500,v8,v2));

        v2.addNeighbour(new Edge(170,v2,v9));

        v13.addNeighbour(new Edge(120,v13,v3));
        v13.addNeighbour(new Edge(250,v13,v12));

        v3.addNeighbour(new Edge(260,v3,v14));

        v14.addNeighbour(new Edge(600,v14,v15));
        v14.addNeighbour(new Edge(900,v14,v4));

        v15.addNeighbour(new Edge(420,v15,v7));
        v15.addNeighbour(new Edge(170,v15,v4));

        v7.addNeighbour(new Edge(550,v7,v11));

        v11.addNeighbour(new Edge(800,v11,v10));

        v12.addNeighbour(new Edge(320,v12,v6));

        v6.addNeighbour(new Edge(360,v6,v18));

        v18.addNeighbour(new Edge(270,v18,v19));

        v19.addNeighbour(new Edge(580,v19,v5));

        v5.addNeighbour(new Edge(380,v5,v17));

        v17.addNeighbour(new Edge(190,v17,v16));

        Dijkstra shortestPath = new Dijkstra();
        shortestPath.findTheShortestPath(v1);
        System.out.println("v1 đến v4: " + v4.getDistance());

        System.out.print("v1 đến v4: ");
        shortestPath.printList(v4);
        System.out.println();



    }
    public static void main(String[] args) {
        test3();
    }
}
