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
    * @Autowired dit à Spring de créer un objet du type attendu
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

    @Test
    void comicsCollectionDeserialization() throws IOException {
        final String expected = """
                {
                "id": 2,
                "comics":
                    {
                        "id" : 89,
                        "title": "Batman year one"
                    }
                }
                """;
        assertThat(json.parse(expected)).isEqualTo(new ComicsCollection(2L,  new Comics(89L, "Batman year one")));
    }
}
