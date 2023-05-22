package com.example.shopservice.common;

public interface Endpoints {

    interface BasicOperationPrinter {
        String PRINTER_CREATE = "/printers";
        String PRINTER_GET = "/printers/{printersId}";
        String PRINTER_DELETE = "printers/{printersId}";
        String PRINTER_UPDATE = "printers/{printersId}";
        String PRINTER_ALL = "/printers/all";
    }
    interface BasicOperationShop{
        String SHOP_CREATE = "/shops";
        String SHOP_GET = "/shops/{shopsId}";
        String SHOP_DELETE = "shops/{shopsId}";
        String SHOP_UPDATE = "shops/{shopsId}";
        String SHOP_ALL = "/shops/all";
        String DELETE_BY_PLASTIC_MODEL_ID = "/shops/all/{printersId}";
    }
}
