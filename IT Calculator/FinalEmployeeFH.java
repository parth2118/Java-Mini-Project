import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * FinalEmployeeFH
 * 
 * @author parth2118
 */
public class FinalEmployeeFH implements IConst {
	public static void main(String[] args) throws IOException {
		double[] arr = new double[23];
		int city_type, age = 0;
		String[] option = { "Non-Metro", "Metro" };
		boolean valid = false;
		String[] arr_Str = new String[3];
		boolean set_PAN1 = false;
		boolean set_PAN = false;
		boolean set_PAN2 = false;
		boolean set_NAME = false;
		String PAN;
		do {
			JTextField dob = new JTextField();
			try {
				JTextField name = new JTextField();
				JTextField pan = new JTextField();
				JTextField email = new JTextField();
				Object[] fields1 = { "Enter Name : ", name, "\nEnter PAN : ", pan, "\nEnter DOB (YYYY-MM-DD) : ", dob,
						"\nEnter E-Mail ID : ", email };
				result1_label: while (true) {

					try {
						int result1 = JOptionPane.showConfirmDialog(null, fields1, "Personal Details",
								JOptionPane.OK_CANCEL_OPTION);
						if (result1 == -1 || result1 == JOptionPane.CANCEL_OPTION) {
							System.exit(-1);
						} else if (result1 == JOptionPane.OK_OPTION) {
							// char ch;
							for (int i = 0; i < name.getText().length(); i++) {
								if (Character.isLetter(name.getText().charAt(i))
										|| (name.getText().charAt(i) == ' ' && name.getText().charAt(i + 1) != ' '))
									set_NAME = true;
								else {
									set_NAME = false;
									break;
								}
							}
							if (!set_NAME && arr_Str[0].isEmpty()) {
								throw new InputMismatchException();
							} else {
								arr_Str[0] = name.getText();
							}
							PAN = pan.getText();
							for (int i = 0; i < 10; i++) {
								if ((i < 5 || i == 9) && (int) PAN.charAt(i) <= 90 && (int) PAN.charAt(i) >= 65) {
									set_PAN1 = true;
								} else if ((i >= 5 && i != 9) && (int) PAN.charAt(i) <= 57
										&& (int) PAN.charAt(i) >= 48) {
									set_PAN2 = true;
								}

							}
							set_PAN = (set_PAN1 && set_PAN2) && ((int) PAN.charAt(3) == 80);
							if (set_PAN) {
								arr_Str[1] = PAN;
							} else {
								throw new InputMismatchException();
							}
							if (arr_Str[1].isEmpty()) {
								throw new InputMismatchException();
							}

							age = Period.between(LocalDate.parse(dob.getText()), LocalDate.now()).getYears();
							if (age < min_age_to_pay_tax) {
								LocalDate.parse("to throw exception");
							}
							if (email.getText().contains("@")
									&& (email.getText().contains(".c") || email.getText().contains(".in"))) {
								arr_Str[2] = email.getText();
							} else {
								throw new Exception();
							}
							break;
						}
					} catch (DateTimeParseException ex1_date) {
						int temp_r1 = JOptionPane.showConfirmDialog(null,
								"Please Enter Date in Appropriate format\nNOTE: Age should be greater than 18\nto be elegible to pay tax",
								"Invalid Date", JOptionPane.OK_OPTION);
						if (temp_r1 == -1 || temp_r1 == 1) {
							JOptionPane.showMessageDialog(null, "Exiting Program");
							System.exit(-1);
						}
						continue result1_label;
					} catch (Exception ex1) {
						int temp_r1 = JOptionPane.showConfirmDialog(null, "Please Enter Appropriate Data",
								"Invalid Data", JOptionPane.OK_OPTION);
						if (temp_r1 == -1 || temp_r1 == 1) {
							JOptionPane.showMessageDialog(null, "Exiting Program");
							System.exit(-1);
						}
						continue result1_label;
					}
				}

				city_type = JOptionPane.showOptionDialog(null, "Select type of City (of Residence)", "Type of City",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, option, option[1]);
				if (city_type == -1) {
					System.exit(-1);
				}

				JTextField bs = new JTextField();
				JTextField rp = new JTextField();
				JTextField hra = new JTextField();
				JTextField std = new JTextField();
				JTextField ex = new JTextField();
				JTextField pt = new JTextField();
				JTextField sal = new JTextField();
				JTextField inv_intrest = new JTextField();
				Object[] fields2 = { "Enter Gross Annual Salary (with all allowances) : ", sal,
						"\nAllowances exempt u/s 10(for Service Period):-" + "\n	A. H.R.A Exemption\n"
								+ "		I. Enter Basic Salary (Basic + Dearness Allowence) : ",
						bs, "		II. Enter Rent Paid : ", rp, "		III. Enter H.R.A received : ", hra,
						"\n	B. Standard Deduction for Salaried & Pensioners : ", std,
						"\n	C. Enter Any Other Exempted Receipts/Allowances : ", ex,
						"\n	D. Enter Professional Tax : ", pt,
						"\n	Income From Other Sources:-\n" + "		Interest received from following Investments"
								+ "\n			A. Bank (Saving/FD/Rec)\n			B. N.S.C (Accrued/Recd)\n			C. Post Office M.I.S (6 yrs.)\n			D. Post Office Recurring Deposit (5 yrs.)\n			Enter Total Income From Other Sources",
						inv_intrest };
				result2_label: while (true) {
					try {
						int result2 = JOptionPane.showConfirmDialog(null, fields2, "Income Details",
								JOptionPane.OK_CANCEL_OPTION);
						if (result2 == -1 || result2 == JOptionPane.CANCEL_OPTION) {
							System.exit(-1);
						} else if (result2 == JOptionPane.OK_OPTION) {
							arr[0] = Double.parseDouble(sal.getText());
							arr[1] = Double.parseDouble(bs.getText());
							arr[2] = Double.parseDouble(rp.getText());
							arr[3] = Double.parseDouble(hra.getText());
							arr[4] = Double.parseDouble(std.getText());
							arr[5] = Double.parseDouble(ex.getText());
							arr[6] = Double.parseDouble(pt.getText());
							arr[7] = Double.parseDouble(inv_intrest.getText());
							break;
						}
					} catch (Exception ex2) {
						int temp_r2 = JOptionPane.showConfirmDialog(null, "Please Enter Appropriate Data",
								"Invalid Data", JOptionPane.OK_OPTION);
						if (temp_r2 == -1 || temp_r2 == 1) {
							JOptionPane.showMessageDialog(null, "Exiting Program");
							System.exit(-1);
						}
						continue result2_label;
					}
				}

				JTextField hp = new JTextField();
				JTextField hil = new JTextField();
				JTextField c = new JTextField();
				JTextField nps = new JTextField();
				JTextField rgess = new JTextField();
				Object[] fields4 = {
						"Exemption On Home Loan Interest (Section 24):-\n"
								+ "\nA. Enter Loss From House Property (Section 24) : ",
						hp, "B. Enter Interest paid on Home Improvement Loan (Max Rs. 30,000/-) : ", hil,
						"\nDeduction under Section 80C (Max Rs. 1,50,000/-):-\n"
								+ "\nA. EPF & VPF Contribution\nB. Public Provident Fund (PPF)\nC. Senior Citizen's Saving Scheme (SCSS)\nD. N.S.C (Investment + Accrued Interest Before Maturity Year)\nE. Tax Saving Fixed Deposit (5 Years & above)\nF. Tax Savings Bonds\nG. E.L.S.S (Tax Saving Mutual Fund)\nH. Life Insurance Premiums\nI. New Pension Scheme (NPS) (u/s 80CCC)\nJ. Pension Plan from Insurance Companies/Mutual Funds (u/s 80CCC)\nK. 80CCD Central Govt. Employees Pension Plan (u/s 80CCD)\nL. Housing Loan (Principal Repayment)\nM. Sukanya Samriddhi Account\nN. Stamp Duty & Registration Charges\nO. Tuition Fees For 2 Children\nEnter Total Deduction Under Section 80C : ",
						c, "\nB. Enter Deduction Under Section 80CCD NPS (Max Rs. 50,000/-) : ", nps,
						"\nC. Enter Deduction Under RGESS Section 80CCG (Max Rs. 50,000/-) : ", rgess };
				result4_label: while (true) {
					try {
						int result4 = JOptionPane.showConfirmDialog(null, fields4, "Sections 24, 80C, 80CCD, 80CCG",
								JOptionPane.OK_CANCEL_OPTION);
						if (result4 == -1 || result4 == JOptionPane.CANCEL_OPTION) {
							System.exit(-1);
						}
						if (result4 == JOptionPane.OK_OPTION) {
							arr[8] = Double.parseDouble(hp.getText());
							arr[9] = Double.parseDouble(hil.getText());
							arr[10] = Double.parseDouble(c.getText());
							arr[11] = Double.parseDouble(nps.getText());
							arr[12] = Double.parseDouble(rgess.getText());
							break;
						}
					} catch (Exception ex4) {
						int temp_r4 = JOptionPane.showConfirmDialog(null, "Please Enter Appropriate Data",
								"Invalid Data", JOptionPane.OK_OPTION);
						if (temp_r4 == -1 || temp_r4 == 1) {
							JOptionPane.showMessageDialog(null, "Exiting Program");
							System.exit(-1);
						}
						continue result4_label;
					}
				}

				JTextField da = new JTextField();
				JTextField db = new JTextField();
				JTextField dc = new JTextField();
				JTextField dd = new JTextField();
				JTextField de = new JTextField();
				JTextField df = new JTextField();
				JTextField dg = new JTextField();
				JTextField dh = new JTextField();
				JTextField di = new JTextField();
				Object[] fields5 = { "A. Enter 80D Medical Insurance Premiums (For Self) : ", da,
						"\nB. Enter 80D Medical Insurance Premiums (For Parents) : ", db,
						"\nC. Enter 80E Interest Paid On Education Loan : ", dc,
						"\nD. Enter 80DD Medical Treatment Of Handicapped Dependent : ", dd,
						"\nE. Enter 80DDB Expenditure On Selected Medical Treatment For Self/Dependent : ", de,
						"\nF. Enter 80G, 80GGA, 80GGC Donation To Approved Funds : ", df,
						"\nG. Enter 80GG For Rent In Case Of NO HRA Component : ", dg,
						"\nH. Enter 80U For Physically Disable Assesse : ", dh,
						"\nI. Enter 80TTA (Rs. 50,000/- For Senior Citizens & Rs. 10,000/- for others) : ", di };
				result5_label: while (true) {
					try {
						int result5 = JOptionPane.showConfirmDialog(null, fields5, "Deduction Under Chapter VI-A",
								JOptionPane.OK_CANCEL_OPTION);
						if (result5 == -1 || result5 == JOptionPane.CANCEL_OPTION) {
							System.exit(-1);
						} else if (result5 == JOptionPane.OK_OPTION) {
							arr[13] = Double.parseDouble(da.getText());
							arr[14] = Double.parseDouble(db.getText());
							arr[15] = Double.parseDouble(dc.getText());
							arr[16] = Double.parseDouble(dd.getText());
							arr[17] = Double.parseDouble(de.getText());
							arr[18] = Double.parseDouble(df.getText());
							arr[19] = Double.parseDouble(dg.getText());
							arr[20] = Double.parseDouble(dh.getText());
							arr[21] = Double.parseDouble(di.getText());
							break;
						}
					} catch (Exception ex5) {
						int temp_r5 = JOptionPane.showConfirmDialog(null, "Please Enter Appropriate Data",
								"Invalid Data", JOptionPane.OK_OPTION);
						if (temp_r5 == -1 || temp_r5 == 1) {
							JOptionPane.showMessageDialog(null, "Exiting Program");
							System.exit(-1);
						}
						continue result5_label;
					}
				}

				result5a_label: while (true) {
					JTextField adv_tax = new JTextField();
					Object[] fields5a = { "Enter Advance Tax Paid", adv_tax };
					try {
						int result5a = JOptionPane.showConfirmDialog(null, fields5a, "Advance Tax",
								JOptionPane.OK_CANCEL_OPTION);
						if (result5a == -1 || result5a == JOptionPane.CANCEL_OPTION) {
							System.exit(-1);
						} else if (result5a == JOptionPane.OK_OPTION) {
							arr[22] = Double.parseDouble(adv_tax.getText());
							break;
						}
					} catch (Exception ex5a) {
						int temp_r5a = JOptionPane.showConfirmDialog(null, "Please Enter Appropriate Data",
								"Invalid Data", JOptionPane.OK_OPTION);
						if (temp_r5a == -1 || temp_r5a == 1) {
							JOptionPane.showMessageDialog(null, "Exiting Program");
							System.exit(-1);
						}
						continue result5a_label;
					}
				}

				valid = true;

				CEmployee5 emp = new CEmployee5(arr_Str[0], arr_Str[1], age, arr_Str[2], arr[0], city_type, arr[1],
						arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[10], arr[11], arr[12],
						arr[13], arr[14], arr[15], arr[16], arr[17], arr[18], arr[19], arr[20], arr[21], arr[22]);

				JOptionPane.showMessageDialog(null,
						"Tax Rebate of Rs. 2,500/- (For Income of less than 3.5 Lakhs)"
								+ "\nTax Surcharge @ 10% (For Income of more than 50 Lakhs)"
								+ "\nEducation Cess + Health Cess @ 4%\n\n" + "Total Taxable Income : "
								+ emp.getTotIncome() + "\nTotal Tax Payable        : " + emp.getTotTaxPayable()
								+ "\nNet Tax Payable           : " + emp.getNetTaxPayable_Remaining());

				File f = new File(arr_Str[1] + ".txt");
				f.createNewFile();
				FileWriter fos = new FileWriter(f);
				fos.write("************************* Income-Tax Calculator *************************");
				fos.write("\n\nPersonal Details:-\n\tName : " + arr_Str[0] + "\n\tPAN : " + arr_Str[1]
						+ "\n\tDOB (YYYY-MM-DD) : " + dob.getText() + "\n\tAge : " + age + "\n\tE-Mail ID : "
						+ arr_Str[2]);
				if (city_type == 1) {
					fos.write("\n\tCity-Type of Residence : Metro-City");
				} else {
					fos.write("\n\tCity-Type of Residence : Non-Metro-City");
				}
				fos.write("\n\tGross Annual Salary (with all allowances) : " + arr[0]);
				fos.write("\n\nAllowances Exempt u/s 10(for Service Period):-\n\tA. H.R.A Exemption:-"
						+ "\n\t\tI. Basic Salary (Basic + DA) : " + arr[1] + "\n\t\tII. Rent Paid(Basic + DA) : "
						+ arr[2] + "\n\t\tIII. H.R.A received : " + arr[3]
						+ "\n\tB. Standard Deduction for Salaried & Pensioner : " + arr[4]
						+ "\n\tC. Any Other Exempted Receipts/Allowances : " + arr[5] + "\n\tD. Professional Tax : "
						+ arr[6]);
				fos.write("\n\nTotal Income From Other Sources (Bank, N.S.C, M.I.S, etc.) : " + arr[7]);
				fos.write("\n\nExemption on Home Loan Interest (Section 24):-"
						+ "\n\tA. Loss from House Property (Section 24) : " + arr[8]
						+ "\n\tB. Interest Paid on Home Improvement Loan (Max Rs. 30,000/-) : " + arr[9]);
				fos.write("\n\nTotal Deduction under Section 80C (Max Rs. 1,50,000/-) : " + arr[10]);
				fos.write("\n\nTotal Deduction under Section 80CCD NPS (Max Rs. 50,000/-) : " + arr[11]);
				fos.write("\n\nTotal Deduction under RGESS Section 80CCG (Max Rs. 50,000/-) : " + arr[12]);
				fos.write("\n\nDeduction under Chapter VI-A:-"
						+ "\n\tA. Enter 80D Medical Insurance Premiums (For Self) : " + arr[13]
						+ "\n\tB. 80D Medical Insurance Premiums (For Parents) : " + arr[14]
						+ "\n\tC. Enter 80E Interest Paid On Education Loan : " + arr[15]
						+ "\n\tD. Enter 80DD Medical Treatment Of Handicapped Dependent : " + arr[16]
						+ "\n\tE. Enter 80DDB Expenditure On Selected Medical Treatment For Self/Dependent : " + arr[17]
						+ "\n\tF. Enter 80G, 80GGA, 80GGC Donation To Approved Funds : " + arr[18]
						+ "\n\tG. Enter 80GG For Rent In Case Of NO HRA Component : " + arr[19]
						+ "\n\tH. Enter 80U For Physically Disable Assesse : " + arr[20]
						+ "\n\tI. Enter 80TTA (Rs. 50,000/- For Senior Citizens & Rs. 10,000/- for others) : "
						+ arr[21]);
				fos.write("\n\nAdvance Tax Paid : " + arr[22]);
				fos.write("\n\nTotal Taxable Income : " + emp.getTotIncome());
				fos.write("\n\nTotal Tax Payable    : " + emp.getTotTaxPayable());
				fos.write("\n\nNet Tax Payable      : " + emp.getNetTaxPayable_Remaining());
				fos.close();

				int x = JOptionPane.showConfirmDialog(null,
						"The file has been created.\nPressing the Yes button will open the file.", "File",
						JOptionPane.OK_OPTION);

				if (x == JOptionPane.OK_OPTION) {
					if (System.getProperty("os.name").contains("Windows")) {
						ProcessBuilder pb = new ProcessBuilder("Notepad.exe", (arr_Str[1] + ".txt"));
						pb.start();
					} else if (System.getProperty("os.name").contains("Mac OS X")) {
						ProcessBuilder pb = new ProcessBuilder("open", (arr_Str[1] + ".txt"));
						pb.start();
					} else if (System.getProperty("os.name").contains("Linux")) {
						ProcessBuilder pb = new ProcessBuilder("gedit", (arr_Str[1] + ".txt"));
						pb.start();
					} else {
						JOptionPane.showMessageDialog(null,
								"Sorry for Inconvenience ! \nImplicit File open operations are currently supported on : \n- Windows \n-Mac OS X \n-Linux (gedit) \nHowever, your file has been saved in current Directory");
						System.exit(-1);
					}
				} else if (x == -1 || x == JOptionPane.CANCEL_OPTION) {
					System.exit(-1);
				}
			} catch (Exception e) {
				System.err.println(e + " Occured");
				int opt = JOptionPane.showConfirmDialog(null,
						"Would you like to Exit ? \nIf Not you would be asked to re-enter all fields.", "Error Occured",
						JOptionPane.YES_NO_OPTION);
				if (opt == JOptionPane.YES_OPTION || opt == -1) {
					System.exit(-1);
				}
			}
		} while (!valid);
	}
}
