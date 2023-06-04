package backend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "History_of_orders")
public class HistoryOfOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User userId;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "departure_time", nullable = false)
    private Date departureTime;

    @Column(name = "departure_p", nullable = false)
    private String departureP;

    @Column(name = "destination_p", nullable = false)
    private String destinationP;

    @Column(name = "flight_id", nullable = false)
    private Long flightId;

    public HistoryOfOrders() {
    }

    public HistoryOfOrders(User userId, Float price, Date departureTime, String departureP, String destinationP, Long flightId) {
        this.userId = userId;
        this.price = price;
        this.departureTime = departureTime;
        this.departureP = departureP;
        this.destinationP = destinationP;
        this.flightId = flightId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureP() {
        return departureP;
    }

    public void setDepartureP(String departureP) {
        this.departureP = departureP;
    }

    public String getDestinationP() {
        return destinationP;
    }

    public void setDestinationP(String destinationP) {
        this.destinationP = destinationP;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }
}
