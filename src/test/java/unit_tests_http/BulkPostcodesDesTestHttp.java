package unit_tests_http;

import http_management.BulkPostcodesHttpManager;
import object_mapping.PostcodesDeserialiser;
import object_mapping.data_transfer_objects.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BulkPostcodesDesTestHttp {
    private static BulkPostcodesDto requestDto;
    private static List<QueryDto> postcodeDto;

    @BeforeAll
    private static void setup() {
            BulkPostcodesHttpManager bulkPostcodesHttpManager = new
                    BulkPostcodesHttpManager(new String[] {"G335HX", "M320JG"});
            bulkPostcodesHttpManager.makeUrlCall();
            requestDto = new PostcodesDeserialiser<>(BulkPostcodesDto.class).
                    postcodeRequestData(bulkPostcodesHttpManager.getResponseBody());
            postcodeDto = requestDto.getResult();

        }


    @Test
    public void getRequestStatusTest() {
        assertEquals(200, requestDto.getStatus());
    }

    @Test
    public void getQueryResponseSizeTest(){
        assertEquals(2, postcodeDto.size());
    }

    @Test

    public void getPostcodesFromQueryTest(){
        assertEquals( "G33 5HX", postcodeDto.get(0).getResult().getPostcode());
        assertEquals( "M32 0JG", postcodeDto.get(1).getResult().getPostcode());

    }


}
