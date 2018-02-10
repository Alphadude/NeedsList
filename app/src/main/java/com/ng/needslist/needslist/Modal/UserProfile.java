package com.ng.needslist.needslist.Modal;

/**
 * Created by user on 2/3/2018.
 */

public class UserProfile {
        private String coverImageUrl;
        private String photo;
        private String name;
        private String email;
        private String phone_number;
        private String address;
        private String bio;
        private String device_token;
        private String status;
        private Long  d_o_b;

    public UserProfile(){

    }

        public UserProfile(String coverImageUrl, String photo, String name, String email, String phone_number, String address, String bio,String device_token, String status, Long  d_o_b){
            this.coverImageUrl = coverImageUrl;
            this.photo = photo;
            this.name = name;
            this.email = email;
            this.phone_number = phone_number;
            this.address = address;
            this.status = status;
            this.device_token = device_token;
            this.bio = bio;
            this.d_o_b = d_o_b;
        }

        public String getCoverImageUrl() {
            return coverImageUrl;
        }

        public void setCoverImageUrl(String coverImageUrl) {
            this.coverImageUrl = coverImageUrl;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public Long getD_o_b() {
            return d_o_b;
        }

        public void setD_o_b(Long d_o_b) {
            this.d_o_b = d_o_b;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public String getDevice_token() {
            return device_token;
        }

        public void setDevice_token(String device_token){this.device_token = device_token;}

    public String getStatus() {
        return status;
    }

        public void setStatus(String status) {
            this.status = status;
        }
}
