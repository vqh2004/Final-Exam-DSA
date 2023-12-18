package BICYCLE_MANAGEMENT;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer {
    private String name;
    private int idName;
    private static final String ID_FORMAT = "2200%4d";
    private Ticket currentTicket;
    private LocalTime bicycleRentalTime; //thoi gian den lay xe thue
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

    public Ticket getCurrentTicket() {
        return currentTicket;
    }

    public void buyTicketForHour(int hours) {
        if (checkTimeForRent(hours)) {
            Ticket ticket = new Ticket();
            this.currentTicket = ticket.createTicketForHour(hours);
            System.out.println("Buy hour ticket successful!!!!!");
        } else {
            System.out.println("We only rent bikes for the day, please check the time you entering to buy hour ticket!!!");
        }
    }

    public boolean checkTimeForRent(int hours) {
        LocalDateTime current = LocalDateTime.now();
        LocalDateTime checkValid = current.plusHours(hours);
        if (current.getDayOfWeek().equals(checkValid.getDayOfWeek())) {
            return true;
        } else {
            return false;
        }
    }

    public void buyTicketForDaily() {
        Ticket ticket = new Ticket();
        this.currentTicket = ticket.createTicketForDaily();
        System.out.println("Buy daily ticket successful!!!!!");
    }

    public void rentBicycle(Station station) {
        LocalTime currentTime = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
        // Check if customer hasn't tickets or ticket is expired
        if (this.currentTicket == null) {
            System.out.println("Please buy a new ticket before renting !!!");
        } else if (this.currentTicket.isExpired(currentTime)) {
            System.out.println("Your rental period has expired, please buy a new ticket !!!");
        } else {
            this.bicycleRented = station.rentBicycle();
            // Renting success
            this.bicycleRentalTime = currentTime;
            // update bicycle time traveled
//            Duration duration = Duration.between(bicycleRentalTime, currentTicket.getValidTime());
//            long updateTime = duration.getSeconds();
//            double traveledHours = updateTime * 1.0 / 60 / 60;
//            this.bicycleRented.updateTraveledTime(traveledHours);
            System.out.print("RENTING SUCCESS!!!!");
//            System.out.println("Time available: " + currentTicket.getValidTime());
            System.out.println("Rented bike with running time: " + this.bicycleRented.getTimeTraveled()); // print time traveled of bicycle
            station.getCustomerList().add(this);
            station.updateRevenue(this.currentTicket.getPrice());
        }
    }

    public void returnBicycle(Station station) {
        LocalTime currentTime = LocalTime.now().truncatedTo(ChronoUnit.MINUTES).plusHours(4).plusMinutes(20);
//        System.out.println("Time to return bike: " + currentTime);
        if (this.currentTicket == null) {
            System.out.println("There is no bike to return");
        } else {
            // check expired ticket
            if (!this.currentTicket.isExpired(currentTime)) {
//                System.out.println("The current ticket has not expired. Do you want to return the bike?\n" +
//                        "Yes : Please enter 1.\n" +
//                        "No : Please enter 0 to exit.");
//                Scanner sc = new Scanner(System.in);
//                int choose = sc.nextInt();
//                if (choose == 1) {
//                    station.insertBicycle(this.bicycleRented);
//                } else if (choose == 0) {
//                    return;
//                } else {
//                    System.out.println("Please choose your option!!");
//                }
                Duration duration = Duration.between(currentTicket.getPurchaseTime(), currentTime);
                //lay ra su chenh lech giua khoang thoi gian thue xe va thoi gian ve con han
                long updateTime = duration.getSeconds();
                double traveledHours = updateTime * 1.0 / 60 / 60;
                this.bicycleRented.updateTraveledTime(traveledHours); // update thoi gian di chinh xac cua xe
                station.insertBicycle(this.bicycleRented);
                System.out.println("Return successful!!!");
                station.getCustomerList().remove(this);
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
//                    this.bicycleRented.updateTraveledTime(hours+(minutes*1.0/60));
//                    System.out.println("You need to pay extra: " + new FormatMoney(extraMoney).format());
                    station.getCustomerList().remove(this);
                    station.updateRevenue(extraMoney);
                }
            }
        }
    }


    // to extend ticket validity
    public void renewalTicket(int extraHours) {
        if (checkTimeForRent(extraHours) && this.currentTicket != null && this.currentTicket.isHourTicket()) {
            this.currentTicket.getValidTime().plusHours(extraHours);
            System.out.println("Your new valid time: " + this.currentTicket.getValidTime());
        } else if(this.currentTicket != null && !this.currentTicket.isHourTicket()){
            System.out.println("Ve cua ban la ve ngay nen khong can gia han ve trong hom nay!!!!");
        } else {
            System.out.println("Check time you entering when extending ticket please!!!");
        }
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

            return "#########TICKET INFORMATION#########\n" +
                    "ID: " + this.idName +
                    "\nName: " + this.name +
                    "\nTicket Type: " + ticketType +
                    "\nTicket Price: " + new FormatMoney(ticketPrice).format() +
                    "\nPurchase Time: " + this.currentTicket.getPurchaseTime() +
                    "\nValid Until: " + this.currentTicket.getValidTime() + "\n" +
                    "#####################################";
        }
        return "No ticket purchased yet.";
    }
}
