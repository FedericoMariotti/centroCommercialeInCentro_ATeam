import { PRODUCT_DETAILS_FAIL, PRODUCT_DETAILS_REQUEST, PRODUCT_DETAILS_SUCCESS, 
    PRODUCT_LIST_FAIL, PRODUCT_LIST_REQUEST, PRODUCT_LIST_SUCCESS,
    PRODUCT_SAVE_REQUEST, PRODUCT_SAVE_SUCCESS, PRODUCT_SAVE_FAIL } from "../constants/productConstants";

function productListReducer( state = { product:[]}, action ) {

    switch (action.type) {
        case PRODUCT_LIST_REQUEST: 
            return {loadign: true};
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

function productSaveReducer(state = { product: {} }, action ) {

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

export { productListReducer, productDetailsReducer, productSaveReducer }