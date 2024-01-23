package com.zingleside.urbanbusinesssystem.business.api;

import com.zingleside.urbanbusinesssystem.business.entity.Business;
import com.zingleside.urbanbusinesssystem.business.service.BusinessServiceContract;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Businesses")
public class BusinessController {

  private final BusinessServiceContract businessServiceContract;

  @Autowired
  public BusinessController(BusinessServiceContract businessServiceContract) {
    this.businessServiceContract = businessServiceContract;
  }

  @GetMapping("/businesses")
  public List<Business> findAll() {
    return businessServiceContract.findAll();
  }

  @GetMapping("/businesses/{id}")
  public Business getById(@PathVariable("id") long id) {
    return businessServiceContract.getById(id);
  }

  @PutMapping("/businesses")
  Business update(@RequestBody Business business) {
    return businessServiceContract.update(business);
  }

  @PostMapping("/businesses")
  Business create(@RequestBody Business business) {
    return businessServiceContract.create(business);
  }

  @DeleteMapping("/businesses/{id}")
  long deleteBusiness(@PathVariable("id") long id) {
    return businessServiceContract.deleteById(id);
  }
}
