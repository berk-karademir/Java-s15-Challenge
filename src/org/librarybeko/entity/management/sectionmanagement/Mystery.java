package org.librarybeko.entity.management.sectionmanagement;

import org.librarybeko.entity.management.pr.Author;
import org.librarybeko.entity.management.enums.CategoryType;

public class Mystery extends Book {

    public Mystery(Long ISBN, String title, Author author, Integer edition, Double price) {
        super(ISBN, title, author, edition, price);
        setCategory(CategoryType.MYSTERY);
    }
}
