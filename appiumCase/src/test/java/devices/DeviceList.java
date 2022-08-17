package devices;

public enum DeviceList {

    PIXEL_4_XL("src/test/resources/capabilities/google-pixel-4-XL.json");

    public String path;

    DeviceList(String path){
        this.path = path;
    }
}
