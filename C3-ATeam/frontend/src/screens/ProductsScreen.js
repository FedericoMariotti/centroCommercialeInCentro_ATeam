import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
import { signin } from '../actions/userAction';

function ProductsScreen(props) {

  const [name, setName] = useState('');
  const [price, setPrice] = useState('');
  const productSave = useSelector(state => state.userSignin);
  const { loading: loadingSave, success: successSave, error: errorSave } = productSave;
  const dispatch = useDispatch();
  const redirect = props.location.search ? props.location.search.split("=")[1] : '/';
  useEffect(() => {
    
    return () => {
      //
    };
  }, [userInfo]);

  const submitHandler = (e) => {
    e.preventDefault();
    dispatch(saveProduct({name, price}));

  }
  return <div className="form">
    <form onSubmit={submitHandler} >
      <ul className="form-container">
        <li>
          <h2>Aggiungi prodotto</h2>
        </li>
        <li>
          {loading && <div>Caricamento...</div>}
          {error && <div>{error}</div>}
        </li>
        <li>
          <label htmlFor="name">
            Nome
          </label>
          <input type="text" name="name" id="name" onChange={(e) => setName(e.target.value)}>
          </input>
        </li>
        
        <li>
          <button type="submit" className="button primary">Crea</button>
        </li>
       
      </ul>
    </form>
  </div>
}
export default SigninScreen;