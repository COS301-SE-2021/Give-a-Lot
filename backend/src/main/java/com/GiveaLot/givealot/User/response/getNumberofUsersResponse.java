package com.GiveaLot.givealot.User.response;

import com.GiveaLot.givealot.User.dataclass.User;
public class getNumberofUsersResponse {

        private final String message;
        private final boolean success;
        int response;
        public getNumberofUsersResponse(boolean success, String message, int res)
        {
            this.message = message;
            this.success = success;
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


}
