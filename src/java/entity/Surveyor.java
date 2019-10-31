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
public class Surveyor extends User{
     private int surv_id;
      public Surveyor(int survId,String name, String email, String phone, String age, String role, String password){
          super(name, email, phone,role, age, password);
          this.surv_id = survId;
      }

    public int getSurv_id() {
        return surv_id;
    }

    public void setSurv_id(int surv_id) {
        this.surv_id = surv_id;
    }
}
