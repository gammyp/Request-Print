package RequestPrintShop;

public class Address {
    private String houseNum;
    private String road;
    private String district;
    private String province;
    private String postNum;

    public Address(String houseNum, String road, String district, String province, String postNum) {
        this.houseNum = houseNum;
        this.road = road;
        this.district = district;
        this.province = province;
        this.postNum = postNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setPostNum(String postNum) {
        this.postNum = postNum;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public String getRoad() {
        return road;
    }

    public String getDistrict() {
        return district;
    }

    public String getProvince() {
        return province;
    }

    public String getPostNum() {
        return postNum;
    }

    @Override
    public String toString() {
        return "Address: " + houseNum + " " + road + " road " + district + " " + province + " " + postNum;
    }
    
}
