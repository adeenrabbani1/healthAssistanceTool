/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author adeen
 */
public class Admin extends Person {

    public Admin(boolean flagCanAssign, boolean flagCanAddAdmin, boolean flagCanAddSurveyor, boolean flagCanViewResult, String name, String email, String phone, String age, String role) {
        super(name, email, phone,role, age);
        this.flagCanAssign = flagCanAssign;
        this.flagCanAddAdmin = flagCanAddAdmin;
        this.flagCanAddSurveyor = flagCanAddSurveyor;
        this.flagCanViewResult = flagCanViewResult;
    }
    private boolean flagCanAssign, flagCanAddAdmin, flagCanAddSurveyor,flagCanViewResult;

    public boolean isFlagCanAssign() {
        return flagCanAssign;
    }

    public void setFlagCanAssign(boolean flagCanAssign) {
        this.flagCanAssign = flagCanAssign;
    }

    public boolean isFlagCanAddAdmin() {
        return flagCanAddAdmin;
    }

    public void setFlagCanAddAdmin(boolean flagCanAddAdmin) {
        this.flagCanAddAdmin = flagCanAddAdmin;
    }

    public boolean isFlagCanAddSurveyor() {
        return flagCanAddSurveyor;
    }

    public void setFlagCanAddSurveyor(boolean flagCanAddSurveyor) {
        this.flagCanAddSurveyor = flagCanAddSurveyor;
    }

    public boolean isFlagCanViewResult() {
        return flagCanViewResult;
    }

    public void setFlagCanViewResult(boolean flagCanViewResult) {
        this.flagCanViewResult = flagCanViewResult;
    }
    
   
    }
  

