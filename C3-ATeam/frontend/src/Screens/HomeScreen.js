import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import data from '../data';
import { useSelector, useDispatch } from 'react-redux';

import Axios from 'axios'; //richieste XMLHttp dal browser e node
import { listProducts } from '../actions/productAction';



function HomeScreen (props){
const productList = useSelector(state => state.productList);
const { product, loading, error} = productList;
const dispatch = useDispatch();

useEffect (() => {
    dispatch(listProducts());
  /*  const fetchData = async () => {
        const {data} = await axios.get("/api/products");
        //{data} perchè l'oggetto ritona axios propietà --> data contiene tutti i dati dei prodotti
        setProduct(data);
    }
    fetchData();
    /*Richiamo fetchData per avere la richiesta dal server
    Chrome dev -> XHR -> products */ 
    return () => {
        //cleanup
    };
}, [dispatch])

    return loading? <div>Loading...</div>:
    error? <div>{error}</div>:
    
    <ul className="products">
                  {
                    data.products.map(product => 
                    <li key= {product._id}> 
                        <div className="product">
                        <Link to={'/products/' + product._id}>
                        <img className="product-image" src={product.image} alt="prodotti"></img>

                        </Link>

                            <div className="product-name">
                                <Link to={'/products/' + product._id}>{product.name}</Link>
                            </div>
                            <div className="product-brand">{product.brand}</div>
                            <div className="product-price">{product.price}$</div>
                            <div className="product-rating">{product.rating}Stars ({product.numReiews})</div>

                        </div> 
                    </li>)
                  }
                  </ul>
}
export default HomeScreen;