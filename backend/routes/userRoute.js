import express from 'express';
import User from '../models/userModel';

const router = express.Router();


router.post = express.Router();

router.post('/signin', async (req, res) => {
    const signinUser = await User.findOne({
        email: req.body.email,
        password: req.body.password
    });

    if(signinUser){
        res.send({
            _id: signinUser.id,
            name: signinUser.name,
            email: signinUser.email,
            isAdmin: signinUser.isAdmin,
            token: getToken(signinUser)
        })
    } else {
        res.status(401).send({msg:'Email o Password non corrette :('});
    }
})


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