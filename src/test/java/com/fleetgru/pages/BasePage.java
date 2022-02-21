package com.fleetgru.pages;

import com.fleetgru.utilities.ConfigurationReader;
import com.fleetgru.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){ PageFactory.initElements(Driver.get(), this);}

    public String getUserName(String userType){

        String username="";

        switch (userType){
            case "Driver":
                username = ConfigurationReader.get("driver_username");
                break;
            case "Store manager":
                username = ConfigurationReader.get("store_manager_username");
                break;
            case "Sales manager":
                username = ConfigurationReader.get("sales_manager_username");
                break;
            default:
                System.out.println("Invalid user_type");
                break;
        }
        System.out.println("username = " + username);
        return username;
    }
}
