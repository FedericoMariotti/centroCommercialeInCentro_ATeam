import express from 'express';
import User from '../models/userModel';

const router = express.Router();

router.get("/api/users/createadmin", async (req, rest) => {
    try {
        const user = new User({
            name: 'Federico',
            email: 'federico.mariotti@studenti.unicam.it',
            password: '1234',
            isAdmin: true
        });

        const newUser = await user.save();
        res.send(user);
    } catch (error){
        res.send({ msg: error.message });
    }
});

export default router;

//http://localhost:5000/api/users/creatadmin --> BUG!!!