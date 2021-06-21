package com.GiveaLot.givealot.BrowseUnitTest;

import com.GiveaLot.givealot.Browse.BrowseHelper;
import com.GiveaLot.givealot.Browse.BrowseServiceImp;
import com.GiveaLot.givealot.Browse.rri.browseRequest;
import com.GiveaLot.givealot.Browse.rri.browseResponse;
import com.GiveaLot.givealot.Report.ReportHelper;
import com.GiveaLot.givealot.Report.ReportServiceImpl;
import com.GiveaLot.givealot.Report.dataclass.Report;
import com.GiveaLot.givealot.Report.exceptions.InvalidRequestException;
import com.GiveaLot.givealot.Report.rri.createReportRequest;
import com.GiveaLot.givealot.Report.rri.createReportResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.context.annotation.Description;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BrowseUnitTest
{
    @InjectMocks

    browseRequest request1;
    browseRequest request2;
    browseRequest request3;

    browseResponse response1;
    BrowseServiceImp browseServiceImpl = new BrowseServiceImp();
    BrowseHelper BrowseHelper;

    @BeforeEach
    void setUp()
    {
        BrowseHelper = new BrowseHelper();
        request1 = null;
        request2 = new browseRequest();
    }

    @Test
    @Description("Create a null request object to test if an exception is thrown.")
    void TEST_SHOULD_RETURN_AN_EXCEPTION()
    {
        Throwable throwError = assertThrows(Exception.class, () -> browseServiceImpl.browse(request1));
        assertEquals("Exception: browse request not instantiated", throwError.getMessage());
    }
}