import { PRODUCT_LIST_FAIL, PRODUCT_LIST_REQUEST, PRODUCT_LIST_SUCCESS,
         PRODUCT_DETAILS_FAIL, PRODUCT_DETAILS_REQUEST, PRODUCT_DETAILS_SUCCESS,
         PRODUCT_SAVE_FAIL, PRODUCT_SAVE_REQUEST, PRODUCT_SAVE_SUCCESS,
         PRODUCT_DELETE_FAIL, PRODUCT_DELETE_REQUEST, PRODUCT_DELETE_SUCCESS, 
          } from "../constants/productConstants";

function productListReducer( state = { product: [] }, action ) {
    switch (action.type) {
        case PRODUCT_LIST_REQUEST: 
            return {loadign: true, products: [] };
        case PRODUCT_LIST_SUCCESS:
            return {loadign: false, products: action.payload};
        case PRODUCT_LIST_FAIL:
            return {loadign: false, error: action.payload}
        default:
            return state;
    }
}

function productDetailsReducer(state = { product:{} }, action ) {
    switch (action.type) {
        case PRODUCT_DETAILS_REQUEST: 
            return {loadign: true};
        case PRODUCT_DETAILS_SUCCESS:
            return {loadign: false, product: action.payload};
        case PRODUCT_DETAILS_FAIL:
            return {loadign: false, error: action.payload}
        default:
            return state;
    }
}

function productDeleteReducer(state = { product:{} }, action ) {
    switch (action.type) {
        case PRODUCT_DELETE_REQUEST: 
            return {loadign: true};
        case PRODUCT_DELETE_SUCCESS:
            return {loadign: false, product: action.payload, success: true};
        case PRODUCT_DELETE_FAIL:
            return {loadign: false, error: action.payload}
        default:
            return state;
    }
}

function productSaveReducer(state = { product:{} }, action ) {
    switch (action.type) {
        case PRODUCT_SAVE_REQUEST: 
            return {loadign: true};
        case PRODUCT_SAVE_SUCCESS:
            return {loadign: false, success: true, product: action.payload};
        case PRODUCT_SAVE_FAIL:
            return {loadign: false, error: action.payload}
        default:
            return state;
    }
}

export { productListReducer, productDetailsReducer, productSaveReducer, productDeleteReducer}