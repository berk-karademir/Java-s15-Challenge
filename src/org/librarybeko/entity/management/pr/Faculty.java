package org.librarybeko.entity.management.pr;

import org.librarybeko.entity.management.enums.MemberType;

public class Faculty extends Member{

    public Faculty(String fullName, String address, Long phoneNumber, String username, String password) {
        super(fullName, MemberType.FACULTY, address, phoneNumber, username, password);
    }

    @Override
    public void showBook() {
        super.showBook();
    }
}
