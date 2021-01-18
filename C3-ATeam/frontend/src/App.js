import React from 'react';
import { useSelector } from 'react-redux';
import { BrowserRouter, Link, Route} from 'react-router-dom';
import './App.css';
import CartScreen from './screens/CartScreen';
import HomeScreen from './screens/HomeScreen';
import ProductScreen from './screens/ProductScreen';
import ProductsScreen from '/screens/ProductsScreen';
import RegisterScreen from './screens/RegisterScreen';
import SigniSncreen from './screens/SigninScreen';


function App() {

    const userSignin = useSelector(state=>state.userSignin);
    const {userInfo} = userSignin;

const openMenu = () => {
  document.querySelector(".sidebar").classList.add("open");
}

const closeMenu = () => {
  document.querySelector(".sidebar").classList.remove("open")
}

  return (
    <BrowserRouter>
    <div className="grid-container">
        <header className="header">
            <div className="brand">
                <button onClick={openMenu}>
                    &#9776;
                </button>
                <Link to='/'>CC-Conero</Link>
            </div>
            <div className="header-links">
                <a href="cart.html">Profilo</a>
                {
                    userInfo ? <Link to="/profile">{userInfo.name}</Link>: 
                    <Link to="/signin">Sign-In</Link>
                }
                
                <a href="signin.html">Sign-In</a>
            </div>
        </header>
         <aside className="sidebar">
            <h3> Categorie </h3>
            <button className="sidebar-close-button" onClick={closeMenu}>x</button>
            <ul>
                <li>
                    <a href="index.html">Pantaloni</a>
                </li>
                <li>
                    <a href="index.html">Maglie</a>
                </li>
            </ul>
        </aside>

        <main className="main">
            <div className="content">
                <Route path="/products" component={ProductsScreen} />
                <Route path="/signin" component={SigniSncreen} />
                <Route path="/register" component={RegisterScreen} />
                <Route path="/products/:id" component={ProductScreen} />
                <Route path="/cart/:id?" component={CartScreen} />
                <Route path="/" exact={true} component={HomeScreen} />
            </div>
        </main>

        <footer className="footer">
            Centro Commerciale Conero - Ancona Corso Garibaldi
        </footer>
    </div>
    </BrowserRouter>

    );
}

export default App;
