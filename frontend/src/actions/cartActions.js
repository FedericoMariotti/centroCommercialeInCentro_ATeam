import Axios from 'axios';
import {
  CART_ADD_ITEM,
  CART_REMOVE_ITEM,
  CART_ADD_ITEM_FAIL,
} from '../constants/cartConstants';

export const addToCart = (productId, qty) => async (dispatch, getState) => {
  const { data } = await Axios.get(`/controller/api/products/${productId}`);
  const {
    cart: { cartItems },
  } = getState();
  if (cartItems.length > 0 && data.seller._id !== cartItems[0].seller._id) {
    dispatch({
      type: CART_ADD_ITEM_FAIL,
      payload: ` ${cartItems[0].seller.seller.name} `,
    });
  } else {
    dispatch({
      type: CART_ADD_ITEM,
      payload: {
        name: data.name,
        image: data.image,
        price: data.price,
        countInStock: data.countInStock,
        product: data._id,
        seller: data.seller,
        qty,
      },
    });
    localStorage.setItem(
      'Prodotti',
      JSON.stringify(getState().cart.cartItems)
    );
  }
};

export const removeFromCart = (productId) => (dispatch, getState) => {
  dispatch({ type: CART_REMOVE_ITEM, payload: productId });
  localStorage.setItem('Prodotti', JSON.stringify(getState().cart.cartItems));
};

