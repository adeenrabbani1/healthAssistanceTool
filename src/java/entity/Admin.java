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
public class Admin extends User {

    //fields needed to be executed by the constructor
    private boolean flagCanAssign, flagCanAddAdmin, flagCanAddSurveyor, flagCanViewResult;
    private int admin_id;

    //contructor method!
    public Admin(int adminid, boolean flagCanAssign, boolean flagCanAddAdmin, boolean flagCanAddSurveyor, boolean flagCanViewResult, String name, String email, String phone, String age, String role, String password) {
        super(name, email, phone, role, age, password);
        this.admin_id = adminid;
        this.flagCanAssign = flagCanAssign; 
        this.flagCanAddAdmin = flagCanAddAdmin;
        this.flagCanAddSurveyor = flagCanAddSurveyor;
        this.flagCanViewResult = flagCanViewResult;
    }

    //setters and getters methods!
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

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }
}
