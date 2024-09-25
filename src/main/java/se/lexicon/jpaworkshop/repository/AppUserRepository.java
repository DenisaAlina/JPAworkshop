package se.lexicon.jpaworkshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.jpaworkshop.entity.AppUser;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
    Optional<AppUser> findByUsername(String username);
       List<AppUser> findAllByRegistrationDateBetween(LocalDate startDate, LocalDate endDate);
   Optional<AppUser> findByUserDetailsId(int detailsId);
    Optional<AppUser> findByUserDetails_EmailIgnoreCase(String email);
    //Optional
    Optional<AppUser> findByUsernameAndPassword(String username, String password);
}
