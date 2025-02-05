package org.librarybeko.entity.management.sectionmanagement;

import org.librarybeko.entity.management.pr.Author;
import org.librarybeko.entity.management.enums.CategoryType;

public class Dystopian extends Book {

    public Dystopian(Long ISBN, String title, Author author, Integer edition, Double price) {
        super( ISBN, title, author, edition, price);
        setCategory(CategoryType.DYSTOPIAN);
    }
}
