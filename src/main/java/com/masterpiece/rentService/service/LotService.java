package com.masterpiece.rentService.service;

import com.masterpiece.rentService.model.Lot;
import com.masterpiece.rentService.repository.LotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.masterpiece.rentService.util.ValidationUtil.checkNotFoundWithId;

@Service
public class LotService {

    private final LotRepository lotRepository;

    public LotService(LotRepository lotRepository) {
        this.lotRepository = lotRepository;
    }

    public Lot create(Lot lot, int userId) {
        return lotRepository.save(lot, userId);
    }

    public void update(Lot lot, int userId) {
        checkNotFoundWithId(lotRepository.save(lot, userId), lot.id());
    }

    public void delete(int id, int userId) {
        checkNotFoundWithId(lotRepository.delete(id, userId), id);
    }

    public Lot get(int id) {
        return checkNotFoundWithId(lotRepository.get(id), id);
    }

    public List<Lot> getAll() {
        return lotRepository.getAll();
    }
}
