package org.librarybeko.entity.management.sectionmanagement;

import org.librarybeko.entity.management.pr.Author;
import org.librarybeko.entity.management.enums.CategoryType;

public class Philosophy extends Book {
    public Philosophy(Long ISBN, String title, Author author, Integer edition, Double price) {
        super(ISBN, title, author, edition, price);
        setCategory(CategoryType.PHILOSOPHY);
    }
}
