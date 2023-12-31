package com.zingleside.urbanbusinesssystem.business;

import com.zingleside.urbanbusinesssystem.business.entity.Business;
import com.zingleside.urbanbusinesssystem.user.entity.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Businesses Manager")
public class BusinessController {

    private final BusinessJDBCDataAccessService businessJDBCDataAccessService;

    public BusinessController(BusinessJDBCDataAccessService businessJDBCDataAccessService) {
        this.businessJDBCDataAccessService = businessJDBCDataAccessService;

    }

    @GetMapping("/business")
    public List<Business> getAllbusiness(){
        return businessJDBCDataAccessService.selectAllBusinesses();


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
