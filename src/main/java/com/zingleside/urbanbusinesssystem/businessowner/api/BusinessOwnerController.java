package com.zingleside.urbanbusinesssystem.businessowner.api;

import com.zingleside.urbanbusinesssystem.businessowner.model.BusinessOwner;
import com.zingleside.urbanbusinesssystem.businessowner.service.BusinessOwnerServiceContract;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Businesses Owner")
public class BusinessOwnerController {

  private final BusinessOwnerServiceContract businessOwnerServiceContract;

  public BusinessOwnerController(BusinessOwnerServiceContract businessOwnerServiceContract) {

    this.businessOwnerServiceContract = businessOwnerServiceContract;
  }

  @PostMapping("/business-owners")
  BusinessOwner createNewBusinessOwner(@RequestBody BusinessOwner businessOwner) {
    return businessOwnerServiceContract.create(businessOwner);
  }

  @PutMapping("/business-owners")
  BusinessOwner updateNewBusinessOwner(@RequestBody BusinessOwner businessOwner) {
    return businessOwnerServiceContract.update(businessOwner);
  }

  @DeleteMapping("/business-owners/{id}")
  long deleteBusinessOwner(@PathVariable("id") long id) {
    return businessOwnerServiceContract.deleteById(id);
  }

  @GetMapping("/business-owners")
  List<BusinessOwner> findAll() {
    return businessOwnerServiceContract.findAll();
  }

  @GetMapping("/business-owners/{id}")
  BusinessOwner getById(@PathVariable("id") long id) {
    return businessOwnerServiceContract.getById(id);
  }
}
