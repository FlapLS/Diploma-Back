package com.example.plasticmodels.common;

public interface Endpoints {

    interface BasicOperationPrinter {
        String PLASTIC_MODEL_CREATE = "/plastic-models";
        String PLASTIC_MODEL_GET = "/plastic-models/{plasticModelId}";
        String PLASTIC_MODEL_DELETE = "plastic-models/{plasticModelId}";
        String PLASTIC_MODEL_UPDATE = "plastic-models/{plasticModelId}";
        String PLASTIC_MODEL_ALL = "/plastic-models/all";
    }
    interface BasicOperationShop{
        String SHOP_CREATE = "/shops";
        String SHOP_GET = "/shops/{shopsId}";
        String SHOP_DELETE = "shops/{shopsId}";
        String SHOP_UPDATE = "shops/{shopsId}";
        String SHOP_ALL = "/shops/all";
        String DELETE_BY_PLASTIC_MODEL_ID = "/shops/all/{plasticModelId}";
    }
}
