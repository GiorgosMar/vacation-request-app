package com.example.demo.service.mapper;

import com.example.demo.domain.Bonus;
import com.example.demo.dto.BonusDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BonusMapper {
    public BonusDTO toDTO(Bonus bonus) {
        BonusDTO bonusDTO = new BonusDTO();
        bonusDTO.setId(bonus.getId());
        bonusDTO.setEmployee(bonus.getEmployee());
        bonusDTO.setCompany(bonus.getCompany());
        bonusDTO.setAmount(bonus.getAmount());
        return bonusDTO;
    }

    public Bonus toEntity(BonusDTO bonusDTO) {
        Bonus bonus = new Bonus();
        bonus.setId(bonusDTO.getId());
        bonus.setEmployee(bonusDTO.getEmployee());
        bonus.setCompany(bonusDTO.getCompany());
        bonus.setAmount(bonusDTO.getAmount());
        return bonus;
    }

    public List<BonusDTO> toDTO(List<Bonus> bonusList) {
        List<BonusDTO> bonusDTOList = new ArrayList();
        for (Bonus bonus : bonusList) {
            BonusDTO bonusDTO = toDTO(bonus);
            bonusDTOList.add(bonusDTO);
        }
        return bonusDTOList;
    }

    public List<Bonus> toEntity(List<BonusDTO> bonusDTOList) {
        List<Bonus> bonusList = new ArrayList();
        for (BonusDTO bonusDTO : bonusDTOList) {
            Bonus bonus = toEntity(bonusDTO);
            bonusList.add(bonus);
        }
        return bonusList;
    }
}
