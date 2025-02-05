package org.librarybeko.entity.management.sectionmanagement;

import org.librarybeko.entity.management.pr.Author;
import org.librarybeko.entity.management.enums.CategoryType;

public class Classic extends Book {
    public Classic(Long ISBN, String title, Author author, Integer edition, Double price) {
        super(ISBN, title, author, edition, price);
        setCategory(CategoryType.CLASSIC);
    }

}
