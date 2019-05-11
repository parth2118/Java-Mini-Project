//Tested OK
/**
 * CEmployee2
 * 
 * @author parth2118
 */
class CEmployee2 extends CEmployee1 {
    private double AnyOtherIncomeSource;
    /*
     * private double Bank; private double NSC; private double PO_MIS; private
     * double PO_recring_deposit; private double Other_Income_1; private double
     * Other_Income_2;
     */
    private double exception_Home_Loan_Intrest;
    private double lossFromHouseProperty;
    private double intrest_home_improvement_loan;
    private double grossTotalIncome;

    CEmployee2(String name, String PAN, int age, String email, double grossSal, int CityOfResidence, double basicSal_DA,
            double rentPaid, double HRArecieved, double standard_deduction_Salaried_Pensioner, double other_excempted,
            double professional_tax, double AnyOtherIncomeSource, double lossFromHouseProperty,
            double intrest_home_improvement_loan)
    // double Bank, double NSC, double PO_MIS, double PO_recring_deposit,
    // double Other_Income_1, double Other_Income_2)
    {
        super(name, PAN, age, email, grossSal, CityOfResidence, basicSal_DA, rentPaid, HRArecieved,
                standard_deduction_Salaried_Pensioner, other_excempted, professional_tax);
        /*
         * this.Bank = Bank; this.NSC = NSC; this.PO_MIS = PO_MIS;
         * this.PO_recring_deposit = PO_recring_deposit; this.Other_Income_1 =
         * Other_Income_1; this.Other_Income_2 = Other_Income_2;
         */
        this.AnyOtherIncomeSource = AnyOtherIncomeSource;
        this.lossFromHouseProperty = -1
                * (lossFromHouseProperty > loss_From_House_Property_lim ? loss_From_House_Property_lim
                        : lossFromHouseProperty);
        this.intrest_home_improvement_loan = -1
                * (intrest_home_improvement_loan > intrest_home_improvement_loan_lim ? intrest_home_improvement_loan_lim
                        : intrest_home_improvement_loan);
        this.exception_Home_Loan_Intrest = (-1
                * (this.lossFromHouseProperty + this.intrest_home_improvement_loan)) > exception_Home_Loan_Intrest_lim
                        ? -1 * exception_Home_Loan_Intrest_lim
                        : (this.lossFromHouseProperty + this.intrest_home_improvement_loan);
        this.grossTotalIncome = super.getIncomeUnderHeadSalaries() + this.AnyOtherIncomeSource
                + this.exception_Home_Loan_Intrest;
    }

    public String toString() {
        return "any other income source " + this.AnyOtherIncomeSource + " excempted home loan intrest "
                + this.exception_Home_Loan_Intrest + " gtot income " + this.grossTotalIncome;
    }

    double getGrossTotalIncome() {
        return this.grossTotalIncome;
    }

    double getAnyOtherIncomeSource() {
        return this.AnyOtherIncomeSource;
    }
}
/*
 * class cEmployee2 { public static void main(String[] args) { cEmployee e = new
 * cEmployee("dc", "edc", "1985-10-01", 900000, 1, 800000, 300000, 500, 40000,
 * 50000, 10000, 30000, 5000, 5000); System.out.println(e.toString()); } }
 */
