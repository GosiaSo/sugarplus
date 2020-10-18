package pl.sobocinska.sugarplus.sugar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class JpaSugarService implements SugarService {
    private final SugarRepository sugarRepository;

    @Autowired
    public JpaSugarService(SugarRepository sugarRepository) {
        this.sugarRepository = sugarRepository;
    }

    @Override
    public List<Sugar> findSugars() {
        return sugarRepository.findAll();
    }

    @Override
    public Sugar findSugarById(Long id) {
        return sugarRepository.getOne(id);
    }

    public List<Sugar> findSugarsByDate() {

        return sugarRepository.findRecentSugars();
    }

    @Override
    public Sugar createSugar(Sugar sugar) {
        return sugarRepository.save(sugar);
    }

    @Override
    public Sugar editSugar(Sugar sugar) {
        return sugarRepository.save(sugar);
    }

    @Override
    public void deleteSugar(Long id) {
        sugarRepository.delete(sugarRepository.getOne(id));
    }


}
