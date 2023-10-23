package com.example.demo.service;

import com.example.demo.domain.Bonus;
import com.example.demo.domain.Employee;
import com.example.demo.dto.BonusDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.enums.BonusRate;
import com.example.demo.exception.EmptyListException;
import com.example.demo.exception.SeasonException;
import com.example.demo.repository.BonusRepository;
import com.example.demo.service.mapper.BonusMapper;
import com.example.demo.service.mapper.EmployeeMapper;
import com.example.demo.utils.Const;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BonusService {
    private final BonusRepository bonusRepository;
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;
    private final BonusMapper bonusMapper;
    public BonusService(BonusRepository bonusRepository, EmployeeService employeeService, EmployeeMapper employeeMapper, BonusMapper bonusMapper) {
        this.bonusRepository = bonusRepository;
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
        this.bonusMapper = bonusMapper;
    }
    public List<BonusDTO> getAllBonus(){
        List<Bonus> bonusList = bonusRepository.findAll();
        List<BonusDTO> bonusDTOList = bonusMapper.toDTO(bonusList);
        return ResponseEntity.ok().body(bonusDTOList).getBody();
    }
    public double getCalculationOfBonus(double salary, String season){
        if(BonusRate.resolve(season) == null ){
            throw new SeasonException(Const.SEASON);
        }
        double salaryWithBonus = salary * BonusRate.resolve(season).getValue();
        return ResponseEntity.ok().body(salaryWithBonus).getBody();
    }
    public List<BonusDTO> addNewBonus(Long companyId, String season){
        List<EmployeeDTO> employeeDTOList = employeeService.getEmployeesByCompanyId(companyId);
        if (employeeDTOList.isEmpty()){
            throw new EmptyListException(Const.EMPTY_LIST);
        }
        List<Employee> employeeList = employeeMapper.toEntity(employeeDTOList);
        List<Bonus> bonusList = new ArrayList<>();
        for (Employee employee : employeeList) {
            Bonus bonus = new Bonus();
            bonus.setAmount(getCalculationOfBonus(employee.getSalary(), season));
            bonus.setCompany(employee.getCompany());
            bonus.setEmployee(employee);
            bonusList.add(bonus);
        }
        bonusRepository.saveAll(bonusList);
        List<BonusDTO> bonusDTOList = bonusMapper.toDTO(bonusList);
        return ResponseEntity.ok().body(bonusDTOList).getBody();
    }
    public BonusDTO getBonusById(Long bonusId){
        Optional<Bonus> bonusOptional = bonusRepository.findById(bonusId);
        if(bonusOptional.isEmpty()){
            throw new EntityNotFoundException("Bonus not found for id : " + bonusId);
        }
        BonusDTO bonusDTO = bonusMapper.toDTO(bonusOptional.get());
        return ResponseEntity.ok().body(bonusDTO).getBody();
    }
    public BonusDTO addNewBonus(Bonus bonus) {
        BonusDTO bonusDTO;
        bonusDTO = bonusMapper.toDTO(bonusRepository.save(bonus));
        return ResponseEntity.ok().body(bonusDTO).getBody();
    }
    public void deleteBonus(Long bonusId) {
        boolean exists = bonusRepository.existsById(bonusId);
        if(!exists){
            throw new EntityNotFoundException("Bonus with id " + bonusId + " does not exist");
        }
        bonusRepository.deleteById(bonusId);
    }
    @Transactional
    public BonusDTO updateBonus(Long bonusId, Bonus bonus) {
        boolean exists = bonusRepository.existsById(bonusId);
        BonusDTO bonusDTO;
        if(!exists){
            throw new EntityNotFoundException("Bonus with id " + bonusId + " does not exist");
        }else{
            bonusDTO = bonusMapper.toDTO(bonusRepository.save(bonus));
        }
        return ResponseEntity.ok().body(bonusDTO).getBody();
    }
}
