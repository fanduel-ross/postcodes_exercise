package object_mapping.data_transfer_objects;

public class QueryDto {
    private String query;
    private PostcodesJsonDTO result;

    public String getQuery() {
        return query;
    }

    public PostcodesJsonDTO getResult() {
        return result;
    }
}