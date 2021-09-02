package unit_tests;

import config_management.ConfigManager;
import http_management.PostcodesHttpMgr;
import object_mapping.PostcodesDeserialiser;
import object_mapping.PostcodesJsonDTO;
import object_mapping.PostcodesRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PostcodesDesTest {
    private static PostcodesRequest postcodesRequest;
    private static PostcodesJsonDTO postcodeDto;

    @BeforeAll
    private static void setup() {
        if (ConfigManager.test_env().equals("file")) {
            postcodesRequest = new PostcodesDeserialiser().postcodeRequestData(new File(ConfigManager.
                    postcodeTestFileLocation()));
            postcodeDto = postcodesRequest.getResult();
        } else if (ConfigManager.test_env().equals("http")) {
            PostcodesHttpMgr postcodesHttpMgr = new PostcodesHttpMgr("G226LS");
            postcodesHttpMgr.makeUrlCall();
            postcodesRequest = new PostcodesDeserialiser().postcodeRequestData(postcodesHttpMgr.getResponseBody());
            postcodeDto = postcodesRequest.getResult();

        }

    }

    @Test
    public void getRequestStatusTest() {
        assertEquals(200, postcodesRequest.getStatus());
    }

    @Test
    public void getPostcodeTest() {
        assertEquals("G22 6LS", postcodeDto.getPostcode());
    }

    @Test
    public void getQualityTest() {
        assertEquals(1, postcodeDto.getQuality());
    }

    @Test
    public void getEastingsTest() {
        assertEquals(259083, postcodeDto.getEastings());
    }

    @Test
    public void getNorthingsTest() {
        assertEquals(668762, postcodeDto.getNorthings());
    }

    @Test
    public void getCountryTest() {
        assertEquals("Scotland", postcodeDto.getCountry());
    }

    @Test
    public void getNhsHaTest() {
        assertEquals("Greater Glasgow and Clyde", postcodeDto.getNhsHa());
    }

    @Test
    public void getLongitudeTest() {
        assertEquals(-4.254854, postcodeDto.getLongitude());
    }

    @Test
    public void getLatitudeTest() {
        assertEquals(55.891307, postcodeDto.getLatitude());
    }

    @Test
    public void getElectoralRegionTest() {
        assertEquals("Scotland", postcodeDto.getEuropeanElectoralRegion());
    }

    @Test
    public void getPrimaryCareTrustTest() {
        assertEquals("Glasgow City Community Health Partnership",
                postcodeDto.getPrimaryCareTrust());
    }

    @Test
    public void getLsoaTest() {
        assertEquals("Possil Park - 03",
                postcodeDto.getLsoa());
    }

    @Test
    public void getMsoaTest() {
        assertEquals("Possil Park",
                postcodeDto.getMsoa());
    }

    @Test
    public void getIncodeTest() {
        assertEquals("6LS",
                postcodeDto.getIncode());
    }

    @Test
    public void getOutcodeTest() {
        assertEquals("G22",
                postcodeDto.getOutcode());
    }

    @Test
    public void getParliamentaryConstituencyTest() {
        assertEquals("Glasgow North East",
                postcodeDto.getParliamentaryConstituency());
    }


    @Test
    public void getAdminDistrictTest() {
        assertEquals("Glasgow City",
                postcodeDto.getAdminDistrict());
    }

    @Test
    public void getAdminWardTest() {
        assertEquals("Canal",
                postcodeDto.getAdminWard());
    }

    @Test
    public void getCcgTest() {
        assertEquals("Glasgow City Community Health Partnership",
                postcodeDto.getCcg());
    }

    @Test
    public void getNutsTest() {
        assertEquals("Glasgow City",
                postcodeDto.getNuts());
    }

    @Test
    public void getCodes() {
        HashMap<String, String> codesMap = new HashMap<>();

        codesMap.put("admin_district", "S12000049");
        codesMap.put("admin_county", "S99999999");
        codesMap.put("admin_ward", "S13002982");
        codesMap.put("parish", "S99999999");
        codesMap.put("parliamentary_constituency", "S14000032");
        codesMap.put("ccg", "S03000043");
        codesMap.put("ccg_id", "043");
        codesMap.put("ced", "S99999999");
        codesMap.put("nuts", "TLM82");
        codesMap.put("lsoa", "S01010325");
        codesMap.put("msoa", "S02001942");
        codesMap.put("lau2", "S30000019");

        Map<String, String> sortedCodes = new TreeMap<>(codesMap);
        Map<String, String> responseMap = new TreeMap<>(postcodeDto.getCodes());
        assertEquals(sortedCodes, responseMap);


    }


}
