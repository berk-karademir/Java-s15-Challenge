package main.library.shareholders;

import main.library.management.Library;

import java.time.LocalDateTime;

public class LibraryMember {

    private static Long idCounter= 5000L;
    private Long memberId;
    private MemberType membertype;
    private String fullName;
    private String address;
    private Long phoneNumber;
    private LocalDateTime registrationDate;
    private Boolean noBooksIssued;
    private Integer maxBookLimit;

    public LibraryMember(MemberType membertype, String fullName, String address, Long phoneNumber, Boolean noBooksIssued ) {
        this.memberId = ++idCounter;
        this.membertype = membertype;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.registrationDate = LocalDateTime.now();
        this.noBooksIssued = noBooksIssued;
        setMaxBookLimit();
    }

    public void setMaxBookLimit() {
        switch (membertype) {
            case STUDENT:
                this.maxBookLimit = 5;
                break;
            case FACULTY:
                this.maxBookLimit = 50;
                break;
            default:
                this.maxBookLimit = 1;
                System.out.println("Max book limit set as 1 by default.");
        }
    }

    public void increaseMaxBooksIssued(Integer maxBooksCount) {

    }


    public void decreaseMaxBooksIssued(Integer maxBooksCount) {

    }
}
