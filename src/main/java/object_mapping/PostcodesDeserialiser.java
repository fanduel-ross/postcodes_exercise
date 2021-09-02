package object_mapping;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class PostcodesDeserialiser {
    private ObjectMapper mapper = new ObjectMapper();

    public PostcodesRequest postcodeRequestData(File jsonFileLocation) {
        try {
            return mapper.readValue(jsonFileLocation, PostcodesRequest.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PostcodesRequest postcodeRequestData(String jsonString) {
        try {
            return mapper.readValue(jsonString, PostcodesRequest.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
