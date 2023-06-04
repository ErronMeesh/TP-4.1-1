package backend.model;

import javax.persistence.*;


@Entity
@Table(name = "Ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_number", nullable = false)
    private Long ticketNumber;

    @Column(name = "flight_id")
    private Long flightId;

    @Column(name = "business_c", nullable = false)
    private Boolean businessC;

    @Column(name = "price", nullable = false)
    private Float price;

    @OneToOne
    @JoinColumn(name = "passenger_id", referencedColumnName = "passenger_id", nullable = false)
    private Passenger passengerId;

    public Ticket() {
    }

    public Ticket(Long flightId, Boolean businessC, Float price, Passenger passengerId) {
        this.flightId = flightId;
        this.businessC = businessC;
        this.price = price;
        this.passengerId = passengerId;
    }

    public Ticket(Long flightId, Boolean businessC, Float price) {
        this.flightId = flightId;
        this.businessC = businessC;
        this.price = price;
    }

    public Long getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Long ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Boolean getBusinessC() {
        return businessC;
    }

    public void setBusinessC(Boolean businessC) {
        this.businessC = businessC;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Passenger getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Passenger passengerId) {
        this.passengerId = passengerId;
    }
}
