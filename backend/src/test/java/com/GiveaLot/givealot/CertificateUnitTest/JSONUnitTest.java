package com.GiveaLot.givealot.CertificateUnitTest;


import com.GiveaLot.givealot.Certificate.JSONHelper;
import com.GiveaLot.givealot.Certificate.JSONHelperInterface;
import com.GiveaLot.givealot.Certificate.JSONService;
import com.GiveaLot.givealot.Certificate.JSONServiceImpl;
import com.GiveaLot.givealot.Certificate.dataclass.JSON;
import com.GiveaLot.givealot.Certificate.exceptions.InvalidRequestException;
import com.GiveaLot.givealot.Certificate.exceptions.JSONException;
import com.GiveaLot.givealot.Certificate.rri.createJSONRequest;
import com.GiveaLot.givealot.Certificate.rri.createJSONResponse;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class JSONUnitTest {

    @InjectMocks
    JSONServiceImpl jsonServiceImpl = new JSONServiceImpl();

    JSONHelper jsonHelper;
    JSONHelperInterface jsonHelperInt;

    createJSONRequest request1;
    createJSONRequest request2;
    createJSONRequest request3;

    createJSONResponse response1;
    createJSONResponse response2;

    JSON jObj1;
    JSON jObj2;

    String jsonString;
    String jString1;

    @Mock
    JSONService jsonService;



    @BeforeEach
    void setUp() throws Exception {

        jsonHelper = new JSONHelper();


        request1=null;
        request2= new createJSONRequest("The Organisation", "Some description", "www.website.com", "www.image.com");
        request3= new createJSONRequest("The Organisation", "Some description", "www.website.com", "www.image.com");
        jObj1= new JSON();
        jObj2 = new JSON(request2.name,request2.description,request2.serverUrl,request2.imageUrl);

        jsonString = "";

        jString1 = jsonHelper.createJSONObject(jObj2);

        response1 = jsonServiceImpl.createJSON(request2);

        //response2 = jsonService.createJSON(request3);

    }

    @Test
    @Description("Assumes that the createJSON Request is null")
    void TEST_SHOULD_RETURN_INVALID_REQUEST_EXCEPTION(){
        Throwable throwError = assertThrows(InvalidRequestException.class, () -> jsonServiceImpl.createJSON(request1));
        assertEquals("Exception: JSON could not be created because the request object is null", throwError.getMessage());
    }

    @Test
    @Description("Assumes that the JSON object is default")
    void TEST_SHOULD_RETURN_JSON_EXCEPTION(){
        Throwable throwError = assertThrows(JSONException.class, () -> jsonHelper.createJSONObject(jObj1));
        assertEquals("Exception: JSON data is null", throwError.getMessage());
    }

//    @Test
//    @Description("Assumes that the JSON object file is already open")
//    void TEST_CANNOT_WRITE_OVER_FILE(){
//        Throwable throwError = assertThrows(JSONException.class, () -> jsonHelper.createFile(jsonHelper.createJSONObject(jObj2)));
//        assertEquals("JSON file is cannot be written over when open", throwError.getMessage());
//    }
    @Test
    @Description("Assumes that the JSON object passed is empty")
    void TEST_EMPTY_JSON_OBJECT(){
        Throwable throwError = assertThrows(JSONException.class, () -> jsonHelper.createFile(jsonString));
        assertEquals("Exception: Empty JSON object", throwError.getMessage());
    }

//    @Test
//    @Description("Assumes that the returned object is the correct json response")
//    void TEST_RETURNS_JSON_STRING() throws JSONException {
//        when(jsonHelper.createJSONObject(jObj2)).thenReturn("{\"name\":\"Child Welfare\", \"description\":\"Kids are the heart of the world\", \"serverUrl\":\"https://server.com/Certificate/ChildWelfare.pdf\", \"verificationCode\":\"A5414B58A9AB30702B9B12967FB48C12\", \"imageUrl\" :\"https://server.com/Image/ChildWelfare.png\"}");
//        //Assert.assertEquals();
//    }

    @Test
    @Description("Assumes that the returned object is the correct json string")
    void TEST_RETURNS_JSON_OBJECT() throws JSONException {
        assertEquals(jsonHelper.createJSONObject(jObj2),jString1);
    }

}
