package backend.model;

import javax.persistence.*;

@Entity
@Table(name = "Discount")
public class Discount {
    @Id
    @Column(name = "promo_code", nullable = false)
    private String promoCode;

    @Column(name = "size", nullable = false)
    private Integer size;

    public Discount() {
    }

    public Discount(String promoCode, Integer size) {
        this.promoCode = promoCode;
        this.size = size;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
