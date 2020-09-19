package pl.sobocinska.sugarplus.sugar;

import org.hibernate.validator.constraints.Length;
import pl.sobocinska.sugarplus.users.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "sugars")
public class Sugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Poziom cukru jest wymagany.")
    @Length(min = 2, max = 3)
    private int value;

    private LocalDate date;
    private LocalTime time;

    @ManyToOne
    private User user;

    @PositiveOrZero(message = "Podano złą ilość.")
    private double correctionForHypo;
    @PositiveOrZero(message = "Podano złą ilość.")
    private double carbohydratesInMeal;
    @PositiveOrZero(message = "Podano złą ilość.")
    private double bolusForMeal;
    boolean physicalActivity;

}
