package BICYCLE_MANAGEMENT;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private BicyclePriorityManager station;
    private String name;

    private List<Customer> customerList;
    private double revenue; //doanh thu

    public Station(String name) {
        this.station = new BicyclePriorityManager();
        this.name = name;
        this.customerList=new ArrayList<>();
        revenue =0;
    }

    public Station(BicyclePriorityManager station, String name) {
        this.station = station;
        this.name = name;
        this.customerList=new ArrayList<>();
        revenue=0;
    }

    public void insertBicycle(Bicycle bicycle) {
        station.insert(bicycle);
    }

    public Bicycle rentBicycle() {
        return station.export();
    }

    public boolean isStationEmpty() {
        return station.isEmpty();
    }

    public String getName() {
        return name;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
    public void updateRevenue(double m){
        revenue+=m;
    }

    String getRevenue(){
        return new FormatMoney(revenue).format();
    }
    Customer hasCustomer(String name){
        for(Customer c : customerList){
            if(name.equals(c.getName())){
                return c;
            }
        }
        return null;
    }


    void printListCustomer(){
        if(customerList.isEmpty()){
            System.out.println("khong co khach hang nao!!!");
        } else{
            for (int i = 0; i < customerList.size(); i++) {
                System.out.println(customerList.get(i).getName());
            }
        }
    }

}
