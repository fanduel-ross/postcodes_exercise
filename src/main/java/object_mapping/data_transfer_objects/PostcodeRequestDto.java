package object_mapping.data_transfer_objects;

public class PostcodeRequestDto extends RequestDto {
    private PostcodesJsonDTO result;

    public PostcodesJsonDTO getResult() {
        return result;
    }
}
