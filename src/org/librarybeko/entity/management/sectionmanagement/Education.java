package org.librarybeko.entity.management.sectionmanagement;

import org.librarybeko.entity.management.pr.Author;
import org.librarybeko.entity.management.enums.CategoryType;
import org.librarybeko.entity.management.enums.StatusType;

public class Education extends Book {
    public Education(Long ISBN, String title, Author author, Integer edition, StatusType bookStatusType, Double price) {
        super(ISBN, title, author, edition, price);
        setCategory(CategoryType.EDUCATION);
    }
}
