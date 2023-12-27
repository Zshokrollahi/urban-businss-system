package com.zingleside.urbanbusinesssystem.businessOwner;

import com.zingleside.urbanbusinesssystem.business.BusinessJDBCDataAccessService;
import com.zingleside.urbanbusinesssystem.business.entity.Business;
import com.zingleside.urbanbusinesssystem.businessOwner.entity.BusinessOwner;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Businesses Manager")
public class BusinessOwnerController {

    private final BusinessOwnerService businessOwnerService;

    public BusinessOwnerController( BusinessOwnerService businessOwnerService) {

        this.businessOwnerService = businessOwnerService;
    }


    @PostMapping("/business-owner")
    void createNewBusinessOwner(@RequestBody BusinessOwner businessOwner){
        System.out.println("post request");
        System.out.println(businessOwner);
    }

    @PutMapping("/business-owner")
    void updateNewBusinessOwner(@RequestBody BusinessOwner businessOwner){
        System.out.println("update request");
        System.out.println(businessOwner);
    }

    @DeleteMapping("{BusinessOwnerID}")
    void deleteBusinessOwner(@PathVariable("{BusinessOwnerID}") Integer id){
        System.out.println("delete request for id"+ id  );
    }


}
