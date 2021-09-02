package com.GiveaLot.givealot.User.response;

import com.GiveaLot.givealot.User.dataclass.User;
public class getNumberofUsersResponse {

        private final String message;
        private final boolean success;
        private final String JWTToken;
        int response;
        public getNumberofUsersResponse(boolean success, String message, String JWTToken, int res)
        {
            this.message = message;
            this.success = success;
            this.JWTToken = JWTToken;
            this.response = res;
        }

        public int getResponse() {
            return response;
        }

        public void setResponse(int response) {
            this.response = response;
        }

        public String getMessage()
        { return message; }

        public boolean isSuccess() {
            return success;
        }

        public String getJWTToken() {
            return JWTToken;
        }

}
