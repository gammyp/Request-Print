package RequestPrintModel;

public class Shop {
    private long shopId;
    private Address address;
    private OwnerShop owner;
    
    
    public Shop() {
        
    }
    
    public Shop(long shopId , Address address , OwnerShop owner) {
        this.address = address;
        this.shopId = shopId;
        this.owner = owner;
    }

    public long getShopId() {
        return shopId;
    }

    public Address getAddress() {
        return address;
    }

    public OwnerShop getOwner() {
        return owner;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setOwner(OwnerShop owner) {
        this.owner = owner;
    }
    
    
}
