
public class Interest {
    private float interestRate;
    private int months;
    private int years;
    private float deposited;
    private float monthlyDeposit;
    private double totalAccruedInterest;
    private double totalDeposited;


    public void setDeposited(float deposited) {
        this.deposited = deposited;
    }

    public void setMonthlyDeposit(float monthlyDeposite) {
        this.monthlyDeposit = monthlyDeposite;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public void setTotalAccruedInterest(double totalAccruedInterest) {
        this.totalAccruedInterest = totalAccruedInterest;
    }

    public void setTotalDeposited(double totalDeposited) {
        this.totalDeposited = totalDeposited;
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

    public float getMonthlyDeposit() {
        return monthlyDeposit;
    }

    public double getTotalAccruedInterest() {
        return totalAccruedInterest;
    }

    public double getTotalDeposited() {
        return totalDeposited;
    }
}

