package com.GiveaLot.givealot.Certificate;


import com.GiveaLot.givealot.Certificate.dataclass.JSON;
import com.GiveaLot.givealot.Certificate.exceptions.CertificateException;
import com.GiveaLot.givealot.Certificate.exceptions.InvalidRequestException;
import com.GiveaLot.givealot.Certificate.exceptions.JSONException;
import com.GiveaLot.givealot.Certificate.exceptions.NotAuthorizedException;
import com.GiveaLot.givealot.Certificate.rri.createJSONRequest;
import com.GiveaLot.givealot.Certificate.rri.createJSONResponse;

public class JSONServiceImpl implements JSONService {

    public JSONServiceImpl() {

    }

    /**
     * @return
     * @throws NotAuthorizedException
     * @throws JSONException
     * @throws InvalidRequestException
     */
    @Override
    public createJSONResponse createJSON(createJSONRequest request) throws Exception {
        createJSONResponse jsonRes = null;
        if (request == null) {
            throw new InvalidRequestException("Exception: JSON could not be created because the request object is null");
        }
        if (isAuthorized(true)) {
            JSON json = null;
            try {
                json = new JSON("", "", "", "");
            } catch (Exception e) {
                throw new JSONException("Problem creating JSON Object");
            }
            json = new JSON(request.name, request.description, request.serverUrl, request.imageUrl);
            jsonRes = new createJSONResponse();
            JSONHelper createJSON = new JSONHelper();
            try {
                jsonRes.createJSONResponse(createJSON.createFile(createJSON.createJSONObject(json)));
            } catch (Exception e) {
                throw new CertificateException("Problem creating Certificate");
            }
        }
        //System.out.println(jsonRes);
        return jsonRes;
    }

    public boolean isAuthorized(boolean value) throws NotAuthorizedException {
        if (value == false) {
            throw new NotAuthorizedException("Error: User is not authorised to create JSON Objects");
        }
        return true;
    }

    public class External{
        private createJSONResponse response1;
        private createJSONResponse response2;
        public External(createJSONResponse response1, createJSONResponse response2){
            this.response1 = response1;
            this.response2 = response2;
        }
    }
}