package object_mapping.data_transfer_objects;

import java.util.List;

public class BulkPostcodesDto extends RequestDto {
    private List<QueryDto> result;

    public List<QueryDto> getResult() {
        return result;
    }
}

