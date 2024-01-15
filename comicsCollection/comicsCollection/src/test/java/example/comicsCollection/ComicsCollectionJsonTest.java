package example.comicsCollection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

/*
* @JsonTest indique que la classe ComicsCollectionTest utilise le framework Jackson (qui est déjà inclu dans Spring)
* JacksonTester<T> est un wrapper de la bibliothèque de parsing Jackson JSON. Il gère la sérialisation et la désérialisation
* des objets JSON
* */
@JsonTest
public class ComicsCollectionJsonTest {

    /*
    * @Autowired dit à Spring de tester un objet du type attendu
    * */
    @Autowired
    private JacksonTester<ComicsCollection> json;


    /*
    * @Test fait parti de la bibliothèque JUnit
    * */
    @Test
    void comicsCollectionSerializationTest() throws IOException {
        Comics comics = new Comics(1L, "Batman return");
        ComicsCollection comicsCollection = new ComicsCollection(99L, comics);
        assertThat(json.write(comicsCollection)).isStrictlyEqualToJson("expected.json");

        assertThat(json.write(comicsCollection)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(comicsCollection)).extractingJsonPathNumberValue("@.id")
                .isEqualTo(99);

        assertThat(json.write(comicsCollection)).hasJsonPath("@.comics");
        assertThat(json.write(comicsCollection)).extractingJsonPathValue("@.comics.id").isEqualTo(1);
        assertThat(json.write(comicsCollection)).extractingJsonPathValue("@.comics.title").isEqualTo("Batman return");

    }
}
