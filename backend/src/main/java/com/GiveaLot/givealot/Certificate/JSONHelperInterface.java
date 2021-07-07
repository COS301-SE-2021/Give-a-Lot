package com.GiveaLot.givealot.Certificate;

import com.GiveaLot.givealot.Certificate.dataclass.JSON;
import com.GiveaLot.givealot.Certificate.exceptions.CertificateException;
import com.GiveaLot.givealot.Certificate.exceptions.InvalidRequestException;
import com.GiveaLot.givealot.Certificate.exceptions.NotAuthorizedException;
import com.GiveaLot.givealot.Certificate.rri.createJSONRequest;
import com.GiveaLot.givealot.Certificate.rri.createJSONResponse;


public interface JSONHelperInterface {

    /**
     * Generates a new Certificate .
     *
     * @param data:createJSONRequest Object
     * @return createJSONResponse object that holds the created pdf
     * @throws NotAuthorizedException  if user is not an admin that is trying to generate report
     * @throws CertificateException    if Report could not be generated for some reason
     * @throws InvalidRequestException if the request object is not correct
     */
    String createJSONObject(JSON data) throws Exception;
}
