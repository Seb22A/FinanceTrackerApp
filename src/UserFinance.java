public class UserFinance {
    private float moneySpent;
    private float allTime;


    public float getAllTime() {
        return allTime;
    }

    public float getMoneySpent() {
        return moneySpent;
    }

    public void setAllTime(float allTime) {
        this.allTime =+ allTime;
    }

    public void setMoneySpent(float moneySpent) {
        this.moneySpent = moneySpent;
    }

    public void upDateAllTime(float added){
        setAllTime(added);
    }
    float NetWorth(){
       return getAllTime();
    }

    void MonthlyPay(float income){

    }
    float ProjectedValue(){
        return 0;
    }

    float currentBank(){
        return 0;
    }

    void expenses(float moneySpent){

    }
}
