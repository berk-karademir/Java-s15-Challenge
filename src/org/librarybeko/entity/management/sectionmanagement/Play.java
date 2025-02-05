package org.librarybeko.entity.management.sectionmanagement;

import org.librarybeko.entity.management.pr.Author;
import org.librarybeko.entity.management.enums.CategoryType;

public class Play extends Book {
    public Play(Long ISBN, String title, Author author, Integer edition, Double price) {
        super(ISBN, title, author, edition, price);
        setCategory(CategoryType.PLAY);
    }
}
