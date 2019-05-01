class CEmployee3 extends CEmployee2
{
    private double deduction_Sec_80C;
    private double deduction_Sec_80CCD_NPS;
    private double deduction_Sec_80CCG;
    CEmployee3(String name, String PAN, int age, String email,
                double grossSal, int CityOfResidence,
                double basicSal_DA, double rentPaid, double HRArecieved, 
                double standard_deduction_Salaried_Pensioner, double other_excempted, double professional_tax,
                double AnyOtherIncomeSource, double lossFromHouseProperty, double intrest_home_improvement_loan, double deduction_Sec_80C, double deduction_Sec_80CCD_NPS, 
                double deduction_Sec_80CCG)
                {
                    super(name, PAN, age, email, grossSal, CityOfResidence, basicSal_DA, rentPaid, HRArecieved,
                        standard_deduction_Salaried_Pensioner, other_excempted, professional_tax, AnyOtherIncomeSource, 
                        lossFromHouseProperty, intrest_home_improvement_loan);
                    this.deduction_Sec_80C = -1 * (deduction_Sec_80C >= deduction_Sec_80C_lim ? deduction_Sec_80C_lim : deduction_Sec_80C);
                    this.deduction_Sec_80CCD_NPS = -1 * Math.min(deduction_Sec_80CCD_NPS , deduction_Sec_80CCD_NPS_lim);
                    this.deduction_Sec_80CCG = -1 * Math.min(deduction_Sec_80CCG, deduction_Sec_80C_lim) / 2;
                }
    double getDeduction_sec_80C()
    {
        return this.deduction_Sec_80C;
    }

    double getdeduction_Sec_80CCD_NPS()
    {
        return this.deduction_Sec_80CCD_NPS;
    }

    double getdeduction_Sec_80CCG()
    {
        return this.deduction_Sec_80CCG;
    }
    public String toString()
    {
        return " 80C " + getDeduction_sec_80C() + " 80CCD NPS " + getdeduction_Sec_80CCD_NPS() + " 80CCG " + getdeduction_Sec_80CCG();
    }

}
/*
class cEmployee3 {
    public static void main(String[] args) {
        cEmployee e = new cEmployee("dc", "edc", "1985-10-01", 900000.0, 1, 800000.0, 300000.0, 500.0, 40000.0, 50000.0, 10000.0, 30000, 5000, 5000, 100000.0, 40000.0, 40000);
        System.out.println(e.toString());
    }
}
*/