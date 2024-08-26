import java.text.DecimalFormat;

public class MakeWork {
    Interest interest = FloatInputGui.interest;
    public UserFinance userFinance = new UserFinance();


    public String CalculatedInterest(){
        float interestRate = interest.getInterestRate() / 100;
        float deposited = interest.getDeposited();
        int years = interest.getYears();
        float months = (float) interest.getMonths() / 12;
        float time = years + months;
        DecimalFormat twoPlace = new DecimalFormat("#.##");

        double result = CalculateYearly(interestRate,deposited,time);
        System.out.println(CalculateMonthly(interestRate,deposited,time));
        System.out.println(CalculateDaily(interestRate,deposited,time));
        System.out.println(CalcForMonthlyDeposit(interestRate,deposited,time,500));

        return twoPlace.format(result);
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

        return CalculateMonthly(interestRate,deposit,time) + (CalculateMonthly(interestRate,monthlyDeposit,time) - 1)/(interestRate/12);
    }
}
