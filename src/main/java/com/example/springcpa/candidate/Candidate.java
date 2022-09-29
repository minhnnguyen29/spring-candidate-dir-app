package com.example.springcpa.candidate;

import javax.persistence.*;
import java.time.*;

@Entity
//create table named "candidate" with constraint: column "email" is unique 
@Table(
    name = "Candidate",
    uniqueConstraints = @UniqueConstraint(
        name = "c_email_unique", 
        columnNames = "email"
    )
)//this will be mapped to table "candidate"
public class Candidate {
    @Id
    @SequenceGenerator(
            name = "candidate_sequence",
            sequenceName = "candidate_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "candidate_sequence"
    )
    @Column(
        name = "id",
        updatable = false
    )
    private Long id;
    
    @Column(
        name = "first_name", 
        nullable = false, 
        columnDefinition = "TEXT"
    )
    private String firstName;
    
    @Column(
        name = "last_name", 
        nullable = false, 
        columnDefinition = "TEXT"
    )private String lastName;
    
    @Column(
        name = "email", 
        nullable = false, 
        columnDefinition = "TEXT" 
    )
    private String email;
    
    @Column(
        name = "password", 
        nullable = false, 
        columnDefinition = "TEXT"
    )
    private String password; 
    
    @Column(
        name = "dob", 
        nullable = false, 
        columnDefinition = "DATE"
    )
    private LocalDate dob;

    @Column(
        name = "education", 
        columnDefinition =  "TEXT"
    )
    private String education; 
    
    @Column(
        name = "cover_letter", 
        columnDefinition = "TEXT"
    )
    private String coverLetter; 
    
    @Transient
    private Integer age;

    //Constructors
    public Candidate() {//no-arg
    }

    public Candidate(String firstName,
                     String lastName,
                     String email, 
                     String password,
                     LocalDate dob, 
                     String education, 
                     String coverLetter) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password; 
        this.dob = dob;
        this.education = education; 
        this.coverLetter = coverLetter;
    }

    //Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword(){
        return password; 
    }

    public void setPassword(String password){
        this.password = password;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEducation(){
        return education; 
    }

    public void setEducation(String education){
        this.education = education; 
    }

    public String getCoverLetter(){
        return coverLetter; 
    }

    public void setCoverLetter(String coverLetter){
        this.coverLetter = coverLetter; 
    }

    public Integer getAge() {

        return Period.between(dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void printCandidate(){
        System.out.println();
        System.out.println("Name: " + firstName + " " + lastName); 
        System.out.println("Date of Birth: " + dob.toString());
        System.out.println("Email: " + email); 
        System.out.println("Education: " + education); 
        System.out.println("Cover Letter: " + (coverLetter == null ? "No" : "Yes"));
    }
}
