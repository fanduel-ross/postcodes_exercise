package object_mapping;
import com.fasterxml.jackson.databind.ObjectMapper;
import object_mapping.data_transfer_objects.RequestDto;

import java.io.File;
import java.io.IOException;

public class PostcodesDeserialiser<T extends RequestDto> {


    private final ObjectMapper mapper = new ObjectMapper();
    private final Class<T> type;

    public PostcodesDeserialiser(Class<T> type) {
        this.type = type;
    }

    public T postcodeRequestData(File jsonFileLocation) {
        try {
            return mapper.readValue(jsonFileLocation, this.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public T postcodeRequestData(String jsonString) {
        try {
            return mapper.readValue(jsonString, this.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}

