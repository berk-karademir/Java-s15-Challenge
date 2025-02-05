package org.librarybeko.entity.management.pr;

import org.librarybeko.entity.management.enums.MemberType;

public class Student extends Member{

    public Student(String fullName, String address, Long phoneNumber, String username, String password) {
        super(fullName, MemberType.STUDENT ,address, phoneNumber, username, password);
    }

    @Override
    public void showBook() {
        super.showBook();
    }
}
