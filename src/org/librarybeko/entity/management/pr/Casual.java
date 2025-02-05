package org.librarybeko.entity.management.pr;

import org.librarybeko.entity.management.enums.MemberType;
//student yada fakülte olmayan normal üyeler için
public class Casual extends Member{
    public Casual(String fullName, String address, Long phoneNumber, String username, String password) {
        super(fullName, MemberType.NORMAL, address, phoneNumber, username, password);
    }

    @Override
    public void showBook() {
        super.showBook();
    }
}
