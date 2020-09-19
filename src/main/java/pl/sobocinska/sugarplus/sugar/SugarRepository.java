package pl.sobocinska.sugarplus.sugar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SugarRepository extends JpaRepository<Sugar, Long> {

    //TO DO: funkcja do znajdywania dużych i małych cukrów



    @Query(value = "select * from sugars order by date asc limit 20", nativeQuery = true)
    List <Sugar> findRecentSugars();
}
