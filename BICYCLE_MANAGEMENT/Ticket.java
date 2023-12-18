package BICYCLE_MANAGEMENT;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Ticket {
    private LocalTime purchaseTime; // time when customer buy ticket
    private LocalTime validTime; // time validity
    private int price; // Ticket price
    protected final int TICKET_FOR_HOUR = 20000;
    protected final int TICKET_FOR_DAILY = 150000;

    public Ticket createTicketForHour(int time) {
        Ticket ticket = new Ticket();
        ticket.purchaseTime = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
        ticket.validTime = ticket.purchaseTime.plusHours(time).truncatedTo(ChronoUnit.MINUTES);
        ticket.price = TICKET_FOR_HOUR * time;
        return ticket;
    }

    public boolean isHourTicket(){
//        System.out.println("####"+this.getClass().getName().equals("createTicketForHour"));
        if(this.getClass().getName().equals("createTicketForHour")){
            return true;
        } else{
            return false;
        }
    }

    public Ticket createTicketForDaily() {
        Ticket ticket = new Ticket();
        ticket.purchaseTime = LocalTime.now().truncatedTo(ChronoUnit.MINUTES);
        ticket.validTime = LocalTime.MAX.truncatedTo(ChronoUnit.MINUTES);
        ticket.price = TICKET_FOR_DAILY;
        return ticket;
    }

    // function to extend ticket validity
    public void extendValidity(int additionalHours) {
        this.validTime = this.validTime.plusHours(additionalHours);
    }

    public int getPrice() {
        return this.price;
    }

    public LocalTime getPurchaseTime() {
        return this.purchaseTime;
    }

    public LocalTime getValidTime() {
        return this.validTime;
    }

    public boolean isExpired(LocalTime currentTime) {
        return currentTime.isAfter(validTime);
    }
}
