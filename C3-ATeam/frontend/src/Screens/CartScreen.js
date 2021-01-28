import React, { useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { addToCart } from '../actions/cartActions';
import {Link} from 'react-router-dom';

function CartScreen(props){
    const cart = useSelector(state => state.cart);

    const { cartItems } = cart;

    const productId = props.match.params.id;
    const qty = props.location.search? Number(props.location.search.split("=")[1]):1;
    const dispatch = useDispatch();
    const removeFromCartHandler = (productId) => {
        dispatch(removeFromCartHandler(productId)); /*non dovrebbe esserci Handrel, dovrebbe essere importato ma non viene letto --> correggere!!!*/

    }


    
    useEffect(() => {
        if(productId) {
            dispatch(addToCart(productId, qty));
        }
    }, [dispatch]); 
    
    const checkoutHandler = () => {
        props.history.push("/signin?redirect=shipping");
    }

    return <div className="cart">
        <div className="cart-list">
            <ul className="cart-list-container">
                <li>
                    <h3>
                        Prodotti salvati
                    </h3>
                    <div>
                        Prezzo
                    </div>

                </li>
                {
                    cartItems.length === 0 ?
                    <div>
                        Lista dei prodotti vuota
                    </div>
                    :
                    cartItems.map( item =>
                        <div>
                            <div className="cart-image">
                                <img src={item.image} alt="product" />
                            </div>
                            
                            <div className="cart-name">
                                <div>
                                    <Link to={"/product/" + item.product }>
                                        {item.name}
                                    </Link>
                                    
                                </div>
                                <div>
                                    Qty:
                                    <select value={item.qty} onChange={(e) => dispatch(item.product, e.target.value)}>
                                        <option valu="1">1</option>
                                        <option valu="2">2</option>
                                        <option valu="3">3</option>
                                    </select>
                                    <button type="button" className="button" onClick={() => removeFromCartHandler(item.product)}>
                                        Rimuovi dai prodotti selezionati
                                    </button>
                                </div>
                            </div>
                            <div className="cart-price">
                                $ {item.price}
                            </div>
                        </div>
                        )
                }

            </ul>

        </div>
        <div className="cart-action">
            <h3>
                Totale ( {cartItems.reduce((a, c) => a + c.qty, 0)} prodotti)
                :
                 $ {cartItems.reduce((a, c) => a + c.price * c.qty, 0)}
            </h3>
            <button onClick={checkoutHandler} className="button primary full-width" disabled={cartItems.length === 0}>
                Procedi al tuo negozo di fiducia!
            </button>

        </div>
    </div>
}

export default CartScreen;