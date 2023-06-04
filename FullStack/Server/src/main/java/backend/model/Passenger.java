package backend.model;

import javax.persistence.*;

@Entity
@Table(name = "Passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id", nullable = false)
    private Long passengerId;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "doc_series", nullable = false)
    private String docSeries;

    @Column(name = "doc_num", nullable = false)
    private String docNum;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User userId;

//    @OneToOne
//    @JoinColumn(name = "ticket_number", referencedColumnName = "ticket_number", nullable = false)
//    private Ticket ticketNumber;

    public Passenger() {
    }

//    public Passenger(String surname, String name, String lastname, String phoneNumber, String mail, String docSeries, String docNum, User userId, Ticket ticketNumber) {
//        this.surname = surname;
//        this.name = name;
//        this.lastname = lastname;
//        this.phoneNumber = phoneNumber;
//        this.mail = mail;
//        this.docSeries = docSeries;
//        this.docNum = docNum;
//        this.userId = userId;
//        this.ticketNumber = ticketNumber;
//    }

    public Passenger(String surname, String name, String lastname, String phoneNumber, String mail, String docSeries, String docNum, User userId) {
        this.surname = surname;
        this.name = name;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.docSeries = docSeries;
        this.docNum = docNum;
        this.userId = userId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDocSeries() {
        return docSeries;
    }

    public void setDocSeries(String docSeries) {
        this.docSeries = docSeries;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

//    public Ticket getTicketNumber() {
//        return ticketNumber;
//    }
//
//    public void setTicketNumber(Ticket ticketNumber) {
//        this.ticketNumber = ticketNumber;
//    }
}
