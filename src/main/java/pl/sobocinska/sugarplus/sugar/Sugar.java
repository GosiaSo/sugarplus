package pl.sobocinska.sugarplus.sugar;

import pl.sobocinska.sugarplus.users.User;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "sugars")
public class Sugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Poziom cukru musi zawierać się w przedziale {min} i {max}.")
    @Min(20)
    @Max(700)
    private Integer value;

    private LocalDate date = LocalDate.now();
    private LocalTime time = LocalTime.now();

    @ManyToOne
    private User user;

    @PositiveOrZero(message = "Podano złą ilość.")
    private double correctionForHypo;
    @PositiveOrZero(message = "Podano złą ilość.")
    private double carbohydratesInMeal;
    @PositiveOrZero(message = "Podano złą ilość.")
    private double bolusForMeal;
    boolean physicalActivity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getCorrectionForHypo() {
        return correctionForHypo;
    }

    public void setCorrectionForHypo(double correctionForHypo) {
        this.correctionForHypo = correctionForHypo;
    }

    public double getCarbohydratesInMeal() {
        return carbohydratesInMeal;
    }

    public void setCarbohydratesInMeal(double carbohydratesInMeal) {
        this.carbohydratesInMeal = carbohydratesInMeal;
    }

    public double getBolusForMeal() {
        return bolusForMeal;
    }

    public void setBolusForMeal(double bolusForMeal) {
        this.bolusForMeal = bolusForMeal;
    }

    public boolean isPhysicalActivity() {
        return physicalActivity;
    }

    public void setPhysicalActivity(boolean physicalActivity) {
        this.physicalActivity = physicalActivity;
    }
}
