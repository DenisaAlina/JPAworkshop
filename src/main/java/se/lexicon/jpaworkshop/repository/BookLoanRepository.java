package se.lexicon.jpaworkshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.jpaworkshop.entity.BookLoan;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookLoanRepository extends CrudRepository <BookLoan, Integer> {

    List<BookLoan> findByBorrowerId(int borrowerId);
    List<BookLoan> findByBookId(int bookId);
    List<BookLoan> findByReturnedFalse();
    List<BookLoan> findByDueDateBeforeAndReturnedFalse(LocalDate dueDate);
    List<BookLoan> findByLoanDateBetween(LocalDate startDate, LocalDate endDate);

    // Custom method to mark a book loan as returned
    default void markAsReturned(int loanId) {
        findById(loanId).ifPresent(loan -> {
            loan.setReturned(true);
            save(loan);
        });
    }
}
