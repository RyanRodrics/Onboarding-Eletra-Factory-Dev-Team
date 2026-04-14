package com.energy.energy.api.services;

import com.energy.energy.api.models.dto.BoxDTO;
import com.energy.energy.api.models.dto.MeterDTO;
import com.energy.energy.api.models.entities.Box;
import com.energy.energy.api.repositories.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class BoxService {

    @Autowired
    private BoxRepository boxRepository;

    public Page<BoxDTO> getBoxes(Long id, Pageable pageable) {

        if (id != null) {
            return boxRepository.findById(id)
                    .map(box -> {
                        List<BoxDTO> content = List.of(toDTO(box));
                        return (Page<BoxDTO>) new PageImpl<>(content, pageable, 1);
                    })
                    .orElseGet(() -> Page.empty(pageable));
        }

        return boxRepository.findAll(pageable).map(this::toDTO);
    }

    public BoxDTO create(Box box) {
        box.setDateCreate(LocalDateTime.now());
        box.setDateEdit(LocalDateTime.now());

        Box savedBox = boxRepository.save(box);
        return toDTO(savedBox);
    }

    public Optional<BoxDTO> update(Long id, Box boxDetails) {
        return boxRepository.findById(id).map(existingBox -> {
            existingBox.setPackNumber(boxDetails.getPackNumber());
            existingBox.setProductionOrder(boxDetails.getProductionOrder());
            existingBox.setPalletNumber(boxDetails.getPalletNumber());
            existingBox.setBoxNumber(boxDetails.getBoxNumber());
            existingBox.setQuantityMetersInBox(boxDetails.getQuantityMetersInBox());
            existingBox.setBoxWeight(boxDetails.getBoxWeight());
            existingBox.setClosed(boxDetails.getClosed());
            existingBox.setPrinted(boxDetails.getPrinted());
            existingBox.setClosedByUserName(boxDetails.getClosedByUserName());
            existingBox.setUserEdit(boxDetails.getUserEdit());
            existingBox.setDateEdit(LocalDateTime.now());

            Box updatedBox = boxRepository.save(existingBox);
            return toDTO(updatedBox);
        });
    }

    public boolean delete(Long id) {
        if (boxRepository.existsById(id)) {
            boxRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private BoxDTO toDTO(Box box) {
        List<MeterDTO> meters = box.getBoxMeters() != null
                ? box.getBoxMeters().stream()
                .map(m -> new MeterDTO(
                        m.getId(),
                        m.getProductionOrder(),
                        m.getPackNumber(),
                        m.getBoxNumber(),
                        m.getEletraNumber(),
                        m.getClientNumber(),
                        m.getMeterWeight(),
                        m.getMeterBoxWeight(),
                        m.getDateCreate(),
                        m.getDateEdit()
                ))
                .collect(Collectors.toList())
                : List.of();

        return new BoxDTO(
                box.getId(), box.getPackNumber(), box.getProductionOrder(),
                box.getPalletNumber(), box.getBoxNumber(), box.getQuantityMetersInBox(),
                box.getBoxWeight(), box.getClosed(), box.getPrinted(),
                box.getClosedByUserName(), box.getUserCreate(), box.getUserEdit(),
                box.getDateCreate(), box.getDateEdit(),
                meters
        );
    }
}