import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import data from '../data';
import { useSelector, useDispatch } from 'react-redux';
import Axios from 'axios'; 
import { listProducts } from '../actions/productAction';



function HomeScreen (props){
const productList = useSelector(state => state.productList);
const { product, loading, error} = productList;
const dispatch = useDispatch();

useEffect (() => {
    //dispatch(listProducts());
    const fetchData = async () => {
        const {data} = await Axios.get("/api/products");
        //setProduct(data);
    }
    fetchData();
    
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
                            <div className="product-rating">{product.rating}Stelle ({product.numReiews})</div>

                        </div> 
                    </li>)
                  }
                  </ul>
}
export default HomeScreen;