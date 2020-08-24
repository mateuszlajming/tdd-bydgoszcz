package d_assertj_solution;

import d_assertj.Animal;
import d_assertj.Zoo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ZooTest {

    Zoo zoo;

    @BeforeEach
    public void before() {
        zoo = new Zoo();
    }

    @Test
    public void zoo_whenCreatingAZoo_itShouldBeEmpty() {
        assertThat(zoo.getAllAnimals()).isEmpty();
    }

    @Test
    public void zoo_whenAddingOneAnimal_thereShouldBeOneAndOnlyOneAnimalInTheZoo() {
        Animal jan = new Animal("Jan");
        zoo.addAnimal(jan);

        assertThat(zoo.getAllAnimals()).containsExactly(jan);
    }

    @Test
    public void zoo_whenGeneratingFunnyName_itShouldBeEqual() {
        String funnyName = zoo.generateFunnyName(new Animal("Anastazja"));

        assertThat(funnyName).isEqualToIgnoringCase("Anastazja");
    }

    @Test
    public void zoo_whenGeneratingNameWithPrefix_shouldReturnNameWithPrefixAtTheBeginningAndNameAtTheEnd() {
        String nameWithPrefix = zoo.generateNameWithPrefix(new Animal("Adam"));

        assertThat(nameWithPrefix)
            .endsWith("Adam")
            .startsWith("Zwierzątko");
    }

}
