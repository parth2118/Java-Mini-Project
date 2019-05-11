//Tested OK
/**
 * CEmployee1
 * 
 * @author parth2118
 */
class CEmployee1 extends CPerson {
    private double grossSal;
    private double allowencesExcepted;
    private double HRAexception;
    private int CityOfResidence; // 0 = Non-Metro, 1 = Metro
    private double basicSal_DA;
    private double rentPaid;
    private double HRArecieved;
    private double standard_deduction_Salaried_Pensioner;
    private double other_excempted;
    private double professional_tax;
    private double income_under_head_sal;

    CEmployee1(String name, String PAN, int age, String email, double grossSal, int CityOfResidence, double basicSal_DA,
            double rentPaid, double HRArecieved, double standard_deduction_Salaried_Pensioner, double other_excempted,
            double professional_tax) {
        super(name, PAN, age, email);
        this.grossSal = grossSal;
        this.setCityOfResidence(CityOfResidence);
        this.basicSal_DA = (CityOfResidence == 1 ? basicSal_DA * basicSal_DA_mul_Metro
                : basicSal_DA * basicSal_DA_mul_N_Metro);
        this.rentPaid = rentPaid - rent_mul * this.basicSal_DA;
        this.HRArecieved = HRArecieved;
        this.standard_deduction_Salaried_Pensioner = Math
                .max(Math.min(standard_deduction_Salaried_Pensioner, standard_deduction_Salaried_Pensioner_limit), 0);
        this.other_excempted = other_excempted;
        this.professional_tax = professional_tax;
        this.HRAexception = Math.max(Math.min(this.basicSal_DA, Math.min(this.rentPaid, this.HRArecieved)), 0);
        this.allowencesExcepted = -1 * (this.HRAexception + this.standard_deduction_Salaried_Pensioner
                + this.other_excempted + this.professional_tax);
        this.income_under_head_sal = grossSal + this.allowencesExcepted;
    }

    /**
     * @return the cityOfResidence
     */
    public int getCityOfResidence() {
        return CityOfResidence;
    }

    /**
     * @param cityOfResidence the cityOfResidence to set
     */
    public void setCityOfResidence(int cityOfResidence) {
        this.CityOfResidence = cityOfResidence;
    }

    public double getGrossSal() {
        return grossSal;
    }

    public double getAllowencesExcempted() {
        return allowencesExcepted;
    }

    public double getIncomeUnderHeadSalaries() {
        return this.income_under_head_sal;
    }

    public String toString() {
        return "gross anual sal " + this.grossSal + " allownces excempted " + this.allowencesExcepted
                + " income under head sal " + this.income_under_head_sal;
    }
}
