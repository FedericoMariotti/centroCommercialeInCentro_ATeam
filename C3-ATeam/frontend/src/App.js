import React from 'react';
import { BrowserRouter, Link, Route} from 'react-router-dom';
import './App.css';
import HomeScreen from './screens/HomeScreen';
import ProductScreen from './screens/ProductScreen';
import CartScreen from './screens/CartScreen';
import SigninScreen from './screens/SigninScreen';
import { useSelector } from 'react-redux';
import RegisterScreen from './screens/RegisterScreen';

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
                <a href="cart.html">Riepilogo</a>
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
                    <a href="index.html">Cappotti</a>
                </li>
                <li>
                    <a href="index.html">Maglie</a>
                </li>
            </ul>
        </aside>

        <main className="main">
            <div className="content">
            <Route path="/signin" component={SigninScreen} />
            <Route path="/register" component={RegisterScreen}/>
            <Route path="/product/:id" component={ProductScreen} />
            <Route path="/cart/:id?" component={CartScreen} />
            <Route path="/" exact={true} component={HomeScreen} />

                

            </div>
        </main>
        <footer className="footer">
            Tutti i diritti sono pizze
        </footer>
    </div>
    </BrowserRouter>

    
  );

}

export default App;