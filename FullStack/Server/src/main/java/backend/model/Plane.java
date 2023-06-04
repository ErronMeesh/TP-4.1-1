package backend.model;

import javax.persistence.*;

@Entity
//название таблицы (как будет записано в БД)
@Table(name = "Plane")
public class Plane {
    // PrimaryKey
    @Id
    // генерируемое значение
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // параметры колонки таблицы (имя, notNull)
    @Column(name = "plane_id", nullable = false)
    private Long planeId;

    @Column(name = "plane_name", nullable = false)
    private String planeName;

    @Column(name = "num_of_ec_seats", nullable = false)
    private Integer numOfEcSeats;

    @Column(name = "num_of_bc_seats", nullable = false)
    private Integer numOfBcSeats;

    public Plane() {
    }

    // конструктор
    public Plane(String plane_name, Integer num_of_ec_seats, Integer num_of_bc_seats) {
        this.planeName = plane_name;
        this.numOfEcSeats = num_of_ec_seats;
        this.numOfBcSeats = num_of_bc_seats;
    }

    // все необходимые get/set методы
    public Long getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Long planeId) {
        this.planeId = planeId;
    }

    public String getPlaneName() {
        return planeName;
    }

    public void setPlaneName(String planeName) {
        this.planeName = planeName;
    }

    public Integer getNumOfEcSeats() {
        return numOfEcSeats;
    }

    public void setNumOfEcSeats(Integer numOfEcSeats) {
        this.numOfEcSeats = numOfEcSeats;
    }

    public Integer getNumOfBcSeats() {
        return numOfBcSeats;
    }

    public void setNumOfBcSeats(Integer numOfBcSeats) {
        this.numOfBcSeats = numOfBcSeats;
    }
}
