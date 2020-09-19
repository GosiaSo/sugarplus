package pl.sobocinska.sugarplus.sugar;

import java.util.List;

public interface SugarService {
    List<Sugar> findSugars();
    Sugar findSugarById(Long id);
    void createSugar(Sugar sugar);
    void editSugar(Sugar sugar);
    void deleteSugar(Long id);

}
