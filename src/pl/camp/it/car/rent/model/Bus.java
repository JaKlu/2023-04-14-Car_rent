package pl.camp.it.car.rent.model;

public class Bus extends Vehicle {

    private int seats;
    private boolean ticketMachine;

    public Bus(String brand, String model, int year, double price, String plate, int seats, boolean ticketMachine) {
        super(brand, model, year, price, plate);
        this.seats = seats;
        this.ticketMachine = ticketMachine;
    }

    public Bus(String[] vars) {
        super(vars);
        this.seats = Integer.parseInt(vars[6]);
        this.ticketMachine = Boolean.parseBoolean(vars[7]);
    }

    public Bus() {
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean isTicketMachine() {
        return ticketMachine;
    }

    public void setTicketMachine(boolean ticketMachine) {
        this.ticketMachine = ticketMachine;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Bus -> ")
                .append(super.toString())
                .append(" Ilość miejsc: ")
                .append(this.seats)
                .append(" Biletomat: ")
                .append(this.ticketMachine ? "Tak" : "Nie").toString();
    }

    @Override
    public String toCSV() {
        return new StringBuilder(super.toCSV())
                .append(";")
                .append(this.seats)
                .append(";")
                .append(this.ticketMachine).toString();
    }
}
