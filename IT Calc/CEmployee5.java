class CEmployee5 extends CEmployee4
{
    double tot_income;
    double tax_rebate;
    double tot_tax_payable;
    double tax_surcharge;
    double edn_cess_and_health_cess;
    double net_Tax_Payable;
    double advance_tax_paid;
    double tax_remaining_to_be_paid;
    double tax_to_totIncome_ratio;

    CEmployee5(String name, String PAN, int age, String email,
                double grossSal, int CityOfResidence,
                double basicSal_DA, double rentPaid, double HRArecieved, 
                double standard_deduction_Salaried_Pensioner, double other_excempted, double professional_tax,
                double AnyOtherIncomeSource, double lossFromHouseProperty, double intrest_home_improvement_loan,
                double deduction_Sec_80C, double deduction_Sec_80CCD_NPS, double deduction_Sec_80CCG,
                double medical_insurance_80D_self, double medical_insurance_80D_parents, double intrest_on_education_loan,
                double medical_treatment_handicapped_dependent, double expenditure_select_medical_treatment,
                double donation_of_approved_funds, double for_rent_NO_HRA_component, double for_physically_disabled_assasse,
                double TTA80, double advance_tax_paid)
                {
                    super(name, PAN, age, email, grossSal, CityOfResidence, basicSal_DA, rentPaid, HRArecieved,
                        standard_deduction_Salaried_Pensioner, other_excempted, professional_tax, AnyOtherIncomeSource,
                        lossFromHouseProperty, intrest_home_improvement_loan,
                        deduction_Sec_80C, deduction_Sec_80CCD_NPS, deduction_Sec_80CCG, medical_insurance_80D_self,
                        medical_insurance_80D_parents, intrest_on_education_loan, medical_treatment_handicapped_dependent,
                        expenditure_select_medical_treatment, donation_of_approved_funds, for_rent_NO_HRA_component,
                        for_physically_disabled_assasse, TTA80);
                    this.advance_tax_paid = advance_tax_paid;
                    this.tot_income = getGrossTotalIncome() + getDeduction_sec_80C() + getdeduction_Sec_80CCD_NPS() + getdeduction_Sec_80CCG() + getDeduction_chapter_VI_A();
                    this.tax_rebate = -1 * (this.tot_income <= tax_rebate_lim ? tax_rebate_amt : 0);
                    this.tot_tax_payable = Math.max((getTotTaxPayable() + this.tax_rebate), 0);
                    this.tax_surcharge = (getGrossSal() + getAnyOtherIncomeSource()) >= tax_surcharge_lim ? this.tot_tax_payable*tax_surcharge_percent_coeff : 0;
                    this.edn_cess_and_health_cess = edn_cess_and_health_cess_percent_coeff * (this.tot_tax_payable + this.tax_surcharge);
                    this.net_Tax_Payable = this.tot_tax_payable + this.tax_surcharge + this.edn_cess_and_health_cess;
                    this.tax_remaining_to_be_paid = Math.max((this.net_Tax_Payable - this.advance_tax_paid),0);
                    this.tax_to_totIncome_ratio = this.net_Tax_Payable / (getGrossSal() + getAnyOtherIncomeSource());
                }

    public String toString()
    {
        return " tot income " + this.tot_income + " rebate " + this.tax_rebate + " 4 per " + this.edn_cess_and_health_cess + " tot tax payable " + getTotTaxPayable() + " Tax remaining " + getNetTaxPayable_Remaining();
    }
    double getTotIncome()
    {
        return this.tot_income;
    }
    double getNetTaxPayable_Remaining()
    {
        return this.tax_remaining_to_be_paid;
    }
    double getTotTaxPayable()
    {
      //  depends on this.tot_income and this.getAge()
      if((getAge() >= 60) && (getAge() < 80)) return getTotTaxPayable_SrCitizen(this.tot_income);
      else if(getAge() > 80) return getTotTaxPayable_VerySrCitizen(this.tot_income);
      else return getTotTaxPayable_General(this.tot_income);
    }

    //need to remake
    double getTotTaxPayable_General(double income)
    {

        if(income > 0)
        {
            if(income <= 250000) 
                return 0;
            else if(income > 250000 && income <= 500000) 
                return ((income - 250000) * 0.05);
            else if(income > 500000 && income <=1000000) 
                return (((income - 500000) * 0.2) + (250000 * 0.05));
            else 
                return (((income  - 1000000) * 0.3) + (500000 * 0.2) + (250000 * 0.05));
        }
        else return 0;
    }

    double getTotTaxPayable_SrCitizen(double income)
    {
        if(income > 0)
        {
            if (income <= 300000)
                return 0;
            else if (income > 300000 && income <= 500000)
                return ((income - 300000) * 0.05);
            else if (income > 500000 && income <= 1000000)
                return (((income - 500000) * 0.2) + (200000 * 0.05));
            else
                return (((income - 1000000) * 0.3) + (500000 * 0.2) + (200000 * 0.05));
        }
        else return 0;
    }

    double getTotTaxPayable_VerySrCitizen(double income)
    {
        if(income > 0)
        {
            if (income <= 500000)
                return 0;
            else if (income > 500000 && income <= 1000000)
                return ((income - 500000) * 0.2);
            else
                return (((income - 1000000) * 0.3) + (500000 * 0.2));
        }
        else return 0;
    }

}
/*
class cEmployee5 {
    public static void main(String[] args) {
        cEmployee e = new cEmployee("dc", "edc", "1907-10-01", 9000000.0, 1, 800000.0, 300000.0, 500.0, 40000.0, 50000.0,
                10000.0, 30000, 5000, 5000, 100000.0, 40000.0, 40000.0, 5000.0, 5000.0, 5000.0, 5000.0, 5000.0, 5000.0,
                5000.0, 5000.0, 5000.0, 0);
        System.out.println(e.toString());
    }
}
*/
