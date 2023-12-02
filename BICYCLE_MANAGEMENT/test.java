package BICYCLE_MANAGEMENT;

import java.time.LocalTime;

public class test {
    public static void main(String[] args) {
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
        customer1.rentBicycle(customer1, station1 );
        Customer customer2 = new Customer("Vu quang huy");
        customer2.rentBicycle(customer2, station1);
        customer1.returnBicycle(customer1,station1);

    }
}
