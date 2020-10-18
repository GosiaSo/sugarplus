package pl.sobocinska.sugarplus.sugar;

import java.util.List;

public interface SugarService {
    List<Sugar> findSugars();
    Sugar findSugarById(Long id);
    Sugar createSugar(Sugar sugar);
    Sugar editSugar(Sugar sugar);
    void deleteSugar(Long id);

}
