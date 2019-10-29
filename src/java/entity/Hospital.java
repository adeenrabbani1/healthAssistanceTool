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
public class Hospital {

    private String name;
    private String phone;
    private String licenseNum;
    private String address;
    private String country;
    private int numOfBeds;
    private int numOfPatients;
    private int numOfOutPatient;
    private int numOfInPatient;
    private int numOfPatient;
    //as director is not specific to our system! hospital will register director on its own
   private String directorName;
   private String directorEmail;
   private String directorPhone;
    //constructor for setting all the values for the hostpital
   
   
    public Hospital(String name, String phone, String licenseNum, String address, String country, int numOfBeds, int numOfPatients, int numOfOutPatient, int numOfInPatient, int numOfPatient, String directorName, String directorEmail, String directorPhone) {
        this.name = name;
        this.phone = phone;
        this.licenseNum = licenseNum;
        this.address = address;
        this.country = country;
        this.numOfBeds = numOfBeds;
        this.numOfPatients = numOfPatients;
        this.numOfOutPatient = numOfOutPatient;
        this.numOfInPatient = numOfInPatient;
        this.numOfPatient = numOfPatient;
        this.directorName = directorName;
        this.directorEmail = directorEmail;
        this.directorPhone = directorPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNumOfBeds() {
        return numOfBeds;
    }

    public void setNumOfBeds(int numOfBeds) {
        this.numOfBeds = numOfBeds;
    }

    public int getNumOfPatients() {
        return numOfPatients;
    }

    public void setNumOfPatients(int numOfPatients) {
        this.numOfPatients = numOfPatients;
    }

   
    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getDirectorEmail() {
        return directorEmail;
    }

    public void setDirectorEmail(String directorEmail) {
        this.directorEmail = directorEmail;
    }

    public String getDirectorPhone() {
        return directorPhone;
    }

    public void setDirectorPhone(String directorPhone) {
        this.directorPhone = directorPhone;
    }

    public int getNumOfOutPatient() {
        return numOfOutPatient;
    }

    public void setNumOfOutPatient(int numOfOutPatient) {
        this.numOfOutPatient = numOfOutPatient;
    }
   
    //set the surveyor here for the hospital
    public int getNumOfInPatient() {
        return numOfInPatient;
    }

    public void setNumOfInPatient(int numOfInPatient) {
        this.numOfInPatient = numOfInPatient;
    }

    public int getNumOfPatient() {
        return numOfPatient;
    }

    public void setNumOfPatient(int numOfPatient) {
        this.numOfPatient = numOfPatient;
    }


    
}
