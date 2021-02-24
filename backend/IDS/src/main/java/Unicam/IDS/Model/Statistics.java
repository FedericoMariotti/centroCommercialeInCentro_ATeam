package Unicam.IDS.Model;

public class Statistics {

    private int ordersNumber;

    private int customersNumber;

    private int occupiedParkingNumber;


    public Statistics (int onumber,int cnumber, int parksnumber){
        this.setOrderNumber(onumber);
        this.setCustomersNumber(cnumber);
        this.setOccupiedParkingNumber(parksnumber);
    }

    /**
     * @return the ordersNumber
     */
    public int getOrdersNumber() {
        return ordersNumber;
    }

    /**
     * @param ordersNumber the ordersNumber to set
     */
    public void setOrderNumber(int ordersNumber) {
        this.ordersNumber = ordersNumber;
    }

    /**
     * @return the customersNumber
     */
    public int getCustomersNumber() {
        return customersNumber;
    }

    /**
     * @param customersNumber the customersNumber to set
     */
    public void setCustomersNumber(int customersNumber) {
        this.customersNumber = customersNumber;
    }

    /**
     * @return the occupiedParkingNumber
     */
    public int getOccupiedParkingNumber() {
        return occupiedParkingNumber;
    }

    /**
     * @param occupiedParkingNumber the occupiedParkingNumber to set
     */
    public void setOccupiedParkingNumber(int occupiedParkingNumber) {
        this.occupiedParkingNumber = occupiedParkingNumber;
    }

}
