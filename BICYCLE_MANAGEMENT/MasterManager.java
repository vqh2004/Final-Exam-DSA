package BICYCLE_MANAGEMENT;
import java.util.*;
public class MasterManager {
    List<Station> stationList;
    private List<Customer> customerMasterList;

    double revenueMaster; //doanh thu

    public MasterManager() {
        this.stationList = new ArrayList<>();
        this.customerMasterList = new ArrayList<>();
        revenueMaster=0;
    }

    public void addStation(Station station){
        stationList.add(station);
    }
    public void addCustomer(Customer c){
        if(c.getCurrentTicket()!=null){
            customerMasterList.add(c);
            this.revenueMaster+=c.getCurrentTicket().getPrice();
        }
    }
    Customer hasCustomer(String name){
        for(Customer c : customerMasterList){
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }

    public List<Station> getStationList() {
        return stationList;
    }

    public List<Customer> getCustomerMasterList() {
        return customerMasterList;
    }

    public double getRevenueMaster() {
        return revenueMaster;
    }
}
