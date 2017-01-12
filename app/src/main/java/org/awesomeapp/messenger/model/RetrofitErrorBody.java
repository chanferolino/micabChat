package org.awesomeapp.messenger.model;

/**
 * Created by rnecesito on 8/2/16.
 */
public class RetrofitErrorBody {

    private String error;
    private int status;
    private String summary;

    private Raw raw;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Raw getRaw() {
        return raw;
    }

    public void setRaw(Raw raw) {
        this.raw = raw;
    }

    public class Raw {
        private String error;
        private int status;
        private String summary;

        private InvalidAttributes invalidAttributes;

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public InvalidAttributes getInvalidAttributes() {
            return invalidAttributes;
        }

        public void setInvalidAttributes(InvalidAttributes invalidAttributes) {
            this.invalidAttributes = invalidAttributes;
        }

        public class InvalidAttributes {
            private Object username;
            private Object email;

            public Object getUsername() {
                return username;
            }

            public void setUsername(Object username) {
                this.username = username;
            }

            public Object getEmail() {
                return email;
            }

            public void setEmail(Object email) {
                this.email = email;
            }
        }
    }
}
