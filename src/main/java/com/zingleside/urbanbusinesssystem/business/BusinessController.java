package com.zingleside.urbanbusinesssystem.business;

import com.zingleside.urbanbusinesssystem.business.entity.Business;
import com.zingleside.urbanbusinesssystem.businessOwner.entity.BusinessOwner;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Businesses Manager")
public class BusinessController {
    private final BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }


    @PostMapping("/business")
    void createNewBusinessOwner(@RequestBody Business business){
        System.out.println("post request");
        System.out.println(business);
    }

    @PutMapping
    void updateNewBusinessOwner(@RequestBody Business business ){
        System.out.println("update request");
        System.out.println(business);
    }

    @DeleteMapping("{BusinessID}")
    void deleteBusiness(@PathVariable("{BusinessID}") Integer id){
        System.out.println("delete request for id"+ id  );
    }


}
