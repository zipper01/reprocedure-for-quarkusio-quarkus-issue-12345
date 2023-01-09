package test.mavenproject6;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

@JsonDeserialize(using = Subscriber.Deserializer.class)

public class Subscriber {

    public String name;
    public String password;

    public Subscriber(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public static class Deserializer extends StdDeserializer<Subscriber> {

        public Deserializer() {
            super(Subscriber.class);
            //this(null);
        }

        public Deserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public Subscriber deserialize(JsonParser jp, DeserializationContext ctx)
                throws IOException, JsonProcessingException {
            JsonNode node = jp.getCodec().readTree(jp);
            if (node.isEmpty()) {
                return null;
            }
            JsonNode v = node.get("name");
            String name = v == null ? null : v.asText(null);
            v = node.get("password");
            String password = v == null ? null : v.asText(null);
            return new Subscriber(name, password);
        }
    }

}
