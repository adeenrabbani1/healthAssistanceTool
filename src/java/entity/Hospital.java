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

    private int hospitalId;
    private String name;
    private String phone;
    private String licenseNum;
    private String address;

    
   
    private String country;
    private int numOfBeds;
    private int numOfPatients;
    private int numOfOutPatient;
    private int numOfInPatient;
    //as director is not specific to our system! hospital will register director on its own
    private String directorName;
    private String directorEmail;
    private String directorPhone;
    //constructor for setting all the values for the hostpital

    public Hospital(int hospitalId, String name, String phone, String licenseNum, String address, String country, int numOfBeds, int numOfPatients, int numOfOutPatient, int numOfInPatient, String directorName, String directorEmail, String directorPhone) {

        this.hospitalId = hospitalId;
        this.name = name;
        this.phone = phone;
        this.licenseNum = licenseNum;
        this.address = address;
        this.country = country;
        this.numOfBeds = numOfBeds;
        this.numOfPatients = numOfPatients;
        this.numOfOutPatient = numOfOutPatient;
        this.numOfInPatient = numOfInPatient;
        
        this.directorName = directorName;
        this.directorEmail = directorEmail;
        this.directorPhone = directorPhone;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
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

   

    @Override
     public String toString() {
        return "Hospital{" + "name=" + name + ", phone=" + phone + ", licenseNum=" + licenseNum + ", address=" + address + ", country=" + country + ", numOfBeds=" + numOfBeds + ", numOfPatients=" + this.getNumOfPatients()+ ", numOfOutPatient=" + numOfOutPatient + ", numOfInPatient=" + numOfInPatient +", directorName=" + directorName + ", directorEmail=" + directorEmail + ", directorPhone=" + directorPhone + '}';
    }
}
