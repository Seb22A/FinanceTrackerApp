
public class Interest {
    private float interestRate;
    private int months;
    private int years;
    private float deposited;


    public void setDeposited(float deposited) {
        this.deposited = deposited;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public float getDeposited() {
        return deposited;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public int getMonths() {
        return months;
    }

    public int getYears() {
        return years;
    }
}
