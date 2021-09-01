package unit_tests;
import config_management.ConfigManager;
import http_management.PostcodesHttpMgr;
import object_mapping.PostcodesDeserialiser;
import object_mapping.PostcodesJsonDTO;
import object_mapping.PostcodesRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PostcodesDesTest {
    private static PostcodesRequest postcodesRequest;
    private static PostcodesJsonDTO postcodeDto;

    @BeforeAll
    private static void setup(){
        if (ConfigManager.test_env().equals("file")) {
            postcodesRequest = new PostcodesDeserialiser().postcodeRequestData(new File(ConfigManager.
                    postcodeTestFileLocation()));
            postcodeDto = postcodesRequest.getResult();
        } else if (ConfigManager.test_env().equals("http")){
            PostcodesHttpMgr postcodesHttpMgr = new PostcodesHttpMgr("G226LS");
            postcodesHttpMgr.makeUrlCall();
            postcodesRequest = new PostcodesDeserialiser().postcodeRequestData(postcodesHttpMgr.getResponseBody());
            postcodeDto = postcodesRequest.getResult();

        }

    }

    @Test
    public void getRequestStatusTest(){
        assertEquals( 200, postcodesRequest.getStatus());
    }

    @Test
    public void getPostcodeTest(){
        assertEquals( "G22 6LS", postcodeDto.getPostcode());
    }

    @Test
    public void getQualityTest(){
        assertEquals( 1, postcodeDto.getQuality());
    }

    @Test
    public void getEastingsTest(){
        assertEquals( 259083, postcodeDto.getEastings());
    }

    @Test
    public void getNorthingsTest(){
        assertEquals( 668762, postcodeDto.getNorthings());
    }

    @Test
    public void getCountryTest(){
        assertEquals( "Scotland", postcodeDto.getCountry());
    }

    @Test
    public void getNhsHaTest(){
        assertEquals( "Greater Glasgow and Clyde", postcodeDto.getNhsHa());
    }

    @Test
    public void getLongitudeTest(){
        assertEquals( -4.254854, postcodeDto.getLongitude());
    }





}
