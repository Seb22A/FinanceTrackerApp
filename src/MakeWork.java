import java.text.DecimalFormat;

public class MakeWork {
    Interest interest = FloatInputGui.interest;
    public double result;
    public double putIn;
    public double accrued;
    public UserFinance userFinance = new UserFinance();


    public String CalculateInterest(String interestType){

        float interestRate = interest.getInterestRate() / 100;
        float deposited = interest.getDeposited();
        int years = interest.getYears();
        float months = (float) interest.getMonths() / 12;
        float time = years + months;
        float monthlyDeposit = interest.getMonthlyDeposit();

        DecimalFormat twoPlace = new DecimalFormat("#.##");

        switch (interestType){
            case "Yearly":
                result = CalculateYearly(interestRate,deposited,time);
                break;
            case "Monthly":
                result = CalculateMonthly(interestRate,deposited,time);
                break;
            case "Daily":
                result = CalculateDaily(interestRate,deposited,time);
        }

        System.out.println(CalcForMonthlyDeposit(interestRate,deposited,time,500));
        boolean monthlyDeposites = false;
        if (monthlyDeposit > 0){
            monthlyDeposites = true;
            result = CalcForMonthlyDeposit(interestRate, deposited, time, monthlyDeposit);
        }

        interestAmount(result, deposited, monthlyDeposites);
        System.out.println("Put in: "  + putIn);
        System.out.println("Accrued: " + accrued);

        return twoPlace.format(result);
    }

    public void interestAmount(double result, float deposited, boolean monthlyDeposites){
        if(!monthlyDeposites) {
            accrued = result - deposited;
            putIn = deposited;
        }
        else {
           float time = interest.getMonths() + (interest.getYears() * 12);
           putIn = deposited * time;
           accrued = result - putIn;
        }
        interest.setTotalAccruedInterest(accrued);
        interest.setTotalDeposited(putIn);
    }

    private double CalculateYearly(float interestRate, float deposit, float time){
        return (deposit * Math.pow((1 + (interestRate)),(time)));
    }
    private double CalculateMonthly(float interestRate, float deposit, float time){
        return  (deposit * Math.pow((1 + (interestRate/12)),(12*time)));
    }
    private double CalculateDaily(float interestRate, float deposit, float time){
        return (deposit * Math.pow((1 + (interestRate/365)),(365*time)));
    }
    private double CalcForMonthlyDeposit(float interestRate, float deposit, float time, float monthlyDeposit){

        return CalculateMonthly(interestRate,deposit,time) + ( monthlyDeposit * (CalculateMonthly(interestRate,1,time) - 1))/(interestRate/12);
    }
}
