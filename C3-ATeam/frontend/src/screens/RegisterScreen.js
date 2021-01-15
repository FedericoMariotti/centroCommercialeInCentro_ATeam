import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
import { register } from '../actions/userActions';

function RegisterScreen(props) {

    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [rePassword, setRePassword] = useState('');
    const userRegister = useSelector(state=>state.userRegister);
    const {loading, userInfo, error} = userRegister;
    const dispatch = useDispatch();

    useEffect(() => {
        if(userInfo){
            props.history.push("/");
        }
        return() => {

        };
    }, [userInfo]);

    const submitHandler = (e) =>{
        e.preventDefault();
        dispatch(register(name, email, password));

    }
    return <div className="form">
        <form onSubmit={submitHandler}>
            <ul className="form-container">
                <li>
                    <h2>Crea un Account</h2>
                    {error && <div>{error}</div>}
                </li>
                <li>
                    <label htmlFor="name">
                        Nome
                    </label>
                    <input type="name" name="name" id="name" onChange={(e) => setName(e.target.value)}>
                    </input>
                    </li>
                    <li>
                    <label htmlFor="email">
                        Email
                    </label>
                    <input type="email" name="email" id="email" onChange={(e) => setEmail(e.target.value)}>
                    </input>
                    </li>
                    <li>
                        <label htmlFor="password">Password</label>
                        <input type="password" id="password" name="password" onChange={(e)=>setPassword(e.target.value)}>
                        </input>
                    </li>
                    <li>
                        <label htmlFor="RePassword">Password</label>
                        <input type="rePassword" id="rePassword" name="rePassword" onChange={(e)=>setRePassword(e.target.value)}>
                        </input>
                    </li>
                    <li>
                        <button type="submit" className="button primary">Registrati</button>
                    </li>
                    <li>
                        Hai già un account? <Link to="/signin">Sign-in</Link>
                    </li>
            </ul>
        </form>
    </div>
}
export default RegisterScreen;