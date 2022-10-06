package com.masterpiece.rentService.controller.lot;

import com.masterpiece.rentService.model.Lot;
import com.masterpiece.rentService.service.LotService;
import com.masterpiece.rentService.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class AbstractLotController {
    @Autowired
    private RentService rentService;

    @Autowired
    private LotService lotService;

    public List<Lot> getAll() {
        return lotService.getAll();
    }

    protected void delete(int id) {
        lotService.delete(id);
    }

    protected Lot get(int id) {
        return lotService.get(id);
    }

    protected Lot create(Lot lot) {
        return lotService.create(lot);
    }

    protected Set<LocalDateTime> getLotRentDates(Lot lot) {
        return rentService.getLotRentDates(lot);
    }
}
