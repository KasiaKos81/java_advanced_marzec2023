package lab.zoo;

import lab.dynamic.Positive;
import lombok.*;
import lombok.extern.slf4j.Slf4j;


//@ToString
//@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j

public abstract class Animal {

    private String name;
    @Positive(value = 300, max=500)
    @javax.validation.constraints.Positive
    private int mass;


    public void eat(String food) {
        log.info("{} is eating {}", name, food);
    }

    public abstract void move();


}


