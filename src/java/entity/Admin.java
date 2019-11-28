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
    private int flagCanAssign, flagCanAddAdmin, flagCanAddSurveyor, flagCanViewResult;
    private int admin_id;

    public Admin(int id, int flagCanAssign, int flagCanAddAdmin, int flagCanAddSurveyor, int flagCanViewResult, String name, String email, String phone, String role, String age, String password) {
        super(name, email, phone, role, age, password);
        this.admin_id = id;
        this.flagCanAssign = flagCanAssign; 
        this.flagCanAddAdmin = flagCanAddAdmin;
        this.flagCanAddSurveyor = flagCanAddSurveyor;
        this.flagCanViewResult = flagCanViewResult;
        
    }

    

    
    //contructor method!
    

    public int getFlagCanAssign() {
        return flagCanAssign;
    }

    public void setFlagCanAssign(int flagCanAssign) {
        this.flagCanAssign = flagCanAssign;
    }

    public int getFlagCanAddAdmin() {
        return flagCanAddAdmin;
    }

    public void setFlagCanAddAdmin(int flagCanAddAdmin) {
        this.flagCanAddAdmin = flagCanAddAdmin;
    }

    public int getFlagCanAddSurveyor() {
        return flagCanAddSurveyor;
    }

    public void setFlagCanAddSurveyor(int flagCanAddSurveyor) {
        this.flagCanAddSurveyor = flagCanAddSurveyor;
    }

    public int getFlagCanViewResult() {
        return flagCanViewResult;
    }

    public void setFlagCanViewResult(int flagCanViewResult) {
        this.flagCanViewResult = flagCanViewResult;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }
}
    //setters and getters methods!
   