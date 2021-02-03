//import React, { useEffect, useState } from 'react';
//import { useDispatch, useSelector } from 'react-redux';
//import { Link } from 'react-router-dom';
//import data from '../data';
//import { detailsProduct } from '../actions/productAction';
//import e from 'express';

import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
import { detailsProduct, saveProductReview } from '../actions/productAction';


function ProductScreen (props){
    /*
    console.log(props.match.params.id);
    const product = data.products.find(x=> x._id === props.match.params.id);
    */

    const [qty, setQty] = useState(1);
    const productDetails = useSelector(state => state.productList);
    console.log(productDetails);
    const {products, loadign, error} = productDetails;
    const dispatch = useDispatch();

    useEffect(() => {
        dispatch(detailsProduct(props.match.params.id));
        return () => {
        };
    }, [dispatch])

    const handleAddToCart = () => {
        props.history.push("/cart/" + props.match.params.id + "?qty" + qty)
    }


    return <div>
        <div className="back-to-result">
            <Link to='/'>Torna indietro</Link>
        </div>
        {loadign? <div> Caricamento...</div>:
        error? <div> {error} </div>:
        (
        <div className="details">
            <div className="detail-image">
                <img src={"../" + products.image} alt="product"></img>
            </div>
            <div className="details-info">
                <ul>
                    <li>
                        <h4>{products.name}</h4>
                    </li>
                    <li>
                        {products.rating} Voto ({products.numReviews})
                    </li>
                    <li>
                        Prezzo: <b> $ {products.price}</b>
                    </li>
                    <li>
                        Descrizione:
                        <div>
                            {products.description}
                        </div>
                    </li>
                </ul>
            </div>
            <div className="details-action">
                <ul>
                    <li>
                    Prezzo: {products.price}
                    </li>
                    <li>
                    Stato: {products.countInStock > 0? "In Stock" : "" }
                    </li>
                    <li>
                    
                    Quantità: <select value ={qty} onChange={(e)=> { setQty(e.target.value)}}>

                        {[...Array(products.countInStock).keys()].map(x=>
                            <option key value={x+1}>{x+1}</option>
                            )}

                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                        <option>6</option>
                        <option>7</option>
                        <option>8</option>
                        <option>9</option>
                        <option>10</option>


                    </select>
                    </li>
                    <li>
                        {products.countInStock > 0 && <button onClick={handleAddToCart} className="button"> Cerca il prodotto in negozio!</button>
                        }
                        
                    </li>
                </ul>
            </div>

        </div>

        )
         }
        
    </div>
    
}
export default ProductScreen;