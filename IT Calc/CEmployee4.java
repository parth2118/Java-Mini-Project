class CEmployee4 extends CEmployee3
{
    private double deduction_chapter_VI_A;
    private double medical_insurance_80D_self;
    private double medical_insurance_80D_parents;
    private double intrest_on_education_loan;
    private double medical_treatment_handicapped_dependent;
    private double expenditure_select_medical_treatment;
    private double donation_of_approved_funds;
    private double for_rent_NO_HRA_component;
    private double for_physically_disabled_assasse;
    private double TTA80;

    CEmployee4(String name, String PAN, int age, String email,
                double grossSal, int CityOfResidence,
                double basicSal_DA, double rentPaid, double HRArecieved, 
                double standard_deduction_Salaried_Pensioner, double other_excempted, double professional_tax,
                double AnyOtherIncomeSource, double lossFromHouseProperty, double intrest_home_improvement_loan,
                double deduction_Sec_80C, double deduction_Sec_80CCD_NPS, double deduction_Sec_80CCG,
                double medical_insurance_80D_self, double medical_insurance_80D_parents, double intrest_on_education_loan,
                double medical_treatment_handicapped_dependent, double expenditure_select_medical_treatment,
                double donation_of_approved_funds, double for_rent_NO_HRA_component, double for_physically_disabled_assasse,
                double TTA80)
                {
                    super(name, PAN, age, email, grossSal, CityOfResidence, basicSal_DA, rentPaid, HRArecieved,
                        standard_deduction_Salaried_Pensioner, other_excempted, professional_tax, AnyOtherIncomeSource, 
                        lossFromHouseProperty, intrest_home_improvement_loan,
                        deduction_Sec_80C, deduction_Sec_80CCD_NPS, deduction_Sec_80CCG);
                    this.medical_insurance_80D_self = medical_insurance_80D_self >= medical_insurance_80D_self_lim ? medical_insurance_80D_self_lim : medical_insurance_80D_self;
                    this.medical_insurance_80D_parents = medical_insurance_80D_parents >= medical_insurance_80D_parents_self ? medical_insurance_80D_parents_self : medical_insurance_80D_parents;
                    this.intrest_on_education_loan = intrest_on_education_loan;
                    this.medical_treatment_handicapped_dependent = medical_treatment_handicapped_dependent >= medical_treatment_handicapped_dependent_lim ? medical_treatment_handicapped_dependent_lim : medical_treatment_handicapped_dependent;
                    this.expenditure_select_medical_treatment = expenditure_select_medical_treatment >= expenditure_select_medical_treatment_lim ? expenditure_select_medical_treatment_lim : expenditure_select_medical_treatment;
                    this.donation_of_approved_funds = donation_of_approved_funds;
                    this.for_rent_NO_HRA_component = for_rent_NO_HRA_component >= for_rent_NO_HRA_component_lim ? for_rent_NO_HRA_component_lim : for_rent_NO_HRA_component;
                    this.for_physically_disabled_assasse = for_physically_disabled_assasse >= for_physically_disabled_assasse_lim ? for_physically_disabled_assasse_lim : for_physically_disabled_assasse;
                    this.TTA80 = TTA80 >= TTA80_lim ? TTA80_lim : TTA80;
                    this.deduction_chapter_VI_A = -1 * (this.medical_insurance_80D_self + this.medical_insurance_80D_parents +
                                                    this.intrest_on_education_loan + this.medical_treatment_handicapped_dependent +
                                                    this.expenditure_select_medical_treatment + this.donation_of_approved_funds + 
                                                    this. for_rent_NO_HRA_component + this.for_physically_disabled_assasse + 
                                                    this.TTA80);
                    
                }

    double getDeduction_chapter_VI_A()
    {
        return this.deduction_chapter_VI_A;
    }
    public String toString()
    {
        return "ch VI A " + getDeduction_chapter_VI_A();
    }
}
/*
class cEmployee4 {
    public static void main(String[] args) {
        cEmployee e = new cEmployee("dc", "edc", "1985-10-01", 900000.0, 1, 800000.0, 300000.0, 500.0, 40000.0, 50000.0, 10000.0, 30000, 5000, 5000, 100000.0, 40000.0, 40000.0, 5000.0, 5000.0, 5000.0, 5000.0, 5000.0, 5000.0, 5000.0, 5000.0, 5000.0);
        System.out.println(e.toString());
    }
}
*/