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
    private Director hospitalDirector;
    private Cordinator patientSafetyCordinator;
    private int surveyorId;
    //constructor for setting all the values for the hostpital

    public Hospital(String name, String phone, String licenseNum, String address, String country, int numOfBeds, int numOfPatients, int numOfOutPatient, int numOfInPatient, int numOfPatient,Director hospitalDirector, Cordinator patientSafetyCordinator) {
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
        
        this.hospitalDirector = hospitalDirector;
        this.patientSafetyCordinator = patientSafetyCordinator;
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

    public int getNumOfOutPatient() {
        return numOfOutPatient;
    }

    public void setNumOfOutPatient(int numOfOutPatient) {
        this.numOfOutPatient = numOfOutPatient;
    }
   
    //set the surveyor here for the hospital
    
    public int getSurveyorId() {
        return surveyorId;
    }

    public void setSurveyorId (int id) {
        this.surveyorId = id;
    }

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


    public Director getHospitalDirector() {
        return hospitalDirector;
    } 
    public void setHospitalDirector(Director hospitalDirector) {
        this.hospitalDirector = hospitalDirector;
    }

    public Cordinator getPatientSafetyCordinator() {
        return patientSafetyCordinator;
    }

    public void setPatientSafetyCordinator(Cordinator patientSafetyCordinator) {
        this.patientSafetyCordinator = patientSafetyCordinator;
    }
    public void registerDirector(String name,String email, String phone,String age){
        //if there is a hospital then only director exists mou!
         Director d1 = new Director(name,email,phone,age);
    }
    public void registerCordinator(String name,String email, String phone,String age){
        Cordinator c1 = new Cordinator (name,email,phone,age);
    }

}
