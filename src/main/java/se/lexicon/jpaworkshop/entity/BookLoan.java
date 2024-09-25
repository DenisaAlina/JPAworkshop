package se.lexicon.jpaworkshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "app_user_id", nullable = false)
    private AppUser borrower;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(nullable = false)
    private LocalDate loanDate;

    @Column(nullable = false)
    private LocalDate dueDate;

    @Column(nullable = false)
    private boolean returned;

    public BookLoan(AppUser borrower, Book book, LocalDate loanDate, LocalDate dueDate, boolean returned) {
        this.borrower = borrower;
        this.book = book;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returned = returned;
    }


}
