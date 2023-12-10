package BICYCLE_MANAGEMENT;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
    private String name;
    private int idName;
    private static final String ID_FORMAT = "2200%4d";
    private Ticket currentTicket;
    private LocalTime bicycleRentalTime;
    private Bicycle bicycleRented;
    private static AtomicInteger idCounter = new AtomicInteger(22000000);

    public Customer(String name) {
        this.name = name;
        this.idName = generateUniqueId();
    }

    // Function to create an unique Id for each customer;
    private int generateUniqueId() {
        return idCounter.getAndIncrement();
    }

    public void buyTicketForHour(int time) {
        Ticket ticket = new Ticket();
        this.currentTicket = ticket.createTicketForHour(time);
    }

    public void buyTicketForDaily() {
        Ticket ticket = new Ticket();
        this.currentTicket = ticket.createTicketForDaily();
    }

    public void rentBicycle(Station station) {
        LocalTime currentTime = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
        // Check if customer hasn't tickets or ticket is expired
        if (this.currentTicket == null) {
            System.out.println("Please purchase a new ticket !!!");
        } else if (this.currentTicket.isExpired(currentTime)) {
            System.out.println("Your rental period has expired, please purchase a new ticket !!!");
        } else {
            this.bicycleRented = station.rentBicycle();
            // Renting success
            this.bicycleRentalTime = currentTime;
            // update bicycle time traveled
            Duration duration = Duration.between(bicycleRentalTime, currentTicket.getValidTime());
            long updateTime = duration.getSeconds();
            System.out.println("Renting success");
            System.out.println("Time available: " + currentTicket.getValidTime());
            System.out.println("Rented bike with running time: " + this.bicycleRented.getTimeTraveled()); // print time traveled of bicycle
        }
    }

    public void returnBicycle(Station station) {
        LocalTime currentTime = LocalTime.now().truncatedTo(ChronoUnit.MINUTES).plusHours(4).plusMinutes(20);
        System.out.println("Time to return bike: " + currentTime);
        if (this.currentTicket == null) {
            System.out.println("There is no car to return");
        } else {
            // check expired ticket
            if (!this.currentTicket.isExpired(currentTime)) {
                System.out.println("The current ticket has not expired. Do you want to return the car?\n" +
                        "Yes : Please enter 1.\n" +
                        "No : Please enter 0 to exit.\n");
                Scanner sc = new Scanner(System.in);
                int choose = sc.nextInt();
                if (choose == 1) {
                    station.insertBicycle(this.bicycleRented);
                } else if (choose == 0) {
                    return;
                } else {
                    System.out.println("Please choose your option!!");
                }
            } else {
                station.insertBicycle(this.bicycleRented);
                Duration ticketDuration = Duration.between(currentTicket.getPurchaseTime(), currentTime);
                if (ticketDuration.toHours() < 0) {
                    ticketDuration.plusHours(24);
                }
                Duration maxDuration = Duration.between(currentTicket.getPurchaseTime(), currentTicket.getValidTime());
                if (ticketDuration.compareTo(maxDuration) > 0) {
                    Duration overdue = ticketDuration.minus(maxDuration);
                    long hours = overdue.toHours();
                    long minutes = overdue.toMinutes() % 60;
                    System.out.println("The ticket is overdue: " + hours + " hours, " + minutes + " minutes");
                    double extraMoney = ((hours + (minutes * 1.0 / 60)) * this.currentTicket.TICKET_FOR_HOUR);
                    System.out.println("You need to pay extra: " + new FormatMoney(extraMoney).format());
                }
            }
        }
    }


    // to extend ticket validity
    public void renewalTicket(int time) {
        renewalTicket(time);
    }

    public String getName() {
        return name;
    }

    public int getIdName() {
        return idName;
    }

    public String getCurrentTicketInfor() {
        if (this.currentTicket != null) {
            String ticketType = "";
            int ticketPrice = this.currentTicket.getPrice();
            if (this.currentTicket.getValidTime().equals(LocalTime.MAX)) {
                ticketType = "Daily Ticket";
            } else {
                ticketType = "Hourly Ticket";
            }

            return "ID: " + this.idName +
                    "\nName: " + this.name +
                    "\nTicket Type: " + ticketType +
                    "\nTicket Price: "+ new FormatMoney(ticketPrice).format()+
                    "\nPurchase Time: " + this.currentTicket.getPurchaseTime() +
                    "\nValid Until: " + this.currentTicket.getValidTime();
        }
        return "No ticket purchased yet.";
    }


//    public static void main(String[] args) {
//
//        Customer customer = new Customer("Vu quang huy");
//        Customer customer1 = new Customer("vu wusn huy");
//        System.out.println(customer.getIdName());
//        System.out.println(customer1.getIdName());
//        customer.buyTicketForHour(2);
//        customer1.buyTicketForDaily();
//        System.out.println(customer.getCurrentTicketInfor());
//        System.out.println(customer1.getCurrentTicketInfor());
//    }
}
