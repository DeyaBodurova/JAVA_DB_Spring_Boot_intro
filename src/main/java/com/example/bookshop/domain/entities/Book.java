package com.example.bookshop.domain.entities;

import com.example.bookshop.domain.enums.EditionType;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Book extends BaseEntity {
    @Column(nullable = false, length = 50)
    private String title;
    @Column(length = 1000)
    private String description;
    @Enumerated(EnumType.STRING)
    private EditionType editionType;
}
