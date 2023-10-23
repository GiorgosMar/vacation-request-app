package com.example.demo.controller;

import com.example.demo.domain.Bonus;
import com.example.demo.dto.BonusDTO;
import com.example.demo.service.BonusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class BonusController {
    private final BonusService bonusService;

    public BonusController(BonusService bonusService) {
        this.bonusService = bonusService;
    }

    @GetMapping(path = "/bonus")
    public List<BonusDTO> getAllBonus(){
        return bonusService.getAllBonus();
    }

    @GetMapping(path = "/bonus/{bonusId}")
    public BonusDTO getBonusById(@PathVariable("bonusId") Long bonusId){
        return bonusService.getBonusById(bonusId);
    }

    @GetMapping(path = "/bonus/calculateOfBonus")
    public double getCalculationOfBonus(
            @RequestParam double salary,
            @RequestParam String season
    ){
        return bonusService.getCalculationOfBonus(salary, season);
    }

    @PostMapping(path = "/bonus/newBonus")
    public List<BonusDTO> addNewBonus(
            @RequestParam Long companyId,
            @RequestParam String season
    ){
        return bonusService.addNewBonus(companyId, season);
    }

    @PostMapping(path = "/bonus")
    public BonusDTO newBonus(@RequestBody Bonus bonus){
        return bonusService.addNewBonus(bonus);
    }

    @DeleteMapping(path = "/bonus/{bonusId}")
    public void deleteBonus(@PathVariable("bonusId") Long bonusId){
        bonusService.deleteBonus(bonusId);
    }

    @PutMapping(path = "/bonus/{bonusId}")
    public BonusDTO updateBonus(
            @PathVariable("bonusId") Long bonusId,
            @RequestBody Bonus bonus){
        return bonusService.updateBonus(bonusId, bonus);
    }
}
