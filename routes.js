const express = require('express');
const bodyParser = require('body-parser')
const router = express.Router();
const fs = require('fs');
const readline = require('readline');
const handlebars = require('express-handlebars');
const urlencodedParser = bodyParser.urlencoded({ extended: false })

router.get('/',function(req,res){    
    res.render(__dirname  + '/views/login');
});
router.get('/register',function(req,res){    
    res.render(__dirname  + '/views/register');
});

router.post('/', urlencodedParser, (req, res) => {       
    var value = req.body.userId + "," + req.body.pass;
    fs.readFile(__dirname + '/data.txt', function (err, data) {
        if (err) throw err;
        if(data.includes(value)){
            console.log("Login Successfull")
            res.sendStatus(200);
            //res.sendFile(__dirname  + '/view/StreetHotRod/index.html');
        }
        else
        {
            console.log("Invalid username or password");
            res.render(__dirname  + '/views/login',{
                msg : "Invalid username or password"
            });
        }
      });
});    
router.post('/register', urlencodedParser, (req, res) => {      

    var value = req.body.userId + "," + req.body.pass;
    fs.readFile(__dirname + '/data.txt', function (err, data) {
        if (err) throw err;
        if(data.includes(req.body.userId)){
            console.log("Uername Already exist");
            res.render(__dirname  + '/views/register',{
                msg : "Uername Already exist"
            });
        }
        else
        {
            fs.appendFile(__dirname + '/data.txt',"\n"+value, 'utf8',
                function(err) {     
                    if (err) throw err;
                    console.log("Account Created");
            });
            res.render(__dirname  + '/views/login',{
                msg : "Account Created, you can login now"
            });
            
        }
      });
});
module.exports = router;