package com.zingleside.urbanbusinesssystem.advertising;

import com.zingleside.urbanbusinesssystem.advertising.entity.Advertising;

import java.util.List;

public interface AdvertisingDAO {

    List<Advertising> selectALlAdvertising();

    Advertising insertAdvertising(Advertising advertising);

    List<Advertising> selectPrice();
}
