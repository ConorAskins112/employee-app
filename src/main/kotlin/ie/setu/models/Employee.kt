package ie.setu.main.kt.ie.setu.models


class Employee(var firstName:String, var surname:String,var gender:Char,var employeeId:Int,var grossSalary:Double,var payePercentage:Double,var  prsiPercentage:Double,var annualBonus:Double,var cycleToWorkScheme:Double) {

    fun getfirstName():String{
        return firstName
    }
    fun getsurname():String{
        return surname
    }
    fun getgender():Char{
        return gender
    }
    fun getemployeeId():Int{
        return employeeId
    }
    fun getgrossSalary():Double{
        return grossSalary
    }
    fun getpayePercentage():Double{
        return payePercentage
    }
    fun getprsiPercentage():Double{
        return prsiPercentage
    }
    fun getannualBonus() : Double {
        return annualBonus
    }
    fun getcycleToWorkScheme():Double{
        return cycleToWorkScheme
    }

    /**
     * This function returns the full name of the employee based on their gender
     */

    fun getFullname() {
        // Returns the full name formatted differently based on the gender
       when(gender){
            // If the gender is 'm', returns "Mr first last"
            'm','M'->"Mr $firstName $surname"
            // If the gender is 'f', returns "Ms first last"
            'f','F'->"Ms $firstName $surname"
            // If the gender is not 'm' or 'f', returns "first last"
            else -> "$firstName $surname"
        }
    }/**
     * payslip calculations
     */


    /**
     *This function calculates the employee's monthly salary
     **/
    fun getMonthlySalary():Double{
        return rounding(grossSalary / 12)
    }

    /**
     *This function calculates the employee's monthly PRSI
     **/
    fun getMonthlyPRSI(): Double {
       return rounding(getMonthlySalary()*(prsiPercentage / 100))
    }
    /**
     *This function calculates the employee's monthly PAYE
     **/
    fun getMonthlyPAYE(): Double {
        return rounding(getMonthlySalary()* (payePercentage / 100))
    }
    /**
     *This function calculates the employee's monthly bonus
     **/
    fun getBonus()=rounding(annualBonus/12)

    /**
     *This function calculates the employee's gross monthly pay
     **/
    fun getGrossMonthlyPay():Double{
      return  rounding(getMonthlySalary() + getBonus())
    }
    /**
     *This function calculates the employee's total monthly deductions
     **/
    fun getTotalMonthlyDeductions():Double {
        return rounding(getMonthlyPRSI() + getMonthlyPAYE() + cycleToWorkScheme)
    }

    /**
     * This function calculates the employee's net monthly pay
     **/
    fun getNetMonthlyPay():Double{
        return rounding(getGrossMonthlyPay() - getTotalMonthlyDeductions())
    }

    /**
     * rounds values to the 2 decimal points
     */
    fun rounding(num: Double):Double{
       return "%.2f".format(num).toDouble()
    }
    /**
     * prints the payslip menu with the finished values
     */
    fun getpayslipLayout():String{
                return """                __________________________________________________________
                                    Monthly Payslip                      
                __________________________________________________________
                                                             
                Employee Name: ${getFullname()}(${gender.uppercase()})            Employee ID:$employeeId  
    
                __________________________________________________________
                                                              
                                    PAYMENT DETAILS         
                __________________________________________________________
                                                              
                            Salary:${getMonthlySalary()}                            
                            bonus:${getBonus()}                               
                      --------------------------------------------
                            Gross:${getGrossMonthlyPay()}
                __________________________________________________________
                                DEDUCTION DETAILS
                __________________________________________________________
                                
                            PAYE:${getMonthlyPAYE()}
                            PRSI:${getMonthlyPRSI()} 
                            Cycle To Work:${cycleToWorkScheme}
                      ----------------------------------------
                            Total Deductions:${getTotalMonthlyDeductions()}                                                      
                __________________________________________________________
                        NET PAY:${getNetMonthlyPay()}                       
                __________________________________________________________"""
    }


    override fun toString(): String {
        return "Employee(firstName='$firstName', surname='$surname', gender=$gender, employeeID=$employeeId, grossSalary=$grossSalary, payePercentage=$payePercentage, prsiPercentage=$prsiPercentage, annualBonus=$annualBonus, cycleToWorkScheme=$cycleToWorkScheme)"
    }



}




