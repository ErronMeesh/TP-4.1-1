package backend.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id", nullable = false)
    private Long flightId;

    @Column(name = "departure_p", nullable = false)
    private String departureP;

    @Column(name = "destination_p", nullable = false)
    private String destinationP;

    @Column(name = "departure_time", nullable = false)
    private Date departureTime;

    @Column(name = "destination_time", nullable = false)
    private Date destinationTime;
    
    @OneToOne
    @JoinColumn(name = "plane_id", referencedColumnName = "plane_id", nullable = false)
    private Plane planeId;

    @Column(name = "price_of_ec", nullable = false)
    private Float priceOfEc;

    @Column(name = "price_of_bc", nullable = false)
    private Float priceOfBc;

    public Flight() {
    }

    public Flight(String departureP, String destinationP, Date departureTime, Date destinationTime, Plane planeId, Float priceOfEc, Float priceOfBc) {
        this.departureP = departureP;
        this.destinationP = destinationP;
        this.departureTime = departureTime;
        this.destinationTime = destinationTime;
        this.planeId = planeId;
        this.priceOfEc = priceOfEc;
        this.priceOfBc = priceOfBc;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
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

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getDestinationTime() {
        return destinationTime;
    }

    public void setDestinationTime(Date destinationTime) {
        this.destinationTime = destinationTime;
    }

    public Plane getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Plane planeId) {
        this.planeId = planeId;
    }

    public Float getPriceOfEc() {
        return priceOfEc;
    }

    public void setPriceOfEc(Float priceOfEc) {
        this.priceOfEc = priceOfEc;
    }

    public Float getPriceOfBc() {
        return priceOfBc;
    }

    public void setPriceOfBc(Float priceOfBc) {
        this.priceOfBc = priceOfBc;
    }
}
