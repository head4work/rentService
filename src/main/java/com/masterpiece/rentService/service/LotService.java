package com.masterpiece.rentService.service;

import com.masterpiece.rentService.model.Lot;
import com.masterpiece.rentService.repository.LotRepository;
import org.springframework.stereotype.Service;

@Service
public class LotService {

    private final LotRepository lotRepository;

    public LotService(LotRepository lotRepository) {
        this.lotRepository = lotRepository;
    }

    public Lot create(Lot lot, int userId) {
        return lotRepository.save(lot, userId);
    }

}
