
public class MakeWork {

    public Interest interest = new Interest();
    public UserFinance userFinance = new UserFinance();


    public double CalculatedInterest(){
        float interestRate = this.interest.getInterestRate();
        float deposited = this.interest.getDeposited();
        int years = this.interest.getYears() * 12;
        int months = this.interest.getMonths();
        int time = years + months;

        return deposited * Math.pow((1 + (interestRate)/(1)),(1* time));

    }

}
